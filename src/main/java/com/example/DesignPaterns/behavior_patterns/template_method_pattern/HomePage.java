package com.example.DesignPaterns.behavior_patterns.template_method_pattern;

public class HomePage extends PageTemplate{
    @Override
    protected void showBody() {
        System.out.println("Content of home page page");
    }
}
