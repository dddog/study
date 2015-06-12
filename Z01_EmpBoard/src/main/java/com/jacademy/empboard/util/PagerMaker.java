package com.jacademy.empboard.util;

public class PagerMaker {

	private Pager pager;
	
	public PagerMaker() {
		this.pager = new Pager();
	}
	
	public Pager make(int showPage, int totalCount) {
		
		pager.setCurrentPage(showPage);
		pager.setTotalCount(totalCount);
		
		//검색쿼리 범위 값 설정
		pager.setStart(calcFirstRowInPage(pager.getCurrentPage(), pager.getRowPerPage()));
		pager.setEnd(calcLastRowInPage(pager.getCurrentPage(), pager.getRowPerPage()));
		
		//전체페이지 수 구하기
		pager.setTotalPage(calcTotalPage(pager.getTotalCount(), pager.getRowPerPage()));
		
		//시작 페이지, 끝 페이지 구하기
		pager.setFirstPage(calcFirstPageInBlock(pager.getTotalPage(), pager.getCurrentPage(), pager.getPagePerBlock()));
		pager.setLastPage(calcLastPageInBlock(pager.getTotalPage(), pager.getCurrentPage(), pager.getPagePerBlock()));
		
		return this.pager;
	}

	public Pager make(int showPage, int rowPerPage, int pagePerBlock, int totalCount) {
		
		pager.setCurrentPage(showPage);
		pager.setRowPerPage(rowPerPage);
		pager.setPagePerBlock(pagePerBlock);
		pager.setTotalCount(totalCount);
		
		//검색쿼리 범위 값 설정
		pager.setStart(calcFirstRowInPage(pager.getCurrentPage(), pager.getRowPerPage()));
		pager.setEnd(calcLastRowInPage(pager.getCurrentPage(), pager.getRowPerPage()));
		
		//전체페이지 수 구하기
		pager.setTotalPage(calcTotalPage(pager.getTotalCount(), pager.getRowPerPage()));
		
		//시작 페이지, 끝 페이지 구하기
		pager.setFirstPage(calcFirstPageInBlock(pager.getTotalPage(), pager.getCurrentPage(), pager.getPagePerBlock()));
		pager.setLastPage(calcLastPageInBlock(pager.getTotalPage(), pager.getCurrentPage(), pager.getPagePerBlock()));
		
		return this.pager;
	}

	private int calcTotalPage(int totalCount, int rowPerPage){

		int totalPage = 0;
		if (totalCount==0) {
			return totalPage;
		}
		int oneMorePage = 0;
		if (totalCount%rowPerPage!=0) {
			oneMorePage = 1;
		}
		totalPage = (totalCount/rowPerPage)+oneMorePage;
		return totalPage;
	}
	
	private int calcFirstPageInBlock(int totalPage, int currentPage, int pagePerBlock){
		
		if (totalPage>0) {
			if (currentPage==0) {
				currentPage=1;
			}
			return (currentPage-1)/pagePerBlock*pagePerBlock+1;
		}
		return 0;
	}
	
	private int calcLastPageInBlock(int totalPage, int currentPage, int pagePerBlock){
		
		int lastPage = 1;
		if (totalPage>0) {
			lastPage = calcFirstPageInBlock(totalPage, currentPage, pagePerBlock)+(pagePerBlock-1);
			if (lastPage > totalPage) {
				lastPage = totalPage;
			}
			return lastPage;
		}
		
		return lastPage;
	}
	
	private int calcFirstRowInPage(int currentPage, int rowPerPage){
		if (currentPage==0) {
			currentPage=1;
		}
		return ((currentPage-1)*rowPerPage+1);
	}
	
	private int calcLastRowInPage(int currentPage, int rowPerPage){
		if (currentPage==0) {
			currentPage=1;
		}
		return currentPage*rowPerPage;
	}
}
