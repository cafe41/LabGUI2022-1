package main.java.GUI.MenuStatus;

import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuStatus extends JFrame{


    private JPanel panelStatus;
    private JLabel texto1;
    private JButton estadoDelMazoButton;
    private JButton back;
    private JButton estadoJugadoresButton;
    private JButton estadoPartidaButton;
    private JLabel fondoArriba;
    private JLabel fondoDerechoArriba;
    private JLabel statusPartidaActual;
    private JLabel statusMazoCartas;
    private JScrollPane scrollPaneCartas;
    private JScrollPane scrollPaneJugadores;
    private JScrollPane scrollPanePartida;
    private JLabel statusJugadores;

    public DobbleGame game;
    private JPanel panel1;

    /**
     * MenuStatus: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @see MainMenu Menú Principal
     */
    public MenuStatus(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelStatus);
        this.pack();

        this.game = game;

        scrollPaneCartas.getViewport().setBackground(Color.black);
        scrollPaneJugadores.getViewport().setBackground(Color.black);
        scrollPanePartida.getViewport().setBackground(Color.black);

        estadoDelMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        estadoJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        estadoPartidaButton.addActionListener(new ActionListener() {
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
