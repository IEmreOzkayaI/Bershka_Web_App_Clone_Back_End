package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pure.bershka.business.abstracts.ImageService;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Image;
import pure.bershka.entities.concretes.Stock;

@CrossOrigin
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Image image){
        return this.imageService.add(image);
    }
    @PutMapping("/update")
    public Result update(int imageId, @RequestBody Image image){
        return this.imageService.update(imageId, image);
    }
    @DeleteMapping("/delete")
    public Result delete(int imageId){
        return this.imageService.delete(imageId);
    }
}
