package hu.nye.prog3.game_finder.service;

import hu.nye.prog3.game_finder.model.Category;
import hu.nye.prog3.game_finder.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Test
    public void testGetAllCategories_ShouldReturnList() {
        CategoryRepository kamuRepository = Mockito.mock(CategoryRepository.class);
        CategoryService categoryService = new CategoryService(kamuRepository);

        Category cat1 = new Category();
        cat1.setName("RPG");
        Category cat2 = new Category();
        cat2.setName("Shooter");

        when(kamuRepository.findAll()).thenReturn(Arrays.asList(cat1, cat2));

        List<Category> result = categoryService.getAllCategories();

        assertEquals(2, result.size());
        assertEquals("RPG", result.get(0).getName());
    }

    @Test
    public void testSaveCategory_ShouldReturnSavedCategory() {
        CategoryRepository kamuRepository = Mockito.mock(CategoryRepository.class);
        CategoryService categoryService = new CategoryService(kamuRepository);

        Category newCategory = new Category();
        newCategory.setName("Strategy");

        when(kamuRepository.save(newCategory)).thenReturn(newCategory);

        Category result = categoryService.saveCategory(newCategory);

        assertEquals("Strategy", result.getName());
    }
}