import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<City> cities = new ArrayList<>();

        cities = XmlUtils.readMap("PgAr_Map_55.xml");
//        Dijkstra.pathFind(cities.get(0), cities);
//
//        for (Map.Entry<City, Double> entry: Dijkstra.distanceFromStart.entrySet()) {
//            System.out.println(entry.getKey().getId() + ": " + entry.getValue());
//        }

        System.out.println("\n\n");

        Dijkstra2 dick = new Dijkstra2(cities);
        dick.cykablyat(cities);
        dick.results();
    }
}