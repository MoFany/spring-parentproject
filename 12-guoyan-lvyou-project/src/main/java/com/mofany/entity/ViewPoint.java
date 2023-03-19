package com.mofany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description ViewPoint 景点
 */
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ViewPoint implements Serializable {
    /**
     * 景点编号
     * */
    private Integer id;

    /**
     * 景点名
     * */
    private String name;

    /**
     * 景点负责人
     * */
    private String principal;

    /**
     * 门票
     * */
    private BigDecimal tickets;

    /**
     * 成立时间,get、post请求用@JsonFormat注解规范日期时间显示格式
     * */
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date established;

    /**
     * 开放时间,get、post请求用@JsonFormat注解规范日期时间显示格式
     * */
    @JsonFormat(pattern = "HH:mm:ss")
    private Time opentime;

    /**
     * 所属公司
     * */
    private List<AffiliatedCompany> companyList;
}
