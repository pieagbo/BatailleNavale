package com.company.view;

import javax.swing.*;
import java.awt.event.*;

public class ConfigurationDialog extends JDialog {
    private JPanel contentPane;
    private JButton playButton;
    private JTextField playerOne;
    private JTextField textField1;
    private JTextField textField2;

    public ConfigurationDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(playButton);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here

        dispose();
    }


    public static void main(String[] args) {
        ConfigurationDialog dialog = new ConfigurationDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
