package com.taekyoungk.matching_service.domain.user.dto;

import com.taekyoungk.matching_service.common.enums.SortDirection;

public class UserSearchParams {
    private String sortBy = "createdAt";
    private SortDirection sortDir = SortDirection.DESC;
    private int page = 0;
    private int size = 10;

    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public SortDirection getSortDir() {
        return sortDir;
    }
    public void setSortDir(SortDirection sortDir) {
        this.sortDir = sortDir;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}