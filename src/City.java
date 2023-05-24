import java.util.ArrayList;
import java.util.Objects;

public class City {

    private int id;
    private String name;
    private Coordinate coordinate;
    private boolean unvisited;

    private ArrayList<Integer> adjacentCities = new ArrayList<>();

    public City(int id, String name, Coordinate coordinate) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        unvisited = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isUnvisited() {
        return unvisited;
    }

    public void setUnvisited() {
        this.unvisited = true;
    }

    public void visited() {
        this.unvisited = false;
    }

    public ArrayList<Integer> getAdjacentCities() {
        return adjacentCities;
    }

    public void addNode(int cityId) {
        adjacentCities.add(cityId);
    }

    public boolean equals(String o) {
        return hashCode()  == o.hashCode();
    }

    public double cartesianDistance(City city) {
        return Math.sqrt(Math.pow(coordinate.getxCor() - city.coordinate.getxCor(), 2) +
                Math.pow(coordinate.getyCor() - city.coordinate.getyCor(), 2));
    }
    public double altitudeDistance(City city) {
        return Math.abs(coordinate.getAltitude() - city.coordinate.getAltitude());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && coordinate.equals(((City) o).coordinate) && Objects.equals(name, city.name) && Objects.equals(adjacentCities, city.adjacentCities);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }



}
