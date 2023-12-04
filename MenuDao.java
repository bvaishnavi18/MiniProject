package com.miniproject;


import java.util.List;

public interface MenuDao {

    void createMenu(Menu menu);

    Menu getMenuById(int id);

    List<Menu> getAllMenuItems();

    void updateMenu(Menu menu);

    void deleteMenu(int id);

}
