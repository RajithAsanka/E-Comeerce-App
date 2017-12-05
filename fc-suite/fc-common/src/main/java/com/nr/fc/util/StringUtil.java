package com.nr.fc.util;

public class StringUtil {
  /* static empty string variable */
  public static final String EMPTY = "";
  
  
  /** Specifying open bracket */
  public static String OPENBRACKET = "(";
  
  /** Specifying close bracket */
  public static String CLOSEBRACKET = ")";
  
  /** Specifying colon */
  public static String COLON = ":";
  
  /** Specifying full stop */
  public static String FULL_STOP = ".";
  
  /** Specify the new line character */
  public static final String NEW_LINE = System.getProperty("line.separator");
  
  /** Specify the percentage character */
  public static final String PERCENTAGE = "%";
  
  /** Specify the space character */
  public static final String SPACE = " ";
  
  /** The method return true if one of input is null or empty */
  public static boolean isNullOrEmpty(String... args) {
    
    for (String arg : args) {
      
      if (arg == null || arg.isEmpty()) {
        
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }
  
  /**
   * The method check whether the input string contains numeric only
   * 
   * @param s String to validate
   * @return True if the input is numeric or otherwise false
   */
  public static boolean isNumberic(String s) {
    
    return s.matches("[-+]?\\d*\\.?\\d+");
  }
  
  public static boolean equalsEither(String val, String... args) {
    
    for (String arg : args) {
      
      if (arg.equalsIgnoreCase(val)) {
        
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }
}
