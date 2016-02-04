package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by loua001 on 04/02/16.
 */
public class FrameDialog extends JFrame{
    private JButton playButton = new JButton("Commencer Jeu");

    BatailleNavaleModel model = new BatailleNavaleModel() ;
    BatailleNavaleController controller = new BatailleNavaleController(model) ;

    public FrameDialog()
    {
        this.setTitle("Ma JFrame");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(playButton);

        playButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                DialogView dial = new DialogView(model, controller);
                BatailleNavaleView bNaval = dial.showBatailView();

            }

        });
        this.setVisible(true);
    }

}
