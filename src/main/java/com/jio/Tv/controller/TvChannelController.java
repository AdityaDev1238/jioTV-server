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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jio.Tv.model.TvChannel;
import com.jio.Tv.service.TvChannelServiceImp;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class TvChannelController 
{
	@Autowired
	TvChannelServiceImp service;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		List<TvChannel> list=service.getAll();
		
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
	
	@PostMapping("/saveChannel")
	public ResponseEntity<?> addChannel(@RequestBody TvChannel channel,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		
		TvChannel channel1=service.addChannel(channel);
		
		if(channel1!=null)
		{
			re=new ResponseEntity<>("Added",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Not Added",HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getId(@PathVariable("id") int id,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		TvChannel channel=service.getChannel(id);
		
		if(channel!=null)
		{
			re=new ResponseEntity<>(channel,HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteId(@PathVariable("id")int id,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		int i=service.deleteChannel(id);
		
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateChannel(@RequestBody TvChannel channel,@PathVariable("id") int id,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<?> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		TvChannel c1=service.updateChannel(id, channel);
		
		if(c1!=null)
		{
			re=new ResponseEntity<>("Updated",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Not Updated",HttpStatus.NOT_ACCEPTABLE);
		}
		return re;
		
	}

}
