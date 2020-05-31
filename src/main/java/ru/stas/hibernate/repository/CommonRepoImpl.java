package ru.stas.hibernate.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.stas.hibernate.model.AbstractEntity;
import ru.stas.hibernate.session.MySessionFactory;

import javax.persistence.Table;
import java.util.List;

public abstract class CommonRepoImpl
    implements CommonRepository
{
    private static Logger logger = Logger.getLogger( CommonRepoImpl.class );

    protected final SessionFactory sessionFactory;

    public CommonRepoImpl()
    {
        this.sessionFactory= MySessionFactory.getSessionFactory();
    }


    @Override
    public <T extends AbstractEntity> T getById( int id , Class<T> tClass)
    {
        logger.debug( "Was called method getUser" );
        try(Session session = sessionFactory.openSession())
        {
            return session.get( tClass, id );
        }
        catch( Exception e )
        {
            logger.error( e.getMessage(), e );

        }
        return null;
    }

    @Override
    public <T extends AbstractEntity> void update( T object )
    {
        logger.debug( "Was called method update " + object.getClass());
        try(Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate( object );
            logger.debug( "update to BD" );
            transaction.commit();
            logger.debug( "Commit !" );
            logger.debug( "Update "+object.getClass()+" finished" );
        }
        catch( Exception e )
        {
            logger.error( e.getMessage(),e );
        }
    }

    @Override
    public <T extends AbstractEntity> void delete( T object )
    {
        logger.debug( "Was called method delete "+object.getClass() );
        try(Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.delete( object );
            logger.debug( "Delete to BD" );
            transaction.commit();
            logger.debug( "Commit !" );
            logger.debug( "Delete finished" );
        }
        catch( Exception e )
        {
            logger.error( e.getMessage(),e );
        }
    }

    @Override
    public <T extends AbstractEntity> List<T> findAll( Class<T> tClass )
    {
        logger.debug( "Was called method findAll + " + tClass );

        try( Session session = sessionFactory.openSession())
        {

            return session.createQuery( "From " + tClass.getName(), tClass  )
                          .list();

        }
        catch( Exception e )
        {
            logger.error( e.getMessage(), e );
        }

        return null;
    }
}
