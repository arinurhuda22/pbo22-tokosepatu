package allobject;

import controller.controller_sepatu;
import controller.controller_admin;
import entity.entity_sepatu;
import entity.entity_admin;
import model.model_sepatu;
import model.model_admin;
import java.util.ArrayList;

public class object {
    public static model_sepatu databasesepatu = new model_sepatu();
    public static controller_sepatu controllersepatu = new controller_sepatu();
    public static ArrayList<entity_sepatu> sepatu = controllersepatu.read();
    public static model_admin databaseadmin = new model_admin();
    public static controller_admin controlleradmin = new controller_admin();
    public static ArrayList<entity_admin> admin = controlleradmin.read();
}
