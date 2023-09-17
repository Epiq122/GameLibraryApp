package dev.robgleason.services;

import dev.robgleason.dto.GameEntityDto;

import java.util.List;

public interface GameService {

    GameEntityDto getGameById(Long gameId);

    List<GameEntityDto> getAllGames();

    List<GameEntityDto> getGamesByTitle(String title);

    List<GameEntityDto> getGamesByGenre(String genre);

    GameEntityDto createGame(GameEntityDto gameEntityDto);

    GameEntityDto updateGame(GameEntityDto gameEntity);

    void deleteByTitle(String title);


    void deleteGame(Long gameId);


}
