package org.xinboot.framework.webscaffolding;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
class WebScaffoldingApplicationTests {

  @Test
  void contextLoads() {
    log.info(UUID.randomUUID().toString());

  }

}
