package view;

import java.awt.*;

public class CruiserView extends ShipView {

    public CruiserView(int x, int y) {
        super(x, y);
        setShipSize(4);
        setColor("#f7860c");
    }

    int x = this.panelPositionX;
    int y = this.panelPositionY;

    void paintShip(Graphics2D g2D) {

        g2D.setColor(Color.decode(this.getColor()));
        g2D.fillRect(x, y, 20 * this.getShipSize(), 20);

    }
}
