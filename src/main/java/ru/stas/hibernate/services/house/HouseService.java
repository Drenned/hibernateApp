package ru.stas.hibernate.services.house;

import ru.stas.hibernate.model.House;

import java.util.List;

public interface HouseService
{
    House getById( int id );

    void update(House house);

    void delete(House house);

    List<House> findAll();
}
