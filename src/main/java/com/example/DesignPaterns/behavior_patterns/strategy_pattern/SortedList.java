package com.example.DesignPaterns.behavior_patterns.strategy_pattern;

import java.util.ArrayList;
import java.util.List;

public class SortedList {
    private SortStrategy strategy;
    private final List<String> items = new ArrayList<>();

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void sort() {
        strategy.sort(items);
    }
}
