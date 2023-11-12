// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  
  TalonFX leftBack;
  TalonFX rightBack;
  TalonFX leftFront;
  TalonFX rightFront;
  PIDController driveController;

  Pigeon2 pigeon;
  public DriveTrain() {
    leftBack = new TalonFX(Constants.LEFT_BACK_PORT);
    rightBack = new TalonFX(Constants.RIGHT_BACK_PORT);
    leftFront = new TalonFX(Constants.LEFT_FRONT_PORT);
    rightFront= new TalonFX(Constants.RIGHT_FRONT_PORT);
    driveController = new PIDController(1000, 1000, 1000);



  }



  public void drive(double x, double y){
    
    rightFront.set(ControlMode.PercentOutput, driveController.calculate(0, x));
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
