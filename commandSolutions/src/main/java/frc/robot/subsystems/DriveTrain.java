// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  
  TalonFX leftBack;
  TalonFX rightBack;
  TalonFX leftFront;
  TalonFX rightFront;

  Pigeon2 pigeon;
  public DriveTrain() {
    leftBack = new TalonFX(0);
    rightBack = new TalonFX(1);
    leftFront = new TalonFX(2);
    rightFront= new TalonFX(3);
    

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
    pigeon = new Pigeon2(6);

  }



  public void drive(double x, double y){
    
    rightFront.set(ControlMode.PercentOutput, x);
    leftFront.set(ControlMode.PercentOutput, y);

  }

  public void resetGyro(){
    pigeon.setYaw(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
