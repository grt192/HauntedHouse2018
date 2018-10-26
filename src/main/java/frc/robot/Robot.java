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
import frc.mechs.AudreySpiders;
import frc.mechs.Eye;
import frc.mechs.Face;
import frc.mechs.HaveANiceDay;
import frc.mechs.KianMech;
import frc.mechs.RotisserieDora;
import frc.mechs.Scythe;
import frc.mechs.StairHand;
import frc.mechs.TurningHeadOpenLoop;

public class Robot extends IterativeRobot {

    private HashSet<Mech> mechs;
    private JeVois jevois;

    @Override
    public void robotInit() {
        Config.start();
        jevois = new JeVois(Port.kUSB);
        jevois.start();
        mechs = new HashSet<>();
        mechs.add(new AudreySpiders());
        // mechs.add(new RotisserieDora());
        // mechs.add(new Face()); Is connected to scythe
        mechs.add(new HaveANiceDay());
        mechs.add(new StairHand());
        mechs.add(new KianMech());
        // mechs.add(new TurningHeadOpenLoop(jevois)); // No encoder | For encoder use
        // TurningHeadClosedLoop
        mechs.add(new Eye());
        mechs.add(new Scythe());
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
        jevois.enable();
        for (Mech mech : mechs)
            mech.start();
    }

    @Override
    public void disabledInit() {
        for (Mech mech : mechs)
            mech.stop();
    }
}
