package dev.robgleason.services;


import dev.robgleason.dto.CollectionEntityDto;
import dev.robgleason.entity.CollectionEntity;
import dev.robgleason.entity.UserEntity;
import dev.robgleason.exception.CollectionNotFoundException;
import dev.robgleason.exception.UserNotFoundException;
import dev.robgleason.repository.CollectionRepository;
import dev.robgleason.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CollectionsServiceImpl implements CollectionsService {

    private CollectionRepository collectionRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public CollectionEntityDto getCollectionById(Long collectionId) {
        CollectionEntity collection = collectionRepository.findById(collectionId)
                .orElseThrow(() -> new CollectionNotFoundException("collection not found with id " + collectionId));

        return modelMapper.map(collection, CollectionEntityDto.class);
    }

    @Override
    public CollectionEntityDto createCollection(CollectionEntityDto collectionEntityDto) {
        CollectionEntity collection = modelMapper.map(collectionEntityDto, CollectionEntity.class);
        CollectionEntity savedCollection = collectionRepository.save(collection);

        return modelMapper.map(savedCollection, CollectionEntityDto.class);
    }

    @Override
    public CollectionEntityDto updateCollection(CollectionEntityDto collectionEntityDto) {
        CollectionEntity existingCollection = collectionRepository.findById(collectionEntityDto.getId())
                .orElseThrow(() -> new CollectionNotFoundException("Collection not found with id " + collectionEntityDto.getId()));

        // Update collection attributes here based on the DTO.

        CollectionEntity updatedCollection = collectionRepository.save(existingCollection);
        return modelMapper.map(updatedCollection, CollectionEntityDto.class);
    }


    @Override
    public void deleteCollection(Long collectionId) {
        collectionRepository.deleteById(collectionId);
    }


    @Override
    public List<CollectionEntityDto> getCollectionByUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));

        List<CollectionEntity> collections = collectionRepository.findByUserId(userId);

        return collections.stream()
                .map(collection -> modelMapper.map(collection, CollectionEntityDto.class))
                .collect(Collectors.toList());
    }
}
