package org.xinboot.framework.webscaffolding.common.context;


import org.xinboot.framework.webscaffolding.model.entity.auth.User;

/**
 * @author zengxin
 */
public class UserContext {
  private static final ThreadLocal<User> CURRENT_USER = new ThreadLocal<>();

  public static User getCurrentUser() {
    return CURRENT_USER.get();
  }

  public static void setCurrentUser(User user) {
    CURRENT_USER.set(user);
  }

  public static void removeUser() {
    CURRENT_USER.remove();
  }
}

