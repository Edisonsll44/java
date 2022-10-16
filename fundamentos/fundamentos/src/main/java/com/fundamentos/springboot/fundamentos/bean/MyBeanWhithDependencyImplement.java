package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWhithDependencyImplement implements IMyBeanWithDependency {
    private IMyOperation _myOperation;

    public MyBeanWhithDependencyImplement(IMyOperation myOperation){
        _myOperation = myOperation;
    }

    @Override
    public void PrintWhitDependency() {
        System.out.println(_myOperation.Sum(7));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
