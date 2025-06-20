package com.jio.Tv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.Tv.model.TvChannel;
import com.jio.Tv.repositry.TvChannelRepo;

@Service
public class TvChannelServiceImp implements TvChannelService
{
	 @Autowired
	 TvChannelRepo rep;

	@Override
	public TvChannel addChannel(TvChannel channel) 
	{
		return rep.save(channel);
		 
	}

	@Override
	public int deleteChannel(int id) 
	{
		int i=0;
		TvChannel channel=getChannel(id);
		
		if(channel!=null)
		{
			rep.delete(channel);
			i=1;
			
		}
		return i;
		
		
	}

	@Override
	public TvChannel getChannel(int id) {
		Optional <TvChannel> op=rep.findById(id);
		
		if(op.isPresent())
		{
			TvChannel channel=op.get();
			if(channel!=null)
			{
				return channel;
			}
		}
		
		
		return null;
	}

	@Override
	public List<TvChannel> getAll() {
		return rep.findAll();
		
	}

	@Override
	public TvChannel updateChannel(int id, TvChannel channel) {
		TvChannel channel1=getChannel(id);
		
		if(channel1!=null)
		{
			channel1.setCname(channel.getCname());
			channel1.setImageurl(channel.getImageurl());
			channel1.setType(channel.getType());
			
		   return rep.save(channel1);
			
		}
		
		return null;
	}

}
