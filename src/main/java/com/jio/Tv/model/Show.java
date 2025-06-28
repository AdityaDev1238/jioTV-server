package com.jio.Tv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shows")
public class Show 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String title;
	@Column
    private String url;
	@Column
    private String type;
	
	private String iurl;
	
	public String getIurl() {
		return iurl;
	}

	public void setIurl(String iurl) {
		this.iurl = iurl;
	}

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", title=" + title + ", url=" + url + ", type=" + type + ", iurl=" + iurl + "]";
	} 
	
	
	
	

}
