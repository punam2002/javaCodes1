package com.company;
import java.awt.*;
import java.awt.event.*;
public class TextAreaAssignment_2 extends Frame implements ActionListener{
      Label L= new Label("Name:- ");
      Button B=new Button("Click to Add");
      TextField T=new TextField(20);
      TextArea T1=new TextArea();

      TextAreaAssignment_2(){
            setBounds(300,300,700,300);
            setTitle("Append Names  ");
            Panel P=new Panel();
            P.setLayout(new FlowLayout());
            P.setBackground(Color.CYAN);
            P.add(L);
            P.add(T);
            P.add(B);

            add(P,"North");

            add(T1);
            B.addActionListener(this);
      }
      @Override
      public void actionPerformed(ActionEvent e) {

                   T1.append(T.getText()+"\n");
                   T.setText("");

      }


      public static void main(String[] args) {
            TextAreaAssignment_2 A=new TextAreaAssignment_2();
            A.setVisible(true);
            A.addWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        A.dispose();
                  }
            });

      }


}

