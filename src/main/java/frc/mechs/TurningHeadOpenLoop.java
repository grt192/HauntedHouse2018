package frc.mechs;

import frc.robot.Mech;
import frc.config.Config;
import frc.robot.JeVois;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TurningHeadOpenLoop extends Mech {

    private TalonSRX rotateMotor;
    private double facePos;
    private JeVois camera;
    Double percentOutput;

    public TurningHeadOpenLoop() {

        rotateMotor = new TalonSRX(Config.getInt("turning_head_motor"));
        camera = new JeVois();
        camera.start();

        // rotateMotor.configOpenloopRamp(1, 0); // ramp up so to not change velocity
        // too quikly

        rotateMotor.setNeutralMode(NeutralMode.Brake); // stop when power is dropped
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