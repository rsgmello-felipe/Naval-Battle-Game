package view;

import java.util.List;

import javax.swing.JButton;

public class ViewActionsFacade {
    private static ViewActionsFacade instance;

    public static synchronized ViewActionsFacade getInstance() {
        if (instance == null) {
            instance = new ViewActionsFacade();
        }
        return instance;
    }

    public boolean placeShip(BoardPanel board, int x, int y, boolean orientation) {

        if (board == null) {
            return false;
        }

        board.placeShip(x, y, orientation);
        return true;
    }

    public List<ShipView> getBoardShips(BoardPanel board) {
        return board.getShipsList();
    }

    public int getShipSize(ShipView ship) {
        return ship.getShipSize();
    }

    public int getCurrentPositionX(BoardPanel board) {
        return board.getCurrentPositionX();
    }

    public int getCurrentPositionY(BoardPanel board) {
        return board.getCurrentPositionY();
    }

    public void setVisibleNextPlayerButton(PositionPanel panel) {
        JButton next = panel.getNextPlayerButton();
        next.setVisible(true);
    }

    public void setVisibleStartGameButton(PositionPanel panel) {
        JButton next = panel.getStartGameButton();
        next.setVisible(true);
    }

    public BoardPanel getCurrentAttackerBoard(AttackPanel attackPanel, int index) {

        return attackPanel.getAttackBoards().get(index);
    }

    public void firstShotHit(BoardPanel attackBoard, int boardX, int boardY, int size) {

        attackBoard.firstShotHit(boardX, boardY, size);
    }

    public void shotHitAgain(BoardPanel attackBoard, int boardX, int boardY, int previousHitCoordX,
            int previousHitCoordY, boolean sunk) {

        attackBoard.shotHitAgain(boardX, boardY, previousHitCoordX, previousHitCoordY, sunk);
    }

    public void shotWater(BoardPanel attackBoard, int boardX, int boardY) {

        attackBoard.shotWater(boardX, boardY);

    }

    public void setVisibleNextPlayerButton(AttackPanel attackPanel, String name) {
        JButton next = attackPanel.getNextPlayerButton();
        next.setText(name + "'s turn");
        next.setVisible(true);
    }

}
