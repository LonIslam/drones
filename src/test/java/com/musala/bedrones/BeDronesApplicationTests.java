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

//    @Test
//    void contextLoads() {
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setAge(26);
//        employeeDto.setName("Islam");
//        employeeDto.setContractInformation("2 years contract");
//
//        ResponseEntity responseEntity = droneController.addEmployee(employeeDto);
//        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        EmployeeResponse createdEmployee = (EmployeeResponse) responseEntity.getBody();
//        Assert.assertEquals(employeeDto.getAge(), createdEmployee.getAge());
//        Assert.assertEquals(DroneState.ADDED, createdEmployee.getDroneState());
//        Assert.assertEquals(employeeDto.getName(), createdEmployee.getName());
//        Assert.assertEquals(employeeDto.getContractInformation(), createdEmployee.getContractInformation());
//        Assert.assertNotNull(createdEmployee.getId());
//    }
}
