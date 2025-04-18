package com.ali.framework.demo;

import com.ali.framework.annotations.Component;

@Component
public class IDaoImpl implements IDao {
    @Override
    public double getData() {
        return 42; // une valeur simulée
    }
}