package main.java.GUI;

import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuCards extends JFrame{
    private JPanel panelCards;
    private JLabel texto1;
    private JButton crearMazoButton;
    private JButton back;
    private JLabel label6;
    private JButton agregarCartasButton;
    private JButton verifyButton;
    private JButton missingCardsButton;
    private JLabel mazoActual;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private final List<JLabel> listaLabel;

    public static DobbleGame game;

    /**
     * MenuCards: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @see MainMenu Menú Principal
     */
    public MenuCards(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelCards);
        this.pack();

        MenuCards.game = game;

        this.listaLabel = new ArrayList<>();
        listaLabel.add(label1); listaLabel.add(label2); listaLabel.add(label3); listaLabel.add(label4);
        listaLabel.add(label5); listaLabel.add(label6); listaLabel.add(label7); listaLabel.add(label8);
        listaLabel.add(label9); listaLabel.add(label10); listaLabel.add(label11); listaLabel.add(label12);
        listaLabel.add(label13); listaLabel.add(label14); listaLabel.add(label15); listaLabel.add(label16);
        listaLabel.add(label17); listaLabel.add(label18); listaLabel.add(label19); listaLabel.add(label20);
        listaLabel.add(label21); listaLabel.add(label22); listaLabel.add(label23); listaLabel.add(label24);
        listaLabel.add(label25); listaLabel.add(label26);

        if (game.getMazoCartas() != null) {
            updateCardsSet();
        }
        else{
            label1.setText("null");
        }

        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1;
                if(game.getMazoCartas() == null) {
                    frame1 = new CrearCartas("Crear Mazo", game);
                }
                else{
                    frame1 = new genericText("Error", "Ya posee un mazo.");
                }
                frame1.setVisible(true);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCardsSet();
                JFrame frame = new MainMenu("Menú Principal", game);
                frame.setVisible(true);
                dispose();
            }
        });
    }

    public void updateCardsSet(){
        if (game.getMazoCartas().getCardsSet().size() > 26) { //solo mostrará hasta 26
            for (int i = 0; i < 26; i++) {
                listaLabel.get(i).setText(game.getMazoCartas().getCardsSet().get(i).toString());
            }
        }
        else {
            for (int i = 0; i < game.getMazoCartas().getCardsSet().size(); i++) {
                listaLabel.get(i).setText(game.getMazoCartas().getCardsSet().get(i).toString());
            }
        }
    }
}
