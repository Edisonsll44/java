package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements IMyBeanWithProperties{
    private String _nombre;
    private String _apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido)
    {
        _nombre = nombre;
        _apellido = apellido;
    }
    @Override
    public String Function() {
        return _nombre + " - " + _apellido;
    }
}
