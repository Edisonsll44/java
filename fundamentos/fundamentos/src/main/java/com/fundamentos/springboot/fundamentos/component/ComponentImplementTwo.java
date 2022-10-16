package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements  IComponentDependency{
    @Override
    public void Saludar() {
        System.out.println("Hola mundo desde implementación 2");
    }
}
