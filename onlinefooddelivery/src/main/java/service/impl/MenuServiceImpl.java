package service.impl;

import org.springframework.stereotype.Service;
import repository.MenuRepository;

@Service
public class MenuServiceImpl {

    private final MenuRepository menuRepository;

    //Constructor Injection
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

}
