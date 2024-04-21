package com.ssm.qmxm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.qmxm.dto.SellerAddressDTO;
import com.ssm.qmxm.model.*;
import com.ssm.qmxm.service.OrderService;
import org.apache.coyote.http2.Http2OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/order/{page}")
    public String index(@PathVariable("page")Integer page, Model model, HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        PageInfo<OrderModel> pages=orderService.selectorder(page);
        List<SellerAddressDTO> list=orderService.selectAdressDTO(sellerModel.seId);
        model.addAttribute("list",list);
        model.addAttribute("page",pages);
        return "index";
    }
    @RequestMapping("/")
    public String login(Model model){
        model.addAttribute("yes",1);
        return "login";
    }
    @RequestMapping("/login")
    public String contrast(Model model,String account,String pass,HttpSession httpSession){
        int a=orderService.admin(account,pass);
        if(a>0){
            httpSession.setAttribute("seller",orderService.getSellerModel());
            return "redirect:/order/1";
        }else {
            model.addAttribute("yes",-1);
            model.addAttribute("account",account);
            return "login";
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpSession httpSession){
        httpSession.removeAttribute("seller");
        return "redirect:/";
    }
    @RequestMapping("/fahuo/{id}")
    public String fahuo(@PathVariable("id") Integer id,Model model,String ordeliver,String name,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        if(ordeliver==null){
            model.addAttribute("aaa",1);
            return "forward:/order/1";
        }
        orderService.fahuo(id,ordeliver,name);
        model.addAttribute("fahuo",1);
        return "forward:/order/1";
    }


    @RequestMapping("/users/{page}")
    public String users(Model model,@PathVariable("page") Integer page,HttpSession httpSession){
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        PageInfo<UserModel> user=orderService.users(page);
        model.addAttribute("page",user);
        return "user";
    }

    @RequestMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable("id") Integer id,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
            int a=orderService.deleteuser(id);
            model.addAttribute("pan",1);
            return "forward:/users/1";
    }

    @RequestMapping("/dedeleteuser/{id}")
    public String dedeleteuser(@PathVariable("id") Integer id,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        int a=orderService.dedeleteuser(id);
        model.addAttribute("depan",1);
        return "forward:/users/1";
    }

    @RequestMapping("/classification/{page}")
    public String classification(@PathVariable("page") Integer page,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
          PageInfo<BooksclModel> booksclModel=orderService.classification(page);
          model.addAttribute("page",booksclModel);
          return "classification";
    }

    @RequestMapping("/deletescl/{id}")
    public String deletescl(@PathVariable("id") Integer id,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        int a=orderService.delectscl(id);
        if(a==1){
            model.addAttribute("yes",1);
            return "forward:/classification/1";
        }else{
            model.addAttribute("yes",0);
            return "forward:/classification/1";
        }
    }
    @RequestMapping("/updatescl")
    public String updatescl(BooksclModel booksclModel,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        String a=orderService.selectscl(booksclModel.clType);
        System.out.println(a);
        if(a!=null){
            model.addAttribute("update",0);
            return "forward:/classification/1";
        }
        int b=orderService.updatescl(booksclModel.getClType(),booksclModel.clId);
        model.addAttribute("update",1);
        return "forward:/classification/1";
    }

    @RequestMapping("/insertscl")
    public String insertscl(BooksclModel booksclModel,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        String a=orderService.selectscl(booksclModel.clType);
        if(a!=null){
            model.addAttribute("insert",0);
            return "forward:/classification/1";
        }
        int b=orderService.insertscl(booksclModel);
        model.addAttribute("insert",1);
        return "forward:/classification/1";
    }
    @RequestMapping("/selectbooks/{page}")
    public String selectbooks(@PathVariable("page") Integer pageNum,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        PageInfo<BooksModel> page=orderService.selectbooks(pageNum);
        model.addAttribute("page",page);
        return "books";
    }
    @RequestMapping("/insertbook")
    public String insertbook(Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        List<BooksclModel> list=orderService.bookscl();
         model.addAttribute("scl",list);
         BooksModel book=new BooksModel();
         model.addAttribute("book",book);
         return "bookcontent";
    }
    @RequestMapping("/updatebook/{id}")
    public String updatebook(Model model,@PathVariable("id") Integer id,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        BooksModel book=orderService.selebook(id);
        List<BooksclModel> list2=orderService.bookscl();
        model.addAttribute("scl",list2);
        model.addAttribute("book",book);
        return "bookcontent";
    }
    @PostMapping  ("/operation1")
    public String operation(MultipartFile file1,BooksModel booksModel,HttpSession httpSession) throws IOException {
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        if((!booksModel.boId.equals(""))&&booksModel.boId!=null){
            if(file1.getSize()==0){
                orderService.upbook(booksModel);
                return "redirect:/selectbooks/1";
            }
            //获取上传的文件的文件名
            String fileName = file1.getOriginalFilename();
            //处理文件重名问题
            String hzName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID().toString() + hzName;
            //获取服务器中file目录的路径
            String photoPath ="C:\\Users\\23154\\Desktop\\upload";
            File file = new File(photoPath);
            if (!file.exists()) {
                file.mkdir();
            }
            String finalPath = photoPath + "\\"+fileName;
            //实现上传功能
            file1.transferTo(new File(finalPath));
            booksModel.setBoPhoto("/upload/"+fileName);
            orderService.upbook1(booksModel);
            return "redirect:/selectbooks/1";
        }
//获取上传的文件的文件名
        String fileName = file1.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中file目录的路径
        String photoPath ="C:\\Users\\23154\\Desktop\\upload";
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + "\\"+fileName;
        //实现上传功能
        file1.transferTo(new File(finalPath));
        booksModel.setBoPhoto("/upload/"+fileName);
        int a=orderService.inputbook(booksModel);
        return "redirect:/selectbooks/1";
    }


    @RequestMapping("/address")
    public String address(Model model, HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        List<SellerAddressDTO> list=orderService.selectAdressDTO(sellerModel.seId);
        model.addAttribute("list",list);
        return "address";
    }

    @RequestMapping("/addaddress/{id}")
    public String addAddress(Model model,@PathVariable("id")Integer id,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        List<DistrictProvince> list1=orderService.selectProvince();
        List<DistrictCity> list2=orderService.selectCityByCid(id);
        model.addAttribute("province",list1);
        model.addAttribute("city",list2);
        model.addAttribute("cid",id);
        return "addaddress";
    }

    @RequestMapping("/addressjudgment")
    public String addressjudgment(Model model,SellerAddress sellerAddress,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        DistrictCity districtCity=orderService.selectCityById(sellerAddress.getAdsCity());
        sellerAddress.setAdsProvince(districtCity.getCiCid());
        if(sellerAddress.getAdsId()==null) {
            sellerAddress.setAdsSeller(sellerModel.seId);
            orderService.insertAddress(sellerAddress);
            model.addAttribute("judgment", 1);
            return "forward:/address";
        }
        model.addAttribute("judgment", 2);
        orderService.updateAddress(sellerAddress);
        return "forward:/address";
    }

    @RequestMapping("/upaddress/{num}/{id}")
    public String addAddress(Model model,@PathVariable("id")Integer id,@PathVariable("num")Integer num,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        SellerAddress sellerAddress=orderService.selectAddressById(num);
        List<DistrictProvince> list1=orderService.selectProvince();
        List<DistrictCity> list2=orderService.selectCityByCid(id);
        model.addAttribute("province",list1);
        model.addAttribute("city",list2);
        model.addAttribute("cid",id);
        model.addAttribute("num",num);
        model.addAttribute("cityId",sellerAddress.getAdsCity());
        model.addAttribute("house",sellerAddress.getAdsHouse());
        return "addaddress";
    }

    @RequestMapping("/deleteaddress/{id}")
    public String deleteAddress(@PathVariable("id")Integer id,Model model,HttpSession httpSession){
        SellerModel sellerModel= (SellerModel) httpSession.getAttribute("seller");
        if(httpSession.getAttribute("seller")==null){
            return "redirect:/";
        }
        orderService.deleteAddress(id);
        model.addAttribute("judgment",3);
        return "forward:/address";
    }
}
