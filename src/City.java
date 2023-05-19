import java.util.HashMap;
import java.util.Objects;

public class City {

    private int id;
    private String name;
    private Coordinate coordinate;
    HashMap<Integer, Double> paths = new HashMap<>();

    public City(int id, String name, Coordinate coordinate) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public void addNode(City city, double cost) {
        paths.put(city.getId(), cost);
    }

    public void addNode(int cityId, double cost) {
        paths.put(cityId, cost);
    }

    public boolean equals(String o) {
        return hashCode()  == o.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && coordinate.equals(((City) o).coordinate) && Objects.equals(name, city.name) && Objects.equals(paths, city.paths);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
