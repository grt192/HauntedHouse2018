package frc.mechs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.config.Config;
import frc.robot.Mech;

public class SadTurningHead extends Mech {

    private static final double TICK_LIMIT = 44000.0;
    private static final double MAX_SPEED = 0.5;
    private static final double MIN_SPEED = 0.1;

    private double direction;
    private TalonSRX motor;

    public SadTurningHead() {
        motor = new TalonSRX(Config.getInt("turning_head_motor"));

        motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        direction = 1.0;
    }

    @Override
    public void loop() throws InterruptedException {
        double pos = motor.getSelectedSensorPosition(0) / TICK_LIMIT;

        if (direction * pos > 1.0) {
            direction *= -1;
        }

        double speed = MAX_SPEED - (MAX_SPEED - MIN_SPEED) * Math.abs(pos);
        speed = Math.max(MIN_SPEED, speed); // just in case

        motor.set(ControlMode.PercentOutput, speed * direction);

        Thread.sleep(50);
    }

}