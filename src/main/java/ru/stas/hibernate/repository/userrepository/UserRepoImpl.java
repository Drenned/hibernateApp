package ru.stas.hibernate.repository.userrepository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.stas.hibernate.model.User;
import ru.stas.hibernate.repository.CommonRepoImpl;

public class UserRepoImpl
    extends CommonRepoImpl
    implements UserRepository
{

    private static Logger logger = Logger.getLogger( UserRepoImpl.class );

    @Override
    public User getStanislavUser()
    {
        logger.debug( "Was called specific method getStanislavUser" );
        try( Session session = sessionFactory.openSession() )
        {
            return session.createQuery( "from User where last_name ='Станислав'", User.class  ).getSingleResult();
        }
        catch( Exception e )
        {
            logger.error( e.getMessage(),e );
        }

        return null;
    }
}
