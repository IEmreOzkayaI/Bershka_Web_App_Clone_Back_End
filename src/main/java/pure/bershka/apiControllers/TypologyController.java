package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pure.bershka.business.abstracts.TypologyService;

@CrossOrigin
@RestController
@RequestMapping("/api/typology")
public class TypologyController {
    private TypologyService typologyService;

    @Autowired
    public TypologyController(TypologyService typologyService) {
        this.typologyService = typologyService;
    }
}
