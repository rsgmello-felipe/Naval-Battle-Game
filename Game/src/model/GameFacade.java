package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import controller.Controller;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GameFacade {
    private static GameFacade instance;
    private List<Player> jogadores = new ArrayList<Player>();

    public static synchronized GameFacade getInstance() {
        if (instance == null) {
            instance = new GameFacade();
        }
        return instance;
    }

    public void startGame(String player1, String player2) {
        // Criar os jogadores
        Player jogador1 = new Player(player1, 0);
        Player jogador2 = new Player(player2, 1);

        jogadores.add(jogador1);
        jogadores.add(jogador2);
    }

    @SuppressWarnings("deprecation")
    public void restartGame(Controller controller) {

        Player jogador_novo1 = new Player(jogadores.get(0).getName(), 0);
        Player jogador_novo2 = new Player(jogadores.get(1).getName(), 1);

        for (Player player : jogadores) {
            player.deleteObserver(controller);
            player.GetTabuleiroNavios().deleteObserver(controller);
            player.GetTabuleiroAtaques().deleteObserver(controller);
        }

        jogadores.clear();
        jogadores.add(jogador_novo1);
        jogadores.add(jogador_novo2);

        // Observe the game boards of the players
        for (Player player : jogadores) {
            player.addObserver(controller);
            player.GetTabuleiroNavios().addObserver(controller);
            player.GetTabuleiroAtaques().addObserver(controller);
        }
    }

    public boolean endGame(List<Player> players) {
        if (players.stream().anyMatch(x -> x.GetTotalShipsLeft() == 0)) {
            return true;
        }
        return false;
    }

    public void saveGame(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(jogadores.get(0));
            oos.writeObject(jogadores.get(1));

            System.out.println("Game saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    public void loadGame(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Player player1 = (Player) ois.readObject();
            Player player2 = (Player) ois.readObject();

            jogadores.set(0, player1);
            jogadores.set(1, player2);

            System.out.println("Game loaded successfully from " + filePath);
        } catch (IOException e) {
            System.err.println("Error loading game: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error finding class during game load: " + e.getMessage());
        }
    }

    public List<Player> getJogadores() {

        return this.jogadores;
    }

}
