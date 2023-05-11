package com.example.webclient.controller;

import com.example.webclient.DTO.v1.EmployeeDTOv1;
import com.example.webclient.httpBlock.client.v1.Employee.BlockEmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("employee")
public class BlockEmployeeController {

    private final BlockEmployeeClient blockEmployeeClient;

    @Autowired
    public BlockEmployeeController(BlockEmployeeClient blockEmployeeClient) {
        this.blockEmployeeClient = blockEmployeeClient;
    }

    @GetMapping("/list")
    public List<EmployeeDTOv1> getEmployees() {
        return blockEmployeeClient.findAll();
    }

    @GetMapping("/{login}")
    public EmployeeDTOv1 getEmployee(@PathVariable("login") String login) {
        return blockEmployeeClient.findByLogin(login);
    }
}
