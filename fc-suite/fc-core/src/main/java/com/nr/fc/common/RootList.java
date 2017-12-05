package com.nr.fc.common;

import java.util.List;

import javax.persistence.criteria.Root;

/**
 * 
 * @author Mohamed Sayyaff
 *
 * @param <T>
 */
public class RootList <T> {
  private Root<T> trailRoot;
  private String variableName;
  
 
  public Root<T> getTrailRoot() {
  
    return trailRoot;
  }
  public void setTrailRoot(Root<T> trailRoot) {
  
    this.trailRoot = trailRoot;
  }
  public String getVariableName() {
  
    return variableName;
  }
  public void setVariableName(String variableName) {
  
    this.variableName = variableName;
  }
}
