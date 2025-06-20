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

import com.jio.Tv.model.Banner;
import com.jio.Tv.model.Show;
import com.jio.Tv.service.ShowServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShowController 
{
	@Autowired
	ShowServiceImp service;
	
	
	@PostMapping("/addShow")
	public ResponseEntity<String> addShow(@RequestBody Show show)
	{
		Show s1=service.addShow(show);
		ResponseEntity<String> re=null;
		
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
	public ResponseEntity<List<Show>> getAll()
	{
		List<Show> list=service.getAll();
		ResponseEntity<List<Show>> re=null;
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
	public ResponseEntity<List<Show>> getAllType(@PathVariable("type") String type)
	{
		List<Show> list=service.getType(type);
		ResponseEntity<List<Show>> re=null;
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
