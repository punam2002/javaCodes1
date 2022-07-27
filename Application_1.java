
//Purchase code for the furniture shop.

package com.company;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Application_1 extends JFrame implements ActionListener{

    JPanel Center=new JPanel();
    JPanel Center1=new JPanel();
    JPanel Center2=new JPanel();
    JPanel South= new JPanel();
    JPanel P1= new JPanel();
    JPanel P2=new JPanel();
    JPanel P3=new JPanel();
    JPanel Inaction=new JPanel();
    JPanel Deaction=new JPanel();
    JPanel Faction1=new JPanel();
    JPanel Faction2=new JPanel();
    JPanel FD=new JPanel();

JButton In=new JButton("Insertion");
JButton De=new JButton("Deletion");
JButton Search=new JButton("Search");
JButton Find=new JButton("Find");

JButton Enter =new JButton("Enter");
JButton Delete =new JButton("Delete");


    JTextField Jt1=new JTextField();
    JTextField Jt2=new JTextField();
    JTextField Jt3=new JTextField();
    JTextField Jt4=new JTextField();
    JTextField Jt5=new JTextField();
    JTextField Jt6=new JTextField();
    JTextField Jt7=new JTextField();
    JTextField Jt8=new JTextField();

    JTextField DeJt1=new JTextField(10);

    JTextField Fac =new JTextField(15);

    JTable JT=new JTable();
    JTable JT1=new JTable();

    JScrollPane Jsp=new JScrollPane(JT);
    JScrollPane Jsp1=new JScrollPane(JT1);


    CardLayout C=new CardLayout();
    Connection Conn;
    Statement Stat;

    Application_1() {
        setBounds(100, 100, 600, 600);
        setTitle("Accounting Software for furniture Shop...");

        JTabbedPane Jp=new JTabbedPane();
        Jp.addTab("Customer",P1);
        Jp.addTab("Goods",P2);
        add(Jp);



        Center.setBackground(Color.LIGHT_GRAY);
        Deaction.setBackground(Color.pink);
        Inaction.setBackground(new Color(120,162,66));
        Faction1.setBackground(new Color(219,91,41));
        Faction2.setBackground(new Color(174,213,174));
        JT.setBackground(new Color(204,216,75));

        P1.setLayout(new BorderLayout());

        South.setBackground(Color.orange);
        South.add(In);
        South.add(De);
      //  South.add(Up);
        South.add(Find);

        P1.add(South,"South");

        Center.setLayout(new BorderLayout());
        Center.add(Inaction,"Center");
        Center.add(Enter,"South");


        Center1.setLayout(new BorderLayout());
        Deaction.add(new JLabel("Enter the name of the customer to delete the record it's Record :-"));
        Deaction.add(DeJt1);

        Center1.add(Deaction,"Center");
        Center1.add(Delete,"South");

        P3.setLayout(C);
        P3.add("In_Panel",Center);
        P3.add("De_Panel",Center1);
        P3.add("Find_Panel",Center2);



        Inaction.setLayout(new GridLayout(8,2,20,20));

        Inaction.add(new JLabel("Date",4));
        Inaction.add(Jt1);

        Inaction.add(new JLabel("Cust_Name",4));
        Inaction.add(Jt2);

        Inaction.add(new JLabel("Item",4));
        Inaction.add(Jt3);

        Inaction.add(new JLabel("rate",4));
        Inaction.add(Jt4);

        Inaction.add(new JLabel(" Qty",4));
        Inaction.add(Jt5);

        Inaction.add(new JLabel("Total_Amt",4));
        Inaction.add(Jt6);

        Inaction.add(new JLabel("Paid_Amt",4));
        Inaction.add(Jt7);

        Inaction.add(new JLabel("Credit_Amt",JLabel.RIGHT));
        Inaction.add(Jt8);

        Center2.setLayout(new BorderLayout());

        Faction1.add(new JLabel("Find record :- "));
        Faction1.add(Fac);
        Faction1.add(Search);

        Faction2.add(new JLabel("Record is :-"));
        Faction2.add(Jsp1);

        Center2.add(Faction2,"Center");
        Center2.add(Faction1,"South");

        P1.add(P3,"Center");
        FD.setLayout(new BorderLayout());
        FD.add(Jsp);
        Jp.add("Display Cust Record",FD);


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered....");
            Conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture",
                    "Punam","punam_mistari");

            Stat =Conn.createStatement();
        }


        catch(Exception e){
            System.out.println(e);
        }
        Display_Fcustomer();
        In.addActionListener(this);
        De.addActionListener(this);
        Find.addActionListener(this);

        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String InSql="Insert into fcustomer values ('"+Jt1.getText()+"','"+Jt2.getText()+"','"+Jt3.getText()+"',"+Jt4.getText()+","+Jt5.getText()+","+Jt6.getText()+","+Jt7.getText()+","+Jt8.getText()+");";
                System.out.println(InSql);
                try {
                    Stat.execute(InSql);
                    JOptionPane.showMessageDialog(null, "Record is inserted");

                     Display_Fcustomer();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DeSql="Delete from fcustomer where Cust_Name='"+DeJt1.getText()+"';";
                System.out.println(DeSql);
                try {
                    Stat.execute(DeSql);
                    JOptionPane.showMessageDialog(null, "Record is Deleted");

                    Display_Fcustomer();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fSql="Select * from fcustomer where Cust_Name='"+ Fac.getText() +"';" ;
                System.out.println(fSql);
                try{
                    ResultSet Set1=Stat.executeQuery(fSql);
                    JT1.setModel(DbUtils.resultSetToTableModel(Set1));

                    JOptionPane.showMessageDialog(null, "Record is Found");

                }
                catch(Exception ex){
                   ex.printStackTrace();
                }
            }
        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {
       String Action=e.getActionCommand();
       if(Action.equals("Insertion")){
           C.show(P3,"In_Panel");

       }
       if(Action.equals("Deletion")){
           C.show(P3,"De_Panel");
       }

        if(Action.equals("Find")){
            C.show(P3,"Find_Panel");
        }

    }

    void Display_Fcustomer(){

        try{
            ResultSet set=Stat.executeQuery("Select * from fcustomer");
            JT.setModel(DbUtils.resultSetToTableModel(set));

        }
        catch(Exception Ex){
            System.out.println(Ex);
        }
    }



        public static void main(String[] args) {
            Application_1 A=new Application_1();
            A.setVisible(true);
            A.setDefaultCloseOperation(3);
    }
}



