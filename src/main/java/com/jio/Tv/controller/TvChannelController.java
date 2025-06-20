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

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TvChannelController 
{
	@Autowired
	TvChannelServiceImp service;
	
	@GetMapping("/")
	public ResponseEntity<List<TvChannel>> getAll()
	{
		List<TvChannel> list=service.getAll();
		ResponseEntity<List<TvChannel>> re=null;
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
	public ResponseEntity<String> addChannel(@RequestBody TvChannel channel)
	{
		
		TvChannel channel1=service.addChannel(channel);
		ResponseEntity<String> re=null;
		
		if(channel1!=null)
		{
			re=new ResponseEntity<>("Added",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Added",HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TvChannel> getId(@PathVariable("id") int id)
	{
		TvChannel channel=service.getChannel(id);
		ResponseEntity<TvChannel> re=null;
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
	public ResponseEntity<String> deleteId(@PathVariable("id")int id)
	{
		int i=service.deleteChannel(id);
		ResponseEntity<String> re=null;
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
	public ResponseEntity<String> updateChannel(@RequestBody TvChannel channel,@PathVariable("id") int id)
	{
		TvChannel c1=service.updateChannel(id, channel);
		ResponseEntity<String> re=null;
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
