package net.ali.pres;

import net.ali.dao.IDao;
import net.ali.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Scanner;

public class pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(new File("config.txt"));


        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d= (IDao) cDao.newInstance();


        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        //IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
        //Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
        //setDao.invoke(metier,d);


        System.out.println("RES="+metier.calcul());
    }
}
