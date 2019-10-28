package com.zjiecode.wxpusher.client.bean;

import java.util.List;

/**
 * 说明：分页数据
 * 作者：zjiecode
 * 时间：2019-10-28
 */
public class Page<T> {
    private Integer total;
    private Integer page;
    private Integer pageSize;
    private List<T> records;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
