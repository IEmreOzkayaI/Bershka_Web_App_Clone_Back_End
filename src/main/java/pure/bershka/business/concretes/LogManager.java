/*
package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.LogService;
import pure.bershka.core.utilities.Log;
import pure.bershka.dataAccess.abstracts.LogDao;

import java.util.Date;

@Service
public class LogManager implements LogService {
    private LogDao logDao;

    @Autowired
    public LogManager(LogDao logDao) {
        this.logDao = logDao;
    }

    public void saveLog(String message) {
        Log log = new Log();
        log.setMessage(message);
        log.setDate(new Date());
        logDao.save(log);
    }
}
*/
