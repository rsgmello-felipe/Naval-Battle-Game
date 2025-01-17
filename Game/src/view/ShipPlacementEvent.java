package view;

public class ShipPlacementEvent {

    private ShipView selectedShip;
    private int boardX;
    private int boardY;
    private boolean orientation;

    public ShipPlacementEvent(ShipView selectedShip, int boardX, int boardY, boolean orientation) {
        this.selectedShip = selectedShip;
        this.boardX = boardX;
        this.boardY = boardY;
        this.orientation = orientation;
    }

    public ShipView getSelectedShip() {
        return selectedShip;
    }

    public int getBoardX() {
        return boardX;
    }

    public int getBoardY() {
        return boardY;
    }

    public boolean isOrientation() {
        return orientation;
    }

}
