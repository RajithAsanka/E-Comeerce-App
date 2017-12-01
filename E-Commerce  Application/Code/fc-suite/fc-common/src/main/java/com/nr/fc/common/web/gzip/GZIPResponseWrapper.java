/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.common.web.gzip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class GZIPResponseWrapper extends HttpServletResponseWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(GZIPResponseWrapper.class);


    /* Specify the HTTP servlet response. */
    protected HttpServletResponse origResponse = null;

    /* Specify the servlet out put stream. */
    protected ServletOutputStream stream = null;

    /* Specify the print writer. */
    protected PrintWriter writer = null;

    /**
     * @param response HTTP servlet response.
     */
    public GZIPResponseWrapper(HttpServletResponse response) {

        super(response);
        origResponse = response;
    }

    /**
     * @return Servlert output stream.
     * @throws IOException throws if IO exeption occurred.
     */
    public ServletOutputStream createOutputStream() throws IOException {

        return (new GZIPResponseStream(origResponse));
    }

    /**
     * Wrapper the response.
     */
    public void finishResponse() {

        try {

            if (writer != null) {

                writer.close();
            } else {

                if (stream != null) {

                    stream.close();
                }
            }
        } catch (IOException e) {
            LOGGER.error("IOException occurred finishResponse() ", e);

        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletResponseWrapper#flushBuffer()
     */
    public void flushBuffer() throws IOException {

        stream.flush();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletResponseWrapper#getOutputStream()
     */
    public ServletOutputStream getOutputStream() throws IOException {

        if (writer != null) {
            throw new IllegalStateException("getWriter() has already been called!");
        }

        if (stream == null) {
            stream = createOutputStream();
        }
        return (stream);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletResponseWrapper#getWriter()
     */
    public PrintWriter getWriter() throws IOException {

        if (writer != null) {
            return (writer);
        }

        if (stream != null) {
            throw new IllegalStateException("getOutputStream() has already been called!");
        }

        stream = createOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
        return (writer);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletResponseWrapper#setContentLength(int)
     */
    public void setContentLength(int length) {

    }
}
