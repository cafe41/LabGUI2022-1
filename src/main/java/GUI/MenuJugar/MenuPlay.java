package main.java.GUI.MenuJugar;

import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPlay extends JFrame{
    private JPanel panelJugar;
    private JButton modoContrarrelojPvPButton;
    private JButton modoCooperativoVsIAButton;
    private JButton modoCompetitivoPvPButton;
    private JButton modoContrarrelojButton;
    private JButton modoVsIAButton;
    private JButton modoDePruebaButton;
    private JLabel texto1;
    private JButton back;

    public DobbleGame game;

    /**
    * MenuJugar: Constructor de menú jugar, pide un título que será el título de la ventana creada.
    * La función llama al constructor de JFrame a través de "super(title)"
    * <p>
    * @param title Título de la ventana a crear.
    * @see MainMenu Menú Principal
    */
    public MenuPlay(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelJugar);
        this.pack();

        this.game = game;

        modoDePruebaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modoVsIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modoContrarrelojButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modoCompetitivoPvPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modoContrarrelojPvPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modoCooperativoVsIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainMenu("Menú Principal", game);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
