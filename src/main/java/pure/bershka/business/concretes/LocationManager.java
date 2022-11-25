package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.LocationService;
import pure.bershka.dataAccess.abstracts.LocationDao;

@Service
public class LocationManager implements LocationService {
    private LocationDao locationDao;

    @Autowired
    public LocationManager(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
}
