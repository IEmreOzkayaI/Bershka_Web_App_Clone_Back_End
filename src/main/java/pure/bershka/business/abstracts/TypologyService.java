package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.entities.concretes.Typology;

import java.util.List;

public interface TypologyService {

    DataResult<List<Typology>> listCategories(int categoryId);
}
