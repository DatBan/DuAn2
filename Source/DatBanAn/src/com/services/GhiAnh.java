package com.services;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GhiAnh {
	@Autowired
	private ServletContext context;
	//duong dan hinh
	public String taoPhotoPathThuong(String slug){
		Calendar cal = Calendar.getInstance();
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	    int dow = cal.get(Calendar.DAY_OF_WEEK);
	    int dom = cal.get(Calendar.DAY_OF_MONTH);
	    int doy = cal.get(Calendar.DAY_OF_YEAR);
	
	    System.out.println("Current Date: " + cal.getTime());
	    System.out.println("Day: " + day);
	    System.out.println("Month: " + month);
	    System.out.println("Year: " + year);
	    System.out.println("Day of Week: " + dow);
	    System.out.println("Day of Month: " + dom);
	    System.out.println("Day of Year: " + doy);
	    
	    return "upload/"+slug+"/"+year+"/"+month+"/";
	}
	public String taoPhotoPathThumbnail(String idnhahang){
		return "upload/"+idnhahang+"/thumbnail/";
	}
	//thay doi ten file
	public String taoFileName(String slug, String tenfile){
		return "datban-"+slug+"-"+tenfile;
	}
	//tien hanh ghi anh
	public void GhiAnhTheoPathName(MultipartFile fileanh, String photoPath, String filename){
	  //ghi anh
	    String rootPath = context.getRealPath("/");
	    
		String pathName = rootPath+photoPath+filename;
		//kiem tra thu muc co ton tai hay khong
	    File file = new File(rootPath+photoPath);
		if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
		//Ghi anh theo pathName
		try {
			fileanh.transferTo(new File(pathName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI GHI ANH");
			e.printStackTrace();
		}
	}
	
	public void xoaThuMuc(File file){
		if(file.isDirectory()){
			//directory is empty, then delete it
			if(file.list().length==0){
				file.delete();
				System.out.println("Directory is deleted: "+file.getAbsolutePath());
			}else{
				//list all the directory contents
				String files[] = file.list();
				for(String temp: files){
					//construct the file structure
					File fileDelete = new File(file, temp);
					
					//recursive delete
					xoaThuMuc(fileDelete);
				}
				
				//Check the directory again, if empty then delete it
				if(file.list().length==0){
					file.delete();
					System.out.println("Directory (recursive) is deleted: "+file.getAbsolutePath());
				}
			}
		}else{
			//if file, then delete it
			file.delete();
			System.out.println("File is deleted: "+file.getAbsolutePath());
		}
	}
}
