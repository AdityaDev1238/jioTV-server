package com.jio.Tv.service;

import java.util.List;

import com.jio.Tv.model.Show;


public interface ShowService 
{
	public Show addShow(Show show);
	public List<Show> getAll();
	public List<Show> getType(String type);
	
	

}
