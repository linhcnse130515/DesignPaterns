package com.example.DesignPaterns.behavior_patterns.template_method_pattern;

public class DetailPage extends PageTemplate{
    @Override
    protected void showBody() {
        System.out.println("Content of detail");
    }
}
