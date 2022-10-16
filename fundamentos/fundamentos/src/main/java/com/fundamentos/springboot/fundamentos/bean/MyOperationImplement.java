package com.fundamentos.springboot.fundamentos.bean;

public class MyOperationImplement implements IMyOperation {
    @Override
    public int Sum(int number) {
        return number + 7;
    }
}
