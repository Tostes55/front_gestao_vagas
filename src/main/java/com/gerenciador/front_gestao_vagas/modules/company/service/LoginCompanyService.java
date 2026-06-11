package com.gerenciador.front_gestao_vagas.modules.company.service;

import com.gerenciador.front_gestao_vagas.modules.candidate.dto.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginCompanyService {

    @Value("${host.api.gestao_vagas}")
    private String hotApiGestaoVagas;

    public Token execute(String username, String password){
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

        var url = hotApiGestaoVagas.concat("/company/auth");

        var result = rt.postForObject(url, request, Token.class);
        System.out.println("Retorno do login: ");
        System.out.println(result.getAcess_token());

        System.out.println(result);

        return result;
    }
}
