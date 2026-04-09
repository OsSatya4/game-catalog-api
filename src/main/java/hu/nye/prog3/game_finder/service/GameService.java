package hu.nye.prog3.game_finder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }
}
