package org.xinboot.framework.webscaffolding.util;

public class BeanUtils {
  public static void copyBean(Object source, Object target){
    org.springframework.beans.BeanUtils.copyProperties(source, target);
  }
}
