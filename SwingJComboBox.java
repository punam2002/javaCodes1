package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SwingJComboBox extends JFrame implements ActionListener {

    String [] S={"India","Italy","Liaberia","Lithuania","Myanmar","Romania","Anguilla"};
    String [] C={"C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-india-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-italy-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-liberia-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-lithuania-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-myanmar-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-romania-100.png",
            "C:\\Users\\Poonam\\IdeaProjects\\javaprogramPINU\\src\\com\\AdvJava\\icons8-anguilla-circular-100.png"};
    JLabel L=new JLabel(" ",new ImageIcon(C[0]),JLabel.CENTER);

  //  JComboBox JC;    also we can use like this, but it gives warning still program is Running. Here typecasting is use

    JComboBox <String> JC;// Here typecasting is use


    SwingJComboBox(){
        setBounds(200,200,400,400);
        setTitle("Swing JCombo Box Component...");

        JPanel P=new JPanel();
        JPanel P1=new JPanel();

        P.setBackground(Color.orange);
        P1.setBackground(Color.CYAN);
          JC= new JComboBox <> (S);
        P.add(JC);
        add(P,"North");

        P1.add(L);
        add(P1);
        JC.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int I=JC.getSelectedIndex();
        ImageIcon I1=new ImageIcon(C[I]);
    L.setIcon(I1);
    L.setLocation(150,50);
    }

    public static void main(String[] args) {
        SwingJComboBox SC=new SwingJComboBox();
        SC.setVisible(true);
        SC.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
