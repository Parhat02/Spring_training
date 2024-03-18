package com.cydeo.looselyCoupled;

import com.cydeo.looselyCoupled.casefactory.Case;
import com.cydeo.looselyCoupled.casefactory.DellCase;
import com.cydeo.looselyCoupled.monitorfactory.AcerMonitor;
import com.cydeo.looselyCoupled.monitorfactory.Monitor;
import com.cydeo.looselyCoupled.motherboardfactory.AsusMotherboard;
import com.cydeo.looselyCoupled.motherboardfactory.Motherboard;

public class Main {

    public static void main(String[] args) {

        Monitor theMonitor = new AcerMonitor("27inch Beast", "Acer", 27);
        Case theCase = new DellCase("220B", "Dell", "240");
        Motherboard theMotherboard = new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC myPc = new PC(theCase,theMonitor,theMotherboard);

        myPc.powerUp();

    }
}
