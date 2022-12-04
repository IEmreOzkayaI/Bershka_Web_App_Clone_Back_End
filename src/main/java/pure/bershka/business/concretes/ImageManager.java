package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.ImageService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.dataAccess.abstracts.ImageDao;
import pure.bershka.entities.concretes.Image;

import java.util.List;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }


    @Override
    public DataResult<List<Image>> getProductImages(int productId) {
        return new SuccessDataResult<>(this.imageDao.getByProduct_Id(productId));
    }
}
