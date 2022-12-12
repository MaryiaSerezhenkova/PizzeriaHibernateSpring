package pizza.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "pizza")

public class ProjectConfig {

    @Bean(name = "entityManager", destroyMethod = "close")
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("pizza").createEntityManager();
    }
   
}