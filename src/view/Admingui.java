package view;

import allobject.object;
import entity.entity_admin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admingui {
    JLabel username, pin;
    JTextField nama, kode;
    JButton btnregist,btnlogin;
    JFrame admin = new JFrame();
    JTable tableadmin = new JTable();
    JScrollPane scroladmin = new JScrollPane(tableadmin);


    public static void main(String[] args) {
        Admingui admin = new Admingui();
    }
    public Admingui() {
        admin = new JFrame();
        admin.setSize(600,500);
        admin.setLayout(null);

        JLabel login = new JLabel("Login Admin");
        login.setBounds(160,0,150,50);
        admin.add(login);

        JLabel username = new JLabel("Username");
        username.setBounds(70,50,100,50);
        admin.add(username);

        JLabel pin = new JLabel("Pin");
        pin.setBounds(70,80,100,50);
        admin.add(pin);

        nama = new JTextField();
        nama.setBounds(160,65,100,20);
        admin.add(nama);

        kode = new JTextField();
        kode.setBounds(160,95,100,20);
        admin.add(kode);

        btnregist = new JButton("Register");
        btnregist.setBounds(70,130,90,20);
        admin.add(btnregist);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(190,130,70,20);
        admin.add(btnlogin);

        scroladmin.setBounds(265,65,200,150);
        tableadmin.setModel(object.controlleradmin.listadmin());
        admin.add(scroladmin);

        btnregist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = nama.getText();
                    int pin = Integer.parseInt(kode.getText());
                    object.controlleradmin.tambahadmin(new entity_admin(username, pin));
                    tableadmin.setModel(object.controlleradmin.listadmin());
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Inputan salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    admin.dispose();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Inputan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tableadmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableadmin.getSelectedRow();
                int index=i;
                nama.setText(object.controlleradmin.listadmin().getValueAt(i, 0).toString());
                pin.setText(object.controlleradmin.listadmin().getValueAt(i, 1).toString());
            }
        });

        admin.setVisible(true);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin.setLocationRelativeTo(null);
    }
    void kosong(){
        nama.setText(null);
        kode.setText(null);
    }
}
