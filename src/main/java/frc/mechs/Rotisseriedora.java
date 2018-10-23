package frc.mechs;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.config.*;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Mech;

public class RotisserieDora extends Mech {

    Solenoid mechSolenoid;
    TalonSRX mechTalon;

    public RotisserieDora() {
        Config.start();
        mechSolenoid = new Solenoid(Config.getInt("rotisserie_dora"));
        mechTalon = new TalonSRX(Config.getInt("rotisserie_dora"));
        Config.defaultConfigTalon(mechTalon);
    }

    public void loop() throws InterruptedException {

        mechSolenoid.set(true);
        Thread.sleep(4000);
        mechSolenoid.set(false);
        mechTalon.set(ControlMode.PercentOutput, 0.25);
        Thread.sleep(3000);
        mechTalon.set(ControlMode.PercentOutput, 0.0);
        mechSolenoid.set(true);
        Thread.sleep(4000);
        mechSolenoid.set(false);
        Thread.sleep(3000);
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }

}