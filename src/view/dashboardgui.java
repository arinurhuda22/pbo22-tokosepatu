package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboardgui {
    JLabel judul,pilih;
    JButton tambah,edit,hapus,lihat,exit;
    JFrame menu = new JFrame();
    JScrollPane tabel = new JScrollPane();

    public static void main(String[] args) {
        dashboardgui dashboardgui = new dashboardgui();
    }

    public dashboardgui() {
        menu.setSize(600,550);
        menu.setLayout(null);
        menu.setTitle("Menu");

        judul = new JLabel("DASHBOARD");
        judul.setBounds(160,50,400,50);
        judul.setFont(new Font("Times New Roman",Font.BOLD,40));
        menu.add(judul);

        pilih = new JLabel("Pilih Menu");
        pilih.setBounds(215,100,200,50);
        pilih.setFont(new Font("Times New Roman",Font.BOLD,30));
        menu.add(pilih);

        tambah = new JButton("TAMBAH");
        tambah.setBounds(215,165,150,50);
        tambah.setFont(new Font("Times New Roman",Font.BOLD,20));
        menu.add(tambah);

        edit = new JButton("EDIT");
        edit.setBounds(215,230,150,50);
        edit.setFont(new Font("Times New Roman",Font.BOLD,20));
        menu.add(edit);

        hapus = new JButton("HAPUS");
        hapus.setBounds(215,295,150,50);
        hapus.setFont(new Font("Times New Roman",Font.BOLD,20));
        menu.add(hapus);

        lihat = new JButton("LIHAT");
        lihat.setBounds(215,360,150,50);
        lihat.setFont(new Font("Times New Roman",Font.BOLD,20));
        menu.add(lihat);

        exit = new JButton("KELUAR");
        exit.setBounds(215,425,150,50);
        exit.setFont(new Font("Times New Roman",Font.BOLD,20));
        menu.add(exit);

        tabel.setBounds(115,30,350,470);
        menu.add(tabel);

        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tambahgui tambahgui = new tambahgui();
                    menu.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    editgui editgui = new editgui();
                    menu.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    hapusgui hapusgui = new hapusgui();
                    menu.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        lihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lihatgui lihatgui = new lihatgui();
                    menu.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    menu.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
