package controller;

import Abstraction.interface_sepatu;
import allobject.object;
import entity.entity_sepatu;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class controller_sepatu implements interface_sepatu {
    @Override
    public ArrayList<entity_sepatu> read() {
        return object.databasesepatu.read();
    }

    @Override
    public boolean tambahsepatu(entity_sepatu sepatu) {
        try{
            object.databasesepatu.createsepatu(sepatu);
            return true;
        } catch (ArrayStoreException e){
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listsepatu() {
        DefaultTableModel daftarsepatu = new DefaultTableModel();
        Object[] kolom = {"No","Merk Sepatu", "Ukuran Sepatu","Harga Sepatu"};
        daftarsepatu.setColumnIdentifiers(kolom);

        int size = object.sepatu.size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = i+1;
            data[1] = object.sepatu.get(i).getMerksepatu();
            data[2] = object.sepatu.get(i).getJenissepatu();
            data[3] = object.sepatu.get(i).getHargasepatu();
            daftarsepatu.addRow(data);

        }
        return daftarsepatu;
    }

    @Override
    public boolean hapussepatu(int idsepatu) {
        try{
            object.databasesepatu.hapussepatu(idsepatu-1);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean editsepatu(int idsepatu, entity_sepatu sepatu) {
        try{
            object.databasesepatu.editsepatu(idsepatu, sepatu);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
