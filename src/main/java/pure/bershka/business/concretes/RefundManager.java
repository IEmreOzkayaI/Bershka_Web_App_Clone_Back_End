package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.RefundDao;

@Service
public class RefundManager {
    private RefundDao refundDao;

    @Autowired
    public RefundManager(RefundDao refundDao) {
        this.refundDao = refundDao;
    }
}
