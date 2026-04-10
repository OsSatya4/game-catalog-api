package hu.nye.prog3.game_finder.config;

import hu.nye.prog3.game_finder.model.Category;
import hu.nye.prog3.game_finder.model.Game;
import hu.nye.prog3.game_finder.repository.CategoryRepository;
import hu.nye.prog3.game_finder.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository  categoryRepository;
    private final GameRepository gameRepository;

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count()==0 && gameRepository.count()==0){

            Category rpg = new Category();
            rpg.setName("RPG");
            categoryRepository.save(rpg);

            Category moba = new Category();
            moba.setName("MOBA");
            categoryRepository.save(moba);

            Category mmorpg = new Category();
            mmorpg.setName("MMORPG");
            categoryRepository.save(mmorpg);

            Category survival = new Category();
            survival.setName("SURVIVAL");
            categoryRepository.save(survival);

            Game skyrim = new Game();
            skyrim.setTitle("The Elder Scrolls V: Skyrim");
            skyrim.setReleaseDate("2011-11-11");
            skyrim.setRating(4.8);
            skyrim.setCategory(rpg);
            gameRepository.save(skyrim);

            Game lol = new Game();
            lol.setTitle("League of Legends");
            lol.setReleaseDate("2009-10-27");
            lol.setRating(4.5);
            lol.setCategory(moba);
            gameRepository.save(lol);

            Game wow = new Game();
            wow.setTitle("World of Warcraft");
            wow.setReleaseDate("2004-11-23");
            wow.setRating(4.7);
            wow.setCategory(mmorpg);
            gameRepository.save(wow);

            Game minecraft = new Game();
            minecraft.setTitle("Minecraft");
            minecraft.setReleaseDate("2011-11-18");
            minecraft.setRating(4.9);
            minecraft.setCategory(survival);
            gameRepository.save(minecraft);

            System.out.println("Game and Category are created");

        }
    }
}
