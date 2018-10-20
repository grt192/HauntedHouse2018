package frc.mechs;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.config.*;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Mech;

public class RotisserieDora extends Mech {

    Solenoid mechSolenoid;
    // TalonSRX mechTalon = new TalonSRX();

    private RotisserieDora() {
        Config.start();
        mechSolenoid = new Solenoid(Config.getInt("rotisserie_dora"));
        // Config.defaultConfigTalon(mechTalon);
    }

    // Config.getInt("RotisserieDora");
    public void loop() throws InterruptedException {

        mechSolenoid.set(true);
        Thread.sleep(4000);
        mechSolenoid.set(false);
        // mechTalon.set(0.25);
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }

}