package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pincers;

import java.util.function.Supplier;

public class MoveArms extends CommandBase {

    protected Pincers pincers;
    private final Supplier<Double> input;
    private final double minRotation;
    private final double maxRotation;
    protected final Supplier<Double> rotation;

    protected Supplier<Boolean> isFinished;

    public MoveArms(Pincers pincers, Supplier<Double> input, double minRotation, double maxRotation) {

        addRequirements(pincers);

        this.rotation = pincers::getRotation;
        this.input = input;
        this.minRotation = minRotation;
        this.maxRotation = maxRotation;
    }

    @Override
    public void execute() {

        if(rotation.get() > minRotation && rotation.get() < maxRotation)
        {
            pincers.setSpeed(input.get());
        }
        else
        {
            pincers.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished.get();
    }

    @Override
    public void end(boolean interrupted) {
        pincers.stop();
    }
}
