import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        algorithmForSingleCity("PgAr_Map_5.xml");
        algorithmForSingleCity("PgAr_Map_12.xml");
        algorithmForSingleCity("PgAr_Map_50.xml");
        algorithmForSingleCity("PgAr_Map_200.xml");
        algorithmForSingleCity("PgAr_Map_2000.xml");
        algorithmForSingleCity("PgAr_Map_10000.xml");
    }

    public static void algorithmForSingleCity(String filename) {

        System.out.println("Working on " + filename + "...");
        ArrayList<City> cities = new ArrayList<>();

        cities = XmlUtils.readMap(filename);

        City destination = cities.get(cities.size() - 1);

        Dijkstra.pathFinderCartesian(cities.get(0), cities);
        Dijkstra.pathFinderAltitude(cities.get(0), cities);

        XmlUtils.writeMap(destination, filename);
    }
}