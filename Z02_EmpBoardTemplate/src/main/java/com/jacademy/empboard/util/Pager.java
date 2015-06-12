package com.jacademy.empboard.util;

public class Pager {

	private int currentPage;
	private int rowPerPage;
	private int pagePerBlock;
	private int start;
	private int end;
	private int firstPage;
	private int lastPage;
	private int totalCount;
	private int totalPage;

	public Pager() {}

	public Pager(int currentPage, int rowPerPage, int pagePerBlock) {
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage;
		this.pagePerBlock = pagePerBlock;
	}

	public int getCurrentPage() {
		if (currentPage == 0) {
			return 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowPerPage() {
		if (rowPerPage == 0) {
			rowPerPage = 10;
		}
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getPagePerBlock() {
		if (pagePerBlock == 0) {
			pagePerBlock = 10;
		}
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getStart() {
		if (start == 0) {
			start = 1;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		if (end == 0) {
			end = 10;
		}
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getFirstPage() {
		if (firstPage == 0) {
			firstPage = 1;
		}
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		if (lastPage == 0) {
			lastPage = 1;
		}
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
