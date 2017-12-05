// *************************************************************************************************
//

package com.nr.fc.internet.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeImageServlet extends HttpServlet{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    
      Properties properties = new Properties();
      InputStream input = getClass().getClassLoader().getResourceAsStream("upload_config.properties");
      properties.load(input);
      String path = properties.getProperty("employeeUploads");
    
      String filename = request.getParameter("file");
      File file = new File(path, filename);
      response.setHeader("Content-Type", getServletContext().getMimeType(filename));
      response.setHeader("Content-Length", String.valueOf(file.length()));
      response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
      Files.copy(file.toPath(), response.getOutputStream());
  }
}
