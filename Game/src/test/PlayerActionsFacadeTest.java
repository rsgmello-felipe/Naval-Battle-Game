package test;

import static org.junit.Assert.*;
import org.junit.Test;
import model.PlayerActionsFacade;
import model.Player;
import model.ShipType;
import model.GameBoard;

public class PlayerActionsFacadeTest {

    @Test
    public void testPositionShip() {
    	String name = "TEST";
        int playerOrderId = 0;
        PlayerActionsFacade facade = PlayerActionsFacade.getInstance();
        Player player = new Player(name, playerOrderId); // Supondo que a classe Player tenha um construtor padrão

        // Testando com uma posição válida
        assertTrue(facade.PositionShip(player, 0, 0, ShipType.BATTLESHIP, true));

        // Testando com uma posição inválida
        assertFalse(facade.PositionShip(null, 0, 0, ShipType.BATTLESHIP, true));
    }

    @Test
    public void testAttack() {
    	String name = "TEST";
        int playerOrderId = 0;
        PlayerActionsFacade facade = PlayerActionsFacade.getInstance();
        Player playerAttacking = new Player(name, playerOrderId); // Supondo que a classe Player tenha um construtor padrão
        Player playerDefending = new Player(name, playerOrderId); // Supondo que a classe Player tenha um construtor padrão

        // Testando com jogadores válidos e coordenadas válidas
        assertTrue(facade.Attack(playerAttacking, playerDefending, 0, 0));

        // Testando com jogador atacante inválido
        assertFalse(facade.Attack(null, playerDefending, 0, 0));

        // Testando com jogador defensor inválido
        assertFalse(facade.Attack(playerAttacking, null, 0, 0));
    }

    @Test
    public void testValidateAttack() {
    	String name = "TEST";
        int playerOrderId = 0;
        PlayerActionsFacade facade = PlayerActionsFacade.getInstance();
        Player playerAttacking = new Player(name, playerOrderId); // Supondo que a classe Player tenha um construtor padrão

        // Testando com uma posição válida
        assertTrue(facade.ValidateAttack(playerAttacking, 0, 0));

        // Testando com uma posição já atacada
        GameBoard attackMap = playerAttacking.GetTabuleiroAtaques();
        attackMap.shotAttack(0, 0, true); // Marcando a posição como atacada
        assertFalse(facade.ValidateAttack(playerAttacking, 0, 0));
    }
}
