package com.jlyk.controller;

import com.jlyk.domain.Car;

import com.jlyk.service.CarService;
import com.jlyk.service.CarUserService;
import com.jlyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarUserService carUserService;
    @Autowired
    private UserService userService;



    @RequestMapping("/updateCarDao")
    public ModelAndView updateCarDao(Car car){
        ModelAndView modelAndView = new ModelAndView();

        Car c = carService.findByLicense(car.getLicense());


        if (c==null || c.getLicense().equals(car.getLicense())){
            carService.updateCar(car);
            System.out.println(111);
            modelAndView.addObject("msg","修改成功");
            modelAndView.setViewName("index");
            return modelAndView;
        }else {
            modelAndView.addObject("msg","该车牌已存在");
            modelAndView.setViewName("updateCar");
        }

        return modelAndView;
    }

    @GetMapping("/updateCar/{cid}")
    public ModelAndView UpdateCar(@PathVariable("cid") Integer cid){
        ModelAndView modelAndView = new ModelAndView();

        Car car = carService.findByCid(cid);
        modelAndView.addObject("car",car);
        modelAndView.setViewName("updateCar");
        return modelAndView;

    }


    @ResponseBody
    @PostMapping("/adminFindCar")
    public List<Car> adminCarTable(Integer flag){
        List<Car> carList=null;
        if (flag==1){
            carList = carService.findAllCar();
        }else {
            carList = carService.findByInParking();
        }
        return carList;
    }

    @ResponseBody
    @PostMapping("/findCar")
    public List<Car> findCarByUId(Integer uid){
        List<Car> carList = carService.findByUID(uid);

        return carList;
    }

    @RequestMapping("/insertCar")
    public ModelAndView insertCar(Integer uid, String license, String carName, HttpSession  session) {
        ModelAndView modelAndView = new ModelAndView();

        Car car = carService.findByLicense(license);
        if (car != null) {

            if (carUserService.findIdByUidAndCid(car.getCid(),uid) ==null){
                carUserService.insertCarUser(uid, car.getCid());
                modelAndView.addObject("msg","添加成功  ");
            }else {
                modelAndView.addObject("msg","车辆已存在");
            }

        } else {
            carService.insertCar(license, carName);
            Car car1 = carService.findByLicense(license);
            carUserService.insertCarUser(uid, car1.getCid());
            modelAndView.addObject("msg","添加成功  ");
        }

        session.setAttribute("user",userService.findByID(uid));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/deleteCar")
    public String deleteCar(Integer cid,Integer uid){
        try {
            carUserService.deleteCarUser(cid,uid);
            Integer id = carUserService.findIdByCid(cid);

            if (id ==null){
                carService.deleteCar(cid);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
}
