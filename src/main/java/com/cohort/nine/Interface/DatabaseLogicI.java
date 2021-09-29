package com.cohort.nine.Interface;

import java.util.List;

public interface DatabaseLogicI<T> {
    void add(T t) ;
    List<T> view();
}
