// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  TalonFX rightMotor;
  TalonFX leftMotor;

  PIDController intakeController;

  public Intake() {
   
    rightMotor = new TalonFX(Constants.IntakeMotor1);
    leftMotor = new TalonFX(Constants.IntakeMotor2);
    
    rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    leftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    intakeController = new PIDController(Constants.intakeGains[0], Constants.intakeGains[1], Constants.intakeGains[2]);
     
    leftMotor.setInverted(true);
    leftMotor.follow(rightMotor);
  }


  public void extend(){
     rightMotor.set(ControlMode.PercentOutput, intakeController.calculate(rightMotor.getSelectedSensorPosition(), 7200));


  }

  public void retract(){
      rightMotor.set(ControlMode.PercentOutput, intakeController.calculate(rightMotor.getSelectedSensorPosition(), 0));



  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
