package com.cydeo.stereotype_annotation;

import com.cydeo.stereotype_annotation.casefactory.Case;
import com.cydeo.stereotype_annotation.monitorfactory.Monitor;
import com.cydeo.stereotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {

    //@Autowired
    private Case theCase;
    //@Autowired
    private Monitor monitor;
    //@Autowired
    private Motherboard motherboard;

    //@Autowired
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
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
