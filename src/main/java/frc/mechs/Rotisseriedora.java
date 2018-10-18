package frc.mechs;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.config.*;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Mech;

public class RotisserieDora extends Mech {

    Solenoid mechSolenoid = new Solenoid(Config);
    TalonSRX mechTalon = new TalonSRX(2);

    public RotisserieDora() {
        // Config.getInt("RotisserieDora");

        Solenoid mechSolenoid;
        TalonSRX mechTalon;

        mechSolenoid.set(true);
        Thread.sleep(5000);
        mechSolenoid.set(false);
        mechTalon.set();

    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }
}