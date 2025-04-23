package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.dto.MenuDTO;
import com.accenturebe.onlinefooddelivery.entity.Menu;
import com.accenturebe.onlinefooddelivery.exception.MenuNotFoundException;
import com.accenturebe.onlinefooddelivery.mapper.MenuMapper;
import com.accenturebe.onlinefooddelivery.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu Not Found"));
        return menuMapper.toMenuDTO(menu);
    }

    // requestDTO convert to menu entity to use JPA repository save
    // saved menu entity convert to responseDTO
    public MenuDTO createMenu(MenuDTO request){
        boolean exists = menuRepository.existsByName(request.getName());
        if(exists){
            log.error("Caught DataIntegrityViolationException");
            throw new DataIntegrityViolationException("Menu " + request.getName() + " already exists");
        }
        Menu menu = menuMapper.toMenu(request);
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.toMenuDTO(savedMenu);
    }

    public MenuDTO updateMenu(Long id, MenuDTO request){
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu Not Found"));

        menu.setName(request.getName());
        menu.setPrice(request.getPrice());
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toMenuDTO(updatedMenu);
    }

    public void deleteMenu(Long id){
        menuRepository.deleteById(id);
    }
}

