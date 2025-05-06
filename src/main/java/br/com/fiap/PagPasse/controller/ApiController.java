package br.com.fiap.PagPasse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Endpoint existente (mantenha)
    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello from a public endpoint!";
    }

    // Endpoint existente (mantenha)
    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello from a private endpoint!";
    }

    // Novo endpoint de health check (adicione)
    @GetMapping("/health")
    public String healthCheck() {
        return "{\"status\": \"UP\"}";  // Retorno padronizado para health checks
    }
}