package com.jio.Tv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jio.Tv.model.User;
import com.jio.Tv.service.UserServiceImp;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
public class UserController 
{
	@Autowired
	UserServiceImp service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		User u1=service.addUser(user);
		ResponseEntity<String> re=null;
		if(u1!=null)
		{
			re=new ResponseEntity<>("Added",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Added",HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id)
	{
		int i=service.deleteUser(id);
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
	
	@PostMapping("/loginuser")
	public ResponseEntity<String> validateUser(@RequestBody User user) 
	{
		
	    User u1=service.validateUser(user.getName(), user.getPassword());
	    ResponseEntity<String> re=null;
	    if(u1!=null)
	    {
	    	re=new ResponseEntity<>("Found",HttpStatus.OK);
	    }
	    else
	    {
	    	re=new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
	    }
	    return re;
	}
	
	@PutMapping("/changepassw")
	public ResponseEntity<String> changePassword(@RequestBody User user)
	{
		int i=service.changePassword(user.getName(), user.getPassword());
		
		ResponseEntity<String> re=null;
		if(i>0)
		{
			re=new ResponseEntity<>("Changed",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Not Changed",HttpStatus.NOT_ACCEPTABLE);
		}
		return re;
		
	}

}
