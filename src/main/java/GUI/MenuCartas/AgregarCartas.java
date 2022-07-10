package main.java.GUI.MenuCartas;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        List<Card> cartasFaltantes = game.getMazoCartas().missingCards(game.getMazoIdeal());

        actualizarTexto(cartasFaltantes, cartasPosiblesLabel);

        agregarMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Actualizar missingCards
                List<Card> cartasFaltantes = game.getMazoCartas().missingCards(game.getMazoIdeal());

                List<Card> mazo = game.getMazoCartas().getCardsSet();
                mazo.add(cartasFaltantes.get(Integer.parseInt(numeroElemento.getText())));

                cartasFaltantes = game.getMazoCartas().missingCards(game.getMazoIdeal());

                //Actualizar missingCards
                actualizarTexto(cartasFaltantes, cartasPosiblesLabel);
            }
        });
    }

    /**
     * Función que encapsula los procesos para actualizar el texto del label.
     * @param cartasFaltantes resultado de aplicar missingCards al CardsSet
     * @param cartasPosiblesLabel Label que muestra las cartas de missingCards
     */
    public static void actualizarTexto(List<Card> cartasFaltantes, JLabel cartasPosiblesLabel){
        if (cartasFaltantes == null || cartasFaltantes.size() == 0){
            cartasPosiblesLabel.setText("No hay nada para agregar.");
        }
        else {
            cartasPosiblesLabel.setText(obtenerTexto(cartasFaltantes));
        }
    }

    /**
     * Función que encapsula el proceso para recalcular el missingCards y pasarlo a texto.
     * @param cartasFaltantes resultado de aplicar missingCards al CardsSet
     * @return String con las missingCards
     */
    public static String obtenerTexto(List<Card> cartasFaltantes){
        StringBuilder acum = new StringBuilder("<html>");
        for (int i = 0; i < cartasFaltantes.size(); i++){
            acum.append("[POS ").append(i).append("] = ").append(cartasFaltantes.get(i)).append(", ");
        }
        acum.append("</html>");
        return acum.toString();
    }

}
