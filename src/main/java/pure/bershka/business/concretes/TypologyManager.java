package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.TypologyService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.dataAccess.abstracts.TypologyDao;
import pure.bershka.entities.concretes.Typology;

import java.util.List;

@Service
public class TypologyManager implements TypologyService {
    private TypologyDao TypologyDao;
    @Autowired
    public TypologyManager(pure.bershka.dataAccess.abstracts.TypologyDao typologyDao) {
        TypologyDao = typologyDao;
    }

    @Override
    public DataResult<List<Typology>> listCategories(int categoryId) {
        return new SuccessDataResult<List<Typology>>(this.TypologyDao.getByCategory_Id(categoryId));
    }
}
