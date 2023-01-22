package view;

import allobject.object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hapusgui {
    JLabel no_sepatu;
    JTextField nomor;
    JButton hapus,dashboard;
    JFrame hapusframe =new JFrame();
    JTable tablesepatu = new JTable();
    JScrollPane scrolsepatu = new JScrollPane(tablesepatu);

    public hapusgui() {
        hapusframe.setSize(700,350);
        hapusframe.setLayout(null);
        hapusframe.setTitle("Menu Hapus Data Sepatu");

        no_sepatu = new JLabel("No Sepatu");
        no_sepatu.setBounds(30,30,100,50);
        no_sepatu.setFont(new Font("Times New Roman",Font.BOLD,20));
        hapusframe.add(no_sepatu);

        nomor = new JTextField();
        nomor.setBounds(120,43,120,25);
        nomor.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,20));
        hapusframe.add(nomor);

        hapus = new JButton("DELETE");
        hapus.setBounds(120,80,120,20);
        hapus.setFont(new Font("Times New Roman",Font.BOLD,14));
        hapusframe.add(hapus);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(120,130,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        hapusframe.add(dashboard);

        scrolsepatu.setBounds(250,43,400,250);
        scrolsepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablesepatu.setModel(object.controllersepatu.listsepatu());
        tablesepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        hapusframe.add(scrolsepatu);

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nmr = Integer.parseInt(nomor.getText());
                    object.controllersepatu.hapussepatu(nmr);
                    tablesepatu.setModel(object.controllersepatu.listsepatu());
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data Sepatu", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    hapusframe.dispose();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Inputan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(exception);
                }
            }
        });

        hapusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hapusframe.setLocationRelativeTo(null);
        hapusframe.setVisible(true);

    }
}
