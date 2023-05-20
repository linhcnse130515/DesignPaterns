package com.example.DesignPaterns.creational_patterns.abstract_factory_pattern;

public class WoodChair implements Chair{
    @Override
    public void create() {
        System.out.println("Create wood chair");
    }
}
