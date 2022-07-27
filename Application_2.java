package com.company;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Application_2 extends JFrame implements ActionListener {
    JTabbedPane TP=new JTabbedPane();
    JTable JT1=new JTable();
    JTable JT2=new JTable();
    JTable JT3=new JTable();

    CardLayout C=new CardLayout();

    List L1=new List(33);

    JScrollPane SP=new JScrollPane(JT1);
    JScrollPane SP1=new JScrollPane(L1);
    JScrollPane SP2=new JScrollPane(JT2);
    JScrollPane SP3=new JScrollPane(JT3);

    JPanel Inaction=new JPanel();
    JPanel P1=new JPanel();
    JPanel P2=new JPanel();
    JPanel P3=new JPanel();
    JPanel P4=new JPanel();
    JPanel P5=new JPanel();
    JPanel P6=new JPanel();
    JPanel Center=new JPanel();
    JPanel P7=new JPanel();
    JPanel P8=new JPanel();
    JPanel P9=new JPanel();
    JPanel P10=new JPanel();
    JPanel Avl=new JPanel();

    JButton B1=new JButton("Create");
    JButton B2=new JButton("Delete");
    JButton B3=new JButton("Enter");
    JButton B4=new JButton("Show");
    JButton B5=new JButton("Find Record");
    JButton B6= new JButton("Back");
    JButton AvailableStock= new JButton("Stock");

    JTextField JF1=new JTextField(15);
    JTextField JF2=new JTextField(15);
    JTextField JF3=new JTextField(15);
    JTextField JF4=new JTextField(15);
    JTextField JF5=new JTextField(15);
    JTextField JF6=new JTextField(15);
    JTextField JF7=new JTextField(15);
    JTextField JF8=new JTextField(15);
    JTextField JF9=new JTextField(15);
    JTextField JF10=new JTextField(15);
    JTextField JF11=new JTextField(15);

    Connection Conn;
    Statement stat;

    String SQL="Show tables;";
    float Ss1,Ss2;

    Application_2(){

        //set Default Frame;
        setBounds(100, 100, 670, 600);
        setTitle("Accounting Software for furniture Shop...");

        Inaction.setBackground(new Color(255, 186,187));

        JT1.setBackground(new Color(204,216,75));
        JT2.setBackground(new Color(204,216,75));
        JT3.setBackground(new Color(204,216,75));
        P5.setBackground(new Color(120,162,66));
        P3.setBackground(new Color(140,122,98));
        P8.setBackground(new Color(140,122,98));
        P10.setBackground(new Color(0,167,187));
        P6.setBackground(new Color(0,167,187));
        P7.setBackground(new Color(0,167,187));

        //Create Panel to insert the items, and addition of panel to code;

        Inaction.setLayout(new GridLayout(9,2,20,20));

        Inaction.add(new JLabel("Date",4));
        Inaction.add(JF9);

        Inaction.add(new JLabel("Item",4));
        Inaction.add(JF2);

        Inaction.add(new JLabel("Size",4));
        Inaction.add(JF7);

        Inaction.add(new JLabel("SqFeet",4));
        Inaction.add(JF8);

        Inaction.add(new JLabel("Rate",4));
        Inaction.add(JF3);

        Inaction.add(new JLabel("C_SqFeet",4));
        Inaction.add(JF10);

        Inaction.add(new JLabel("C_Rate",4));
        Inaction.add(JF4);

        Inaction.add(new JLabel("QTY",4));
        Inaction.add(JF5);

        Inaction.add(new JLabel("Total_Amt",4));
        Inaction.add(JF6);

        Center.setLayout(new BorderLayout());
        Center.add(Inaction,"Center");
        Center.add(P7,"South");

        P1.setLayout(new BorderLayout());
        P2.setLayout(new BorderLayout());
        P6.setLayout(new BorderLayout());
        P9.setLayout(new BorderLayout());

        P5.add(new JLabel("Enter Table Name"));
        P5.add(JF1);
        P5.add(B1);
        P5.add(B2);
        P5.add(new JLabel("Enter Item name"));
        P5.add(JF11);
        P5.add(AvailableStock);

        P6.add(SP2,"Center");

         P7.add(B3);
         P7.add(B4);
         P8.add(B5);
        P9.add(SP,"Center");
        P9.add(P10,"South");

        P4.setLayout(C);
        Avl.add(SP3);
        //create the cards on p4 Panel.

        P4.add("Card_1",P5);
        P4.add("Card_2",Center);
        P4.add("Card_3",P6);
        P4.add("Card_4",P9);
        P4.add("Card_5",Avl);

        P3.add(SP1);
        P2.add(B6,"South");
        P2.add(P8,"North");
        P2.add(P3,"Center");

        P1.add(P2,"West");
        P1.add(P4,"Center");

        TP.addTab("Purchase",P1);
        add(TP);
//Database connection and Showing tables for the list Component
        try{
           Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("Driver Resister.....");
            Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture",
                    "Punam","punam_mistari");
            stat=Conn.createStatement();
            ResultSet Set2=stat.executeQuery(SQL);
           // System.out.println(SQL);
            while(Set2.next()){
           String Ss=Set2.getString(1);
               L1.add(Ss);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Resister the Action Event on buttons.
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Insertion of items into the Tables

               String InSql="Insert into "+JF1.getText()+" values('"+JF9.getText()+"','"+JF2.getText()+"','"+JF7.getText()+"',"+JF8.getText()+","+JF3.getText()+","+JF10.getText()+","+JF4.getText()+","+JF5.getText()+","+JF6.getText()+");";
                String InItems="Insert into available_stock values ('"+JF2.getText()+"','"+JF7.getText()+"',"+JF10.getText()+","+JF4.getText()+");";
              //  System.out.println(InItems);
               // System.out.println(InSql);

                try {
                    stat.execute(InSql);
                    stat.execute(InItems);
                    JOptionPane.showMessageDialog(null, "Record is inserted");
                    Display();
                    JF2.setText("");
                    JF3.setText("");
                    JF4.setText("");
                    JF5.setText("");
                    JF6.setText("");
                    JF7.setText("");
                    JF8.setText("");

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display();
                C.show(P4,"Card_3");
                 P6.add(new JLabel("Total amount to pay :- "+ Ss2),"South");
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Disp();
              C.show(P4,"Card_4");
                P10.add(new JLabel("Total Amount to pay :- " + Ss1));
            }
        });
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                C.first(P4);
            }
        });

        AvailableStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String AvSql="Select * from available_stock where Items='"+JF11.getText()+"';";
                try {
                    ResultSet Set4 = stat.executeQuery(AvSql);
                    JT3.setModel(DbUtils.resultSetToTableModel(Set4));
                }
                catch(Exception E){
                    E.printStackTrace();
                }
                C.show(P4,"Card_5");
            }
        });

    }

    public static void main(String[] args) {
        Application_2 A=new Application_2();
        A.setVisible(true);
        A.setDefaultCloseOperation(3);
    }

     // Function to Display the Records of new Created table'

    void Display(){
        try{
            String SumSQL = "Select sum(Total_Amt)from " + JF1.getText() + ";";
            ResultSet set=stat.executeQuery( "Select * from "+JF1.getText()+";");
            System.out.println();
            JT2.setModel(DbUtils.resultSetToTableModel(set));

            ResultSet Set3 = stat.executeQuery(SumSQL);
            while (Set3.next()) {
                Ss2 = Set3.getFloat(1);
            }

        }
        catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    // Function to Display the Records of particular table in the list component.
    void Disp(){
        try {
            String Ng = "Select * from " + L1.getSelectedItem() + ";";
            String SumSQL = "Select sum(Total_Amt)from " + L1.getSelectedItem() + ";";

            ResultSet set = stat.executeQuery(Ng);
            System.out.println();
            JT1.setModel(DbUtils.resultSetToTableModel(set));

            ResultSet Set3 = stat.executeQuery(SumSQL);
            while (Set3.next()) {
                 Ss1 = Set3.getFloat(1);
            }
        }
        catch(Exception Ex){
            System.out.println(Ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
String S2=e.getActionCommand();
if(S2.equals("Create")){
    String CrSql="create table "+JF1.getText()+"(Date Varchar(30) NOT NULL,Items Varchar(30) NOT NULL,Size Varchar(30),SqFeet float(30),C_SqFeet float(30),Rate float(7.7) NOT NULL,C_Rate float(7.7) NOT NULL,QTY int(10) NOT NULL,Total_Amt Float(8.8) NOT NULL); ";
    System.out.println(CrSql);
    try {
        stat.executeUpdate( CrSql);
        JOptionPane.showMessageDialog(null, "Ready Table");
        L1.add(JF1.getText());
        C.show(P4,"Card_2");
    }
    catch (Exception E){
        E.printStackTrace();
    }
}
if(S2.equals("Delete")){

   String DrSQL="Drop table "+L1.getSelectedItem()+";";
    try {
        stat.executeUpdate( DrSQL);
        JOptionPane.showMessageDialog(null, "Delete Table");
        int X=L1.getSelectedIndex();
        L1.remove(X);
    }
    catch (Exception E){
        E.printStackTrace();
    }
}
        }
    }

