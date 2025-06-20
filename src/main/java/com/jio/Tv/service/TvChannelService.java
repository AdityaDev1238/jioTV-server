package com.jio.Tv.service;

import java.util.List;

import com.jio.Tv.model.TvChannel;

public interface TvChannelService 
{
	public TvChannel addChannel(TvChannel channel);
	
	public int deleteChannel(int id);
	
	public TvChannel getChannel(int id);
	
	public List<TvChannel> getAll();
	
	public TvChannel updateChannel(int id,TvChannel channel);

}
