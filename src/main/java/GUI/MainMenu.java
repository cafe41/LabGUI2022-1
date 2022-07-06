package main.java.GUI;

import javax.swing.*;
import java.awt.*;
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

    /**
     * MainMenu: Constructor del menú principal,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * <p>
     * @return MainMenu
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
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new MenuJugar("Menú Jugar");
                frame1.setVisible(true);
            }
        });
        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new MenuCards("Menú Cartas");
                frame2.setVisible(true);
            }
        });
        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new MenuPlayer("Menú Jugadores");
                frame3.setVisible(true);
            }
        });
        estadoActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new MenuStatus("Menú Estado");
                frame4.setVisible(true);
            }
        });
    }

    /**Método main donde llamaremos las interfaces gráficas definidas previamente.
     * <p>
     * @param args
     * <p>
     * @return void
     */
    public static void main(String[] args) {
        JFrame frame = new MainMenu("Menú Principal");
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        JLabel separador1 = new JLabel();
        separador1.setText("AYUDA");
        separador1.setIcon(new ImageIcon("GUI/JPG/Separador1.jpg"));
        separador1.setHorizontalTextPosition(JLabel.CENTER);
        separador1.setVerticalTextPosition(JLabel.TOP);
        separador1.setForeground(new Color(0xBB0007));
        separador1.setBackground(Color.BLACK);
        separador1.setOpaque(true);
        separador1.setBorder(BorderFactory.createLineBorder(Color.red,3));
    }
}


