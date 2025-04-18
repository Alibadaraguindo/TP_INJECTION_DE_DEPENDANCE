package net.ali.metier;

import net.ali.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("d2")
    private IDao dao; //Couplage faible

/**
     * Pour injecter dans l'attribut dao
     * un objet d'une classe qui implemente l'interface IDao
 * au moment de l'instatiaton
     */
    public MetierImpl( @Qualifier("d") IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t*12*Math.PI/2*Math.cos(t);
        return res;
    }

    /**
     * Pour injecter dans l'attribut dao
     * un objet d'une classe qui implemente l'interface IDao
     * apres instantiation
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
