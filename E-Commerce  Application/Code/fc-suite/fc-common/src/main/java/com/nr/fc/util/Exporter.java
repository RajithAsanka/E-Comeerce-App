package com.nr.fc.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public class Exporter 
{
	public void exportXls(HttpServletResponse response, JasperPrint jp, ByteArrayOutputStream baos) throws JRException, IOException {
	    //Get response output stream to download report file
	    //OutputStream ouputStream = new FileOutputStream(new File("C:/JasperReports/Account_Report.xls"));
	    OutputStream ouputStream = response.getOutputStream();
	    // Create a JRXlsExporter instance
	    JRXlsExporter exporter = new JRXlsExporter();
	    
	    // Here we assign the parameters jp and baos to the exporter
	    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
	    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
	    
	    // Excel specific parameters
	    exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	    exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	    exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	    exporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
	    
	    // Retrieve the exported report in XLS format
	    exporter.exportReport();
	    
	    ouputStream.write(baos.toByteArray());
	    ouputStream.flush();
	    ouputStream.close();
	  }
	  
	  /**
	   * Exports a report to CSV format.
	   * @param response 
	   * 
	   * @param jp the JasperPrint object
	   * @param baos the ByteArrayOutputStream where the report will be written
	   * @throws IOException
	   */
	  public void exportCsv(HttpServletResponse response, JasperPrint jp, ByteArrayOutputStream baos) throws JRException, IOException {
	    //Get response output stream to download report file
	    OutputStream ouputStream = response.getOutputStream();
	    // Create a JRCsvExporter instance
	    JRCsvExporter csvExporter = new JRCsvExporter();
	    
	    // Here we assign the parameters jp and baos to the exporter
	    csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
	    csvExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
	    
	    // DELIMETER Provider parameter
	    /*csvExporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ":");
	    csvExporter.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, ".");*/
	    
	    
	    csvExporter.exportReport();
	    
	    ouputStream.write(baos.toByteArray());
	    ouputStream.flush();
	    ouputStream.close();
	  }
	  
	  /**
	   * Exports a report to PDF format.
	   * @param response 
	   * 
	   * @param jp the JasperPrint object
	   * @param baos the ByteArrayOutputStream where the report will be written
	   * @throws IOException
	   */
	  public void exportPdf(HttpServletResponse response, JasperPrint jp, ByteArrayOutputStream baos) throws JRException, IOException {
	  
	    //OutputStream ouputStream = new FileOutputStream(new File("C:/JasperReports/Account_Report.pdf"));
	    //Get response output stream to download report file
	    OutputStream ouputStream = response.getOutputStream();
	    
	    // Create a JRPdfExporter instance
	    JRPdfExporter pdfExporter = new JRPdfExporter();
	    
	    // Here we assign the parameters jp and baos to the exporter
	    pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
	    pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
	    
	    pdfExporter.exportReport();
	    
	    ouputStream.write(baos.toByteArray());
	    ouputStream.flush();
	    ouputStream.close();
	  }
	  

}
