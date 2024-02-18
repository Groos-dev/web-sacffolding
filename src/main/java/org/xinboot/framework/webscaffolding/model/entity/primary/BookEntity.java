package org.xinboot.framework.webscaffolding.model.entity.primary;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.xinboot.framework.webscaffolding.model.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @author zengxin
 */
@Entity
@Table(name = "books")
@Data
public class BookEntity extends BaseEntity {
  private String name;

  private BigDecimal price;

  private String description;
}
