package dev.robgleason.services;


import dev.robgleason.dto.GameEntityDto;
import dev.robgleason.entity.GameEntity;
import dev.robgleason.exception.GameNotFoundException;
import dev.robgleason.exception.ResourceNotFoundException;
import dev.robgleason.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private ModelMapper modelMapper;

    @Override
    public GameEntityDto getGameById(Long gameId) {
        GameEntity game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("game not found with id " + gameId));
        return modelMapper.map(game, GameEntityDto.class);
    }

    @Override
    public List<GameEntityDto> getAllGames() {
        List<GameEntity> games = gameRepository.findAll();
        if (games.isEmpty()) {
            return Collections.emptyList();
        }
        return games.stream()
                .map(game -> modelMapper.map(game, GameEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameEntityDto> getGamesByTitle(String title) {
        List<GameEntity> games = gameRepository.findByTitle(title);


        if (games.isEmpty()) {
            throw new GameNotFoundException("No games found with title '" + title + "'");
        }


        List<GameEntityDto> gameDto = new ArrayList<>();
        for (GameEntity game : games) {
            gameDto.add(modelMapper.map(game, GameEntityDto.class));
        }

        return gameDto;
    }

    @Override
    public List<GameEntityDto> getGamesByGenre(String genre) {
        List<GameEntity> games = gameRepository.findByGenre(genre);

        List<GameEntityDto> gameDto = new ArrayList<>();
        for (GameEntity game : games) {
            gameDto.add(modelMapper.map(game, GameEntityDto.class));
        }

        return gameDto;
    }

    @Override
    public GameEntityDto createGame(GameEntityDto gameEntityDto) {
        GameEntity game = modelMapper.map(gameEntityDto, GameEntity.class);
        GameEntity savedGame = gameRepository.save(game);
        return modelMapper.map(savedGame, GameEntityDto.class);
    }

    @Override
    public GameEntityDto updateGame(GameEntityDto gameEntity) {
        GameEntity existingGame = gameRepository.findById(gameEntity.getId())
                .orElseThrow(() -> new GameNotFoundException("Game not found with id " + gameEntity.getId()));

        existingGame.setTitle(gameEntity.getTitle());
        existingGame.setGenre(gameEntity.getGenre());
        existingGame.setReleaseYear(gameEntity.getReleaseYear());
        existingGame.setCoverArtUrl(gameEntity.getCoverArtUrl());
        existingGame.setDescription(gameEntity.getDescription());

        GameEntity updatedGame = gameRepository.save(existingGame);
        return modelMapper.map(updatedGame, GameEntityDto.class);


    }

    @Override
    public void deleteGame(Long gameId) {
        GameEntity game = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game with id " + gameId + " " + "does not exist"));
        gameRepository.deleteById(gameId);
    }

    @Override
    public void deleteByTitle(String title) {
        long deletedCount = gameRepository.deleteByTitle(title);
        if (deletedCount == 0) {
            throw new GameNotFoundException("No game found with title " + title);
        }
    }

}
