// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.testingdashboard.Command;
import frc.robot.testingdashboard.TDNumber;

public class Consume extends Command {
  Intake m_intake;

  TDNumber m_RPM;

  TDNumber m_IntakeSpeed;

  /** Creates a new Consume. */
  public Consume() {
    super(Intake.getInstance(), "Intake", "Consume");
    m_intake = Intake.getInstance();

    m_RPM = new TDNumber(m_intake, "Intake Speed (RPM)", "RPM");

    m_IntakeSpeed = new TDNumber(m_intake, "Intake Speed (Power)", "Speed", Constants.kIntakeSpeed);

    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_intake.setSpeeds(m_RPM.get());
    m_intake.spinIn(m_IntakeSpeed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // m_intake.setSpeeds(0);
    m_intake.spinStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
