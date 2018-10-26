package frc.mechs;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;
import frc.robot.Mech;

public class HaveANiceDay extends Mech {

    private Solenoid mechSolenoid;

    public HaveANiceDay() {
        mechSolenoid = new Solenoid(Config.getInt("have_a_nice_day"));
    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay

        Thread.sleep((long) (3000 + 2000 * Math.random()));
        mechSolenoid.set(false);

        Thread.sleep((long) (5000 + 5000 * Math.random()));
        mechSolenoid.set(true);
    }
}