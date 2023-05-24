import java.util.ArrayList;

public class Dijkstra2 {
    private ArrayList<Integer> visited = new ArrayList<>();
    private ArrayList<Integer> unvisited = new ArrayList<>();
    private ArrayList<Double> tab = new ArrayList<>();
    private Integer city = 0;

    public Dijkstra2(ArrayList<City> cities) {

        tab.add(0.0);

        for (int i = 1; i < cities.size() - 1; i++) {
            unvisited.add(i);
            tab.add(Double.MAX_VALUE);
        }

        visited.add(0);
    }

    public void cykablyat(ArrayList<City> cities) {
        do {
            ArrayList<Integer> adjacentCities = cities.get(city).getAdjacentCities();

            for (Integer adjacentCity : adjacentCities) {
                if (tab.get(adjacentCity) > cities.get(city).cartesianDistance(cities.get(adjacentCity))) {
                    tab.add(adjacentCity, cities.get(city).cartesianDistance(cities.get(adjacentCity)));
                }
            }

            if(!unvisited.isEmpty()) {
                city = Integer.MAX_VALUE;
                for (int i = 0; i < unvisited.size(); i++) {
                    System.out.println("CYKA BLYAT");
                    if (unvisited.get(i) < city && (!cities.get(unvisited.get(i)).isUnvisited())) {
                        System.out.println("BRUTTO PEZZO DI MERDA");
                        city = i;
                    }
                }

                if(city != Integer.MAX_VALUE) {
                    visited.add(unvisited.get(city));
                    unvisited.remove(city);
                }
            }
            System.out.println(unvisited.size() + " " + city);
        } while(unvisited.size() > 0);
    }

    public void results() {
        for (int i = 0; i < tab.size() - 1; i++) {
            System.out.println(i + ": " + tab.get(i));
        }
    }
}
