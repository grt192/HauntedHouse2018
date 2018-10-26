package frc.mechs;

import frc.config.Config;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Mech;

public class AudreySpiders extends Mech {

    // TalonSRX and limit switch created
    private TalonSRX motor1;
    private DigitalInput limitSwitch;

    // Need to test mech to figure out variables
    private double outputPercent = 0.2;
    private long timeUp;
    private long timeDown;
    private long currentTime = System.currentTimeMillis();

    private boolean prevSwitchValue;
    private double currentOutput;

    // Constructor
    public AudreySpiders() {

        // Set up TalonSRX
        motor1 = new TalonSRX(Config.getInt("audrey_spiders"));
        motor1.setNeutralMode(NeutralMode.Brake);
        motor1.setInverted(false);

        // Set up limit switch
        limitSwitch = new DigitalInput(9);
        currentOutput = outputPercent;
        prevSwitchValue = false;
    }

    // Methods to move motor clockwise(spiderDown) and counter-clockwise(spiderUp)
    public void spiderDown() {

        motor1.set(ControlMode.PercentOutput, outputPercent);

    }

    public void spiderUp() {

        motor1.set(ControlMode.PercentOutput, -outputPercent);

    }

    public void loop() throws InterruptedException {
        motor1.set(ControlMode.PercentOutput, currentOutput);
        boolean switchValue = !limitSwitch.get();
        if (switchValue && !prevSwitchValue) {
            currentOutput *= -1;
        }
        prevSwitchValue = switchValue;
        Thread.sleep(50);

    }
}