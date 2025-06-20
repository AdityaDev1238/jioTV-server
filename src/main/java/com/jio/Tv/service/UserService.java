package com.jio.Tv.service;

import com.jio.Tv.model.User;

public interface UserService 
{
	public User addUser(User user);
	public User validateUser(String name,String password);
	public int deleteUser(int id);
	public int changePassword(String name,String password);
	

}
