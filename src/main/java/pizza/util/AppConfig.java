package pizza.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("properties.properties")
public class AppConfig {

	@Bean(name = "EntityManager", destroyMethod = "close")
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("pizza").createEntityManager();
    }

}