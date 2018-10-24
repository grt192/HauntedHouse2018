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
    private int outputPercent;
    private long timeUp;
    private long timeDown;
    private long currentTime = System.currentTimeMillis();

    // Constructor
    public AudreySpiders() {

        // Set up TalonSRX
        motor1 = new TalonSRX(Config.getInt("audrey_spiders"));
        motor1.setNeutralMode(NeutralMode.Brake);
        motor1.setInverted(false);

        // Set up limit switch
        limitSwitch = new DigitalInput(9);

    }

    // Methods to move motor clockwise(spiderDown) and counter-clockwise(spiderUp)
    public void spiderDown() {

        motor1.set(ControlMode.PercentOutput, outputPercent);

    }

    public void spiderUp() {

        motor1.set(ControlMode.PercentOutput, -outputPercent);

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

        // Can also use limit switches to determine when to do spiderUp and spiderDown

        if (limitSwitch.get() == true) {
            spiderDown();
        } else {
            spiderUp();
        }

    }
}