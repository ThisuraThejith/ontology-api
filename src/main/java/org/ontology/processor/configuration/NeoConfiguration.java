package org.ontology.processor.configuration;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by thisura on 6/22/18.
 */

@Configuration
@ComponentScan("org.thisura.processor")
@EnableNeo4jRepositories(basePackages = "org.thisura.processor.repositories.neo")
@EnableTransactionManagement
public class NeoConfiguration extends Neo4jConfiguration{

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("org.thisura.processor.models.dao.neo");
    }

    @Bean
    @Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception{
        return super.getSession();
    }

}
