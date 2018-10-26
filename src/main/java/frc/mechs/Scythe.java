package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;
import frc.robot.Mech;

public class Scythe extends Mech {

    private Solenoid scytheMech;

    public Scythe() {
        scytheMech = new Solenoid(Config.getInt("scythe_pneumatics"));
    }

    public void loop() throws InterruptedException {
        scytheMech.set(true);
        Thread.sleep((long) (2000 + 3000 * Math.random()));
        scytheMech.set(false);
        Thread.sleep((long) (3000 + 3000 * Math.random()));
    }

}