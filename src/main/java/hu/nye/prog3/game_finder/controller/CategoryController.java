package hu.nye.prog3.game_finder.controller;

import hu.nye.prog3.game_finder.model.Category;
import hu.nye.prog3.game_finder.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category CreateCategory(@RequestBody Category category){
        return  categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
