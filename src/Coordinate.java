import java.util.Objects;

public class Coordinate {

    private double xCor, yCor, altitude;

    public Coordinate(double xCor, double yCor, double altitude) {
        this.xCor = xCor;
        this.yCor = yCor;
        this.altitude = altitude;
    }

    public double getxCor() {
        return xCor;
    }

    public void setxCor(double xCor) {
        this.xCor = xCor;
    }

    public double getyCor() {
        return yCor;
    }

    public void setyCor(double yCor) {
        this.yCor = yCor;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.xCor, xCor) == 0 && Double.compare(that.yCor, yCor) == 0 && Double.compare(that.altitude, altitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCor, yCor, altitude);
    }
}
