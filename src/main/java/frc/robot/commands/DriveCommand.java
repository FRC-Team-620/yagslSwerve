package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveDrive;

public class DriveCommand extends Command {
    private final SwerveSubsystem swerve;
    private final DoubleSupplier vX, vY, vA;

    //supplier: controller:getLeftX, controller:getLeftY
    public DriveCommand(SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier vA){
        this.swerve = swerve;
        this.vX = vX;
        this.vY = vY;
        this.vA = vA;

        addRequirements(swerve);
    }    

    @Override
    public void execute() {
        ChassisSpeeds speeds = swerve.getTargetSpeeds(vX.getAsDouble(), vY.getAsDouble(), vA.getAsDouble());
        swerve.drive(speeds);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

}
