package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    Result add(Category category);
    DataResult<List<Category>> getAll();
}
