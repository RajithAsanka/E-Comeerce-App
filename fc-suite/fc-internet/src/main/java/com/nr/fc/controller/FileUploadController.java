package com.nr.fc.controller;

import com.nr.fc.controller.navigation.NavigationPath;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nr.fc.util.FileMeta;
//to get file extension in java
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Amith
 */
@Controller
@RequestMapping(value = NavigationPath.ADMIN_PREFIX + NavigationPath.FILE_UPLOAD, headers = "Accept=application/json")
public class FileUploadController implements ServletContextAware {

    private ServletContext servletContext;

    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;

    /**
     * *************************************************
     * URL: /rest/controller/upload upload(): receives files
     *
     * @param request : MultipartHttpServletRequest auto passed
     * @param response : HttpServletResponse auto passed
     * @return LinkedList<FileMeta> as json format
     * **************************************************
     */
    @RequestMapping(value = "/upload-employee", method = RequestMethod.POST)
    public @ResponseBody
    LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        try {
            //1. build an iterator
            Iterator<String> itr = request.getFileNames();
            MultipartFile mpf = null;

            //2. get each file
            while (itr.hasNext()) {

                //2.1 get next MultipartFile
                mpf = request.getFile(itr.next());
                System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());

                //2.2 if files > 10 remove the first from the list
                if (files.size() >= 10) {
                    files.pop();
                }

                //2.3 create new fileMeta
                fileMeta = new FileMeta();
                fileMeta.setFileName(mpf.getOriginalFilename());
                fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
                fileMeta.setFileType(mpf.getContentType());

                fileMeta.setBytes(mpf.getBytes());

                Properties properties = new Properties();
                InputStream input = getClass().getClassLoader().getResourceAsStream("upload_config.properties");
                properties.load(input);
                String path = properties.getProperty("employeeUploads");

                String fileName = Calendar.getInstance().getTimeInMillis() + ".jpg";
                fileMeta.setRenamedFileName(fileName);
                File file = new File(path + fileName);
                fileMeta.setActulPath(path);
                // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)           
                FileCopyUtils.copy(mpf.getBytes(), file);

                //2.4 add to files
                files.add(fileMeta);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // result will be like this
        // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
        return files;
    }

    /**
     * *************************************************
     * URL: /rest/controller/get/{value} get(): get file as an attachment
     *
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void **************************************************
     */
    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value) {
        FileMeta getFile = files.get(Integer.parseInt(value));
        try {
            response.setContentType(getFile.getFileType());
            response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
            FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }

}
