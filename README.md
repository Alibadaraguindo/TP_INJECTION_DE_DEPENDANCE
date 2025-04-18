# TP_INJECTION_DE_DEPENDANCE
TP_INJECTION_DE_DEPENDANCE
Objectif de l’activité
L’objectif de cette première partie est de comprendre et mettre en œuvre le principe d’injection des dépendances dans une application Java. L’approche consiste à découpler les composants de l'application en utilisant des interfaces, puis à injecter les dépendances via différentes techniques, y compris l'utilisation du framework Spring.
Étapes réalisées
 1. Création des interfaces
IDao avec la méthode getData()

IMetier avec la méthode calcul()

2. Implémentations
DaoImpl : fournit une donnée simulée.

MetierImpl : dépend de IDao pour effectuer un traitement (ex. : multiplication).

 3. Injection des dépendances
a. Par instanciation statique

IDao dao = new DaoImpl();
MetierImpl metier = new MetierImpl();
metier.setDao(dao);


b. Par instanciation dynamique (via réflexion)
Class<?> daoClass = Class.forName("com.exemple.DaoImpl");
IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();

Class<?> metierClass = Class.forName("com.exemple.MetierImpl");
IMetier metier = (IMetier) metierClass.getDeclaredConstructor().newInstance();

Method setDao = metierClass.getMethod("setDao", IDao.class);
setDao.invoke(metier, dao);



Avec Spring (XML + annotations)

<bean id="dao" class="com.exemple.DaoImpl"/>
<bean id="metier" class="com.exemple.MetierImpl">
    <property name="dao" ref="dao"/>
</bean>



@Component
public class DaoImpl implements IDao {}

@Component
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;
}


