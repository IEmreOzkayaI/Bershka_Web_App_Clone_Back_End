package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Category;
import pure.bershka.entities.concretes.Product;

public interface CategoryService {
    Result add(Category category);
}
