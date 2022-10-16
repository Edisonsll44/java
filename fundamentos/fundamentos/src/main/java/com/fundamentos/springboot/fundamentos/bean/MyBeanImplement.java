package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanImplement implements  IMyBean{
    @Override
    public void Print() {
        System.out.println("Hola desde una función propia del bean");
    }
}
