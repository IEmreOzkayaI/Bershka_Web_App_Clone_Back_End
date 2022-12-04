package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.entities.concretes.Image;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getProductImages(int productId);
}
