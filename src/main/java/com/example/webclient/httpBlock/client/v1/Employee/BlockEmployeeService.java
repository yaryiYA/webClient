package com.example.webclient.httpBlock.client.v1.Employee;

import com.example.webclient.DTO.v1.EmployeeDTOv1;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface BlockEmployeeService {
    List<EmployeeDTOv1> findAll();

    EmployeeDTOv1 findByLogin(String login);

    EmployeeDTOv1 create(EmployeeDTOv1 employee);

    EmployeeDTOv1 update(EmployeeDTOv1 employee);

    void delete(UUID uuid);
}
