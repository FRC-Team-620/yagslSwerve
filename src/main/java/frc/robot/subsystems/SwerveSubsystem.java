package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import swervelib.SwerveController;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveDriveConfiguration;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class SwerveSubsystem extends SubsystemBase{
    //Encoder resolution: 42
    //gear ratio: 4.71
    //Diameter: 3 in
    private SwerveDrive swerve;

    public SwerveSubsystem (File directory){

        SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
        
        try {
            swerve = new SwerveParser(directory).createSwerveDrive(Constants.MAX_SPEED_MPS);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //add alertAPI
        }

    }

    public void drive(ChassisSpeeds velocity){
        swerve.drive(velocity);
    }

    public void drive(Translation2d translation, double rotation, boolean fieldRelative){
        swerve.drive(translation, rotation, fieldRelative, false);
    }

    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        swerve.updateOdometry();
    }

    public ChassisSpeeds getTargetSpeeds(double vX, double vY, double vA){
        Translation2d scaledInputs = SwerveMath.cubeTranslation(new Translation2d(vX, vY));
        ChassisSpeeds speeds = swerve.swerveController.getRawTargetSpeeds(scaledInputs.getX(), scaledInputs.getY(), Math.pow(vA, 3));
        return speeds;
    }

    public SwerveDrive getSwerve(){
        return swerve;
    }
}
