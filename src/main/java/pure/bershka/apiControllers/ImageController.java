package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pure.bershka.business.abstracts.ImageService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.entities.concretes.Image;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/get-product-images")
    public DataResult<List<Image>> getProductImages(int productId){
        return this.imageService.getProductImages(productId);
    }
}
