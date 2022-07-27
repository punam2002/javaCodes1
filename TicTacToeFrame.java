
//OXO game code to understand....

package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToeFrame extends Frame implements ActionListener{
    Button [][] b = new Button[3][3];
    boolean flag=false;
    int [][] status = {{0,0,0},{0,0,0},{0,0,0}};
    int count;

    TicTacToeFrame()
    {
        setSize(400,300);
        setTitle("Tic Tac Toe");
        setLocation(150,150);
        setLayout(new GridLayout(3,3));
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[i].length;j++)
            {
                b[i][j] = new Button();
                b[i][j].setFont(new Font("Times New Roman",Font.BOLD,40));
                b[i][j].setBackground(Color.pink);
                add(b[i][j]);
                b[i][j].addActionListener(this);

            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();
        Button btn = (Button) e.getSource();


        if(str.equals("") && flag)
        {
            btn.setLabel("X")  ;
            flag=false;
            count++;
        }
        else
        if(str.equals("") && !flag)
        {
            btn.setLabel("O");
            flag=true;
            count++;
        }
        int r=0,c=0;

        for(int   i=0;i<3;i++)
            for(int   j=0;j<3;j++)
            {
                if(btn==b[i][j])
                {
                    r=i;
                    c=j;
                    if(btn.getLabel().equals("X"))
                        status[i][j]=1;
                    else
                    if(btn.getLabel().equals("O"))
                        status[i][j]=2;
                    break;
                }

            }

        if((status[r][0]==1 && status[r][1]==1 && status[r][2]==1) ||(status[0][c]==1 && status[1][c]==1 && status[2][c]==1)||
                (status[0][0]==1&& status[1][1]==1 && status[2][2]==1)||(status[0][2]==1&& status[1][1]==1&& status[2][0]==1))
        {
            JOptionPane.showMessageDialog(null,"X is winner");
            System.exit(0);
        }


        if((status[r][0]==2 && status[r][1]==2 && status[r][2]==2)||(status[0][c]==2 && status[1][c]==2 && status[2][c]==2)||
                (status[0][0]==2&& status[1][1]==2 && status[2][2]==2)||(status[0][2]==2&& status[1][1]==2&& status[2][0]==2))
        {
            JOptionPane.showMessageDialog(null,"O is winner");
            System.exit(0);
        }

        if(count==9)
        {
            JOptionPane.showMessageDialog(null,"Game Draw");
            System.exit(0);
        }







/*		if(done)
		{
			JOptionPane.showMessageDialog(null,"Winner");
			System.exit(0);
		}*/
    }



    public static void main(String args[])
    {
        TicTacToeFrame f = new TicTacToeFrame();
        f.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


        f.setVisible(true);
    }
}

