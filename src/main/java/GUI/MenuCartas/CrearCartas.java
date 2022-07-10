package main.java.GUI.MenuCartas;

import main.java.Dobble.cardsSet.Dobble;
import main.java.Dobble.game.DobbleGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class CrearCartas extends JFrame{
    private JButton generarMazoButton;
    private JPanel panelCrearCarta;
    private JTextField numeroElementos;
    private JTextField cantidadCartas;
    private JTextField elementos;
    private JCheckBox randomButton;
    private JLabel maxCText;
    private JLabel numEText;
    private JLabel elementsText;
    private JLabel randomText;
    private JLabel separador;

    public static DobbleGame game;

    public CrearCartas(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panelCrearCarta);
        this.pack();

        AgregarCartas.game = game;
        generarMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numE = Integer.parseInt(numeroElementos.getText());
                int n = (numE -1);
                int maxC = Integer.parseInt(cantidadCartas.getText());

                List<String> listaElementos = new ArrayList<>();

                if (maxC == -1){
                    maxC = (n*n) + numE;
                }

                if (randomButton.isSelected()) {
                    int cantE = (numE -1)*(numE -1) + (numE -1) + 1 + 1; //+1 porque no cuenta el 0
                    Random numeroRandom = new Random();
                    for (int i = 0; i < cantE;) {
                        int numR = numeroRandom.nextInt(1000);
                        if (!(listaElementos.contains(String.valueOf(numR)))){
                            listaElementos.add(String.valueOf(numR));
                            i++; //El i++ está acá, para que en caso de que salga un numero repetido no avance
                        }
                    }
                }
                else {
                    String elements = elementos.getText();
                    String[] elementsSplit = elements.split(" ");
                    //Pasamos de String[] a ArrayList<String>
                    listaElementos.addAll(Arrays.asList(elementsSplit));
                }

                int maxCartas = (numE -1)*(numE -1) + (numE -1) + 1;
                Dobble setOriginal = new Dobble(listaElementos, numE, maxCartas);
                game.setMazoIdeal(setOriginal);

                Dobble setCartas = new Dobble(setOriginal.recortarSet(maxC),setOriginal);
                game.setMazoCartas(setCartas);

                dispose();
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elementos.isVisible()) {
                    elementsText.setVisible(false);
                    elementos.setVisible(false);
                }
                else {
                    elementsText.setVisible(true);
                    elementos.setVisible(true);
                }
            }
        });
    }
}
