package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pure.bershka.business.abstracts.CategoryService;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Category;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody Category category){
        return this.categoryService.add(category);
    }
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
