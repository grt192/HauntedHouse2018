package frc.mechs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.config.Config;
import frc.robot.Mech;

public class SadTurningHead extends Mech {

    private static final double TICK_LIMIT = 44000.0;
    private static final double SPEED = 0.1;

    private double destination;
    private double direction;
    private TalonSRX motor;

    public SadTurningHead() {
        motor = new TalonSRX(Config.getInt("turning_head_motor"));

        motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        direction = 1.0;
    }

    @Override
    public void loop() throws InterruptedException {
        int pos = motor.getSelectedSensorPosition(0);
        if (Math.signum(pos - destination) == Math.signum(direction)) {
            motor.set(ControlMode.PercentOutput, 0);
            Thread.sleep((long) ((Math.random() * 2000) + 1000));
            findNewDestination();
        }
        motor.set(ControlMode.PercentOutput, SPEED * direction);

        Thread.sleep(50);
    }

    private void findNewDestination() {
        destination = Math.random() * 2 * TICK_LIMIT - TICK_LIMIT;
        direction = Math.signum(destination - motor.getSelectedSensorPosition(0));
    }

}