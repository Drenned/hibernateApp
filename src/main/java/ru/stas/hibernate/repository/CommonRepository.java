package ru.stas.hibernate.repository;

import ru.stas.hibernate.model.AbstractEntity;

import java.util.List;

public interface CommonRepository
{
    <T extends AbstractEntity> T getById( int id, Class<T> tClass);

    <T extends AbstractEntity> void update(T object);

    <T extends AbstractEntity> void delete(T object);

    <T extends AbstractEntity> List<T> findAll( Class<T> tClass );
}
