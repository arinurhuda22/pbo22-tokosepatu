package model;

import allobject.object;
import entity.entity_admin;
import java.util.ArrayList;

public class model_admin {
   private ArrayList<entity_admin> admin;

    public model_admin() {
        admin = new ArrayList<entity_admin>();
    }

    public void createadmin(entity_admin admin){
        this.admin.add(admin);
    }
    public ArrayList<entity_admin> read(){
        return admin;
    }
    public void ceklogin(String username, int pin){
        boolean cek;
        int i=0;
        do {
            if (!username.equals(object.admin.get(i).getUsername())){
                cek = false;
                i++;
                if (pin!=object.admin.get(i).getPin()){
                }
            }else if (pin != object.admin.get(i).getPin()) {
                cek = false;
                i++;
            }else{
                cek = true;
            }
        }while(cek!=true);
    }
}
