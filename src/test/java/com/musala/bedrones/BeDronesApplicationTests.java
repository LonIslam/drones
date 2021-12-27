package com.musala.bedrones;

import com.musala.bedrones.controller.DroneController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest
class BeDronesApplicationTests {

    @Autowired
    DroneController droneController;
    
}
