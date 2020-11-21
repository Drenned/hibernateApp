package ru.stas.hibernate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.stas.hibernate.model.House;
import ru.stas.hibernate.model.User;
import ru.stas.hibernate.services.home.HomeRegisterService;
import ru.stas.hibernate.services.home.HomeRegisterServiceImpl;
import ru.stas.hibernate.services.house.HouseService;

import java.util.function.Predicate;

@RestController
@RequestMapping(value = "/homecontroller")
public class HomeController
{
    @Autowired
    private HomeRegisterService homeRegisterService;

    @GetMapping("/add")
    public String addHome(String firstName, String lastName, String address){

        homeRegisterService.addHomeAndUser( firstName,lastName,address );
        return "Ok";
    }

}
