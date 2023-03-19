package com.mofany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description AffiliatedCompany 所属公司
 */
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AffiliatedCompany implements Serializable {
    /**
     * 公司编号
     * */
    private Integer id;

    /**
     * 公司名
     * */
    private String name;

    /**
     * 公司法人
     * */
    private String legal_person;

    /**
     * 公司地址
     * */
    private String address;

    /**
     * 成立时间,get、post请求用@JsonFormat注解规范日期时间显示格式
     * */
    @JsonFormat(pattern = "YYYY-MM-ddd HH:mm:ss")
    private Date established;
}
