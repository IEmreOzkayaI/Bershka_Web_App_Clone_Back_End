package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.RefundService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.RefundDao;
import pure.bershka.entities.concretes.Refund;

import java.util.List;

@Service
public class RefundManager implements RefundService {
    private RefundDao refundDao;

    @Autowired
    public RefundManager(RefundDao refundDao) {
        this.refundDao = refundDao;
    }



    @Override
    public DataResult<List<Refund>> findAllRefunds() {
        return new SuccessDataResult<>(this.refundDao.findAll());
    }

    @Override
    public Result add(Refund refund) {
        this.refundDao.save(refund);
        return new SuccessResult("refund talebi done.");
    }

    @Override
    public Result delete(int refundId) {
        Refund deletedRefund = this.refundDao.findById(refundId).get();
        this.refundDao.delete(deletedRefund);
        return new SuccessResult("refund silindi.");
    }


}
