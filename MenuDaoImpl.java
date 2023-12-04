package com.miniproject;


import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    private List<Menu> menuList = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void createMenu(Menu menu) {
        menu.setId(nextId++);
        menuList.add(menu);
    }

    @Override
    public Menu getMenuById(int id) {
        for (Menu menu : menuList) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public List<Menu> getAllMenuItems() {
        return new ArrayList<>(menuList);
    }

    @Override
    public void updateMenu(Menu menu) {
        int index = menuList.indexOf(getMenuById(menu.getId()));
        if (index != -1) {
            menuList.set(index, menu);
        }
    }

    @Override
    public void deleteMenu(int id) {
        Menu menu = getMenuById(id);
        if (menu != null) {
            menuList.remove(menu);
        }
    }
}
