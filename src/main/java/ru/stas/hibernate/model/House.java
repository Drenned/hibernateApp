package ru.stas.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class House
    extends AbstractEntity
{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Override
    public String toString()
    {
        return "House{" +
               "id=" + id +
               ", address='" + address + '\'' +
               ", user=" + user.getFirstName() +
               '}';
    }
}
