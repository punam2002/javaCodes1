
//program to demonstrate the Swing JTextField, JTextArea and JPasswordField with JScrollPane to the JTextArea.

package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SwingJPassword extends JFrame {
    JLabel JL=new JLabel("",JLabel.CENTER);
    JButton Jb=new JButton("Add");


    JTextField JT=new JTextField(20);
    JPasswordField Ps=new JPasswordField(20);
    JTextArea TA=new JTextArea(20,40);

    SwingJPassword(){
        setBounds(200,200,500,500);
        setTitle("Swing JPassword Field Component.....");

        JPanel P=new JPanel();

        P.add(new JLabel("Password"));
        P.add(Ps);
        P.setBackground(Color.orange);
        add(P,"North");
        add(JL,"South");
         //Anonymous class can also write by this way, and this way called as lambda declaration.
        Ps.addActionListener(e -> {
             char []S=Ps.getPassword();
             String S1=new String(S);
            JL.setText("Password :- "+ S1);
            JL.setFont(new Font("Arial",Font.PLAIN,30));
        });

        JPanel P1=new JPanel();
        P1.add(new JLabel("Values"));
        P1.add(JT);
        P1.add(Jb);
        P1.setBackground(Color.GRAY);
            JScrollPane Js=new JScrollPane(TA);
        P1.add(Js,"Center");
        Jb.addActionListener(new Pro());

        add(P1,"Center");

        }
    class Pro implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String B=JT.getText();
            TA.append(B+"\n");

        }


    }

    public static void main(String[] args) {
        SwingJPassword SP=new SwingJPassword();
        SP.setVisible(true);
        SP.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
