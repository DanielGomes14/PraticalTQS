package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoMain {

    private static final Logger logger = LogManager.getLogger(DemoMain.class);
    /**
     * demonstrates a client for ramdom euromillions bets
     */
    public static void main(String[] args) {

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.info("Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        logger.info("You played:");
        String format = thisWeek.format();
        logger.info(format);

        logger.info("Draw results:");
        format = draw.getDrawResults().format();
        logger.info(format);

        logger.info("Your score:");
        for (Dip dip : draw.findMatches(thisWeek)) {
            format = dip.format();
            logger.info(format);

        }
    }
}
