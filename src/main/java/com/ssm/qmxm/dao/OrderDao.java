package com.ssm.qmxm.dao;

import com.github.pagehelper.PageInfo;
import com.ssm.qmxm.dto.SellerAddressDTO;
import com.ssm.qmxm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderDao {
    public List<OrderModel> selectorder();
    public SellerModel admin(String account);
    public int fahuo(Integer id,String deliver,String name);
    public List<UserModel> users();
    public int deleteuser(Integer id);
    public List<Integer> selectbuyerxx(Integer id);
    public List<Integer> selectshop(Integer id);
    public List<BooksclModel> classification();
    public int deletescl(Integer id);
    public List<Integer> selectbookbyid(Integer id);
    public int updatescl(String value,String id);
    public int insertscl(BooksclModel booksclModel);
    public String selectscl(String name);
    public List<BooksModel> selectbooks();
    public int inputbook(BooksModel booksModel);
    public BooksModel selebook(Integer id);
    public int upbook(BooksModel booksModel);
    public int dedeleteuser(Integer id);
    public int upbook1(BooksModel booksModel);
    public List<DistrictProvince> selectProvince();
    public List<DistrictCity> selectCityByCid(Integer id);
    public List<SellerAddressDTO> selectAdressDTO(Integer id);
    public DistrictCity selectCityById(Integer id);
    public int insertAddress(SellerAddress sellerAddress);
    public SellerAddress selectAddressById(Integer id);
    public int updateAddress(SellerAddress sellerAddress);
    public int deleteAddress(Integer id);
}
