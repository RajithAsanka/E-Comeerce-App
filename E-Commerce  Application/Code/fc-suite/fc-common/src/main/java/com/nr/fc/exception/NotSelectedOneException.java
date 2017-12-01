package com.nr.fc.exception;

import com.nr.fc.json.model.JsonReturn;
import com.nr.fc.json.model.JsonReturn.successValue;

public class NotSelectedOneException extends Exception {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static final String ERROR_CODE = "11";
  
  private JsonReturn jsonReturn = new JsonReturn();
  
  public NotSelectedOneException() {
    super("You have to be either Student or Employee or Parent");
    jsonReturn.setSuccess(successValue.FAILED);
    jsonReturn.setErrorCode(ERROR_CODE);
    jsonReturn.setErrorMessage("You have to be either Student or Employee or Parent");
  }
  
  
  public JsonReturn getJsonReturn() {
  
    return jsonReturn;
  }
  
  public void setJsonReturn(JsonReturn jsonReturn) {
  
    this.jsonReturn = jsonReturn;
  }

  public static String getErrorCode() {
  
    return ERROR_CODE;
  }
}
