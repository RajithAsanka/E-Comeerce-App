/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.common.web.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class GZIPResponseStream extends ServletOutputStream{
    /* Specify the byte array out put stream. */
  protected ByteArrayOutputStream baos = null;
  
  /* Specify the GZIP out put stream. */
  protected GZIPOutputStream gzipstream = null;
  
  /* Specify the flag */
  protected boolean closed = false;
  
  /* Specify the http servlet response. */
  protected HttpServletResponse response = null;
  
  /* specify the servlet output stream. */
  protected ServletOutputStream output = null;
  
  /**
   * @param response HTTP servlet response.
   * @throws IOException thorws if any IO exception occured.
   */
  public GZIPResponseStream(HttpServletResponse response) throws IOException {
  
    super();
    closed = false;
    this.response = response;
    this.output = response.getOutputStream();
    baos = new ByteArrayOutputStream();
    gzipstream = new GZIPOutputStream(baos);
  }
  
  public void close() throws IOException {
  
    if (closed) {
      throw new IOException("This output stream has already been closed");
    }
    gzipstream.finish();
    
    byte[] bytes = baos.toByteArray();
    
    
    response.addHeader("Content-Length", Integer.toString(bytes.length));
    response.addHeader("Content-Encoding", "gzip");
    output.write(bytes);
    output.flush();
    output.close();
    closed = true;
  }
  
  public void flush() throws IOException {
  
    if (closed) {
      throw new IOException("Cannot flush a closed output stream");
    }
    gzipstream.flush();
  }
  
  public void write(int b) throws IOException {
  
    if (closed) {
      throw new IOException("Cannot write to a closed output stream");
    }
    gzipstream.write((byte) b);
  }
  
  public void write(byte b[]) throws IOException {
  
    write(b, 0, b.length);
  }
  
  public void write(byte b[], int off, int len) throws IOException {
  
    if (closed) {
      throw new IOException("Cannot write to a closed output stream");
    }
    gzipstream.write(b, off, len);
  }
  
  public boolean closed() {
  
    return (this.closed);
  }
  
  public void reset() {
  
    // noop
  }
}
