package com.company;
import java.awt.*;
import java.awt.event.*;

public class Sum_in_UI extends Frame implements ActionListener{
    TextField T1= new TextField(20);
    TextField T2= new TextField(20);

    Label L=new Label(" ", Label.CENTER);
    Sum_in_UI(){
        setSize(800,500);
        setTitle("Sum By Using UI");
        Panel p=new Panel();
        L.setFont(new Font("Arial",Font.BOLD,20));
        p.setBackground(Color.gray);
        setBackground(Color.pink);
        p.add(new Label("Number 1 :- "));
        p.add(T1);
        p.add(new Label("Number 2 :- "));
        p.add(T2);
        add(p,"North");
        add(L,"Center");

        T2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String A= T1.getText();
       String B= T2.getText();
    int a= Integer.parseInt(A);
    int b= Integer.parseInt(B);
    int c=a+b;
    String C=Integer.toString(c);
        L.setText("Sum :- "+C);
    }

    public static void main(String[] args) {
        Sum_in_UI S=new Sum_in_UI();
        S.setVisible(true);
        S.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowOpened(e);
                S.dispose();
            }
        });
    }
}
