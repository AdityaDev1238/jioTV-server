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

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@RestController

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController 
{
	@Autowired
	UserServiceImp service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> addUser(@RequestBody User user,HttpSession session)
	{
	    ResponseEntity<String> re=null;
		
		User u1=service.addUser(user);
		
		if(u1!=null)
		{
			re=new ResponseEntity<>("Added",HttpStatus.OK);
		}
		else
		{
			re=new ResponseEntity<>("Not Added",HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id,HttpSession session)
	{
		String cuser=(String)session.getAttribute("name");
		ResponseEntity<String> re=null;
		if(cuser==null)
		{
			re=new ResponseEntity<>("Unauthorised",HttpStatus.UNAUTHORIZED);
			return re;
		}
		int i=service.deleteUser(id);
		
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
	public ResponseEntity<String> validateUser(@RequestBody User user,HttpSession session) 
	{
		ResponseEntity<String> re=null;
		String currentUser = (String) session.getAttribute("name");
	    if (currentUser != null) {
	        re = new ResponseEntity<>("Already logged in as: " + currentUser, HttpStatus.CONFLICT);
	        return re;
	    }
	    User u1=service.validateUser(user.getName(), user.getPassword());
	    
	    if(u1!=null)
	    {
	    	session.setAttribute("name", user.getName());
	    	re=new ResponseEntity<>("Found",HttpStatus.OK);
	    }
	    else
	    {
	    	re=new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
	    }
	    return re;
	}
	
	@PutMapping("/changepassw")
	public ResponseEntity<String> changePassword(@RequestBody User user,HttpSession session)
	{
		
		ResponseEntity<String> re=null;
		
		
          
		int i=service.changePassword(user.getName(), user.getPassword());
		
		
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
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session)
	{
		String  u1=(String)session.getAttribute("name");
		ResponseEntity<String> re=null;
		if(u1==null)
		{
			re=new ResponseEntity<String>("No active Sessions",HttpStatus.BAD_REQUEST);
			return re;
			
		}
		
		session.invalidate();
		re=new ResponseEntity<String>("Logout Successfully",HttpStatus.OK);
		return re;
	}
	

}
