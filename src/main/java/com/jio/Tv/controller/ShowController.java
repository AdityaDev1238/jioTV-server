package com.jio.Tv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jio.Tv.model.Show;
import com.jio.Tv.service.ShowServiceImp;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class ShowController 
{
	@Autowired
	ShowServiceImp service;
	
	
	@PostMapping("/addShow")
	public ResponseEntity<?> addShow(@RequestBody Show show,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		Show s1=service.addShow(show);
		
		
		if(s1!=null)
		{
			re=new ResponseEntity<>("Added",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Not Added",HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
	}
	@GetMapping("/getAllShows")
	public ResponseEntity<?> getAll(HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		List<Show> list=service.getAll();
		
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
	
	@GetMapping("/showtype/{type}")
	public ResponseEntity<?> getAllType(@PathVariable("type") String type,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		List<Show> list=service.getType(type);
		
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

}
