/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashSet;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.config.Config;
import frc.mechs.TurningHeadOpenLoop;

public class Robot extends IterativeRobot {

    private HashSet<Mech> mechs;
    private JeVois jevois;

    @Override
    public void robotInit() {
        Config.start();
        jevois = new JeVois(Port.kUSB1);
        jevois.start();
        mechs = new HashSet<>();
        mechs.add(new TurningHeadOpenLoop()); // No encoder | For encoder use TurningHeadClosedLoop
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
        for (Mech mech : mechs)
            mech.start();
    }

    @Override
    public void disabledInit() {
        for (Mech mech : mechs)
            mech.stop();
    }
}
