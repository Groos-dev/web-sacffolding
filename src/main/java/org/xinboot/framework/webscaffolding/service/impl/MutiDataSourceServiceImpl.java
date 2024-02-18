package org.xinboot.framework.webscaffolding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.xinboot.framework.webscaffolding.model.entity.primary.BookEntity;
import org.xinboot.framework.webscaffolding.repository.primary.BookRepositoryPrimary;
import org.xinboot.framework.webscaffolding.repository.second.BookRepositorySecond;
import org.xinboot.framework.webscaffolding.service.MutiDataSourceService;

import java.util.List;
import java.util.Optional;

@Service
public class MutiDataSourceServiceImpl implements MutiDataSourceService {
  private final BookRepositoryPrimary bookRepositoryPrimary;

  private final BookRepositorySecond bookRepositorySecond;

  @Autowired
  public MutiDataSourceServiceImpl(BookRepositoryPrimary bookRepositoryPrimary,
                                   BookRepositorySecond bookRepositorySecond){
    this.bookRepositoryPrimary = bookRepositoryPrimary;
    this.bookRepositorySecond = bookRepositorySecond;
  }

  @Override
  public Object getBookFromPrimaryDataSource() {
    List<BookEntity> all = bookRepositoryPrimary.findAll();
    if(all.isEmpty())return null;
    return all.get(0);
  }

  @Override
  public Object getBookFromSecondDataSource() {
    List<org.xinboot.framework.webscaffolding.model.entity.second.BookEntity> all = bookRepositorySecond.findAll();
    if(all.isEmpty())return null;
    return all.get(0);
  }
}
