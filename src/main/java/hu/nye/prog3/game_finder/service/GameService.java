package hu.nye.prog3.game_finder.service;

import hu.nye.prog3.game_finder.model.Game;
import hu.nye.prog3.game_finder.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    //READ ALL BY ID
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    //READ ONE BY ID
    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    //SAVE
    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    //UPDATE
    public Game updateGame(Long id, Game updatedGame) {
        return gameRepository.findById(id).map(existingGame -> {
            existingGame.setTitle(updatedGame.getTitle());
            existingGame.setReleaseDate(updatedGame.getReleaseDate());
            existingGame.setRating(updatedGame.getRating());
            existingGame.setCategory(updatedGame.getCategory());
            return gameRepository.save(existingGame);
        }).orElseThrow(() -> new RuntimeException("Játék nem található ezzel az ID-val: " + id));
    }
    //DELETE
    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
    }

}
