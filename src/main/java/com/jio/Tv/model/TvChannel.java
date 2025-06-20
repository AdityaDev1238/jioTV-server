package com.jio.Tv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TvChannel 
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String cname;
	@Column
	private String type;
	@Column
	private String imageurl;
	@Column
	private String vurl;
	
	
	public TvChannel(int id, String cname, String type, String imageurl, String vurl) {
		super();
		this.id = id;
		this.cname = cname;
		this.type = type;
		this.imageurl = imageurl;
		this.vurl = vurl;
	}

	public String getVurl() {
		return vurl;
	}

	public void setVurl(String vurl) {
		this.vurl = vurl;
	}

	public TvChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TvChannel(int id, String cname, String type, String imageurl) {
		super();
		this.id = id;
		this.cname = cname;
		this.type = type;
		this.imageurl = imageurl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Override
	public String toString() {
		return "TvChannel [id=" + id + ", cname=" + cname + ", type=" + type + ", imageurl=" + imageurl + ", vurl="
				+ vurl + "]";
	}

	
	
	
	

}
