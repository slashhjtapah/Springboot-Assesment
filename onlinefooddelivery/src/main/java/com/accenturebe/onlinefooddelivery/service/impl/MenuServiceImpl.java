package com.accenturebe.onlinefooddelivery.service.impl;

import com.accenturebe.onlinefooddelivery.entity.Menu;
import com.accenturebe.onlinefooddelivery.service.MenuService;
import org.springframework.stereotype.Service;
import com.accenturebe.onlinefooddelivery.repository.MenuRepository;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    //Constructor Injection
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenus() {
        return List.of();
    }
}
