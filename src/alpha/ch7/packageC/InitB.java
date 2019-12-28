package alpha.ch7.packageC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitB extends JFrame {

    JButton jButton;

    public InitB(){
        jButton = new JButton("Click");
//        GridLayout gridLayout = new GridLayout();
//        gridLayout.addLayoutComponent("1", jButton);
        this.add(jButton);
        this.setSize(300, 400);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);


        jButton.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
//                        new InitA();
                        System.out.println(InitA.tempA);
                    }
                }
        );
    }



    public static void main(String[] args) {
        new InitB();
    }
}
