package com.example.webclient.configuration;

import com.example.webclient.httpInterface.EmployeeHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Value("${baseUrl}")
    private String baseUrl;


    @Bean
    public EmployeeHttpClient employeeImpClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8081/api/v1/")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(EmployeeHttpClient.class);

    }
}
