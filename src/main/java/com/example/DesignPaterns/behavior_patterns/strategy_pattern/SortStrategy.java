package com.example.DesignPaterns.behavior_patterns.strategy_pattern;

import java.util.List;

public interface SortStrategy {
    <T> void sort(List<T> items);
}
