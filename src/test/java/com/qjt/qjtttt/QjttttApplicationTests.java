package com.qjt.qjtttt;

import com.qjt.qjtttt.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QjttttApplicationTests {

    @Resource
    private UserServiceImpl userServiceImpl;


    @Test
    public void MutiDataSourceTest(){
        System.out.println("--------11111111--------");

////        多数据源
//        User user1 =userService.findById(1);
//        System.out.println(user1.toString());
//        assertThat(user1.getUsername(),is("admin"));
//        User user2=userService.findById1(1);
//        assertThat(user2.getUsername(),is("admin1"));
//        System.out.println(user2.toString());
//
////        分页
//        RowBounds rowBounds=new RowBounds(1,5);
//        List list=userService.getUserList(rowBounds);
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }


        System.out.println("--------22222222--------");
    }

    @Test
    public void MyExceptionTest(){
        throw new NullPointerException("sdfew");
    }

}
