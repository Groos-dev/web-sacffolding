package org.xinboot.framework.webscaffolding.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * @author zengxin
 */
@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
  private String name;

  private BigDecimal price;

  private String description;
}
