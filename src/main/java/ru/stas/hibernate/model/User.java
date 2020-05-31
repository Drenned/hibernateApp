package ru.stas.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User
    extends AbstractEntity
{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String secondName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<House> houses = new ArrayList<>(  );

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder( "User{");
        result.append( "id=" ).append( id )
              .append( ", firstName='" ).append( firstName ).append( '\'' )
              .append( ", secondName='" ).append( secondName).append( '\'' );

        int i=0;
        for( House house : houses )
        {
            if( i==0 )
            {
                result.append( ", [" );
            }
            result.append( house.toString() );

            if( i!=houses.size()-1  )
            {
                result.append( ", " );
            }
            else
            {
                result.append( "]" );
            }
            i++;
        }
        result.append( "}" );

        return result.toString();
    }
}
