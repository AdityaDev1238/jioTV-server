package com.jio.Tv.service;

import java.util.List;

import com.jio.Tv.model.Banner;

public interface BannerService 
{
	public Banner addBanner(Banner banner);
	public List<Banner> getAllBanner();
	public int deleteBanner(int id);

}
