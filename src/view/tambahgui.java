package view;

import allobject.object;
import entity.entity_sepatu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tambahgui {
    JLabel merk,size,harga;
    JTextField merks, sizes, hargas;
    JButton tambah,dashboard;
    JFrame tambahframe = new JFrame();
    JTable tablesepatu = new JTable();
    JScrollPane scrolsepatu = new JScrollPane(tablesepatu);

    public tambahgui() {
        tambahframe.setSize(900,600);
        tambahframe.setLayout(null);
        tambahframe.setTitle("Menu Tambah Data Sepatu");

        merk = new JLabel("Merk");
        merk.setBounds(30,50,50,50);
        merk.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(merk);

        size = new JLabel("Ukuran");
        size.setBounds(30,100,70,50);
        size.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(size);

        harga = new JLabel("Harga ");
        harga.setBounds(30,150,120,50);
        harga.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(harga);

        merks = new JTextField();
        merks.setBounds(160,63,120,25);
        merks.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(merks);

        sizes = new JTextField();
        sizes.setBounds(160,113,120,25);
        sizes.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(sizes);

        hargas = new JTextField();
        hargas.setBounds(160,163,120,25);
        hargas.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(hargas);

        tambah = new JButton("Create");
        tambah.setBounds(160,200,120,20);
        tambah.setFont(new Font("Times New Roman",Font.BOLD,14));
        tambahframe.add(tambah);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(160,250,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        tambahframe.add(dashboard);

        scrolsepatu.setBounds(300,62,500,400);
        scrolsepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablesepatu.setModel(object.controllersepatu.listsepatu());
        tablesepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tambahframe.add(scrolsepatu);

        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String mrk = merks.getText();
                    String siz = sizes.getText();
                    int hrg = Integer.parseInt(hargas.getText());
                    object.controllersepatu.tambahsepatu(new entity_sepatu(mrk,siz,hrg));
                    tablesepatu.setModel(object.controllersepatu.listsepatu());
                    kosong();
                    JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Sepatu", "Information", JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Inputan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(exception);
                }
            }
        });

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    tambahframe.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        tablesepatu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablesepatu.getSelectedRow();
                int index=i;
                merks.setText(object.controllersepatu.listsepatu().getValueAt(i, 1).toString());
                sizes.setText(object.controllersepatu.listsepatu().getValueAt(i, 2).toString());
                hargas.setText(object.controllersepatu.listsepatu().getValueAt(i, 3).toString());
            }
        });

        tambahframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tambahframe.setLocationRelativeTo(null);
        tambahframe.setVisible(true);
    }

    void kosong(){
        merks.setText(null);
        sizes.setText(null);
        hargas.setText(null);
    }
}
