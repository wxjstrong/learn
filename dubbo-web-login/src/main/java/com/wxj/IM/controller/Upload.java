package com.wxj.IM.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.testng.log4testng.Logger;


@Controller
@RequestMapping("/file")

public class Upload {
	
	Logger logger=Logger.getLogger(Upload.class);
	
	@RequestMapping("/upload.do")
	public String uploadApp(MultipartFile file,HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		//设置相应给前台内容的数据格式
		String fileName = file.getOriginalFilename();
		File targetFile =new File(realPath,fileName);
		
		if(!targetFile.exists()){
			targetFile.mkdir();
		}
		//上传
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "success";
	}

}
