package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.joueurs.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cindy on 03/02/2016.
 */
public class DialogView extends JDialog{

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    private JLabel nomJoueur;
    private JTextField nom;
    private JFrame frame;


    public DialogView(BatailleNavaleModel _model, BatailleNavaleController _controller)
    {
        super();

        this.model = _model;
        this.controller = _controller;

        this.frame = new JFrame("Bataille Navale");


        this.frame.setSize(1200, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        //this.frame.setLocationRelativeTo(null);
        this.initComponent();


        this.frame.setVisible(true);
        this.frame.pack();



    }

    private void initComponent() {
        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(220, 60));
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(100, 25));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
        nomJoueur = new JLabel("Saisir un nom :");
        panNom.add(nomJoueur);
        panNom.add(nom);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panNom);

        JPanel control = new JPanel();
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton cancel = new JButton("Annuler");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        control.add(okButton);
        control.add(cancel);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);


    }

}
