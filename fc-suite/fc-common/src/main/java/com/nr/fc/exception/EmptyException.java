package com.nr.fc.exception;

import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.JsonReturn.successValue;

public class EmptyException extends Exception {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private static final String ERROR_CODE = "12";
  
  private JsonReturn jsonReturn = new JsonReturn();
  
  /**
   * 
   * @param msg 
   */
  public EmptyException() {
    super("You are trying to add Duplicate for ");
    jsonReturn.setSuccess(successValue.FAILED);
    jsonReturn.setErrorCode(ERROR_CODE);
    jsonReturn.setErrorMessage("You are trying to update without data please recheck data");
  }

  public JsonReturn getJsonReturn() {
  
    return jsonReturn;
  }
  
  public void setJsonReturn(JsonReturn jsonReturn) {
  
    this.jsonReturn = jsonReturn;
  }
  
  /**
   * 12 error for empty fields trying to update
   * 
   * @return {@link String}
   */
  public static String getErrorCode() {
  
    return ERROR_CODE;
  }
  
  
}
