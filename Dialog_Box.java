package com.AdvJava;
import java.awt.*;
import java.awt.event.*;

public class Dialog_Box extends Frame implements ActionListener{


    Dialog_Box(){
        setBounds(200,200,700,400);
        setTitle("Dialog Box Component...");
        MenuBar M=new MenuBar();
        Menu M1=new Menu("Help");
        MenuItem I=new MenuItem("About");

        M1.add(I);
        M.add(M1);

        setMenuBar(M);

        I.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AboutDialog A=new AboutDialog(this);
       A.setVisible(true);
    }

    public static void main(String[] args) {
        Dialog_Box D=new Dialog_Box();
        D.setVisible(true);
        D.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                D.dispose();
            }
        });
    }
}
class AboutDialog extends Dialog{
    Label L=new Label("Software by Mona",Label.CENTER);
    Button B=new Button("OK");
    AboutDialog(Frame parent){
     super(parent,"About",true);
     setSize(300,300);
     add(B,"South");
     add(L,"Center");

     B.addActionListener((new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             setVisible(false);
         }
     }));
    }


}