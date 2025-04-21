package com.accenturebe.onlinefooddelivery.controller;

import org.springframework.web.bind.annotation.RestController;
import com.accenturebe.onlinefooddelivery.service.MenuService;

@RestController
public class MenuController {

    private final MenuService menuService;

    //Constructor Injection
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }
}
