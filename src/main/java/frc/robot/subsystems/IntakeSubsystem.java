/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX intake;
  private TalonSRXConfiguration intakeSettings;
  
  public IntakeSubsystem() {
    intake=new WPI_TalonSRX(Constants.INTAKE);
    intakeSettings=new TalonSRXConfiguration();
    intakeSettings.peakCurrentLimit= 3;
    intakeSettings.continuousCurrentLimit=3;
    intakeSettings.peakCurrentDuration=0;
    intake.configAllSettings(intakeSettings);
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void runIntake(double speed){
    intake.set(speed);
  }
}
