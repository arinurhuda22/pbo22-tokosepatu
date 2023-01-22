package entity;

public class entity_sepatu {
    public String merk,size;
    public int harga;

    public entity_sepatu(String merk, String size, int harga) {
        this.merk = merk;
        this.size = size;
        this.harga = harga;
    }

    public String getMerksepatu() {
        return merk;
    }

    public void setMerksepatu(String merk) {
        this.merk = merk;
    }

    public String getJenissepatu() {
        return size;
    }

    public void setJenissepatu(String size) {
        this.size = size;
    }

    public int getHargasepatu() {
        return harga;
    }

    public void setHargasepatu(int harga) {
        this.harga = harga;
    }
}
