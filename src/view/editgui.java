package view;

import allobject.object;
import entity.entity_sepatu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editgui {
    JLabel no_sepatu,merk,size,harga;
    JTextField nomer,merks, sizes, hargas;
    JButton edit,dashboard;
    JFrame editframe = new JFrame();
    JTable tablesepatu = new JTable();
    JScrollPane scrolsepatu = new JScrollPane(tablesepatu);

    public editgui() {
        editframe.setSize(900,600);
        editframe.setLayout(null);
        editframe.setTitle("Menu Edit Data Sepatu");

        no_sepatu = new JLabel("No Sepatu");
        no_sepatu.setBounds(30,50,100,50);
        no_sepatu.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(no_sepatu);

        merk = new JLabel("Merk");
        merk.setBounds(30,100,50,50);
        merk.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(merk);

        size = new JLabel("Ukuran");
        size.setBounds(30,150,70,50);
        size.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(size);

        harga = new JLabel("Harga");
        harga.setBounds(30,200,120,50);
        harga.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(harga);

        nomer = new JTextField();
        nomer.setBounds(160,63,120,25);
        nomer.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(nomer);

        merks = new JTextField();
        merks.setBounds(160,113,120,25);
        merks.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(merks);

        sizes = new JTextField();
        sizes.setBounds(160,163,120,25);
        sizes.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(sizes);

        hargas = new JTextField();
        hargas.setBounds(160,213,120,25);
        hargas.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(hargas);

        edit = new JButton("Update");
        edit.setBounds(160,250,120,20);
        edit.setFont(new Font("Times New Roman",Font.BOLD,14));
        editframe.add(edit);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(160,300,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        editframe.add(dashboard);

        scrolsepatu.setBounds(300,62,500,400);
        scrolsepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablesepatu.setModel(object.controllersepatu.listsepatu());
        tablesepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        editframe.add(scrolsepatu);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nmr = Integer.parseInt(nomer.getText());
                    String mrk = merks.getText();
                    String jns = sizes.getText();
                    int hrg = Integer.parseInt(hargas.getText());
                    object.controllersepatu.editsepatu(nmr,new entity_sepatu(mrk,jns,hrg));
                    tablesepatu.setModel(object.controllersepatu.listsepatu());
                    kosong();
                    JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data Sepatu", "Information", JOptionPane.INFORMATION_MESSAGE);
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
                    editframe.dispose();
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

        editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editframe.setLocationRelativeTo(null);
        editframe.setVisible(true);
    }

    void kosong(){
        nomer.setText(null);
        merks.setText(null);
        sizes.setText(null);
        hargas.setText(null);
    }
}
