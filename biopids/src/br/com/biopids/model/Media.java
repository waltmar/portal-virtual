package br.com.biopids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Media implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Video> videos;
	
	public Media(){
		this.videos = new ArrayList<Video>();
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	

}
