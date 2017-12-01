package com.nr.fc.exception;

import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.JsonReturn.successValue;

/**
 * 
 * @author Mohamed Sayyaff
 *
 */
public class DuplicateException extends Exception {
   /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private static final String ERROR_CODE="123";
  
  private JsonReturn jsonReturn = new JsonReturn();
  
  public DuplicateException(){};
   
   /**
    * 
    * @param name for what database/UI or something thats related
    * Example if you add exception message as "Student" the result would be "You are trying to add Duplicate for Student" 
    * 
    * 
    */
   public DuplicateException(String name){
     super("You are trying to add Duplicate for ");
     jsonReturn.setSuccess(successValue.FAILED);
     jsonReturn.setErrorCode(ERROR_CODE);
     jsonReturn.setErrorMessage("You are trying to add Duplicate for "+name);
   };
   
   /**
    * 123 error is the duplication code
    * @return {@link String}
    */
   public static String getErrorCode() {
     
     return ERROR_CODE;
   }

  public JsonReturn getJsonReturn() {
    return jsonReturn;
  }

  public void setJsonReturn(JsonReturn jsonReturn) {
    this.jsonReturn = jsonReturn;
  }
   
   
   
    
   
}
