package net.ali.pres;

import net.ali.dao.DaoImpl;
import net.ali.ext.DaoImplV2;
import net.ali.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d);// INJECTION DES DEPENDANCES VIA LE SETTER
        System.out.println("RES= " + metier.calcul());
    }
}
