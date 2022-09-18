package repository;

import model.Answer;
import model.Question;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private static final SessionFactory factory=
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Question.class)
                    .addAnnotatedClass(Answer.class)
                    .buildSessionFactory();



    public static SessionFactory getFactory() {
        return factory;
    }

}
