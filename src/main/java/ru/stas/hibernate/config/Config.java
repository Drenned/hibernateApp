package ru.stas.hibernate.config;

import org.apache.log4j.Logger;
import ru.stas.hibernate.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config
{
    private static final Logger logger = Logger.getLogger( Config.class );

    public static Properties getProperties()
    {
        return getConfig("hibernate.properties");

    }

    public static Properties getProperties( String file )
    {
        return getConfig( file );
    }

    private static Properties getConfig(String file)
    {
        Properties properties = new Properties(  );

        try( InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream( file ) )
        {
            properties.load( resourceAsStream );
        }
        catch( IOException e )
        {
            logger.error( e.getMessage(), e );
        }

        return properties;
    }
}
