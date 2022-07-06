package main.java.GUI;

import main.java.Dobble.cardsSet.Dobble;
import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCards extends JFrame{
    private JPanel panelCards;
    private JLabel texto1;
    private JButton crearMazoButton;
    private JButton back;
    private JLabel mazoActual;
    private JButton agregarCartasButton;
    private JButton verifyButton;
    private JButton missingCardsButton;

    public static DobbleGame game;

    /**
     * MenuCards: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * <p>
     * @return MenuCards
     * @see MainMenu Menú Principal
     */
    public MenuCards(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelCards);
        this.pack();

        this.game = game;
        if(game.getMazoCartas() != null){
            mazoActual.setText("Mazo Actual de cartas: " +
                    game.getMazoCartas().getCardsSet().toString());
        }
        else{
            mazoActual.setText("Mazo Actual de cartas: null");
        }

        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new CrearCartas("Crear Mazo", game);
                frame1.setVisible(true);
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
