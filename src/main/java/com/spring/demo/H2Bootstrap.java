package com.spring.demo;

import com.spring.demo.entity.RoomEntity;
import com.spring.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrapping data....");
        this.roomRepository.save(new RoomEntity(401,"20"));
        this.roomRepository.save(new RoomEntity(402, "30"));
        this.roomRepository.save(new RoomEntity(403,"40"));

        System.out.println("Printing out data....");
        Iterable<RoomEntity> itr = this.roomRepository.findAll();
        for (RoomEntity entity: itr){

            System.out.println("Room Number is:"+entity.getRoomNumber());
            System.out.println("Room Id is :"+entity.getId());
        }
    }
}
