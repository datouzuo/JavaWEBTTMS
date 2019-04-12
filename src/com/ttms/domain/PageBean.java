package com.ttms.domain;

import java.util.List;

public class PageBean {

	
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	private List<play> movieall;
	private Integer page;
	private Integer toatal;
	public List<play> getMovieall() {
		return movieall;
	}
	public void setMovieall(List<play> movieall) {
		this.movieall = movieall;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getToatal() {
		return toatal;
	}
	public void setToatal(Integer toatal) {
		this.toatal = toatal;
	}
}
