package dev.robgleason.services;

import dev.robgleason.dto.CollectionEntityDto;

import java.util.List;

public interface CollectionsService {

    CollectionEntityDto getCollectionById(Long collectionId);

    CollectionEntityDto createCollection(CollectionEntityDto collectionEntityDto);

    CollectionEntityDto updateCollection(CollectionEntityDto collectionEntityDto);

    List<CollectionEntityDto> getCollectionByUser(Long userId);

    void deleteCollection(Long CollectionId);


}
