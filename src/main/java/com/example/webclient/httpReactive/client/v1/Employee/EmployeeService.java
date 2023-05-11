package com.example.webclient.httpReactive.client.v1.Employee;

import com.example.webclient.DTO.v1.EmployeeDTOv1;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Flux<EmployeeDTOv1> findAll();

    Mono<EmployeeDTOv1> findByLogin(String login);

    Mono<EmployeeDTOv1> create(EmployeeDTOv1 employee);

    Mono<EmployeeDTOv1> update(EmployeeDTOv1 employee);

    Mono<Void> delete(UUID uuid);

}
