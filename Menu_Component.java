package com.company;
import java.awt.*;
import java.awt.event.*;


public class Menu_Component extends Frame implements ActionListener{
    MenuBar M1=new MenuBar();
    Menu file=new Menu("File");
    Menu edit=new Menu("Edit");
    Menu help=new Menu("Help");
    Menu Options=new Menu("Options");

    MenuItem New=new MenuItem("New",new MenuShortcut(KeyEvent.VK_N,true));
    MenuItem save=new MenuItem("Save",new MenuShortcut(KeyEvent.VK_S));
    MenuItem open=new MenuItem("Open",new MenuShortcut(KeyEvent.VK_O,false));

    MenuItem Exit=new MenuItem("Exit");
    MenuItem cut=new MenuItem("Cut");
    MenuItem copy=new MenuItem("Copy");
    MenuItem Paste=new MenuItem("Paste");
    MenuItem About=new MenuItem("About");
    MenuItem Read=new MenuItem("Read");
    MenuItem write=new MenuItem("Write");


    Menu_Component(){

        setBounds(200,200,500,500);
     file.add(New);
        file.add(New);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(Options);
        file.addSeparator();
        file.add(Exit);


        Options.add(Read);
        Options.add(write);

        edit.add(cut);
        edit.add(copy);
        edit.add(Paste);

        help.add(About);

        M1.add(file);
        M1.add(edit);
        M1.add(help);
       setMenuBar(M1);

       New.addActionListener(this);
       About.addActionListener(this);
       Options.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String S=e.getActionCommand();
        if(S.equals("New"))
            setTitle("The New MenuItem is selected.");
        if(S.equals("New"))
            setTitle("The New MenuItem is selected.");


       else if(S.equals("About"))
            setTitle("The About MenuItem in help menu is selected.");

        if(S.equals("Options"))
        setTitle("The Option MenuItem is selected.");
    }

    public static void main(String[] args) {
Menu_Component Mc=new Menu_Component();
Mc.setVisible(true);
Mc.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        Mc.dispose();
    }
});
    }

}
