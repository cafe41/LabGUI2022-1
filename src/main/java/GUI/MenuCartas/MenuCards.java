package main.java.GUI.MenuCartas;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.cardsSet.Dobble;
import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MainMenu;
import main.java.GUI.genericText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuCards extends JFrame{
    public JPanel panelCards;
    private JLabel texto1;
    private JButton crearMazoButton;
    private JButton back;
    private JButton agregarCartasButton;
    private JButton verifyButton;
    private JButton missingCardsButton;
    private JLabel mazoActual;
    private JButton quitarCartasButton;
    private JScrollPane scrollPane;
    private JLabel fondoDerecho;
    private JLabel fondoArriba;
    private JLabel fondoBottom;

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

        scrollPane.getViewport().setBackground(Color.black);
        updateCardsSet();

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
                updateCardsSet();
            }
        });
        agregarCartasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2;
                if(game.getMazoCartas() != null) {
                    frame2 = new AgregarCartas("Agregar Cartas", game);
                }
                else{
                    frame2 = new genericText("Error", "No posee un mazo.");
                }
                frame2.setVisible(true);
                updateCardsSet();
            }
        });
        quitarCartasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3;
                if(game.getMazoCartas() != null) {
                    frame3 = new EliminarCartas("Eliminar Cartas", game);
                }
                else{
                    frame3 = new genericText("Error", "No posee un mazo.");
                }
                frame3.setVisible(true);
                updateCardsSet();
            }
        });
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto;
                JFrame frame4;
                if (game.getMazoCartas() != null){
                    if (game.getMazoCartas().dobbleValido()){
                        texto = "El conjunto de cartas es válido.";
                    }
                    else {texto = "El conjunto de cartas no es válido.";}
                    frame4 = new genericText("Verificar Cartas", texto);
                }
                else {frame4 = new genericText("Error", "No posee un mazo.");}
                frame4.setVisible(true);
                updateCardsSet();
            }
        });
        missingCardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder texto;
                JFrame frame5;
                if (game.getMazoCartas() != null){
                    List<Card> cartasFaltantes = game.getMazoCartas().missingCards(
                            game.getMazoIdeal());
                    if (cartasFaltantes.size() != 0){
                        texto = new StringBuilder("<html>Las cartas que faltan son:<br/>");
                        int i = 1;
                        for (Card cartasFaltante : cartasFaltantes) {
                            texto.append(cartasFaltante).append(" ");
                            if (i % 2 == 0) {
                                texto.append("<br/>");
                            }
                            i++;
                        }
                        texto.append("</html>");
                    }
                    else {
                        texto = new StringBuilder("No faltan cartas en el mazo.");}
                    frame5 = new genericText("Cartas Faltantes", texto.toString());
                }
                else {frame5 = new genericText("Error", "No posee un mazo.");}
                frame5.setVisible(true);
                updateCardsSet();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.getMazoCartas() != null){updateCardsSet();}
                JFrame frame = new MainMenu("Menú Principal", game);
                frame.setVisible(true);
                dispose();
            }
        });
        mazoActual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                updateCardsSet();
            }
        });
    }

    public void updateCardsSet(){
        if (game.getMazoCartas() != null) {
            StringBuilder acum = new StringBuilder("<html> Mazo de Cartas:<br/>");
            for (int i = 1; i <= game.getMazoCartas().getCardsSet().size(); i++) {
                acum.append(game.getMazoCartas().getCardsSet().get(i - 1).toString()).append(" ");
            }
            acum.append("</html>");
            this.mazoActual.setText(acum.toString());
        }
        else{
            mazoActual.setText("Mazo Actual: null");
        }
    }
}
