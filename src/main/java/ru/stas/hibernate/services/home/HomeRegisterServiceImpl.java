package ru.stas.hibernate.services.home;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stas.hibernate.model.House;
import ru.stas.hibernate.model.User;
import ru.stas.hibernate.services.house.HouseService;
import ru.stas.hibernate.services.user.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeRegisterServiceImpl
    implements HomeRegisterService
{
    private final HouseService houseService;
    private final UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addHomeAndUser( String firstName, String lastName, String address )
    {
        User user = createUser(firstName, lastName);
        House house = createHouse(address);
        user.setHouses( Collections.singletonList( house ) );
        house.setUser( user );
        entityManager.merge( user );
    }

    private House createHouse( String address )
    {
        House house = new House();
        house.setAddress( address );
        return house;
    }

    private User createUser( String firstName, String lastName )
    {
        User user = new User();
        user.setFirstName( firstName );
        user.setSecondName( lastName );
        return user;
    }
}
