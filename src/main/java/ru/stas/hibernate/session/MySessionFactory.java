package ru.stas.hibernate.session;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.stas.hibernate.Main;
import ru.stas.hibernate.config.Config;
import ru.stas.hibernate.model.House;
import ru.stas.hibernate.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MySessionFactory
{
    private static final Logger logger = Logger.getLogger( MySessionFactory.class );

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        if( sessionFactory==null )
        {
            synchronized( SessionFactory.class )
            {
                try
                {
                    Properties properties = Config.getProperties();
                    Configuration configuration = new Configuration();
                    configuration.addAnnotatedClass( User.class );
                    configuration.addAnnotatedClass( House.class );
                    configuration.addProperties( properties );
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() );
                    sessionFactory = configuration.buildSessionFactory( builder.build() );
                }
                catch( Exception e )
                {
                    logger.error( e.getMessage(), e );
                }
            }
        }
        return sessionFactory;
    }
}
