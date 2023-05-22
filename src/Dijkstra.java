import java.util.*;

public class Dijkstra {

    private static Deque<City> deque = new ArrayDeque<>();
    public static HashMap<City, Double> distanceFromStart = new HashMap<>();
    public static HashMap<City, ArrayList<City>> pathFromStart = new HashMap<>();

    public static void pathFind(City start, ArrayList<City> cities) {

        City currentNode;
        deque.add(start);
        cities.get(0).visited();

        distanceFromStart.put(start, 0.0);

        while (deque.size() > 0) {
            currentNode = deque.poll();
            for (Integer i: currentNode.getAdjacentCities()) {
                if (cities.get(i).isUnvisited()) {
                    deque.add(cities.get(i));
                    cities.get(i).visited();
                }

                double currentDistancePlusCurrentNode = distanceFromStart.getOrDefault(currentNode, Double.MAX_VALUE / 2)
                            + currentNode.distance(cities.get(i));

                // distanza dall'inizio del nodo attuale + distanza dal prossimo è minore dalla distanza dal prossimo dall'inizo
                if (currentDistancePlusCurrentNode < distanceFromStart.getOrDefault(cities.get(i), Double.MAX_VALUE/2)) {
                    // aggiorniamo la distanza del prossimo
                    distanceFromStart.put(cities.get(i), distanceFromStart.getOrDefault(currentNode, Double.MAX_VALUE) + currentNode.distance(cities.get(i)));
                    ArrayList<City> updatePath = new ArrayList<>(pathFromStart.get(cities.get(i)));
                    updatePath.add(currentNode);
                    pathFromStart.put(cities.get(i), updatePath);

                } else if (currentNode.equals(start)) {
                    // aggiungiamo le città iniziali
                    distanceFromStart.put(cities.get(i), currentNode.distance(cities.get(i)));
                    ArrayList<City> initialPath = new ArrayList<>();
                    initialPath.add(currentNode);
                    pathFromStart.put(cities.get(i), initialPath);
                }
            }
        }
    }
}