package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.MenuDTO;
import com.accenturebe.onlinefooddelivery.entity.Menu;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T09:11:06+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public Menu toMenu(MenuDTO menuDTO) {
        if ( menuDTO == null ) {
            return null;
        }

        Menu.MenuBuilder menu = Menu.builder();

        menu.id( menuDTO.getId() );
        menu.name( menuDTO.getName() );
        menu.price( menuDTO.getPrice() );

        return menu.build();
    }

    @Override
    public MenuDTO toMenuDTO(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuDTO.MenuDTOBuilder menuDTO = MenuDTO.builder();

        menuDTO.id( menu.getId() );
        menuDTO.name( menu.getName() );
        menuDTO.price( menu.getPrice() );

        return menuDTO.build();
    }
}
