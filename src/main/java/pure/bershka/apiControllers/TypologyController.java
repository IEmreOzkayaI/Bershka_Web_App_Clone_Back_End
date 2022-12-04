package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pure.bershka.business.abstracts.TypologyService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.entities.concretes.Typology;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/typology")
public class TypologyController {
    private TypologyService typologyService;

    @Autowired
    public TypologyController(TypologyService typologyService) {
        this.typologyService = typologyService;
    }

    @GetMapping("/list-typologies")
    public DataResult<List<Typology>> listTypologies(int categoryId){
        return this.typologyService.listCategories(categoryId);
    }
}
