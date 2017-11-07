package com.services;

import java.util.Date;

public class DoiTenFile {
	public static String DoiFile(String file){
        int index = file.lastIndexOf(".");
        String typeFile = file.substring(index);        
        file = file.substring(0,index);
        
        Date date = new Date();
        file =file +date.getTime();
        file = file + typeFile;
        
        return file;
    }
}
