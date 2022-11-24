package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.TypologyDao;

@Service
public class TypologyManager {
    private TypologyDao TypologyDao;
    @Autowired
    public TypologyManager(pure.bershka.dataAccess.abstracts.TypologyDao typologyDao) {
        TypologyDao = typologyDao;
    }
}
