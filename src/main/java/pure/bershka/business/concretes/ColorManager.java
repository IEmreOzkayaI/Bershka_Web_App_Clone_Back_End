package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import pure.bershka.business.abstracts.ColorService;
import pure.bershka.dataAccess.abstracts.ColorDao;

public class ColorManager implements ColorService {
    private ColorDao colorDao;

    @Autowired
    public ColorManager(ColorDao colorDao) {
        this.colorDao = colorDao;
    }
}
