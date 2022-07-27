package com.company;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TwoTierAppProgram extends JFrame implements ActionListener {
    JTextField Jt1=new JTextField(20);
    JTextField Jt2=new JTextField(20);
    JTextField Jt3=new JTextField(20);
    JTextField Jt4=new JTextField(20);

    JButton JB1=new JButton("Add Record");
    JButton JB2=new JButton("Delete Record");
    JButton JB3=new JButton("Update Record");
    JButton JB4=new JButton("Search Record");

    JTable JT=new JTable();

    JTextArea JTA=new JTextArea();
    JScrollPane JSP=new JScrollPane(JTA);
    JScrollPane JSP1=new JScrollPane(JT);

    Connection Conn;
    Statement Stat;

    TwoTierAppProgram(){
        setBounds(200,200,600,600);
        setTitle("Two Tier Application Program");

        //Design GUI for database.
        JPanel P1=new JPanel();
        JPanel P2=new JPanel();
        JPanel P3=new JPanel();
        JPanel P4=new JPanel();
        JPanel P5=new JPanel();

        P2.setLayout(new GridLayout(4,2,10,70));
        P2.add(new JLabel("Emp_ID",JLabel.RIGHT));
        P2.add(Jt1);
        P2.add(new JLabel("Emp_NAME",JLabel.RIGHT));
        P2.add(Jt2);
        P2.add(new JLabel("SALARY",JLabel.RIGHT));
        P2.add(Jt3);
        P2.add(new JLabel("DEPARTMENT",JLabel.RIGHT));
        P2.add(Jt4);

        P3.add(JB1);
        P3.add(JB2);
        P3.add(JB3);
        P3.add(JB4);


        P1.setLayout(new BorderLayout());
        P1.add(P2,"Center");
        P1.add(P3,"South");

        JTabbedPane JTP=new JTabbedPane();
        add(JTP);
        JTP.addTab("Record Management",P1);

        P4.add(JSP);
        P5.add(JSP1);

      //  JTA.setFont(new Font("Segoe UI",Font.PLAIN,20));

        JTA.setEditable(false);

        JTP.addTab("Display Record",P4);
        JTP.addTab("Display Record in Table",P5);

//Establish Connection with Database.
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered....");
            Conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase",
                    "Punam","punam_mistari");

            Stat =Conn.createStatement();
        }


        catch(Exception e){
            System.out.println(e);
        }


        Display_Records();
        JB1.addActionListener(this);
        JB2.addActionListener(this);
    }


    void Display_Records(){
        JTA.setText("");

        try{
            ResultSet set=Stat.executeQuery("Select * from Employee");
//Instead of JTextArea we can use JTable component to Display the records.


//            JTA.append("Emp ID\tNAME\tSALARY\tDEPARTMENT");
//            JTA.append("\n\r-------------------------------------------------------------------------------\n\r");
//
//            while (set.next())
//
//                JTA.append(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getDouble(3)+"\t"+set.getString(4)+"\n\r");
//
//                JTA.append("-------------------------------------------------------------------------------\n\r");
//

            //To show the records in the JText Area on the 2nd Tab Comment the below line uncomment the Above code.

            JT.setModel(DbUtils.resultSetToTableModel(set));

        }
        catch(Exception Ex){
            System.out.println(Ex);
        }

    }

    public static void main(String[] args) {
        TwoTierAppProgram TTP=new TwoTierAppProgram();
        TTP.setVisible(true);
        TTP.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String S = e.getActionCommand();
        if (S.equals("Add Record")) {
            String sql = "insert into employee values(" + Jt1.getText() +
                    ",'" + Jt2.getText() + "'," + Jt3.getText() + ",'" + Jt4.getText() + "');";
            System.out.println(sql);
            try {
                Stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Record is inserted");
                Display_Records();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if(S.equals("Delete Record")){
            String sql="Delete from employee where Emp_id="+ Jt1.getText()+"";
            System.out.println(sql);
            try {
                Stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Record is Deleted");
                Display_Records();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    }

