package frc.mechs;

import frc.robot.Mech;
import frc.config.Config;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TurningHeadClosedLoop extends Mech {

    private final int encoderTicks = 4096; // I think - its based off encoder
    private int encoderOffset;
    private TalonSRX rotateMotor;

    public TurningHeadClosedLoop() {

        rotateMotor = new TalonSRX(Config.getInt("turning_head_motor"));

        // rotateMotor.configClosedloopRamp(1, 0); // ramp up so to not change velocity
        // too quikly
        // Done with PID control

        rotateMotor.setNeutralMode(NeutralMode.Brake); // stop when power is dropped

        rotateMotor.config_kP(0, 3.0, 30); // https://sites.google.com/site/fpgaandco/pid
        rotateMotor.config_kI(0, 0.8, 30);
        rotateMotor.config_kD(0, 0.9, 30);

        rotateMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30); // not sure what type of encoder,
                                                                                     // if any
        // FeedbackDevice.Analog

        findZero();

    }

    public void findZero() {
        encoderOffset = rotateMotor.getSelectedSensorPosition(0); // make the head face forward

        int limit = encoderTicks / 4; // TODO: find value (how far the head can turn in each direction)

        rotateMotor.configForwardSoftLimitThreshold(limit - encoderOffset, 0);
        rotateMotor.configReverseSoftLimitThreshold(-limit + encoderOffset, 0);
        rotateMotor.configForwardSoftLimitEnable(true, 0);
        rotateMotor.configReverseSoftLimitEnable(true, 0);
    }

    private void moveHead(int targetPosition) {

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