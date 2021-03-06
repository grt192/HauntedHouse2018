package frc.mechs;

import frc.robot.Mech;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;

public class Eye extends Mech {
    private Solenoid eye1;
    private Solenoid eye2;

    public Eye() {
        this.eye1 = new Solenoid(Config.getInt("eye_pneumatic_forward"));
        this.eye2 = new Solenoid(Config.getInt("eye_pneumatic_down"));
    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
        eye1.set(true);
        Thread.sleep(1000);
        double j = Math.random() * 5;
        for (int i = 0; i < j; i++) {
            eye2.set(true);
            Thread.sleep((long) ((Math.random() * 0.5 + 0.5) * 1000));
            eye2.set(false);
            Thread.sleep((long) ((Math.random() * 0.5 + 0.5) * 1000));
        }
        Thread.sleep(500);
        eye1.set(false);
        Thread.sleep((long) (Math.random() * 5000 + 5000));
    }
}