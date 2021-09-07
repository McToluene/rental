package com.mctoluene.rental.dtos.response;

public class PagedResponse<T> extends Response<T> {
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private int totalRecords;

    public PagedResponse(T data, String message, boolean succeeded, int pageNumber, int pageSize) {
        super(data, message, succeeded);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
