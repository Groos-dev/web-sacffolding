package org.xinboot.framework.webscaffolding.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.xinboot.framework.webscaffolding.common.context.UserContext;

import java.util.Optional;

/**
 * @author zengxin
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class DataJPAConfig {

  @Bean("auditorAware")
  public AuditorAware<String> auditorProvider() {
    return () -> Optional.ofNullable("admin");
  }



}
