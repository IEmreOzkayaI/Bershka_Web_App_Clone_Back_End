package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.RefundService;
import pure.bershka.dataAccess.abstracts.RefundDao;

@Service
public class RefundManager implements RefundService {
    private RefundDao refundDao;

    @Autowired
    public RefundManager(RefundDao refundDao) {
        this.refundDao = refundDao;
    }
}
