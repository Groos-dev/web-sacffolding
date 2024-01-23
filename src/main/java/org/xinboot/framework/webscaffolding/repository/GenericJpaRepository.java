package org.xinboot.framework.webscaffolding.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zengxin
 */
@NoRepositoryBean
public interface GenericJpaRepository<T, D> extends CrudRepository<T, D>,
    ListCrudRepository<T, D>, JpaSpecificationExecutor<T>, PagingAndSortingRepository<T,D> {
}
