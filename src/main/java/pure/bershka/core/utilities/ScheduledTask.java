package pure.bershka.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pure.bershka.business.abstracts.LogService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;


@Component
public class ScheduledTask {
    @Autowired
    LogService logService;
    private final String logFile = "my-app-log";
    int counter = 0;
    @Scheduled(fixedRate = 10000)
    public void scheduleTask() throws IOException {
        storeLog(logFile);
    }

    public void storeLog(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        int localCounter = 0;
        while((line = reader.readLine()) != null) {
            if(localCounter>=counter){
                String date = line.split("|")[0];
                String message = line.split(":")[1];
                logService.saveLog(message);
                counter = counter + 2;
            }else
                localCounter++;
        }
        reader.close();
    }

}
