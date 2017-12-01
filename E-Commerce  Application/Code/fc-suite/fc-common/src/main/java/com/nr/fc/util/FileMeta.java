
package com.nr.fc.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Amith
 */
//ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"})
public class FileMeta {

    private String actulPath;
    private String renamedFileName;
    private String fileName;
    private String fileSize;
    private String fileType;
    private String fileExtension;

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getActulPath() {
        return actulPath;
    }

    public void setActulPath(String actulPath) {
        this.actulPath = actulPath;
    }

    public String getRenamedFileName() {
        return renamedFileName;
    }

    public void setRenamedFileName(String renamedFileName) {
        this.renamedFileName = renamedFileName;
    }

    private byte[] bytes;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

}
