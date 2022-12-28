package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.Log;

public interface LogService {
    void saveLog(String message);
    void saveLog(Log log);
}
