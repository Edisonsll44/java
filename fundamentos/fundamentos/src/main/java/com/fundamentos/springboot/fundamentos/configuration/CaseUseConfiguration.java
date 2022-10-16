package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.caseuse.GetUserImplement;
import com.fundamentos.springboot.fundamentos.caseuse.IGetUser;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    IGetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
