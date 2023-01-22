package Abstraction;

import entity.entity_admin;

import java.util.ArrayList;

public interface interface_admin {
    ArrayList<entity_admin> read();
    boolean tambahadmin(entity_admin admin);
    boolean cekLogin(String username, int pin);

}