package com.mso.base.cloud.product.service;

import com.mso.base.cloud.product.domain.po.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {

    public void testC(){
        List<User> list = new ArrayList<>();

        User user1 = new User(13,"t",10);
        User user2 = User.builder().age(1).id(1).name("t1").build();
        User user3 = User.builder().age(18).id(1).name("t3").build();

        list.add(user1);
        list.add(user2);
        list.add(user3);

        list.sort(Comparator.comparing(User::getAge).reversed());
        System.out.println(list);
    }

    public static void main(String[] args) {
        new UserService().testC();
    }
}
