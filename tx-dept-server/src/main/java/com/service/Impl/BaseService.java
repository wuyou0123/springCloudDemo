package com.service.Impl;

import com.common.utils.PageResult;
import com.github.pagehelper.PageInfo;

public class BaseService<T> {

    public PageResult<T> getPageResult(PageInfo<T> pageInfo) {
        PageResult<T> pageResult = new PageResult<T>();
        pageResult.setList(pageInfo.getList());
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPages(pageInfo.getPages());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setSize(pageInfo.getSize());
        pageResult.setIsFirstPage(pageInfo.isIsFirstPage());
        pageResult.setIsLastPage(pageInfo.isIsLastPage());
        return pageResult;
    }


}
