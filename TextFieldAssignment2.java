package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TextFieldAssignment2 extends JFrame implements ActionListener {

    Label L1 = new Label("Add");
    Label L2 = new Label("Sum");
    TextField T1 = new TextField(15);
    TextField T2 = new TextField(15);
    Button B1 = new Button("Add");
    Button B2 = new Button("Reset");
    Button B3 = new Button("Quit");
    int C;

    TextFieldAssignment2() {
        setBounds(200, 200, 700, 500);
        setTitle("Assignment 2nd on text field...");

        Panel P = new Panel();
        P.add(L1);
        P.add(T1);
        P.add(L2);
        P.add(T2);
        P.add(B1);
        P.add(B2);
        P.add(B3);
        P.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(P);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object O1 = e.getSource();

        if (O1 == B1) {
            String A = T1.getText();
            int B = Integer.parseInt(A);
            C = B + C;
            T2.setText(Integer.toString(C));
            T1.setText("");
        }
        if (O1 == B2) {

            T1.setText("0");
            T2.setText("0");
        }
        if (O1 == B3) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        TextFieldAssignment2 T = new TextFieldAssignment2();
        T.setVisible(true);
        T.setDefaultCloseOperation(3);
    }
}







