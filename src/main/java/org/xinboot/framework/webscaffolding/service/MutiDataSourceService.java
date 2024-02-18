package org.xinboot.framework.webscaffolding.service;

public interface MutiDataSourceService {
  Object getBookFromPrimaryDataSource();

  Object getBookFromSecondDataSource();
}
