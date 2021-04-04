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

    public double getMoment() {
        return magnitude*position; //not the distance from pivot at the min
    }

    private float magnitude;
    private boolean antiClockWise;
    private double angle;
    private double position;
    private double moment;

    public Force(float magnitude,boolean antiClockWise,double angle,double position){
        this.magnitude = magnitude;
        this.antiClockWise = antiClockWise;
        this.angle = angle;
        this.position = position;
        this.moment = getMoment();
    }

}
