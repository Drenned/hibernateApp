package ru.stas.hibernate.services.house;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.stas.hibernate.model.House;
import ru.stas.hibernate.repository.houserepository.HouseRepoImpl;
import ru.stas.hibernate.repository.houserepository.HouseRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HouseServiceImpl
    implements HouseService
{
    private final HouseRepository houseRepository;


    @Override
    public House getById( int id )
    {
        return houseRepository.getById( id,House.class );
    }

    @Override
    public void update( House house )
    {
        houseRepository.update( house );
    }

    @Override
    public void delete( House house )
    {
        houseRepository.delete( house );
    }

    @Override
    public List<House> findAll()
    {
        return houseRepository.findAll( House.class );
    }
}
