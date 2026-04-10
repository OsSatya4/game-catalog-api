package hu.nye.prog3.game_finder.service;

import hu.nye.prog3.game_finder.model.Category;
import hu.nye.prog3.game_finder.repository.CategoryRepository;
import hu.nye.prog3.game_finder.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
