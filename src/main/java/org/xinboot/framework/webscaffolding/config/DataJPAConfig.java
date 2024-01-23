package org.xinboot.framework.webscaffolding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.xinboot.framework.webscaffolding.common.context.UserContext;

import java.util.Optional;

/**
 * @author zengxin
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.xinboot.framework.webscaffolding")
public class DataJPAConfig {

  @Bean
  public AuditorAware<String> auditorProvider() {
    return () -> Optional.of(UserContext.getCurrentUser().getName());
  }



}
