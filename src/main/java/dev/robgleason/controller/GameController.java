package dev.robgleason.controller;


import dev.robgleason.dto.GameEntityDto;
import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.exception.GameNotFoundException;
import dev.robgleason.services.GameService;
import dev.robgleason.services.GameServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/games")
@AllArgsConstructor
public class GameController {

    private GameService gameService;


    @PostMapping
    public ResponseEntity<GameEntityDto> addGame(@RequestBody GameEntityDto gameEntityDto) {
        GameEntityDto savedGame = gameService.createGame(gameEntityDto);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GameEntityDto>> getAllGames() {
        List<GameEntityDto> allGames = gameService.getAllGames();
        return ResponseEntity.ok(allGames);
    }

    @GetMapping("{id}")
    public ResponseEntity<GameEntityDto> getGame(@PathVariable("id") Long gameId) {
        GameEntityDto gameByIdDto = gameService.getGameById(gameId);
        return ResponseEntity.ok(gameByIdDto);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<GameEntityDto>> getGameByTitle(@PathVariable("title") String title) {
        List<GameEntityDto> gameEntityDtoList = gameService.getGamesByTitle(title);

        if (gameEntityDtoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameEntityDtoList);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<GameEntityDto>> getGameByGenre(@PathVariable("genre") String genre) {
        List<GameEntityDto> gameEntityDtoList = gameService.getGamesByGenre(genre);

        if (gameEntityDtoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameEntityDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<GameEntityDto> updatedGame(@PathVariable("id") Long gameId, @RequestBody GameEntityDto gameEntityDto) {
        gameEntityDto.setId(gameId);
        GameEntityDto updatedGame = gameService.updateGame(gameEntityDto);
        return ResponseEntity.ok(updatedGame);
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<String> deleteGameByTitle(@PathVariable String title) {
        gameService.deleteByTitle(title);
        return ResponseEntity.ok("Game deleted successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGameById(@PathVariable("id") Long gameId) {
        gameService.deleteGame(gameId);
        return ResponseEntity.ok("game deleted successfully");
    }

}
