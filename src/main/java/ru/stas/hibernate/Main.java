package ru.stas.hibernate;

import ru.stas.hibernate.model.House;
import ru.stas.hibernate.model.User;
import ru.stas.hibernate.repository.userrepository.UserRepoImpl;
import ru.stas.hibernate.repository.userrepository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {

        UserRepository userRepository = new UserRepoImpl();

        System.out.println("чисто тест ролбэка");


      /*  User user = new User();
        user.setFirstName( "Муха" );
        user.setSecondName( "Станислав" );

        List<House> houseList = new ArrayList<>(  );
        House house = new House();
        house.setAddress( "Заводская 2" );
        house.setUser( user );
        houseList.add( house );

        House house1 = new House();
        house1.setAddress( "Пионерская 24" );
        house1.setUser( user );
        houseList.add( house1 );

        user.setHouses( houseList );

        userRepository.update( user );*/

        List<User> all = userRepository.findAll( User.class );

        User stanislavUser = userRepository.getStanislavUser();

        System.out.println(stanislavUser.toString());


  /*      User user = userRepository.getById( 6, User.class);

        List<House> houses = user.getHouses();

        userRepository.delete( user );*/

    }
}
