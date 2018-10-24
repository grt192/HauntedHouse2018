package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;
import frc.robot.Mech;

public class Face extends Mech {

    Solenoid mechSolenoid;
    int handDelay;

    public Face() {
        mechSolenoid = new Solenoid(Config.getInt("face"));
        // read delay from the config
        handDelay = 3000;
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