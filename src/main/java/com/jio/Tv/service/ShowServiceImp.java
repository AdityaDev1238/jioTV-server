package com.jio.Tv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.Tv.model.Show;
import com.jio.Tv.repositry.ShowsRepo;

@Service
public class ShowServiceImp implements ShowService
{
	@Autowired
	ShowsRepo repo;

	@Override
	public Show addShow(Show show) 
	{
		return repo.save(show);
	}

	@Override
	public List<Show> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Show> getType(String type) {
		return repo.findByType(type);
	}

}
