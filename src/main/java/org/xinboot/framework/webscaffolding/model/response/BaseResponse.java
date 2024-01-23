package org.xinboot.framework.webscaffolding.model.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zengxin
 */
@Data
public abstract class BaseResponse {
  private UUID id;

  private LocalDateTime createdTime;

  private LocalDateTime updatedTime;

  private String createdBy;

  private String updatedBy;
}
