package main.java.GUI.MenuJugar;

import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MainMenu;
import main.java.GUI.genericText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPlay extends JFrame{
    private JPanel panelJugar;
    private JButton modoDePruebaButton;
    private JButton modoContrarrelojPvPButton;
    private JButton modoCooperativoVsIAButton;
    private JButton modoCompetitivoPvPButton;
    private JButton modoContrarrelojButton;
    private JButton modoVsIAButton;
    private JButton back;
    private JLabel texto1;
    private JLabel fondoBottom;
    private JLabel fondoDerecho;

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

        if (game.getJugadores().size() < 1){
            modoContrarrelojPvPButton.setVisible(false);
            modoCooperativoVsIAButton.setVisible(false);
            modoCompetitivoPvPButton.setVisible(false);
            modoContrarrelojButton.setVisible(false);
            modoVsIAButton.setVisible(false);
        }
        else if (game.getJugadores().size() == 1){
            modoDePruebaButton.setVisible(false);
            modoCompetitivoPvPButton.setVisible(false);
            modoContrarrelojPvPButton.setVisible(false);
            modoCooperativoVsIAButton.setVisible(false);
        }
        else if(game.getJugadores().size() > 1){
            modoDePruebaButton.setVisible(false);
            modoVsIAButton.setVisible(false);
            modoContrarrelojButton.setVisible(false);
        }

        modoDePruebaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame contraReloj = new Juego("Modo de Prueba", game, 10,
                        3,false,"IA Vs IA",2);
                contraReloj.setVisible(true);
            }
        });
        modoVsIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame contraReloj = new Juego("Modo Vs IA", game, 20,
                        3,false,"Vs IA",1);
                contraReloj.setVisible(true);
            }
        });
        modoContrarrelojButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame contraReloj = new Juego("Modo Contrarreloj", game, 10,
                        5,true,"Contrarreloj",0);
                contraReloj.setVisible(true);
            }
        });
        modoCompetitivoPvPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getJugadores().size() > 1){
                    JFrame competitivoPVP = new Juego("Modo Competitivo Player Vs Player",
                            game, 20, 3,false,
                            "Competitivo PvP",0);
                    competitivoPVP.setVisible(true);
                }
                else {
                    JFrame competitivoPVP = new genericText("Error",
                            "<html>Debe tener al menos dos jugadores para " +
                                    "elegir este modo de juego </html>");
                }
            }
        });
        modoContrarrelojPvPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getJugadores().size() > 1){
                    JFrame competitivoPVP = new Juego("Modo Competitivo Player Vs Player",
                            game, 10, 5,true,
                            "Competitivo PvP",0);
                    competitivoPVP.setVisible(true);
                }
                else {
                    JFrame competitivoPVP = new genericText("Error",
                            "<html>Debe tener al menos dos jugadores para " +
                                    "elegir este modo de juego </html>");
                }
            }
        });
        modoCooperativoVsIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getJugadores().size() > 1){
                    JFrame competitivoPVP = new Juego("Modo Cooperativo VS IA",
                            game, 20, 3,false,
                            "Cooperativo Vs IA",2);
                    competitivoPVP.setVisible(true);
                }
                else {
                    JFrame competitivoPVP = new genericText("Error",
                            "<html>Debe tener al menos dos jugadores para " +
                                    "elegir este modo de juego </html>");
                }
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
