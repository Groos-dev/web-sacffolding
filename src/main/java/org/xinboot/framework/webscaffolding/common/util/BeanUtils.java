package org.xinboot.framework.webscaffolding.common.util;

public class BeanUtils {
  public static void copyBean(Object source, Object target){
    org.springframework.beans.BeanUtils.copyProperties(source, target);
  }
}
