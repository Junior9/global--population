package com.mex.global.population.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mex.global.population.service.FileUploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUpload;

	@GetMapping("init/data")
	public void InitData() {
		fileUpload.initData();
	}
	
}
