package Dobble.cardsSet;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<String> carta;

    //Card tendrá 3 constructores, uno para cada "tipo" de carta (carta1, cartaN y cartaN2).
    //"Constructor"
    public Card(List<String> elementos, int n) { // n = orden, debe ser un número primo
        //Inicializamos variables
        List<String> carta1 = new ArrayList<>();
        //Ciclo para crear la carta1
        for (int i = 1; i <= n+1; i++) {
            carta1.add(elementos.get(i));
        }
        this.carta = carta1;
    }
    //"Constructor 2" Overload
    public Card(List<String> elementos, int n, int j) { // n = orden, debe ser un número primo
        //Inicializamos variables
        List<String> cartaN = new ArrayList<>();
        //Ciclo para crear una cartaN
        cartaN.add(elementos.get(1));
        for (int k=1; k<=n; k++) {
            cartaN.add(elementos.get(n * j + (k+1)));
        }
        this.carta = cartaN;
    }
    //"Constructor 3" Overload
    public Card(List<String> elementos, int n, int i, int j) { // n = orden, debe ser un número primo
        //Inicializamos variables
        List<String> cartaN2 = new ArrayList<>();
        //Ciclo para crear una cartaN
        cartaN2.add(elementos.get(i+1));
        for (int k=1; k<=n; k++) {
            cartaN2.add(elementos.get(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
        }
        this.carta = cartaN2;
    }

    //Getters
    public List<String> getCarta() {
        return carta;
    }
    public String getElemento(int n) {return carta.get(n);}

    @Override
    //Override de toString
    public String toString() {
        //Realmente esto solo imprime la carta
        return "" + carta;
    }

    @Override
    //Override de equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return getCarta() != null ? getCarta().equals(card.getCarta()) : card.getCarta() == null;
    }
}