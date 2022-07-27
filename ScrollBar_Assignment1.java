package com.company;
import java.awt.*;
import java.awt.event.*;
public class ScrollBar_Assignment1 extends Frame implements AdjustmentListener{
    Scrollbar S1=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,260);
    Scrollbar S2=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,260);
    Scrollbar S3=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,260);

    Label L1=new Label("Red");
    Label L2=new Label("Green");
    Label L3=new Label("Blue");


    ScrollBar_Assignment1(){
        setBounds(200,200,500,500);
        setTitle("Colour Combination Code...");
        Panel P=new Panel();

        P.setLayout(new GridLayout(3,2));

        P.add(L1);
        P.add(S1);

        P.add(L2);
        P.add(S2);

        P.add(L3);
        P.add(S3);


        add(P,"South");

        S1.addAdjustmentListener(this);
        S2.addAdjustmentListener(this);
        S3.addAdjustmentListener(this);
    }


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        int A=0;
        int B=0;
        int C=0;
          Object Sc=e.getSource();
          if(Sc==S1||Sc==S2||Sc==S3)
              A=S1.getValue();
             B=S2.getValue();
             C=S3.getValue();

         setBackground(new Color(A,B,C));
         setTitle("Color Value is :- "+ A +","+ B +","+ C);
    }


    public static void main(String[] args) {
        ScrollBar_Assignment1 A1=new ScrollBar_Assignment1();
        A1.setVisible(true);
        A1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                A1.dispose();
            }
        });
    }



}
