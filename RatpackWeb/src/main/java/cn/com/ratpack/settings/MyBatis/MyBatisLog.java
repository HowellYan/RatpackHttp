package cn.com.ratpack.settings.MyBatis;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;

/**
 * Created by Howell on 14/12/16.
 */

public class MyBatisLog implements Log {
    Logger log;

    public MyBatisLog(String clazz) {
        log = org.slf4j.LoggerFactory.getLogger(clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable throwable) {
        log.error(s);
        throwable.printStackTrace(System.err);
    }

    @Override
    public void error(String s) {
        log.error(s);
    }

    @Override
    public void debug(String s) {
        log.info(s);
    }

    @Override
    public void trace(String s) {
        log.trace(s);
    }

    @Override
    public void warn(String s) {
        log.warn(s);
    }
}
