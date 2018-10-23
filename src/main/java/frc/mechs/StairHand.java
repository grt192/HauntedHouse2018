package frc.mechs;

import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;

import frc.config.Config;

public class StairHand extends Mech {

    private Solenoid stair;
    private Solenoid hand;

    public StairHand () {
        stair = new Solenoid(Config.getInt("stair"));
        hand = new Solenoid(Config.getInt("hand"));
    }

    public void loop() throws InterruptedException {
        // 1. Stair opens (1 sec)
        stair.set(true);
        Thread.sleep(1000);
        
        // 2. Hand extends (2 sec)
        hand.set(true);
        Thread.sleep(2000);
        
        // 3. Pause (3 sec)
        Thread.sleep(3000);
        
        // 4. Hand retracts (2 sec)
        hand.set(false);
        Thread.sleep(1000);
        
        // 5. Stair closes (1 sec)
        stair.set(false);
                
        // 6. Restart in a random amount of 
        // time btwn 20 and 40 seconds
        Thread.sleep(Math.random * 2000 + 2000);
    }
}