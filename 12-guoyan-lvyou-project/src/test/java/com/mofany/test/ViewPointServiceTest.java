package com.mofany.test;

import com.mofany.config.SpringBeansConfig;
import com.mofany.entity.ViewPoint;
import com.mofany.service.ViewPointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description ViewPointServiceTest 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBeansConfig.class})
@WebAppConfiguration("src/main/resources")
public class ViewPointServiceTest {
    @Autowired
    private ViewPoint viewPoint;

    @Autowired
    private ViewPointService viewPointService;

    /**
     * 多条件查询（ok）
     * */
    @Test
    public void test1(){
        viewPoint.setName("崆峒山");
        //负责人
        viewPoint.setPrincipal("蒋明辉");
        //门票
        viewPoint.setTickets(BigDecimal.valueOf(50));
        System.out.println(viewPointService.selectByEntity(viewPoint));
    }

    /**
     * 插入景点数据（ok）
     * */
    @Test
    public void test2(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        viewPoint.setId(5);
        viewPoint.setName("雷锋塔");
        //负责人
        viewPoint.setPrincipal("法海");
        //门票
        viewPoint.setTickets(BigDecimal.valueOf(70));
        //成立时间
        try {
            viewPoint.setEstablished(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //开放时间
        viewPoint.setOpentime(new Time(6,30,00));

        System.out.println(viewPointService.insertByEntity(viewPoint));
    }

    /**
     * 按id动态修改景点数据（业务ok）
     * */
    @Test
    public void test3(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        viewPoint.setId(1);
        //负责人
        viewPoint.setPrincipal("默凡语");
        //门票
        viewPoint.setTickets(BigDecimal.valueOf(120));
        //成立时间
        try {
            viewPoint.setEstablished(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //开放时间
        viewPoint.setOpentime(new Time(8,40,00));

        System.out.println(viewPointService.updateByEntity(viewPoint));
    }

    /**
     * 批量删除景点记录（ok）
     * */
    @Test
    public void test4(){
        List list=List.of(3,4);
        System.out.println(viewPointService.deleteByIds(list));
    }

    /**
     * 分页显示：景点信息+所属公司名
     * */
    @Test
    public void test5(){
        viewPointService.SelectByPage().stream().forEach(System.out::println);
    }

    /**
     * 多条件查询分页显示：景点信息+所属公司
     * */
    @Test
    public void test6(){
        //多条件查询查询票价为50的旅游景点
        viewPoint.setTickets(BigDecimal.valueOf(50));
        viewPointService.SelectByPages(viewPoint).stream().forEach(System.out::println);
    }
}
