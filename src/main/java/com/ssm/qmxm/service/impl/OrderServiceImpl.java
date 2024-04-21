package com.ssm.qmxm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.qmxm.dao.OrderDao;
import com.ssm.qmxm.dto.SellerAddressDTO;
import com.ssm.qmxm.model.*;
import com.ssm.qmxm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private SellerModel sellerModel;
    public SellerModel getSellerModel(){
        return sellerModel;
    }
    @Autowired
    OrderDao orderDao;
    @Override
    public PageInfo<OrderModel> selectorder(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<OrderModel> list = orderDao.selectorder();
        PageInfo<OrderModel> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int admin(String account,String pass) {
        sellerModel=orderDao.admin(account);
        if(sellerModel==null){
            return -1;
        }
        else {
            if(sellerModel.sePass.equals(pass)){
                return 1;
            }else {
                return -1;
            }
        }
    }

    @Override
    public int fahuo(Integer id,String deliver,String name) {
        return orderDao.fahuo(id,deliver,name);
    }

    @Override
    public PageInfo<UserModel> users(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<UserModel> list = orderDao.users();
        PageInfo<UserModel> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public int deleteuser(Integer id) {
        return orderDao.deleteuser(id);
    }

    @Override
    public int dedeleteuser(Integer id) {
        return orderDao.dedeleteuser(id);
    }

    @Override
    public List<Integer> selectbuyerxx(Integer id) {
        return orderDao.selectbuyerxx(id);
    }

    @Override
    public List<Integer> selectshop(Integer id) {
        return orderDao.selectshop(id);
    }

    @Override
    public PageInfo<BooksclModel> classification(Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<BooksclModel> list = orderDao.classification();
        PageInfo<BooksclModel> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public Integer delectscl(Integer id) {
        List<Integer> book=orderDao.selectbookbyid(id);
        if(book.size()==0){
            orderDao.deletescl(id);
            return 1;
        }
        return 0;
    }
    @Override
    public int updatescl(String value,String id){
        return orderDao.updatescl(value,id);
    }

    @Override
    public int insertscl(BooksclModel booksclModel) {
        return orderDao.insertscl(booksclModel);
    }

    @Override
    public String selectscl(String name) {
        return orderDao.selectscl(name);
    }

    @Override
    public PageInfo<BooksModel> selectbooks(Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<BooksModel> book=orderDao.selectbooks();
        PageInfo<BooksModel> page = new PageInfo<>(book, 5);
        return page;
    }

    @Override
    public List<BooksclModel> bookscl() {
        return orderDao.classification();
    }

    @Override
    public BooksModel selebook(Integer id) {
        return orderDao.selebook(id);
    }

    @Override
    public int inputbook(BooksModel booksModel) {
        return orderDao.inputbook(booksModel);
    }

    @Override
    public int upbook(BooksModel booksModel) {
        return orderDao.upbook(booksModel);
    }
    @Override
    public int upbook1(BooksModel booksModel) {
        return orderDao.upbook1(booksModel);
    }
    @Override
    public List<DistrictProvince> selectProvince(){
        return orderDao.selectProvince();
    }
    @Override
    public List<DistrictCity> selectCityByCid(Integer id){
        return orderDao.selectCityByCid(id);
    }
    @Override
    public List<SellerAddressDTO> selectAdressDTO(Integer id){
        return orderDao.selectAdressDTO(id);
    }
    @Override
    public DistrictCity selectCityById(Integer id){
        return orderDao.selectCityById(id);
    }
    @Override
    public int insertAddress(SellerAddress sellerAddress){
        return orderDao.insertAddress(sellerAddress);
    }
    @Override
    public SellerAddress selectAddressById(Integer id){
        return orderDao.selectAddressById(id);
    }
    @Override
    public int updateAddress(SellerAddress sellerAddress){
        return orderDao.updateAddress(sellerAddress);
    }

    @Override
    public int deleteAddress(Integer id){
        return orderDao.deleteAddress(id);
    }
}
