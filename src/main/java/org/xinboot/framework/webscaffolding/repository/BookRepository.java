package org.xinboot.framework.webscaffolding.repository;


import org.xinboot.framework.webscaffolding.model.entity.BookEntity;

import java.util.UUID;

/**
 * @author zengxin
 */
public interface BookRepository extends GenericJpaRepository<BookEntity, UUID> {
}
