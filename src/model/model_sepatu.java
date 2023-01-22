package model;

import entity.entity_sepatu;
import java.util.ArrayList;

public class model_sepatu {
    private ArrayList<entity_sepatu> data_sepatu;

    public model_sepatu(){
        data_sepatu = new ArrayList<entity_sepatu>();
    }

    public void createsepatu(entity_sepatu sepatu){
        this.data_sepatu.add(sepatu);
    }

    public ArrayList<entity_sepatu> read() {
        return data_sepatu;
    }

    public void hapussepatu(int idsepatu){
        this.data_sepatu.remove(idsepatu);
    }

    public void editsepatu(int idsepatu, entity_sepatu sepatu){
        this.data_sepatu.remove(idsepatu-1);
        this.data_sepatu.add(idsepatu-1,sepatu);
    }
}
