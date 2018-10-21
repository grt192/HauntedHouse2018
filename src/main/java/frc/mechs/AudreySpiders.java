package frc.mechs;

import frc.config.Config;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Mech;

public class AudreySpiders extends Mech {

    private TalonSRX motor1;

    public AudreySpiders() {
        motor1 = new TalonSRX(Config.getInt("AudreySpiders"));
        Config.start();
        motor1.setInverted(true);
        Config.defaultConfigTalon(motor1);
    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay

    }
}