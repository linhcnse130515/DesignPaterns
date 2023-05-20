package com.example.DesignPaterns.behavior_patterns.strategy_pattern;

import java.util.List;

public class SelectionSort implements SortStrategy{
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Selection sort");
    }
}
