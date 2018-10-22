package frc.mechs;

import frc.config.Config;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Mech;

public class AudreySpiders extends Mech {

    private TalonSRX motor1;

    // Need to test mech to figure out variables
    // currentAmount must be greater than 5 amps
    private int currentAmount;
    private int currentPeak;
    private int peakDuration;
    private int timeUp;
    private int timeDown;

    public AudreySpiders() {

        motor1 = new TalonSRX(Config.getInt("AudreySpiders"));
        Config.start();
        motor1.setNeutralMode(NeutralMode.Brake);
        motor1.enableCurrentLimit(true);
    }

    public void spiderDown() {

        peakDuration = 50;

        motor1.setInverted(false);
        motor1.configContinuousCurrentLimit(currentAmount, 0);
        motor1.configPeakCurrentLimit(currentPeak, 0);
        motor1.configPeakCurrentDuration(peakDuration, 0);
    }

    public void spiderUp() {

        peakDuration = 50;

        motor1.setInverted(true);
        motor1.configContinuousCurrentLimit(currentAmount, 0);
        motor1.configPeakCurrentLimit(currentPeak, 0);
        motor1.configPeakCurrentDuration(peakDuration, 0);
    }

    public void loop() throws InterruptedException {
        // code here is repeated continuously while the haunted house is enabled
        // there is no built-in delay

        // can use timeUp, timeDown, and wait() to movie spider

    }
}