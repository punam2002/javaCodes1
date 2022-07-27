package com.company;


import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class Application_3Calc extends JFrame  implements ActionListener{
   // JPanel JP1=new JPanel();
    JPanel JP2=new JPanel();
    JPanel JP3=new JPanel();

    JTextField JT1=new JTextField(20);
    JTextField JT2=new JTextField(20);
    JButton B1=new JButton("C");
    JButton B2=new JButton("PI");
    JButton B3=new JButton("<-");
    JButton B4=new JButton("/");
    JButton B5=new JButton("7");
    JButton B6=new JButton("8");
    JButton B7=new JButton("9");
    JButton B8=new JButton("*");
    JButton B9=new JButton("4");
    JButton B10=new JButton("5");
    JButton B11=new JButton("6");
    JButton B12=new JButton("-");
    JButton B13=new JButton("1");
    JButton B14=new JButton("2");
    JButton B15=new JButton("3");
    JButton B16=new JButton("+");
    JButton B17=new JButton("00");
    JButton B18=new JButton("0");
    JButton B19=new JButton(".");
    JButton B20=new JButton("=");



    boolean isStart=true;
    Application_3Calc(){
        setBounds(100,100,400,400);
        setTitle("Calculator");
        JT2.setEditable(false);
        JP2.setLayout(new GridLayout(5,4,10,10));
        JT1.setEditable(false);

        JP2.add(B1);
        JP2.add(B2);
        JP2.add(B3);
        JP2.add(B4);
        JP2.add(B5);
        JP2.add(B6);
        JP2.add(B7);
        JP2.add(B8);
        JP2.add(B9);
        JP2.add(B10);
        JP2.add(B11);
        JP2.add(B12);
        JP2.add(B13);
        JP2.add(B14);
        JP2.add(B15);
        JP2.add(B16);
        JP2.add(B17);
        JP2.add(B18);
        JP2.add(B19);
        JP2.add(B20);



        add(JT1,"North");
        add(JT2,"Center");
        add(JP2,"South");
        add(JP3,"East");

        Logic();

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        B10.addActionListener(this);
        B11.addActionListener(this);
        B12.addActionListener(this);
        B13.addActionListener(this);
        B14.addActionListener(this);
        B15.addActionListener(this);
        B16.addActionListener(this);
        B17.addActionListener(this);
        B18.addActionListener(this);
        B19.addActionListener(this);
        B20.addActionListener(this);
    }

    double C;
    String[] values={"0","1","2","3","4","5","6","7","8","9","PI","00"};

    void  Logic(){
        Arrays.sort(values);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String S2=e.getActionCommand();
        if(S2.equals(".")){
            JT1.setText(JT1.getText()+".");
            }

       else if(S2.equals("PI")){
           JT1.setText(""+Math.PI);
       }
       else if(S2.equals("C")){

            JT1.setText("");
            JT2.setText("");
        }
        else if(Arrays.binarySearch(values,S2)>=0){
            JT1.setText(JT1.getText()+ S2);
        }
        else if(S2.equals("<-")){
                String St=JT1.getText();
                JT1.setText("");
                for (int i=St.length();i>0;i--){
                   JT1.setText(null);
                }
           }


        else {
            switch (S2) {
                case "+" -> {
                    if(isStart){
                        String A = JT1.getText();
                        double B = Double.parseDouble(A);
                        C = B + C;
                        JT2.setText(Double.toString(C));
                        JT1.setText("");

                        isStart=false;

                    }
                    else{
                        String A = JT2.getText();
                        String X =JT1.getText();
                        double B = Double.parseDouble(A);
                        double Y = Double.parseDouble(X);
                        C = B + Y;
                        JT2.setText(Double.toString(C));
                        JT1.setText("");

                    }

                }
                case "-" -> {
                    String A;
                    if(isStart) {
                        A = JT1.getText();
                        double B = Double.parseDouble(A);
                        C = B - C;
                    }
                    else{
                        A = JT2.getText();
                        String X =JT1.getText();
                        double B = Double.parseDouble(A);
                        double Y = Double.parseDouble(X);
                        C = B - Y;

                    }
                    JT2.setText(Double.toString(C));
                    JT1.setText("");
                    isStart=false;
                    JT2.setText(Double.toString(C));
                    JT1.setText("");
                }
                case "*" -> {
                    String A;

                    if(isStart) {
                        C=1;
                        A = JT1.getText();
                        double B = Double.parseDouble(A);
                        C = B * C;
                        JT2.setText(Double.toString(C));
                        JT1.setText("");

                        isStart=false;
                    }
                    else{

                        A = JT2.getText();
                        String X =JT1.getText();
                        double B = Double.parseDouble(A);
                        double Y = Double.parseDouble(X);
                        C = B * Y;
                    }
                    JT2.setText(Double.toString(C));
                    JT1.setText("");
                }
                case "/" -> {
                    String A;
                    if(isStart) {
                        C=1;
                        A = JT1.getText();
                        double B = Double.parseDouble(A);
                        C = B / C;
                        JT2.setText(Double.toString(C));
                        JT1.setText("");
                        isStart=false;
                    }
                    else{
                        A = JT2.getText();
                        String X =JT1.getText();
                        double B = Double.parseDouble(A);
                        double Y = Double.parseDouble(X);
                        C = B / Y;
                    }
                    JT2.setText(Double.toString(C));
                    JT1.setText("");
                }

                case "=" ->{
                    JT2.setText(String.valueOf(C));
                }
        }


//        else if(S2.equals("+")){
//
//              num1=Double.parseDouble(JT1.getText());
//              result+=num1;
//              JT2.setText(Double.toString(result));
//              JT1.setText(" ");
//            }
//
//        else if(S2.equals("-")) {
//
//                    num1 = Double.parseDouble(JT1.getText());
//                    oper = "-";
//                    JT1.setText("");
//
//            }
//                else if(S2.equals("*")) {
//
//                        num1 = Double.parseDouble(JT1.getText());
//                        oper = "*";
//            JT1.setText("");
//
//                }
//                else if (S2.equals("/")) {
//                    num1 = Double.parseDouble(JT1.getText());
//                    oper = "/";
//                       JT1.setText("");
//        }
//                    else if (S2.equals("=")) {
//
//                              num2=Double.parseDouble(JT1.getText());
//            switch (oper) {
//                case "+" -> result = num1 + num2;
//                case "-" -> result = num1 - num2;
//                case "*" -> result = num1 * num2;
//                case "/" -> result = num1 / num2;
//            }
//                              JT1.setText(String.valueOf(result));
//                              num1=result;
//                    }
//            else if(S2.equals("<-")){
//                String St=JT1.getText();
//                JT1.setText("");
//                for (int i=0;i<St.length();i++){
//                    JT1.setText(JT1.getText()+St.charAt(i));
//                }
//           }
        }
    }


    public static void main(String[] args) {
        Application_3Calc A3=new Application_3Calc();
        A3.setVisible(true);
        A3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
