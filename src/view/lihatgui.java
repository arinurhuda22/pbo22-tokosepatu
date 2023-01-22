package view;

import allobject.object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class lihatgui {
    JFrame lihatframe = new JFrame();
    JTable tablesepatu = new JTable();
    JButton dashboard;
    JScrollPane scrolsepatu = new JScrollPane(tablesepatu);

    public lihatgui() {
        lihatframe.setSize(600,550);
        lihatframe.setLayout(null);
        lihatframe.setTitle("Menu Lihat Data Sepatu");

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(240,470,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        lihatframe.add(dashboard);

        scrolsepatu.setBounds(50,62,500,400);
        scrolsepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablesepatu.setModel(object.controllersepatu.listsepatu());
        tablesepatu.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        lihatframe.add(scrolsepatu);

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    lihatframe.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        lihatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lihatframe.setLocationRelativeTo(null);
        lihatframe.setVisible(true);

    }
}
