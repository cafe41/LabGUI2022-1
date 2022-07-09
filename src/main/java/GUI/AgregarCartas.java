package main.java.GUI;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgregarCartas extends JFrame{
    private JButton agregarMazoButton;
    private JPanel panelCrearCarta;
    private JTextField numeroElemento;
    private JLabel sigCartas;
    private JLabel indexText;
    private JLabel cartasPosiblesLabel;

    public static DobbleGame game;

    public AgregarCartas(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panelCrearCarta);
        this.pack();

        AgregarCartas.game = game;
        List<Card> missingInicial = game.getMazoCartas().missingCards(game.getMazoCartas());

        agregarMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Card> missing = game.getMazoCartas().missingCards(game.getMazoCartas());
                game.getMazoCartas().getCardsSet().add(
                        missing.get(Integer.parseInt(numeroElemento.getText())));
                missing = game.getMazoCartas().missingCards(game.getMazoCartas());
                cartasPosiblesLabel.setText(missing.toString());
            }
        });
    }
}
