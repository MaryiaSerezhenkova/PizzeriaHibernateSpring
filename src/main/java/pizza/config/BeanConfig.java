package pizza.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("properties.properties")
//@EnableJpaRepositories(entityManagerFactoryRef = "EntityManagerFactory", transactionManagerRef = "TransactionManager", basePackages = {
//		"pizza.dao" })
public class BeanConfig  {

//	@Bean(name = "EntityManager", destroyMethod = "close")
//	public EntityManager entityManager(@Qualifier("EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return entityManagerFactory.createEntityManager();
//	}
//
//	@Bean(name = "EntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("JiraDataSource") DataSource dataSource) {
//		return builder.dataSource(dataSource).packages("pizza.api.core.domain").persistenceUnit("pizza").build();
//	}
//
//	@Bean(name = "TransactionManager")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//
//	@Bean(name = "DataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
}
