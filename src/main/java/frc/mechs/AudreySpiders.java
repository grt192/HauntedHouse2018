package frc.mechs;

import frc.config.Config;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Mech;

public class AudreySpiders extends Mech {

    private TalonSRX motor1;

    // Need to test mech to figure out variables
    private int outputPercent;
    private long timeUp;
    private long timeDown;
    private long currentTime = System.currentTimeMillis();

    public AudreySpiders() {

        motor1 = new TalonSRX(Config.getInt("AudreySpiders"));
        motor1.setNeutralMode(NeutralMode.Brake);

    }

    public void spiderDown() {

        motor1.setInverted(false);
        motor1.set(ControlMode.PercentOutput, outputPercent);

    }

    public void spiderUp() {

        motor1.setInverted(true);
        motor1.set(ControlMode.PercentOutput, outputPercent);

    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay

        // Can use timeUp, timeDown, currentTime, and wait() to movie spider
        // Will make more complex once figuring out variables

        // while(System.currentTimeMillis() < timeDown){
        // spiderDown();
        // wait(2000);
        // }
        // while(System.currentTimeMillis() < timeUp){
        // spiderUp();
        // wait(2000);
        // }

    }
}