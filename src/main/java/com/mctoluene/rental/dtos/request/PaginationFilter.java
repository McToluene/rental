package com.mctoluene.rental.dtos.request;

public class PaginationFilter {
    private final int pageNumber;
    private final int pageSize;

    public PaginationFilter(int pageNumber, int pageSize) {
        this.pageNumber = Math.max(pageNumber, 1);
        this.pageSize = pageSize < 5 ? 5 : Math.min(pageSize, 50);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
