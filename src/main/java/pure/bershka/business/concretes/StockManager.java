package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.StockService;
import pure.bershka.dataAccess.abstracts.StockDao;

@Service
public class StockManager implements StockService {
    private StockDao stockDao;
    @Autowired
    public StockManager(StockDao stockDao) {
        this.stockDao = stockDao;
    }
}
