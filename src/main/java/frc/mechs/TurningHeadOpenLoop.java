package frc.mechs;

import frc.robot.Mech;
import frc.config.Config;
import frc.robot.JeVois;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TurningHeadOpenLoop extends Mech {

    private final int encoderTicks = 4096 * 100; // ticks per rotaion * motor to encoder ratio
    private int encoderOffset;

    private TalonSRX rotateMotor;

    private double facePos;
    private JeVois camera;

    Double percentOutput;

    public TurningHeadOpenLoop(JeVois faceCam) {

        rotateMotor = new TalonSRX(Config.getInt("turning_head_motor"));
        camera = faceCam;

        // rotateMotor.configOpenloopRamp(1, 0); // ramp up so to not change velocity
        // too quikly

        rotateMotor.setNeutralMode(NeutralMode.Brake); // stop when power is dropped
        rotateMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0); // https://www.vexrobotics.com/217-5046.html

        findZero();
    }

    private void findZero() {
        encoderOffset = rotateMotor.getSelectedSensorPosition(0); // make the head face forward

        float limit = encoderTicks / 4; // TODO: find value (how far the head can turn in each direction)

        rotateMotor.configForwardSoftLimitThreshold(Math.round(limit - encoderOffset), 0);
        rotateMotor.configReverseSoftLimitThreshold(Math.round(-limit + encoderOffset), 0);
        rotateMotor.configForwardSoftLimitEnable(true, 0);
        rotateMotor.configReverseSoftLimitEnable(true, 0);
    }

    private void moveHead(Double targetPosition) {
        targetPosition -= 0.5; // make position bewteen -0.5 and 0.5
        percentOutput = targetPosition / 2; // between -25% and 25%

        rotateMotor.set(ControlMode.PercentOutput, percentOutput);
    }

    public void loop() throws InterruptedException {
        facePos = camera.getLastDouble();
        moveHead(facePos);
    }
}