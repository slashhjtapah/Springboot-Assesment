package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.dto.MenuDTO;
import com.accenturebe.onlinefooddelivery.entity.Menu;
import com.accenturebe.onlinefooddelivery.mapper.MenuMapper;
import com.accenturebe.onlinefooddelivery.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;

    public MenuService (MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenu(){
        return menuRepository.findAll();
    }

    public MenuDTO getMenuById(Long id){
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.map(menuMapper::toMenuDTO).orElse(null);
    }

    // requestDTO convert to menu entity to use JPA repository save
    // saved menu entity convert to responseDTO
    public MenuDTO createMenu(MenuDTO request){
        Menu menu = menuMapper.toMenu(request);
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.toMenuDTO(savedMenu);
    }

    public MenuDTO updateMenu(Long id, MenuDTO request){
        Menu menu = menuMapper.toMenu(request);
        menu.setId(id);
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toMenuDTO(updatedMenu);
    }

    public void deleteMenu(Long id){
        menuRepository.deleteById(id);
    }
}

