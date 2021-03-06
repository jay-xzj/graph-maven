package uk.co.newcastle.rh.graphmaven.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import uk.co.newcastle.rh.graphmaven.config.ConfigHelper;

public class Neo4jSessionFactory {

    private static SessionFactory sessionFactory = null;
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();
    private static Logger log = LogManager.getLogger(Neo4jSessionFactory.class);
    
    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        if(sessionFactory == null) {

            Configuration configuration = new Configuration.Builder()
                    .uri("bolt://" + ConfigHelper.getNeo4jHost() + ":" + ConfigHelper.getNeo4jPort()).build();

            sessionFactory = new SessionFactory(configuration, "");
        }
        return sessionFactory.openSession();
    }
}
