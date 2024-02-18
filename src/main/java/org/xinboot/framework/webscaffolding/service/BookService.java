package org.xinboot.framework.webscaffolding.service;


import org.xinboot.framework.webscaffolding.model.entity.primary.BookEntity;

import java.util.UUID;

/**
 * @author zengxin
 */
public interface BookService {
  BookEntity get(UUID id);

  BookEntity save(BookEntity bookEntity);
}
