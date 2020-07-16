package com.jlyk.parking;

import com.jlyk.domain.Car;
import com.jlyk.domain.User;
import com.jlyk.mapper.CarMapper;
import com.jlyk.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParkingApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarMapper carMapper;
    @Test
    void contextLoads() {

//        User user = userMapper.findByUsernameAndPassword("abc132", "123456");
//        userMapper.updateMoneyByID(user.getUid(),10000);
//        int moneyByID = userMapper.findMoneyByID(user.getUid());
//        System.out.println(moneyByID);
//        user.setName("吴小叼");
//
//        System.out.println(user);
//        User user2 = userMapper.findByID(user.getUid());
//        System.out.println(user2);
//        Car byUid = carMapper.findByUID(user.getUid());
//        System.out.println(byUid);
//
//        List<Car> byInParking = carMapper.findByInParking();
//        System.out.println(byInParking);
//
//        User byCid = userMapper.findByCid(byInParking.get(0).getCid());
//        System.out.println(byCid);

    }
}
