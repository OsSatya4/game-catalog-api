package hu.nye.prog3.game_finder.repository;


import hu.nye.prog3.game_finder.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findByTitleContainingIgnoreCase(String title);
}
