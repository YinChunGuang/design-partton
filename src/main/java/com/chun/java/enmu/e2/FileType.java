package com.chun.java.enmu.e2;
public enum FileType {
    VIDEO("video"),PIC("PIC");
 
    private String value;
 
    private FileType(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
 
 
}
