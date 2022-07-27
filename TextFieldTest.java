package com.company;
import java.awt.*;
import java.awt.event.*;
public class TextFieldTest extends Frame implements  ActionListener{
   TextField T=new TextField(20);
   Label L=new Label("Enter your name ",Label.CENTER);
    TextFieldTest(){
        setSize(700,700);
        setTitle("TextFieldTesting.....");
        Panel p=new Panel();
        p.add(new Label("Name:"));
        p.add(T);
       // T.setEchoChar('*');      this is use for give the password from the user.
        add(p);
        add(L,"South");
        L.setFont(new Font("Times New Roman", Font.BOLD , 40));
        T.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
     String S=T.getText();
     L.setText("Hello "+ S);
    }

    public static void main(String[] args) {
        TextFieldTest T1=new TextFieldTest();
        T1.setVisible(true);
        T1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                T1.dispose();
            }
        });
    }
}
