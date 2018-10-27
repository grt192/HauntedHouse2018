package frc.mechs;

import frc.robot.Mech;
import frc.config.Config;
import frc.robot.JeVois;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TurningHeadOpenLoop extends Mech {

    private static final int encoderTicks = 4096 * 100; // ticks per rotaion * motor to encoder ratio
    private static final double SCALE = 0.5;
    private static final double MIN_AGE = 100.0;
    private static final double MAX_AGE = 500.0;

    private TalonSRX rotateMotor;

    private JeVois camera;

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
        int limit = encoderTicks / 4; // TODO: find value (how far the head can turn in each direction)

        rotateMotor.configForwardSoftLimitThreshold(limit, 0);
        rotateMotor.configReverseSoftLimitThreshold(-limit, 0);
        rotateMotor.configForwardSoftLimitEnable(true, 0);
        rotateMotor.configReverseSoftLimitEnable(true, 0);
    }

    public void loop() throws InterruptedException {
        double facePos = camera.getLastDouble();
        long age = System.currentTimeMillis() - camera.getTimestamp();
        double delta = facePos - 0.5; // make position bewteen -0.5 and 0.5
        double distance = Math.abs(delta);
        double scale = SCALE * clamp(1 - ((age - MIN_AGE) / (MAX_AGE - MIN_AGE)));
        double percentOutput = distance * scale * Math.signum(delta);

        rotateMotor.set(ControlMode.PercentOutput, percentOutput);
        Thread.sleep(20);
    }

    private static double clamp(double x) {
        return Math.min(Math.max(x, 0), 1);
    }
}