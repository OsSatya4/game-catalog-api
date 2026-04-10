package hu.nye.prog3.game_finder.service;

import hu.nye.prog3.game_finder.model.Game;
import hu.nye.prog3.game_finder.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Test
    public void testGetAllGames_ShouldReturnGameList() {
        GameRepository kamuRepository = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(kamuRepository);

        Game game1 = new Game();
        game1.setTitle("Test Game 1");
        Game game2 = new Game();
        game2.setTitle("Test Game 2");

        when(kamuRepository.findAll()).thenReturn(Arrays.asList(game1, game2));

        List<Game> result = gameService.getAllGames();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetGameById_ShouldReturnGame() {
        GameRepository kamuRepository = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(kamuRepository);

        Game game = new Game();
        game.setId(1L);
        game.setTitle("Witcher 3");

        when(kamuRepository.findById(1L)).thenReturn(Optional.of(game));

        Optional<Game> result = gameService.getGameById(1L);

        assertTrue(result.isPresent());
        assertEquals("Witcher 3", result.get().getTitle());
    }

    @Test
    public void testSaveGame_ShouldReturnSavedGame() {
        GameRepository kamuRepository = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(kamuRepository);

        Game newGame = new Game();
        newGame.setTitle("Elden Ring");

        when(kamuRepository.save(newGame)).thenReturn(newGame);

        Game result = gameService.saveGame(newGame);

        assertEquals("Elden Ring", result.getTitle());
    }

    @Test
    public void testDeleteGame_ShouldCallRepositoryDelete() {
        GameRepository kamuRepository = Mockito.mock(GameRepository.class);
        GameService gameService = new GameService(kamuRepository);

        Long gameId = 1L;

        gameService.deleteGameById(gameId);

        verify(kamuRepository, times(1)).deleteById(gameId);
    }
}