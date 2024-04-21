package com.ssm.qmxm.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (seller_address)实体类
 *
 * @author kancy
 * @since 2023-07-11 09:12:14
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SellerAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * adsId
     */
    private Integer adsId;
    /**
     * adsProvince
     */
    private Integer adsProvince;
    /**
     * adsCity
     */
    private Integer adsCity;
    /**
     * adsHouse
     */
    private String adsHouse;
    /**
     * adsSeller
     */
    private Integer adsSeller;

}