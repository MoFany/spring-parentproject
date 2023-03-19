package com.mofany.controller;

import com.mofany.entity.ViewPoint;
import com.mofany.service.ViewPointService;
import com.mofany.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description MyController 自定义控制器 包含了前端访问的各个接口
 */
@RestController
@RequestMapping(value = "api")
public class MyController {

    /**
     * 响应结果
     */
    private Map<String, Object> responseMap = new HashMap<>();

    /**
     * 业务逻辑层接口：执行SQL
     */
    private ViewPointService viewPointService;

    /**
     * 结果集
     */
    private List<ViewPoint> allViewPoint;

    /**
     * 构造器注入
     */
    @Autowired
    public MyController(ViewPointService viewPointService) {
        this.viewPointService = viewPointService;
    }

    /**
     * 旅游景点信息录入请求
     * 测试接口：http://localhost:8080/viewpoint/api/insertData?id=6&name=大云寺&principal=李丽华&tickets=55&established=2023-2-2 5:5:5&opentime=5:30:0
     */
    @GetMapping("insertData")
    @ResponseBody
    public Map<String, Object> requestInsertHandler(@ModelAttribute("viewPoint") ViewPoint viewPoint) {
        //清空响应map
        responseMap.clear();
        int result = 0;
        if (viewPoint == null) {
            responseMap.put("新增记录数", result);
            return responseMap;
        }
        //新增
        result = viewPointService.insertByEntity(viewPoint);
        responseMap.put("新增记录数", result);
        return responseMap;
    }

    /**
     * 旅游景点信息删除与批量删除请求
     * 测试接口：http://localhost:8080/viewpoint/api/deleteData
     * @param ids 传入json或请求字符串
     */
    @DeleteMapping("deleteData")
    @ResponseBody
    public Map<String, Object> requestDeleteHandler(@RequestBody Map<String,Object> ids) {
        //清空响应map
        responseMap.clear();
        int result = 0;
        if (ids == null) {
            responseMap.put("删除记录数", result);
            return responseMap;
        }
        //获取值的列表
        List<Object> list=(ArrayList)ids.get("ids");
        //删除与批量删除
        result = viewPointService.deleteByIds(list);
        responseMap.put("删除记录数", result);
        return responseMap;
    }

    /***
     * 旅游景点信息的更新请求处理
     * 测试接口：http://localhost:8080/viewpoint/api/updateData?id=6&principal=李文卓&tickets=58
     * */
    @GetMapping("updateData")
    @ResponseBody
    public Map<String, Object> requestUpdateHandler(@ModelAttribute("viewpoint") ViewPoint viewPoint) {
        //清空响应map
        responseMap.clear();
        int result = 0;
        if (viewPoint == null) {
            responseMap.put("更新记录数", result);
            return responseMap;
        }
        //更新
        result = viewPointService.updateByEntity(viewPoint);
        responseMap.put("更新记录数", result);
        return responseMap;
    }

    /**
     * 多条件查询
     * 测试接口：http://localhost:8080/viewpoint/api/queryData
     */
    @GetMapping("queryData")
    @ResponseBody
    public Map<String, Object> requestShowHandler(@ModelAttribute("viewPoint") ViewPoint viewPoint) {
        //清空响应map
        responseMap.clear();
        if (viewPoint == null) {
            responseMap.put("queryResult", 0);
            return responseMap;
        }
        ViewPoint entity = viewPointService.selectByEntity(viewPoint);
        responseMap.put("queryResult", entity);
        return responseMap;
    }

    /**
     * 旅游景点并分页展示+所属公司名
     * 测试接口：http://localhost:8080/viewpoint/api/showData/1
     */
    @GetMapping("showData/{currentPage}")
    @ResponseBody
    public Map<String, Object> requestShowHandler(@PathVariable("currentPage") int currentPage) {
        //清空响应map
        responseMap.clear();
        //一次性取出全部景点信息
        if (allViewPoint == null) {
            allViewPoint = viewPointService.SelectByPage();
        }
        /**
         * 调用自定义分页的插件，每页显示三条记录
         * */
        responseMap.put("queryResults", PagingUtil.paging(allViewPoint, currentPage, 3));
        return responseMap;
    }

    /**
     * 多条件查询旅游景点并分页展示+所属公司名
     * 测试接口：http://localhost:8080/viewpoint/api/showDataByCondition/1?name=骊山
     */
    @GetMapping("showDataByCondition/{currentPage}")
    @ResponseBody
    public Map<String, Object> requestShowByConditionHandler(@PathVariable("currentPage") int currentPage, @ModelAttribute("viewPoint") ViewPoint viewPoint) {
        //清空响应map
        responseMap.clear();
        //一次性取出全部景点信息
        if (allViewPoint == null) {
            allViewPoint = viewPointService.SelectByPages(viewPoint);
        }
        /**
         * 调用自定义分页的插件，每页显示三条记录
         * */
        responseMap.put("queryResults", PagingUtil.paging(allViewPoint, currentPage, 3));
        return responseMap;
    }
}
