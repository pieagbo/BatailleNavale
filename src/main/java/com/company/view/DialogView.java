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

    private BatailleNavaleModel model = new BatailleNavaleModel();
    private BatailleNavaleController controller = new BatailleNavaleController(model);


    private BatailleNavaleView dial = new BatailleNavaleView(model, controller);

    private JLabel nomJoueurUn, nomJoueurDeux;
    private JTextField textNomUn, textNomDeux, coord1;
    private JFrame frame;


    public DialogView(BatailleNavaleModel _model, BatailleNavaleController _controller)
    {
        super();

        this.model = _model;
        this.controller = _controller;

        this.frame = new JFrame("Bataille Navale");


//        this.frame.setSize(1200, 1000);
//        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.frame.setResizable(true);
//        //this.frame.setLocationRelativeTo(null);
//        this.initComponent();
//
//
//        this.frame.setVisible(true);
//        this.frame.pack();


        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.initComponent();

    }

    public BatailleNavaleView showBatailView(){

        this.setVisible(true);

        return this.dial;

    }

    private void initComponent() {
        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(450, 100));


        textNomUn = new JTextField();
        textNomUn.setPreferredSize(new Dimension(100, 25));

        textNomDeux = new JTextField();
        textNomDeux.setPreferredSize(new Dimension(100, 25));

        panNom.setBorder(BorderFactory.createTitledBorder("Paramétrage joueur 1"));

        nomJoueurUn = new JLabel("Nom joueur :");
        panNom.add(nomJoueurUn);
        panNom.add(textNomUn);

        nomJoueurDeux = new JLabel("Entrez les coordonnées de vos navires !!!");
        panNom.add(nomJoueurDeux);

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
