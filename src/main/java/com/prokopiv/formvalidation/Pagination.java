package com.prokopiv.formvalidation;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	
	private static final int LIMIT_RECORDS = 15;
	private static final int COUNT_PAGE_LINKS = 5;
	private static final int MIDDLE_PAGE_LIST = (int)Math.ceil(COUNT_PAGE_LINKS * 1.0 / 2);
	
	private Integer totalRecords;
	private Integer currentPage = 1;
	private Integer nextPage;
	private Integer previousPage;
	private Integer totalPages;
	private List<Integer> pageList;
	
	public List<Integer> getPageList(){
		return this.pageList;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		if(currentPage != 1){
			this.previousPage = currentPage - 1;
		} else {
			this.previousPage = null;
		}
		if(totalPages != currentPage){
			this.nextPage = currentPage + 1;
		} else {
			this.nextPage = null;
		}
		makePagesList(currentPage);
	}

	private void makePagesList(Integer curretPage){
		if(currentPage - MIDDLE_PAGE_LIST > 0){
			if(totalPages - curretPage > MIDDLE_PAGE_LIST - 1){
				this.pageList = makeList(curretPage -  MIDDLE_PAGE_LIST + 1);
			} else {
				this.pageList = makeList(totalPages - COUNT_PAGE_LINKS + 1);
			}
		} else {
			this.pageList = makeList(1);
		}
	}
	
	public Integer getNextPage() {
		return this.nextPage;
	}

	public Integer getPreviousPage() {
		return this.previousPage;
	}

	private List<Integer> makeList(int count){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = count; i < COUNT_PAGE_LINKS + count ; i++){
			list.add(i);
		}
		return list;
	}
	
	
	public Integer getCurrentPage(){
		return this.currentPage;
	}
	
	public Integer getTotalPages() {
		return this.totalPages;
	}

	public Integer getLimitResords(){
		return LIMIT_RECORDS;
	}
	
	public void setTotalRecords(Integer totalRecords) {
		this.totalPages = (int)Math.ceil(totalRecords * 1.0 / LIMIT_RECORDS);
		this.totalRecords = totalRecords;
	}
	
	public Integer getTotalRecords(){
		return this.totalRecords;
	}
	
	public Integer getLimitOffset() {
		return (this.currentPage - 1) * LIMIT_RECORDS;
	}
	
}
