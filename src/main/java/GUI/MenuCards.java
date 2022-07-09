package main.java.GUI;

import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCards extends JFrame{
    private JPanel panelCards;
    private JLabel texto1;
    private JButton crearMazoButton;
    private JButton back;
    private JButton agregarCartasButton;
    private JButton verifyButton;
    private JButton missingCardsButton;
    public JLabel mazoActual;
    private JScrollBar scrollBar1;

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

        if (game.getMazoCartas() != null) {
            updateCardsSet();
        }
        else{
            mazoActual.setText("Mazo Actual: null");
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
            }
        });
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        missingCardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
    }

    public void updateCardsSet(){
        StringBuilder acum = new StringBuilder("<html> Mazo de Cartas:<br/>");
        for (int i = 1; i <= game.getMazoCartas().getCantMaxCartas(); i++) {
            acum.append(game.getMazoCartas().getCardsSet().get(i-1).toString()).append(" ");
        }
        acum.append("</html>");
        mazoActual.setText(acum.toString());
    }
}
