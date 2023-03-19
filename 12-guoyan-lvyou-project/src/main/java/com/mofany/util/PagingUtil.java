package com.mofany.util;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/4
 * @description PagingUtil 自定义假分页工具类
 */
public class PagingUtil {

    /**
     * 不允许反射创建该类对象
     */
    private PagingUtil() {
        throw new RuntimeException("禁止反射！");
    }

    /**
     * @param data        要分页的数据源
     * @param currentPage 当前页
     * @param pageSize    每页的记录数
     */
    public static List<Object> paging(List data, int currentPage, int pageSize) {
        /**
         * 对数据源的非空性与长度非0性的判断
         * */
        if (data == null || data.size() == 0) {
            return null;
        }
        //最大页码
        int mxaPage = 0;
        //剩余记录数
        int remainingSize = 0;
        //先计算终点下标
        int endIndex = currentPage * pageSize;
        //后计算起点下标
        int startIndex = endIndex - pageSize;
        //查询的结果集
        List resultData = null;
        /**
         * 计算最大页与剩余记录：mxaPage = (int) Math.ceil(data.size() / (pageSize * 1.0));
         * */
        int pages = data.size() / pageSize;
        mxaPage = (data.size() / (pageSize * 1.0)) > pages ? pages + 1 : pages;
        remainingSize = data.size() % pageSize;
        System.out.println("总页数：" + mxaPage);
        System.out.println("当前页：" + currentPage);
        System.out.println("总记录数：" + data.size());
        System.out.println("每页记录数：" + pageSize);
        System.out.println("剩余记录数" + remainingSize);
        //请求当前页不符合规范抛异常
        if (currentPage < 1 || currentPage > mxaPage) {
            throw new IllegalArgumentException("1 <= currentPage <=" + mxaPage);
        }
        /**
         * 每次请求的页码范围的判断
         * */
        if (currentPage >= 1 && currentPage < mxaPage) {
            //最后一页之前
            resultData = data.subList(startIndex, endIndex);
        } else if (currentPage == mxaPage) {
            //最后一页
            resultData = data.subList(startIndex, startIndex + remainingSize);
        }
        return resultData;
    }
}
