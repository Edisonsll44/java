package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public IMyBean BeanOperation(){
        return  new MyBeanImplement();
    }

    @Bean
    public IMyOperation BeanMyOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public IMyBeanWithDependency BeanOperationWhithDependency(IMyOperation myOperation){
        return  new MyBeanWhithDependencyImplement(myOperation);
    }
}
