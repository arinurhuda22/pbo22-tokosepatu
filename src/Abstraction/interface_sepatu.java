package Abstraction;

import entity.entity_sepatu;

import java.util.ArrayList;

public interface interface_sepatu {
    ArrayList<entity_sepatu> read();
    boolean tambahsepatu(entity_sepatu sepatu);
    boolean hapussepatu(int idsepatu);
    boolean editsepatu(int idsepatu, entity_sepatu sepatu);
}