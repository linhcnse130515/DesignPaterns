package com.example.DesignPaterns.creational_patterns.abstract_factory_pattern;

public class PlasticChair implements Chair{
    @Override
    public void create() {
        System.out.println("Create plastic chair");
    }
}
