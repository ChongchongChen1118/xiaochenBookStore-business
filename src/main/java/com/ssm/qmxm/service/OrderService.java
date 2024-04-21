package com.ssm.qmxm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.qmxm.dto.SellerAddressDTO;
import com.ssm.qmxm.model.*;

import java.awt.print.Book;
import java.util.List;


public interface OrderService {
    public SellerModel getSellerModel();
    public PageInfo<OrderModel> selectorder(Integer pageNum);
    public int admin(String account,String pass);
    public int fahuo(Integer id,String deliver,String name);
    public PageInfo<UserModel> users(Integer pageNum);
    public int deleteuser(Integer id);
    public int dedeleteuser(Integer id);
    public List<Integer> selectbuyerxx(Integer id);
    public List<Integer> selectshop(Integer id);
    public PageInfo<BooksclModel> classification(Integer pageNum);
    public Integer delectscl(Integer id);
    public int updatescl(String value,String id);
    public int insertscl(BooksclModel booksclModel);
    public String selectscl(String name);
    public PageInfo<BooksModel> selectbooks(Integer pageNum);
    public List<BooksclModel> bookscl();
    public BooksModel selebook(Integer id);
    public int inputbook(BooksModel booksModel);
    public int upbook(BooksModel booksModel);
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
