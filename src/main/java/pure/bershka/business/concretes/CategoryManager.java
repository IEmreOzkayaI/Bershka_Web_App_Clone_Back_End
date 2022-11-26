package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.CategoryService;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.CategoryDao;
import pure.bershka.entities.concretes.Category;
import pure.bershka.entities.concretes.Product;

@Service
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Result add(Category category) {
        this.categoryDao.save(category);
        return new SuccessResult("Kategori eklendi");
    }
}
