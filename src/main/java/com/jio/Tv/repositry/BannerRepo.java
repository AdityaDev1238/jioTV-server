package com.jio.Tv.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.Tv.model.Banner;

public interface BannerRepo extends JpaRepository<Banner, Integer>
{

}
