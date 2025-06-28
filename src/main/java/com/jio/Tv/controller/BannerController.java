package com.jio.Tv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jio.Tv.model.Banner;
import com.jio.Tv.service.BannerServiceImp;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class BannerController 
{
	@Autowired
	BannerServiceImp service;
	
	@GetMapping("/getAllBanner")
	public ResponseEntity<?> getAllBannner(HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		List<Banner> list=service.getAllBanner();
		
		if(list!=null)
		{
			re=new ResponseEntity<>(list,HttpStatus.ACCEPTED); 
		}
		else
		{
			re=new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
		return re;
		
	}
	
	 @PostMapping("/saveBanner")
	 public ResponseEntity<?> addBanner(@RequestBody Banner banner,HttpSession session)
	 {
		    String cuser=(String)session.getAttribute("name");
			ResponseEntity<?> re=null;
			if(cuser==null)
			{
				re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
				return re;
			}
		 Banner b1=service.addBanner(banner);
		 
		 if(b1!=null)
		 {
			 re=new ResponseEntity<>("Added",HttpStatus.OK);
		 }
		 else
			{
				re=new ResponseEntity<>("Not Added",HttpStatus.FAILED_DEPENDENCY);
			}
		return re;
		 
		 
	 }
	 @DeleteMapping("/deleteBanner/{id}")
	 public ResponseEntity<?> deleteBanner(@PathVariable("id") int id,HttpSession session)
	 {
		    String cuser=(String)session.getAttribute("name");
			ResponseEntity<?> re=null;
			if(cuser==null)
			{
				re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
				return re;
			}
		   int i=service.deleteBanner(id);
		  
			if(i>0)
			{
				re=new ResponseEntity<>("Deleted",HttpStatus.OK);
			}
			else
			{
				re=new ResponseEntity<>("Not Deleted",HttpStatus.NOT_ACCEPTABLE);
			}
			return re;
		 
	 }
	 

}
