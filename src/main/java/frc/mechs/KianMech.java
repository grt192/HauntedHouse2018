package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.config.Config;
import frc.robot.Mech;

public class KianMech extends Mech {

    public Solenoid traySolenoid;

    public KianMech() {
        traySolenoid = new Solenoid(Config.getInt("barney_pneumatic"));

    }

    @Override
    public void loop() throws InterruptedException {
        traySolenoid.set(true);
        Thread.sleep(5000);
        traySolenoid.set(false);
        Thread.sleep(10000 + (int) (Math.random() * 15000));
    }
}