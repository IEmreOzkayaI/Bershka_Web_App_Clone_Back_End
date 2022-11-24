package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.MaterialDao;

@Service
public class MaterialManager {
    private MaterialDao materialDao;

    @Autowired
    public MaterialManager(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }
}
