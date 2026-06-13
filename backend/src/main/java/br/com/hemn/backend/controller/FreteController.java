package br.com.hemn.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreteController {

    @GetMapping("/frete")
    public Double calcularFrete(
            @RequestParam String cep
    ) {

        cep = cep.replace("-", "");

        if (cep.startsWith("89900")) {
            return 5.0;
        }

        if (cep.startsWith("89910")) {
            return 8.0;
        }

        return 12.0;
    }
}