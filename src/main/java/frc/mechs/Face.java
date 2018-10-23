package frc.mechs;

import frc.robot.Mech;
import frc.config.*;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Mech;

public class Face extends Mech {

    Solenoid mechSolenoid;
    int handDelay;

    private Face() {
        Config.start();
        mechSolenoid = new Solenoid(Config.getInt("face"));
        // read delay from the config
        handDelay = Config.getInt("face.delay");
    }

    public void loop() throws InterruptedException {
        // starting hand
        mechSolenoid.set(true);
        // wait for delay time
        Thread.sleep(handDelay);
        // hand goes back
        mechSolenoid.set(false);
        // wait for delay time
        Thread.sleep(handDelay);

        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }
}