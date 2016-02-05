package com.company.view;

import com.company.model.joueurs.Joueur;

import javax.swing.*;

/**
 * Created by pieagbo on 05/02/16.
 */
public class PlayerBoard extends JPanel {

    Joueur player ;

    JLabel playerName ;
    JLabel nbBoats ;

    public PlayerBoard(Joueur player) {
        super() ;
        this.player = player;

        this.playerName = new JLabel("A votre tour : " + player.getName(), JLabel.CENTER) ;
        this.nbBoats = new JLabel("Bateaux restants : " + player.getBateauxInLife(), JLabel.CENTER) ;

        JPanel panel1 = new JPanel() ;
        JPanel panel2 = new JPanel() ;
        JPanel panel3 = new JPanel() ;

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
        panel1.add(playerName) ;

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        panel2.add(nbBoats) ;

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
        panel3.add(new JLabel("Cliquez sur une case pour tirer")) ;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(panel1) ;
        this.add(panel2) ;
        this.add(panel3) ;
    }

    public void setPlayer(Joueur player){
        this.player = player ;
        this.playerName.setText("A votre tour : " + player.getName());
        this.nbBoats.setText("Bateaux restants : " + player.getBateauxInLife());
    }


}
