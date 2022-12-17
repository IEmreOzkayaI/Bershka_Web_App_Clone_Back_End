package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Stock;

public interface StockService {

    Result addStock(Stock stock);
    Result updateStock(int stockId, Stock stock);
    Result deleteStock(int stockId);
}
