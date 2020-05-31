package ru.stas.hibernate.repository.userrepository;

import ru.stas.hibernate.model.User;
import ru.stas.hibernate.repository.CommonRepository;

public interface UserRepository extends CommonRepository
{
    User getStanislavUser();
}
