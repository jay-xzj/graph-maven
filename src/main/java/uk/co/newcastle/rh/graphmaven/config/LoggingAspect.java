package uk.co.newcastle.rh.graphmaven.config;

import org.aspectj.lang.annotation.Aspect;
import org.omg.CORBA.Environment;

@Aspect
public class LoggingAspect {

    private final Environment env;

    public LoggingAspect(Environment env){
        this.env = env;
    }
}
