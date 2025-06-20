package com.jio.Tv.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.Tv.model.Show;

public interface ShowsRepo extends JpaRepository<Show, Integer>
{
	List<Show> findByType(String type);
	
	

}
