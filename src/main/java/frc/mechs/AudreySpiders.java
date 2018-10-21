package frc.mechs;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Mech;

public class AudreySpiders extends Mech {
    private int talon_ID = 15;
    private TalonSRX motor1 = new TalonSRX(talon_ID);

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay
        motor1.setInverted(false);

    }
}