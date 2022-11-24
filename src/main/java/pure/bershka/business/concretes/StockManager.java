package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.StockDao;

@Service
public class StockManager {
    private StockDao stockDao;
    @Autowired
    public StockManager(StockDao stockDao) {
        this.stockDao = stockDao;
    }
}
