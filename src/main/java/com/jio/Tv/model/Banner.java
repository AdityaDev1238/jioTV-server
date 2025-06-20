package com.jio.Tv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banner 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String url;
	@Column
	private String vurl;
	
	public Banner(int id, String url, String vurl) {
		super();
		this.id = id;
		this.url = url;
		this.vurl = vurl;
	}

	
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getVurl() {
		return vurl;
	}


	public void setVurl(String vurl) {
		this.vurl = vurl;
	}


	@Override
	public String toString() {
		return "Banner [id=" + id + ", url=" + url + ", vurl=" + vurl + "]";
	}

	
	
	
	
	
	
	
	

}
