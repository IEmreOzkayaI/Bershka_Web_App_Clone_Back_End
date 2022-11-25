package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.DiscountCodeService;
import pure.bershka.dataAccess.abstracts.DiscountCodeDao;

@Service
public class DiscountCodeManager implements DiscountCodeService {
    private DiscountCodeDao discountCodeDao;

    @Autowired
    public DiscountCodeManager(DiscountCodeDao discountCodeDao) {
        this.discountCodeDao = discountCodeDao;
    }
}
