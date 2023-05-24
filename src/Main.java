import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<City> cities = new ArrayList<>();

        cities = XmlUtils.readMap("PgAr_Map_50.xml");

        City destination = cities.get(cities.size() - 1);

        Dijkstra.pathFinderCartesian(cities.get(0), cities);
        Dijkstra.pathFinderAltitude(cities.get(0), cities);

        for (Map.Entry<City, Double> entry: Dijkstra.getDistanceFromStartCartesian().entrySet()) {
            System.out.println(entry.getKey().getId() + " - " + entry.getKey().getName() + ":  " + entry.getValue());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (Map.Entry<City, Double> entry: Dijkstra.getDistanceFromStartAltitude().entrySet()) {
            System.out.println(entry.getKey().getId() + " - " + entry.getKey().getName() + ":  " + entry.getValue());
        }

        XmlUtils.writeMap(destination);

    }
}