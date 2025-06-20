package com.jio.Tv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.Tv.model.Banner;
import com.jio.Tv.repositry.BannerRepo;

@Service
public class BannerServiceImp implements BannerService
{
	@Autowired
    BannerRepo rep;
    
	@Override
	public List<Banner> getAllBanner() {
		
		return rep.findAll();
	}

	@Override
	public Banner addBanner(Banner banner) {
		
		return rep.save(banner);	
	}
	
	public int deleteBanner(int id)
	{
		int i=0;
		Optional<Banner> op=rep.findById(id);
		if(op.isPresent())
		{
			Banner b=op.get();
			rep.delete(b);
			i=1;
		}
		return i;
	}

}
