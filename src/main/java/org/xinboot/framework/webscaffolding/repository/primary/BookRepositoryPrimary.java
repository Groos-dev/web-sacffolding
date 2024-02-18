package org.xinboot.framework.webscaffolding.repository.primary;


import org.xinboot.framework.webscaffolding.model.entity.primary.BookEntity;
import org.xinboot.framework.webscaffolding.repository.GenericJpaRepository;

import java.util.UUID;

/**
 * @author zengxin
 */
public interface BookRepositoryPrimary extends GenericJpaRepository<BookEntity, UUID> {
}
