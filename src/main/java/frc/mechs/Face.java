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
        handDelay = Config.getInt("face.delay");
    }

    public void loop() throws InterruptedException {
        mechSolenoid.set(true);
        Thread.sleep(handDelay);
        mechSolenoid.set(false);
        Thread.sleep(handDelay);

        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }
}