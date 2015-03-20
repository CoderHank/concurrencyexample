package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Hank on 2015/3/19.
 */
public class Log4jLogger {
    static{
        PropertyConfigurator.configure(Log4jLogger.class.getClassLoader().getResource("property/log4j.properties"));
    }

    public static Logger getLogger(){
        return Logger.getLogger("appLogger");
    }
}
