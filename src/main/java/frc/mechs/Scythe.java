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
        Thread.sleep(2000);
        scytheMech.set(false);
        Thread.sleep(2000);
    }

}