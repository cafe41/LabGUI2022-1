package main.java.GUI;

import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton estadoActualButton;
    private JButton jugarButton;
    private JButton agregarJugadoresButton;
    private JButton crearMazoButton;
    private JLabel fondoDerecho;
    private JLabel fondoIzquierdo;

    public static DobbleGame game;


    /**
     * MainMenu: Constructor del menú principal,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @see MenuJugar Menú Jugar
     * @see MenuPlayer Menú para añadir/editar un jugador
     * @see MenuCards Menú para editar el mazo
     * @see MenuStatus Menú del estado del juego
     */
    public MainMenu(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();

        game = new DobbleGame();

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new MenuJugar("Menú Jugar");
                frame1.setVisible(true);
                dispose();
            }
        });
        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new MenuCards("Menú Cartas", game);
                frame2.setVisible(true);
                dispose();
            }
        });
        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new MenuPlayer("Menú Jugadores");
                frame3.setVisible(true);
                dispose();
            }
        });
        estadoActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new MenuStatus("Menú Estado");
                frame4.setVisible(true);
                dispose();
            }
        });
    }
    /**
     * MainMenu: Constructor del menú principal,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @param game DobbleGame que se "pasa" entre menus y botones.
     * @see MenuJugar Menú Jugar
     * @see MenuPlayer Menú para añadir/editar un jugador
     * @see MenuCards Menú para editar el mazo
     * @see MenuStatus Menú del estado del juego
     */
    public MainMenu(String title, DobbleGame game){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();

        MainMenu.game = game;

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new MenuJugar("Menú Jugar");
                frame1.setVisible(true);
                dispose();
            }
        });
        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new MenuCards("Menú Cartas", game);
                frame2.setVisible(true);
                dispose();
            }
        });
        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new MenuPlayer("Menú Jugadores");
                frame3.setVisible(true);
                dispose();
            }
        });
        estadoActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new MenuStatus("Menú Estado");
                frame4.setVisible(true);
                dispose();
            }
        });
    }
    /**Método main donde llamaremos las interfaces gráficas definidas previamente.
     * <p>
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new MainMenu("Menú Principal");
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


