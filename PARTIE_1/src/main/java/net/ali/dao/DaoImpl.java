package net.ali.dao;

import org.springframework.stereotype.Component;

@Component("d")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("VERSION BASE DE DONNEES");
        double t = 34;
        return t;
    }
}
