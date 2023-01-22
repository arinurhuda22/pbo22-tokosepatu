package controller;

import Abstraction.interface_admin;
import allobject.object;
import entity.entity_admin;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class controller_admin implements interface_admin {
    @Override
    public ArrayList<entity_admin> read() {
        return object.databaseadmin.read();
    }

    @Override
    public boolean tambahadmin(entity_admin admin) {
        try {
            object.databaseadmin.createadmin(admin);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean cekLogin(String username, int pin) {

        try {
            for (int i = 0; i < object.admin.size(); i++) {
                object.databaseadmin.ceklogin(username, pin);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public DefaultTableModel listadmin() {
        DefaultTableModel daftaradmin = new DefaultTableModel();
        Object[] kolom = {"Username", "Pin"};
        daftaradmin.setColumnIdentifiers(kolom);

        int size = object.admin.size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[2];
            data[0] = object.admin.get(i).getUsername();
            data[1] = object.admin.get(i).getPin();
            daftaradmin.addRow(data);

        }
        return daftaradmin;
    }
}
