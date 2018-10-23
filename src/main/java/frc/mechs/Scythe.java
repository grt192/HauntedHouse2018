package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;
import frc.robot.Mech;

public class Scythe extends Mech {

    private Solenoid scytheMech;

    public Scythe() {
        scytheMech = new Solenoid(Config.getInt("scythePneumatics"));
    }

    public void loop() throws InterruptedException {
        scytheMech.set(true);
        Thread.sleep((long) (1000 + 3000 * Math.random()));
        scytheMech.set(false);
        Thread.sleep((long) (1000 + 3000 * Math.random()));
    }

}