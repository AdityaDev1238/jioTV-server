package com.jio.Tv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.Tv.model.User;
import com.jio.Tv.repositry.UserRepo;

@Service
public class UserServiceImp implements UserService
{
   @Autowired
	UserRepo repo;
	@Override
	public User addUser(User user) 
	{
		return repo.save(user);
		
	}

	@Override
	public User validateUser(String name, String password) {
		if(name!=null && password!=null)
		{
			User u1=repo.findByName(name);
			if(u1!=null && u1.getName().equals(name) && u1.getPassword().equals(password))
			{
				return u1;
			}
		}
		return null;
	}

	@Override
	public int deleteUser(int id) {
		int i=0;
		Optional <User> op=repo.findById(id);
		if(op.isPresent())
		{
			User u1=op.get();
			repo.delete(u1);
			i=1;
		}
		return i;
	}

	@Override
	public int changePassword(String name, String password) {
		int i=0;
		User u1=repo.findByName(name);
		if(u1!=null)
		{
			u1.setPassword(password);
			repo.save(u1);
			i=1;
		}
		return i;
	}

}
