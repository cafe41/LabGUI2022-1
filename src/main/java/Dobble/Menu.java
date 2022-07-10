package main.java.Dobble;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.game.Humano;
import main.java.Dobble.cardsSet.Dobble;
import main.java.Dobble.game.CPU;
import main.java.Dobble.game.DobbleGame;

import java.util.*;

public class Menu {
    int election;

    //Constructor
    public Menu(int election) {
        this.election = election;
    }

    //Getter
    public int getElection() {
        return election;
    }

    //Setter
    public void setElection(int election) {
        this.election = election;
    }

    //Otros métodos

    //menuPrincipal, método que muestra un menú al usuario y
    //llama a otros métodos para ejecutar el juego
    //DOM: void
    //REC: void
    public static void menuPrincipal() {
        //"Dobble.game" es el estado del juego, se irá pasando entre métodos
        DobbleGame game = new DobbleGame();
        menuPrincipal(game);
    }
    //Sobrecarga
    //DOM: DobbleGame
    //REC: void
    public static void menuPrincipal(DobbleGame game) {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "------------------------DOBBLE------------------------" + "\n" +
                "Bienvenido al juego Dobble seleccione una opción del menú para continuar:" +
                "\n" + "1.- Jugar al juego, requiere un mazo de cartas." +
                "\n" + "2.- Crear/Editar el mazo de cartas." +
                "\n" + "3.- Agregar/Eliminar un jugador." +
                "\n" + "4.- Visualizar estado del juego." +
                "\n" + "0.- Salir del juego.");//El usuario puede haber pausado el juego
        //"definimos el menú, sobre el cual se irán aplicando métodos
        Menu elecciones = new Menu(999);
            System.out.print("\nIngrese la opción que desea: ");
            elecciones.setElection(entradaEscaner.nextInt());
            if (elecciones.getElection() == 1) {//Jugar
                elecciones.menuJugar(game);
                menuPrincipal(game);
            }
            else if (elecciones.getElection() == 2) {
                elecciones.menuMazoDeCartas(game);
                menuPrincipal(game);
            }
            else if (elecciones.getElection() == 3) {
                elecciones.menuJugador(game);
                menuPrincipal(game);
            }
            else if (elecciones.getElection() == 4) {
                elecciones.menuEstado(game);
                menuPrincipal(game);
            }
            else if (elecciones.getElection() == 0) {
                System.out.print("\nHa elegido salir.");
            }
            else {System.out.print("\nNo ha ingresado una opción válida.");
                menuPrincipal(game);
            }
    }

    //menuJugar
    private void menuJugar(DobbleGame game) {
        System.out.print("\n" + "----------Menú Jugar----------" + "\n" +
                "Bienvenido al menú para jugar el juego." +
                "\n\n" + "Los jugadores son: " + game.getNombreJugadores() +
                "\n" + "El mazo de cartas es: ");
        if (game.getMazoCartas()==null){ System.out.println(game.getMazoCartas() +"\n");}
        else {System.out.println(game.getMazoCartas().getCardsSet() +"\n");}
        //
        if (game.getCantidadJugadores() == 0){
            if (game.getMazoCartas()!=null){
            optionDemoMode(game);
            }
            else {System.out.println("Necesita un mazo para jugar, volverá al menú anterior.");}
        }
        else if (game.getCantidadJugadores() == 1){
            optionSinglePlayer(game);
        }
        else if (game.getCantidadJugadores() > 1){
            optionMultiPlayer(game);
        }
        else {System.out.println("\nPor favor, consiga una cantidad válida de jugadores.\n");}
    }
    private void optionDemoMode(DobbleGame game){
        //Reiniciamos election
        election = 99;
        System.out.println("Seleccione el modo de juego:");
        //Esto llamará al modo de juego CPU vs. CPU
        Scanner entradaEscaner = new Scanner(System.in);
        while (election != 0){
            System.out.print("1.- CPU vs. CPU (No posee jugadores)" +
                    "\n" +   "0.- Volver" +
                    "\n\n" + "Ingrese la opción que desea: ");
            election = entradaEscaner.nextInt();
            if (election == 1) {
                //Agregamos 2 cpu para que jueguen entre sí.
                Dobble cartasAnteriores = new Dobble(game.getMazoCartas().getCardsSet()
                        , game.getMazoCartas()); //Instance del mazo para reiniciarlo luego
                CPU cpu1 = new CPU("CPU01",game.getJugadores());
                CPU cpu2 = new CPU("CPU02",game.getJugadores());
                game.getJugadores().add(cpu1);
                game.getJugadores().add(cpu2);
                //Llamamos al modo de juego
                game.modoDemo();
                game.setMazoCartas(cartasAnteriores); //Reiniciamos el mazo
                game.getJugadores().remove(0);
                game.getJugadores().remove(0);
                System.out.println("Fin de la partida.\n\n" +
                        "Seleccione un modo de juego si desea volver a jugar:");
            }
        }
    }
    private void optionSinglePlayer(DobbleGame game){
        // si jugadores.size() = 1:
            //Ofrecer modo vs. ia
                //Se agregará una IA a la lista de jugadores
                //El jugador irá juntando dos cartas con un tiempo límite de 15 seg
                //La IA irá juntando dos cartas cada 10 seg
                //Gana quien se demore menos (contadorTiempoTotal)
            //Ofrecer modo solo contrarreloj
                //Cada turno, el jugador tendrá 10 segundos para juntar dos cartas
                //Si queda 1 carta o menos, el jugador ganará
                //El jugador pierde si se acaban los 10 segundos.
        System.out.println("\nWIP. Solo funciona el modo \"Demo\", el cual es CPU vs CPU" +
                " y solo se ejecuta si no hay jugadores.\n" +
                "Por favor, borre los jugadores si desea probar el juego.");
    }
    private void optionMultiPlayer(DobbleGame game){
        //Si jugadoresHumanos > 1 & cpu = 0
            //Si jugadoresHumanos = 2
                //Ofrecer modo Competitivo (PvP)
                    //Se dividirá el mazo en 4, 2/4 quedarán en el "tablero" y 1/4 se dividirá en
                    //cada jugador, gana el primer jugador que vacíe su mano
        //Si jugadoresHumanos > 1
            //Ofrecer modo contrarreloj PvP
                //Cada jugador tendrá 10 segundos para completar su turno, ganará puntaje basándonos
                //en la cantidad de cartas que se "llevó" o en el tiempo total
                //Opcional: Descalificar un jugador en caso de que demore más de 10 seg.
            //Ofrecer modo multijugador vs. IA
                //Tendrán 15 segundos para completar su turno, deben juntar dos cartas
                //Las IA demorarán 10 segundos en juntar dos cartas (aleatorias)
                //Ganará quien junte más puntaje (puntaje = cartas X sumatoria(15 - turno))
        System.out.println("\nWIP. Solo funciona el modo \"Demo\", el cual es CPU vs CPU" +
                " y solo se ejecuta si no hay jugadores.\n" +
                "Por favor, borre los jugadores si desea probar el juego.");
    }

    //menuMazoDeCartas
    private void menuMazoDeCartas(DobbleGame game) {
        election = 99; //reiniciamos, en caso de que vengamos de un sub-menu y election = 0
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Menú Cartas----------" + "\n" +
                "Bienvenido al menú para gestionar el mazo de cartas. ");
        while (election != 0){
            System.out.println("Seleccione una opción del menú para continuar:");
            if (game.getMazoCartas() != null) {
                System.out.println(
                        "\n" + "1.- Crear mazo de cartas." +
                        "\n" + "2.- Agregar cartas al mazo. (En caso de que no posea el máximo de cartas)" +
                        "\n" + "3.- Quitar cartas del mazo. (En caso de que el mazo posea cartas)" +
                        "\n" + "4.- Verificar que el set de cartas sea válido." +
                        "\n" + "5.- Cartas que faltan en el set de cartas." +
                        "\n" + "0.- Volver.");
            }
            else {
                System.out.println("\n" + "1.- Crear mazo de cartas. (No posee uno)" +
                        "\n" + "0.- Volver.");
            }
            //Mostramos el mazo al usuario por pantalla
            if (game.getMazoCartas() == null){
                System.out.println("\nMazo de cartas actual: " + game.getMazoCartas()+ "\n");}
            else {System.out.println("\nMazo de cartas actual: " +
                    game.getMazoCartas().getCardsSet()+ "\n");}
            //Le pedimos ingresar una opción
            System.out.print("Ingrese la opción que desea: ");
            setElection(entradaEscaner.nextInt());
            if (election == 1 && game.getMazoCartas() == null) { //Crear mazo
                optionCrearMazo(game);
            }
            else if (game.getMazoCartas() != null) {
                if (election == 1) {
                    System.out.println("Ya posee un mazo de cartas, escoja otra opción.");
                }
                else if (election == 2 && (game.getMazoCartas().getCardsSet().size() <
                        game.getMazoCartas().getCantMaxCartas())) { //Agregar cartas al mazo
                    optionAgregarCartas(game);
                }
                else if (election == 2) { //En caso de que no se puedan agregar más
                    System.out.println("No es posible añadir más cartas al mazo");
                }
                else if (election == 3 && game.getMazoCartas().getCardsSet().size() != 0) {
                    //Quitar cartas al mazo
                    optionQuitarCartas(game);
                }
                else if (election == 3) { //En caso de que el largo de Dobble.cardsSet sea 0
                    System.out.println("No es posible quitar más cartas al mazo");
                }
                else if (election == 4) { //Verificar set de cartas
                    optionVerificarSet(game);
                }
                else if (election == 5) { //Cartas faltantes al set de cartas
                    optionCartasFaltantes(game);
                }
                else if (election == 0) {
                    System.out.print("\nHa elegido volver.");
                }
                else {System.out.println("\nNo ha ingresado una opción válida.\n");}
            }
            else if (election == 0) {
                System.out.print("\nHa elegido volver.");
            }
            else {System.out.print("\nNo ha ingresado una opción válida.\n");}
        }
    }
    //crearMazo
    private void optionCrearMazo(DobbleGame game){
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("-Bienvenido al programa para crear cartas-");

        System.out.print("\nIngrese el número de elementos por carta que desea: ");
        //Basándonos en el orden generamos el resto de atributos del Dobble.cardsSet
        int numE = entradaEscaner.nextInt(); //Número de elementos en una carta, entregado por usuario
        int orden = numE - 1;                //"Orden" del Dobble.cardsSet
        int maxC = (orden * orden) + numE;   //Número máximo de cartas a crear
        System.out.print("Ingrese el número de cartas que desea crear (Max. " + maxC +"): ");
        int cCartas = entradaEscaner.nextInt();
        System.out.println("\nEl número de cartas a crear es " + cCartas + " y tendrán " + numE + " elementos.");

        //Custom?
        System.out.print("\nDesea usted definir los elementos de las cartas? (si/no): ");
        String respuesta = entradaEscaner.next();
        boolean custom; //si = true, no = false
        custom = Objects.equals(respuesta, "si");
        //Definimos una lista con los elementos que tendrán las cartas
        int cantE = maxC + 1; //Número de elementos que debe tener la lista de elementos
        List<String> elementos = new ArrayList<>();
        //Si el usuario eligió usar elementos custom:
        if (custom) {//if true:
            System.out.println("Se requiere una cantidad de " + cantE + " elementos para crear las cartas" +
                    "\n" + "Escriba los elementos que desea agregar:");
            Scanner elemento = new Scanner(System.in);
            for (int i = 0; i < cantE; i++) {
                elementos.add(elemento.next());
            }
        }
        //Sino, llena la lista con números random
        else {
            Random numeroRandom = new Random();
            for (int i = 0; i < cantE;) {
                int numR = numeroRandom.nextInt(1000);
                if (!(elementos.contains(String.valueOf(numR)))){
                    elementos.add(String.valueOf(numR));
                    i++; //El i++ está acá, para que en caso de que salga un numero repetido no avance
                }
            }
        }
        //Imprimir lista
        System.out.println("\nLa lista con " + cantE + " elementos es:\n" + elementos + "\n");

        //Creamos un set de cartas con la cantidad máxima, luego lo recortamos según el número que pidió el usuario:
        Dobble setOriginal = new Dobble(elementos, numE, maxC);
        Dobble setCartas = new Dobble(setOriginal.recortarSet(cCartas),setOriginal);

        System.out.println("El Dobble creado es:" + setCartas);
        game.setMazoCartas(setCartas);
        game.setMazoIdeal(setOriginal);
    }
    //agregarCartas
    private void optionAgregarCartas(DobbleGame game){
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("-Bienvenido al programa para quitar cartas del mazo-\n");
        List<Card> cartasFaltantes = game.getMazoCartas().missingCards(
                game.getMazoIdeal());
        System.out.print("La lista de cartas disponibles para agregar es la siguiente: " +
                cartasFaltantes + "\n\n" + "Ingrese el índice de la carta que desea agregar" +
                "\n(Ej: [[0], [1] , [2], ...]): ");
        game.getMazoCartas().getCardsSet().add(cartasFaltantes.get(entradaEscaner.nextInt()));
    }
    //quitarCartas, método que quita cartas del mazo
    private void optionQuitarCartas(DobbleGame game){
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("-Bienvenido al programa para quitar cartas del mazo-\n");
        System.out.print("El mazo actual es: " + game.getMazoCartas().getCardsSet() +
                "\nElija qué carta quiere quitar del mazo con su índice" +
                "\n(Ej: [[0], [1] , [2], ...]): ");
        game.getMazoCartas().getCardsSet().remove(entradaEscaner.nextInt());
    }
    //verificarSet, verifica que el set de cartas sea válido
    private void optionVerificarSet(DobbleGame game){
        System.out.println("-Bienvenido al programa para verificar que el mazo es válido-\n");
        //Verificamos que el set de cartas sea válido
        if (game.getMazoCartas().dobbleValido()){
            System.out.println("El conjunto de cartas es válido\n");
        }
        else {System.out.println("El conjunto de cartas no es válido\n");}

    }
    //cartasFaltantes, ejecuta missingCards, quien muestra las cartas faltantes en el mazo
    private void optionCartasFaltantes(DobbleGame game){
        System.out.println("-Bienvenido al programa para ver qué cartas faltan en el mazo-\n");
        List<Card> cartasPerdidas = game.getMazoCartas().missingCards(
                game.getMazoIdeal());
                //Se le aplica un missingCards al mazo actual, en base al mazo ideal
        System.out.println("\nLas cartas que faltan son "+ cartasPerdidas.size() + ": " +
                cartasPerdidas + "\n");
    }

    //menuJugador
    private void menuJugador(DobbleGame game) {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Menú Jugadores----------" + "\n" +
                "Bienvenido al menú para agregar un jugador");
        while (election != 0){
            System.out.println("La lista de jugadores es " + game.getNombreJugadores() +
                    "\n\n" + "Seleccione una opción del menú para continuar:" +
                    "\n" + "1.- Agregar Jugador." +
                    "\n" + "2.- Eliminar Jugador." +
                    "\n" + "0.- Volver.");
            //Le pedimos ingresar una opción
            System.out.print("Ingrese la opción que desea: ");
            setElection(entradaEscaner.nextInt());
            if (election == 1) { //Agregar Jugador
                optionAgregarJugador(game);
            }
            else if (election == 2) { //Agregar Jugador
                optionEliminarJugador(game);
                election = 2; //En caso de que usemos "Volver" y election sea 0, no sale del menú.
            }
            else if (election == 0) {
                System.out.print("\nHa elegido volver.");
            }
            else {System.out.println("\nNo ha ingresado una opción válida.\n");}
        }
    }
    //optionAgregarJugador
    private void optionAgregarJugador(DobbleGame game){
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Agregar un jugador----------" + "\n" +
                "Bienvenido al menú para agregar un jugador.");
        System.out.println("Por favor, ingrese el nombre del jugador que desea agregar:");
        Humano jugadorNuevo = new Humano(entradaEscaner.next(),game.getJugadores());
        game.getJugadores().add(jugadorNuevo);
        if (game.getJugadores().contains(jugadorNuevo)){
            System.out.println("Se ha agregado al jugador " + jugadorNuevo.getUser() +
                    " a la lista de jugadores\n");
        }
    }
    //optionEliminarJugador
    private void optionEliminarJugador(DobbleGame game) {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Eliminar un jugador----------" + "\n" +
                "Bienvenido al menú para eliminar un jugador.");
        //Solo se ejecuta si la partida aún no ha iniciado (Dobble.game.modoDeJuego = null)
        if (game.getJugadores().size() == 0){
            System.out.println("\nNo hay jugadores para eliminar.\n");
        }
        else if (game.getModoDeJuego() != null){
            System.out.println("\nLa partida ya ha comenzado, no se pueden eliminar jugadores.\n");
        }
        else {
            while (election != 0) {
                System.out.println("Seleccione un jugador de las opciones para continuar:");
                for (int i = 0; i < game.getJugadores().size(); i++){
                    System.out.println((i+1) + ".- " + game.getJugadores().get(i).getUser() + ".");
                }
                System.out.println("0.- Cancelar.");
                //Le pedimos ingresar una opción
                System.out.print("\nIngrese la opción que desea: ");
                setElection(entradaEscaner.nextInt());
                if (election != 0 &&
                        election < game.getJugadores().size()+1) { //Imprime al jugador especificado
                    System.out.println("Se ha borrado el jugador " +
                            game.getJugadores().get(election-1).getUser() + ".\n");
                    game.getJugadores().remove(election-1);
                }

                else if (election == 0) {
                    System.out.println("\nHa cancelado la operación.\n");
                }
                else {System.out.println("\nNo ha ingresado una opción válida.\n");}
            }
        }
    }

    //menuEstado
    private void menuEstado(DobbleGame game) {
        election = 99; //reiniciamos, en caso de que vengamos de un sub-menu y election = 0
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Menú Estado----------" + "\n" +
                "Bienvenido al menú para revisar el estado del juego.");
        while (election != 0){
            System.out.println("Seleccione una opción del menú para continuar:" +
                    "\n" + "1.- Estado del mazo de cartas." +
                    "\n" + "2.- Estado de los jugadores." +
                    "\n" + "3.- Estado de la partida actual." +
                    "\n" + "0.- Volver.");
            //Le pedimos ingresar una opción
            System.out.print("Ingrese la opción que desea: ");
            setElection(entradaEscaner.nextInt());
            if (election == 1) { //Estado del mazo de cartas
                System.out.println("\n" + "----------Estado del mazo de Cartas----------" + "\n");
                    //Mostramos el mazo al usuario por pantalla
                    if (game.getMazoCartas() == null){
                        System.out.println("Mazo de cartas actual: " + game.getMazoCartas()+ "\n");
                    }
                    else {System.out.println("Mazo de cartas actual: " +
                            game.getMazoCartas().getCardsSet()+ "\n");
                    }
                }
            else if (election == 2) { //Estado de los jugadores
                optionEstadoJugadores(game);
                menuEstado(game);
            }
            else if (election == 3) { //Estado de la partida actual
                optionEstadoPartida(game);
            }
            else if (election == 0) {
                System.out.print("\nHa elegido volver.");
            }
            else {System.out.println("\nNo ha ingresado una opción válida.\n");}
        }
    }
    //optionEstadoJugadores
    private void optionEstadoJugadores(DobbleGame game){
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("\n" + "----------Estado de los jugadores----------" + "\n" +
                "Bienvenido al menú para revisar el estado de los jugadores.");
        while (election != 0) {
            System.out.println("Seleccione un jugador de las opciones para continuar:");
            for (int i = 0; i < game.getJugadores().size(); i++){
                System.out.println((i+1) + ".- " + game.getJugadores().get(i).getUser() + ".");
            }
            System.out.println("0.- Volver.");
            //Le pedimos ingresar una opción
            System.out.print("\nIngrese la opción que desea: ");
            setElection(entradaEscaner.nextInt());
            if (election != 0 &&
                    election < game.getJugadores().size()+1) { //Imprime al jugador especificado
                System.out.println("El jugador indicado es:\n" + game.getJugadores().get(election-1));
            }

            else if (election == 0) {
                System.out.print("\nHa elegido volver.");
            }
            else {System.out.println("\nNo ha ingresado una opción válida.\n");}
        }
    }
    //optionEstadoPartida
    private void optionEstadoPartida(DobbleGame game){
        System.out.println("\n" + "----------Estado de la Partida----------" + "\n");
        if(game.getJugadores().size() == 0){
            System.out.println("No hay jugadores.\n");
        }
        else if(game.getMazoCartas() == null){
            System.out.println("No hay un mazo de cartas.\n");
        }
        else if (game.getModoDeJuego() == null){
            System.out.println("La partida aún no ha empezado.\n");
        }
        else {
            System.out.println("En la partida:" +
                    "\nEs el turno de: " + game.getJugadores().get(game.getTurnoActual()) +
                    "Los puntajes son: " + game.getPuntajes() +
                    "\n" + game.vaGanando() + " va ganando con " + game.puntajeMayor() + " puntos." +
                    "\nEl modo de juego es: " + game.getModoDeJuego() + ".\n");
        }
    }
}
