package frc.mechs;

import frc.robot.Mech;
import frc.config.Config;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TurningHead extends Mech {

    private final int encoderTicks = 1024; // I think - its based off encoder
    private int encoderOffset;
    private TalonSRX rotateMotor;

    public TurningHead() {

        rotateMotor = new TalonSRX(Config.getInt("turning_head_motor"));

        rotateMotor.configClosedloopRamp(1, 0); // ramp up so to not change velocity too quikly

        rotateMotor.setNeutralMode(NeutralMode.Brake); // stop when power is dropped

        int limit = encoderTicks / 2; // find value (how far the head can turn in each direction)

        rotateMotor.configForwardSoftLimitThreshold(limit, 0);
        rotateMotor.configReverseSoftLimitThreshold(-limit, 0);
        rotateMotor.configForwardSoftLimitEnable(true, 0);
        rotateMotor.configReverseSoftLimitEnable(true, 0);

        rotateMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0); // not sure what type of encoder, if any
                                                                               // stolen off grt's wheel source
                                                                               // FeedbackDevice.QuadEncoder

        findZero();

    }

    public void findZero() {
        encoderOffset = rotateMotor.getSelectedSensorPosition(0); // find the offset of the encoder (make the head face
        // forward)
    }

    private void moveHead(double targetPosition) {

        double encoderPos = targetPosition * encoderTicks + encoderOffset; // posion is mesured in encoder ticks

        rotateMotor.set(ControlMode.Position, encoderPos);
    }

    public void loop() throws InterruptedException {
        // - move to closest detected face (put on a timer, so its not snaping around to
        // different faces????)

        // We can also intermitantly do some fancy animations with the head (make it
        // skake, do a 360, etc.)????
    }
}