package net.ali.ext;

import net.ali.dao.IDao;
import org.springframework.stereotype.Component;

@Component("d2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("VERSION CAPTEURS......");
        double t =12;
        return t;

    }
}
