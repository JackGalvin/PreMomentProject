package sample;

public class Force {

    public float getMagnitude() {
        return magnitude;
    }

    public boolean isAntiClockWise() {
        return antiClockWise;
    }

    public double getAngle() {
        return angle;
    }

    public double getPosition() {
        return position;
    }

    public double getDistanceFromPivot() { return currentPivotPosition-position;}

    public double getMoment() {
        return magnitude*getDistanceFromPivot(); //not the distance from pivot at the min
    }

    private float magnitude;
    private boolean antiClockWise;
    private double angle;
    private double position;
    private double moment;
    private double currentPivotPosition;

    public Force(float magnitude,boolean antiClockWise,double angle,double position,double pivotPosition){
        this.magnitude = magnitude;
        this.antiClockWise = antiClockWise;
        this.angle = angle;
        this.position = position;
        this.moment = getMoment();
        this.currentPivotPosition = pivotPosition;
    }

}
