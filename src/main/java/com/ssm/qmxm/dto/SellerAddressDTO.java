package com.ssm.qmxm.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SellerAddressDTO {
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
    /**
     * 省的主键
     */
    private Integer prId;
    /**
     * 省的名称
     */
    private String prName;
    /**
     * 城市主键
     */
    private Integer ciId;
    /**
     * 城市名称
     */
    private String ciName;
    /**
     * 外键，城市对应的省
     */
    private Integer ciCid;

}
