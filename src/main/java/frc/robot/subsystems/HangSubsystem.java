/**
 * Coded by Seth White
 * Credit to WPI and ctre for their FIRST oriented objects.
 */

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class HangSubsystem extends SubsystemBase {
  public WPI_TalonFX hanger;
  public int startpoint;
  private SupplyCurrentLimitConfiguration up,down;
  private TalonFXConfiguration conf;
  public HangSubsystem() {
    hanger=new WPI_TalonFX(Constants.HANGER);
    
    conf=new TalonFXConfiguration();
    hanger.configAllSettings(conf);
    
    up=new SupplyCurrentLimitConfiguration(true, 3, 1, 1);
    down=new SupplyCurrentLimitConfiguration(true, 3, 3, 0);
    hanger.configGetSupplyCurrentLimit(up);
    startpoint=hanger.getSelectedSensorPosition();
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void periodic(){
    SmartDashboard.putNumber("hangencoder", hanger.getSelectedSensorPosition());
    //SmartDashboard.put("underrunerror", hanger.clearMotionProfileHasUnderrun());
  }
  public void reach(){
    hanger.configGetSupplyCurrentLimit(up);
    hanger.set(0.5);
  }
  public void stop(){
    hanger.set(0);
  }
  public void pull(){
    hanger.configGetSupplyCurrentLimit(down);
    hanger.set(-.5);
  }
  
}
