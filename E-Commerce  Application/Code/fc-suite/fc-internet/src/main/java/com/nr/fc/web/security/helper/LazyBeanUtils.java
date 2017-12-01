
package com.nr.fc.web.security.helper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author Amith
 */

public abstract class LazyBeanUtils {
  
  /**
   * Copy the all properties from source object and create and paste into destination object.
   * 
   * @param clazz class of destination object.
   * @param source source object where destination object gets the property value
     * @return 
   */
  public static Object copyBean(final Class<?> clazz, final Object source) {
  
    Object destination = null;
    try {
      
      destination = clazz.newInstance();
      PropertyUtils.copyProperties(destination, source);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      
      destination = null;
    }
    
    return destination;
  }
}
