package com.github.hofls.designpatterns.behavioral.strategy;

import java.util.List;

public class Classes {

    public interface Sorting {
        void sort(List<String> list);
    }

    public static class QuickSorting implements Sorting {
        @Override
        public void sort(List<String> list) {}
    }

    public static class SlowSorting implements Sorting {
        @Override
        public void sort(List<String> list) {}
    }

}
