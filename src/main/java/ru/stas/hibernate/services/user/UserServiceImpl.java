package ru.stas.hibernate.services.user;

import ru.stas.hibernate.model.User;
import ru.stas.hibernate.repository.userrepository.UserRepoImpl;
import ru.stas.hibernate.repository.userrepository.UserRepository;

import java.util.List;

public class UserServiceImpl
    implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl()
    {
        userRepository=new UserRepoImpl();
    }

    @Override
    public User getById( int id )
    {
        return userRepository.getById( id,User.class );
    }

    @Override
    public void update( User user )
    {
        userRepository.update( user );
    }

    @Override
    public void delete( User user )
    {
        userRepository.delete( user );
    }

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll( User.class );
    }

    @Override
    public User getStanislavUser()
    {
        return userRepository.getStanislavUser();
    }
}
