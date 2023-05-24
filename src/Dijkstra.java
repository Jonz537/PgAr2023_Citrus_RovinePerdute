import java.util.*;

public class Dijkstra {

    private static Deque<City> deque = new ArrayDeque<>();
    private static HashMap<City, Double> distanceFromStartCartesian = new HashMap<>();
    private static HashMap<City, Double> distanceFromStartAltitude = new HashMap<>();
    private static HashMap<City, ArrayList<City>> pathFromStartCartesian = new HashMap<>();
    private static HashMap<City, ArrayList<City>> pathFromStartAltitude = new HashMap<>();

    public static void pathFinderCartesian(City start, ArrayList<City> cities) {

        City currentNode;
        deque.add(start);
        cities.get(0).visited();

        distanceFromStartCartesian.put(start, 0.0);

        while (deque.size() > 0) {
            currentNode = deque.poll();
            for (Integer i: currentNode.getAdjacentCities()) {
                if (cities.get(i).isUnvisited()) {
                    deque.add(cities.get(i));
                    cities.get(i).visited();
                }

                double currentDistancePlusCurrentNodeCartesian = distanceFromStartCartesian.getOrDefault(currentNode, Double.MAX_VALUE / 2)
                        + currentNode.cartesianDistance(cities.get(i));

                // distanza dall'inizio del nodo attuale + distanza dal prossimo è minore dalla distanza dal prossimo dall'inizo
                if (currentNode.equals(start)) {
                    // aggiungiamo le città iniziali
                    distanceFromStartCartesian.put(cities.get(i), currentNode.cartesianDistance(cities.get(i)));

                    ArrayList<City> initialPath = new ArrayList<>();
                    initialPath.add(currentNode);
                    pathFromStartCartesian.put(cities.get(i), initialPath);
                } else if (currentDistancePlusCurrentNodeCartesian < distanceFromStartCartesian.getOrDefault(cities.get(i), Double.MAX_VALUE/2)) {
                    // aggiorniamo la distanza del prossimo
                    distanceFromStartCartesian.put(cities.get(i), distanceFromStartCartesian.getOrDefault(currentNode, Double.MAX_VALUE) + currentNode.cartesianDistance(cities.get(i)));

                    // aggiorniamo le citta visitate
                    ArrayList<City> updatePath = new ArrayList<>(pathFromStartCartesian.get(currentNode));
                    updatePath.add(currentNode);
                    pathFromStartCartesian.put(cities.get(i), updatePath);
                }
            }
        }
    }

    public static void pathFinderAltitude(City start, ArrayList<City> cities) {

        cities.forEach(City::setUnvisited);

        City currentNode;
        deque.add(start);
        cities.get(0).visited();

        distanceFromStartAltitude.put(start, 0.0);

        while (deque.size() > 0) {
            currentNode = deque.poll();
            for (Integer i: currentNode.getAdjacentCities()) {
                if (cities.get(i).isUnvisited()) {
                    deque.add(cities.get(i));
                    cities.get(i).visited();
                }

                double currentDistancePlusCurrentNodeAltitude = distanceFromStartAltitude.getOrDefault(currentNode, Double.MAX_VALUE / 2)
                        + currentNode.altitudeDistance(cities.get(i));

                // distanza dall'inizio del nodo attuale + distanza dal prossimo è minore dalla distanza dal prossimo dall'inizo
                if (currentNode.equals(start)) {
                    // aggiungiamo le città iniziali
                    distanceFromStartAltitude.put(cities.get(i), currentNode.altitudeDistance(cities.get(i)));

                    ArrayList<City> initialPath = new ArrayList<>();
                    initialPath.add(currentNode);
                    pathFromStartAltitude.put(cities.get(i), initialPath);
                } else if (currentDistancePlusCurrentNodeAltitude < distanceFromStartAltitude.getOrDefault(cities.get(i), Double.MAX_VALUE/2)) {
                    // aggiorniamo la distanza del prossimo
                    distanceFromStartAltitude.put(cities.get(i), distanceFromStartAltitude.getOrDefault(currentNode, Double.MAX_VALUE) + currentNode.altitudeDistance(cities.get(i)));

                    // aggiorniamo le citta visitate
                    ArrayList<City> updatePath = new ArrayList<>(pathFromStartAltitude.get(currentNode));
                    updatePath.add(currentNode);
                    pathFromStartAltitude.put(cities.get(i), updatePath);
                }
            }
        }
    }


    public static HashMap<City, Double> getDistanceFromStartCartesian() {
        return distanceFromStartCartesian;
    }

    public static HashMap<City, ArrayList<City>> getPathFromStartCartesian() {
        return pathFromStartCartesian;
    }

    public static HashMap<City, Double> getDistanceFromStartAltitude() {
        return distanceFromStartAltitude;
    }

    public static HashMap<City, ArrayList<City>> getPathFromStartAltitude() {
        return pathFromStartAltitude;
    }
}