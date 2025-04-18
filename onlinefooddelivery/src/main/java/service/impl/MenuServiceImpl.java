package service.impl;

import entity.Menu;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import service.MenuService;

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
        return menuRepository.findAll();
    }
}
