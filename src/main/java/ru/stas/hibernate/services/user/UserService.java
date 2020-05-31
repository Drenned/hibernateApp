package ru.stas.hibernate.services.user;

import ru.stas.hibernate.model.AbstractEntity;
import ru.stas.hibernate.model.User;

import java.util.List;

public interface UserService
{
    User getById( int id );

    void update(User user);

    void delete(User user);

    List<User> findAll( );

    User getStanislavUser();
}
