package com.company;
import java.awt.*;
import java.awt.event.*;

public class TextFieldAssignment_1 extends Frame implements ActionListener{

Label L=new Label("Number:- ");
Label L1=new Label();
TextField T =new TextField(15);
Button B1=new Button("Sqrt");
    Button B2=new Button("Factorial");
    Button B3=new Button("Square");
    Button B4=new Button("Cube");

TextFieldAssignment_1(){
    setBounds(200,200,700,400);
    setTitle("Text Field Assignment...");
    Panel p=new Panel();
    Panel p1=new Panel();

    p.add(L);
    p.add(T);
    add(p,"North");

     p.setBackground(Color.orange);

    p1.setLayout(new FlowLayout());

    p1.add(B1,"Center");
    p1.add(B2,"Center");
    p1.add(B3,"Center");
    p1.add(B4,"Center");

    add(p1);

    B1.addActionListener(this);
    B2.addActionListener(this);
    B3.addActionListener(this);
    B4.addActionListener(this);

    add(L1,"South");
    L1.setFont(new Font("Times New Roman",Font.BOLD,20));


}
    @Override
    public void actionPerformed(ActionEvent e) {
      Object O=e.getSource();
      String S=T.getText();
      int X=Integer.parseInt(S);

      if(O==B1){
          double A=Math.sqrt(X);
          String C=Double.toString(A);
          L1.setText("The Square root of the number is :- "+ C);
      }

      else if(O==B2){

        long fact=1;

        for(int i=1;i<=X;i++)

        fact=i*fact;

        String C=Long.toString(fact);
        L1.setText("The Factorial of the number is :- "+ C);
      }

      else if(O==B3){
         int A=X*X;
          String C=Integer.toString(A);
          L1.setText("The Square of the number is :- "+ C);

      }
      else if(O==B4){
         int A=X*X*X;
          String C=Integer.toString(A);
          L1.setText("The Cube of the number is :- "+ C);
      }
    }
    public static void main(String[] args) {
        TextFieldAssignment_1 T1=new TextFieldAssignment_1();
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
