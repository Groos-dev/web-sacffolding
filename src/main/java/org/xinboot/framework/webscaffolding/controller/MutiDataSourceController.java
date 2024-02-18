package org.xinboot.framework.webscaffolding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xinboot.framework.webscaffolding.service.MutiDataSourceService;

@RestController("mutiDataSource")
public class MutiDataSourceController {

  private MutiDataSourceService mutiDataSourceService;

  @Autowired
  public MutiDataSourceController(MutiDataSourceService mutiDataSourceService){
    this.mutiDataSourceService = mutiDataSourceService;
  }

  @GetMapping("primary")
  public Object getPrimary(){
    return mutiDataSourceService.getBookFromPrimaryDataSource();
  }

  @GetMapping("second")
  public Object getSecond(){
    return mutiDataSourceService.getBookFromSecondDataSource();

  }


}
