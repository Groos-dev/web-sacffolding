package org.xinboot.framework.webscaffolding.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary",
    transactionManagerRef = "transactionManagerPrimary",
    basePackages = {"org.xinboot.framework.webscaffolding.repository.primary"})
public class PrimaryDataSourceConfig {
  @Autowired
  private HibernateProperties hibernateProperties;

  @Autowired
  private JpaProperties jpaProperties;

  @Bean("dataSourcePrimary")
  @ConfigurationProperties(prefix = "spring.datasource.primary")
  @Primary
  public DataSource dataSourcePrimary(){
    return DruidDataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "entityManagerPrimary")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
  }

  @Primary
  @Bean(name = "entityManagerFactoryPrimary")    //primary实体工厂
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
    return builder.dataSource(dataSourcePrimary())
                  .properties(getHibernateProperties())
                  .packages("org.xinboot.framework.webscaffolding.model.entity.primary")     //换成你自己的实体类所在位置
                  .persistenceUnit("primaryPersistenceUnit")
                  .build();
  }

  @Primary
  @Bean(name = "transactionManagerPrimary")
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
  }

  private Map<String, Object> getHibernateProperties() {
    return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
  }
}
