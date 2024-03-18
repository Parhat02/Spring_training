package com.cydeo.looselyCoupled;


import com.cydeo.looselyCoupled.casefactory.Case;
import com.cydeo.looselyCoupled.monitorfactory.Monitor;
import com.cydeo.looselyCoupled.motherboardfactory.Motherboard;

public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt();
    }

}
