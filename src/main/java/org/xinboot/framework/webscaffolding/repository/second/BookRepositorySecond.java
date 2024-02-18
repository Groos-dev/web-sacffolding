package org.xinboot.framework.webscaffolding.repository.second;


import org.springframework.beans.factory.annotation.Qualifier;
import org.xinboot.framework.webscaffolding.model.entity.second.BookEntity;
import org.xinboot.framework.webscaffolding.repository.GenericJpaRepository;

import java.util.UUID;

/**
 * @author zengxin
 */
//@Repository
@Qualifier("bookRepositorySecond")
public interface BookRepositorySecond extends GenericJpaRepository<BookEntity, UUID> {
}
