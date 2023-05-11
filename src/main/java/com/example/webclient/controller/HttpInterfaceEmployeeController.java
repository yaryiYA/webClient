//package com.example.webclient.controller;
//
//import com.example.webclient.DTO.v1.EmployeeDTOv1;
//import com.example.webclient.reactive.client.v1.Employee.EmployeeClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//
//@RestController
//@RequestMapping("employee")
//public class EmployeeController {
//    private EmployeeClient employeeClient;
//
//    @Autowired
//    public EmployeeController(EmployeeClient employeeClient) {
//        this.employeeClient = employeeClient;
//    }
//
//    @GetMapping("/getList")
//    public void getEmployees() {
//         employeeClient.findAll();
//    }
//
//    @GetMapping("{login}")
//    public Mono<EmployeeDTOv1> getEmployee(@PathVariable("login")String login) {
//        return employeeClient.findByLogin(login);
//    }
//
//
//}
