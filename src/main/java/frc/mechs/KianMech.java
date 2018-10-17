package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.config.Config;
import frc.robot.Mech;

public class KianMech extends Mech {

    public Solenoid traySolenoid;

    public Timer timer;

    public KianMech() {
        traySolenoid = new Solenoid(Config.getInt("barneyPneumatic"));

    }

    @Override
    public void loop() throws InterruptedException {
        if (timer.get() % 2.00 >= 1) {
            traySolenoid.set(true);
        } else {
            traySolenoid.set(false);
        }

        System.out.println("Make CAD a subgroup");
        System.out.println("DT better than controls");
    }
}