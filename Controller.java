package com.miniproject;

public class Controller {

    public static void main(String[] args) {
        MenuDao menuDao = new MenuDaoImpl();
        Service service = new Service(menuDao);
        service.performCRUDOperations();
    }
}
