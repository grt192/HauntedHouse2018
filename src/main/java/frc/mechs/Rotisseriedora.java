package frc.mechs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import frc.config.Config;
import frc.robot.Mech;

public class RotisserieDora extends Mech {

    private Solenoid mechSolenoid;
    private TalonSRX mechTalon;

    public RotisserieDora() {
        mechSolenoid = new Solenoid(Config.getInt("rotisserie_dora"));
        mechTalon = new TalonSRX(Config.getInt("rotisserie_dora_talon"));
        Config.defaultConfigTalon(mechTalon);
    }

    public void loop() throws InterruptedException {

        mechSolenoid.set(true);
        Thread.sleep(2000);
        mechTalon.set(ControlMode.PercentOutput, 0.25);
        Thread.sleep(5000);
        mechTalon.set(ControlMode.PercentOutput, 0.0);
        Thread.sleep(1000);
        mechSolenoid.set(false);
        Thread.sleep((long) (5000 + Math.random() * 5000));
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
    }

}