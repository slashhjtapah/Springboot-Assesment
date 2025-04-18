package controller;

import org.springframework.web.bind.annotation.RestController;
import service.MenuService;
import service.impl.MenuServiceImpl;

@RestController
public class MenuController {

    private final MenuService menuService;

    //Constructor Injection
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }
}
