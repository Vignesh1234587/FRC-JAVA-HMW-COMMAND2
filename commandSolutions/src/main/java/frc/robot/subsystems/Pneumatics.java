// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
  Compressor compress;
  DoubleSolenoid ds;
  public Pneumatics() {
   compress = new Compressor(PneumaticsModuleType.CTREPCM);
    ds = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    compress.enableDigital();
  }
  
  public void compressorToggle(){
    if(compress.isEnabled()){
      compress.disable();
    } else {
      compress.enableDigital();
    }  
  }

  public void setForward(){

    ds.set(DoubleSolenoid.Value.kForward);
  }
  public void setReverse(){
    ds.set(DoubleSolenoid.Value.kReverse);
  }
  public void setOff(){
    ds.set(DoubleSolenoid.Value.kOff);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
