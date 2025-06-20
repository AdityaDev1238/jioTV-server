package com.jio.Tv.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.Tv.model.TvChannel;

public interface TvChannelRepo extends JpaRepository<TvChannel, Integer> 
{
	   List<TvChannel> findByType(String type);
}
