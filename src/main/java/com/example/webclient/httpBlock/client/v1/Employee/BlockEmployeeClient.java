package com.example.webclient.httpBlock.client.v1.Employee;

import com.example.webclient.DTO.v1.EmployeeDTOv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.util.List;
import java.util.UUID;

@Service
public class BlockEmployeeClient implements BlockEmployeeService{
    private final WebClient webClient;
    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${endpoint.employees.list}")
    private String getEmployeesList;
    @Value("${endpoint.employee.login}")
    private String getEmployee;
    @Value("${endpoint.employee.create}")
    private String createEmployee;

    @Value("${endpoint.employee.update.login}")
    private String updateEmployee;
    @Value("${endpoint.employee.delete.loign}")
    private String  deleteEmployee;
    @Value("${token}")
    private String token;


    @Autowired
    public BlockEmployeeClient() {
        HttpClient httpClient = HttpClient.
                create()
                .port(8081);

        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Override
    public List<EmployeeDTOv1> findAll() {
        return webClient.get()
                .uri(getEmployeesList)
                .retrieve()
                .bodyToFlux(EmployeeDTOv1.class)
                .collectList()
                .block();
    }

    @Override
    public EmployeeDTOv1 findByLogin(String login) {
        return webClient.get()
                .uri(String.join(getEmployee,login))
                .retrieve()
                .bodyToMono(EmployeeDTOv1.class)
                .block();
    }

    @Override
    public EmployeeDTOv1 create(EmployeeDTOv1 employee) {
        return null;
    }

    @Override
    public EmployeeDTOv1 update(EmployeeDTOv1 employee) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
