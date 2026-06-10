package com.gerenciador.front_gestao_vagas.modules.candidate.dto;


import lombok.Data;

import java.util.List;

@Data
public class Token {

    private String acess_token;
    private List<String> roles;
    private Long expires_in;

}
