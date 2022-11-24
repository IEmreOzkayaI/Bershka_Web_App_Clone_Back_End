package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.SizeDao;

@Service
public class SizeManager {
    private SizeDao sizeDao;

    @Autowired
    public SizeManager(SizeDao sizeDao) {
        this.sizeDao = sizeDao;
    }
}
