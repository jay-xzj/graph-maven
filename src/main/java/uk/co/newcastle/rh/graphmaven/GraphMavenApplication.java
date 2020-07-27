package uk.co.newcastle.rh.graphmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class GraphMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphMavenApplication.class, args);
    }

    /*@Bean
    @Profile("dev")
    public LoggingAspect loggingAspect(Environment env){
        return new LoggingAspect(env);
    }*/
}
