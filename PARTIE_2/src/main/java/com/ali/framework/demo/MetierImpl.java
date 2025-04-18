package com.ali.framework.demo;

// MetierImpl.java (champ)

import com.ali.framework.annotations.*;

@Component
public class MetierImpl implements IMetier {

    @Inject
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getData() * 5;
    }
}
