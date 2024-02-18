package org.xinboot.framework.webscaffolding.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description: 第二个数据源配置
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySecond",
    transactionManagerRef = "transactionManagerSecond",
    basePackages = {"org.xinboot.framework.webscaffolding.repository.second"})
public class SecondDataSourceConfig {

  @Resource
  private JpaProperties jpaProperties;

  @Resource
  private HibernateProperties hibernateProperties;

  @Bean(name = "dataSourceSecond")
  @ConfigurationProperties(prefix = "spring.datasource.second")
  public DataSource secondDataSource() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(name = "entityManagerSecond")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactorySecond(builder).getObject().createEntityManager();
  }

  @Bean(name = "entityManagerFactorySecond")    //primary实体工厂
  public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond (EntityManagerFactoryBuilder builder) {

    return builder.dataSource(secondDataSource())
                  .properties(getHibernateProperties())
                  .packages("org.xinboot.framework.webscaffolding.model.entity.second")     //换成你自己的实体类所在位置
                  .persistenceUnit("secondaryPersistenceUnit")
                  .build();
  }

  @Bean(name = "transactionManagerSecond")
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
  }

  private Map<String, Object> getHibernateProperties() {
    return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
  }

}