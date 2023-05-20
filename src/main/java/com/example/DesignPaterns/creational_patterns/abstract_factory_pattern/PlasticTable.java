package com.example.DesignPaterns.creational_patterns.abstract_factory_pattern;

public class PlasticTable implements Table{
    @Override
    public void create() {
        System.out.println("Create plastic table");
    }
}
