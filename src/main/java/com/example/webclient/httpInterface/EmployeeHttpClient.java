package com.example.webclient.httpInterface;

import com.example.webclient.DTO.v1.EmployeeDTOv1;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@HttpExchange
public interface EmployeeHttpClient {

    @GetExchange("employee/list")
    Flux<EmployeeDTOv1> findAll();

    @GetExchange("employee/{login}")
    Mono<EmployeeDTOv1> findByLogin(@PathVariable String login);
}
