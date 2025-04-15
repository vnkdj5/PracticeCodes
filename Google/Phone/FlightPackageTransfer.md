##Problem
Given an origin airport, destination airport, and series of flights determine whether it is possible for a package at the origin to reach the destination. A flight is represented as departure airport, arrival airport, departure time, and arrival time.
During the transportation, the time that the package leaves the airport needs to be greater than or equal to the time it arrives at the airport. Please determine whether it is possible for a package transfer from s to t. The package arrived at s at time 0.

Link: https://leetcode.com/discuss/post/6352084/google-l4-phone-screening-round-by-anony-aa15/


E.g. 1
Origin: "NYC"
Destination: "SFO"
Flights: NYC → LAX, Departure: 0, Arrival: 4
LAX - SFO, Departure: 5, Arrival: 7
Output: True

E.g 2
Origin: "NYC" Destination: "SFO"
Flights: NYC →> LAX, Departure: 0, Arrival: 4
LAX -> SFO, Departure: 3, Arrival: 5
Output: False


## Solution


Below is an updated Java solution that returns both the minimum arrival time and the list of flights taken. In this solution, each state in the BFS now carries the current airport, the current time (when the package arrives at that airport), and the list of flights taken so far. When the destination is reached, we update our best solution if the current arrival time is lower than any previously encountered time.

The code uses a helper class `State` (to keep the BFS state) and a result class `Result` (to encapsulate the final answer).

Below is the complete code:

```java
import java.util.*;

class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private int departureTime;
    private int arrivalTime;

    public Flight(String departureAirport, String arrivalAirport, int departureTime, int arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return departureAirport + " -> " + arrivalAirport + " (Dep: " + departureTime + ", Arr: " + arrivalTime + ")";
    }
}

public class PackageTransfer {

    // Helper class representing a state in BFS.
    static class State {
        String airport;
        int time; // time when the package arrives at this airport
        List<Flight> path; // list of flights taken to reach here

        State(String airport, int time, List<Flight> path) {
            this.airport = airport;
            this.time = time;
            this.path = path;
        }
    }

    // Class to encapsulate the result with the minimum arrival time and the list of flights taken.
    public static class Result {
        public int arrivalTime;
        public List<Flight> flights;

        public Result(int arrivalTime, List<Flight> flights) {
            this.arrivalTime = arrivalTime;
            this.flights = flights;
        }
    }

    /**
     * Determines whether a package can be transferred from the origin to the destination,
     * and if so returns the minimum arrival time and the list of flights taken.
     *
     * @param origin      The starting airport.
     * @param destination The destination airport.
     * @param flights     List of available flights.
     * @return A Result object that holds the earliest arrival time and the list of flights taken;
     *         if the destination is unreachable, arrivalTime is -1 and flights is null.
     */
    public static Result getMinimumTimeAndPath(String origin, String destination, List<Flight> flights) {
        // Map each airport to the list of outbound flights for quick lookup.
        Map<String, List<Flight>> flightMap = new HashMap<>();
        for (Flight flight : flights) {
            flightMap.computeIfAbsent(flight.getDepartureAirport(), k -> new ArrayList<>())
                     .add(flight);
        }

        // BFS queue: Start at the origin at time 0 with an empty path.
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(origin, 0, new ArrayList<>()));

        // Record the earliest arrival time at each airport.
        Map<String, Integer> bestArrivalTime = new HashMap<>();
        bestArrivalTime.put(origin, 0);

        int minArrivalTime = Integer.MAX_VALUE;
        List<Flight> bestPath = null;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            String currAirport = current.airport;
            int currTime = current.time;
            List<Flight> currPath = current.path;

            // Check if destination is reached.
            if (currAirport.equals(destination)) {
                if (currTime < minArrivalTime) {
                    minArrivalTime = currTime;
                    bestPath = currPath;
                }
                // Continue processing other states in case a better route exists.
                continue;
            }

            // Process all outgoing flights from the current airport.
            for (Flight flight : flightMap.getOrDefault(currAirport, Collections.emptyList())) {
                // We can take the flight only if its departure time is >= current arrival time.
                if (flight.getDepartureTime() >= currTime) {
                    int arrivalTime = flight.getArrivalTime();
                    String nextAirport = flight.getArrivalAirport();

                    // If we have reached this airport earlier before, skip the current flight.
                    if (bestArrivalTime.containsKey(nextAirport) && bestArrivalTime.get(nextAirport) <= arrivalTime) {
                        continue;
                    }

                    bestArrivalTime.put(nextAirport, arrivalTime);
                    List<Flight> newPath = new ArrayList<>(currPath);
                    newPath.add(flight);
                    queue.offer(new State(nextAirport, arrivalTime, newPath));
                }
            }
        }

        if (minArrivalTime == Integer.MAX_VALUE) {
            return new Result(-1, null); // Destination unreachable.
        }

        return new Result(minArrivalTime, bestPath);
    }

    // Testing the implementation.
    public static void main(String[] args) {
        // Example 1: Expected minimum arrival time: 7 with flights NYC->LAX and LAX->SFO.
        List<Flight> flightsExample1 = new ArrayList<>();
        flightsExample1.add(new Flight("NYC", "LAX", 0, 4));
        flightsExample1.add(new Flight("LAX", "SFO", 5, 7));
        Result result1 = getMinimumTimeAndPath("NYC", "SFO", flightsExample1);
        if (result1.arrivalTime != -1) {
            System.out.println("Example 1: Minimum Arrival Time: " + result1.arrivalTime);
            System.out.println("Flights taken:");
            for (Flight flight : result1.flights) {
                System.out.println("  " + flight);
            }
        } else {
            System.out.println("Example 1: Destination Unreachable.");
        }

        // Example 2: Unreachable due to flight timings.
        List<Flight> flightsExample2 = new ArrayList<>();
        flightsExample2.add(new Flight("NYC", "LAX", 0, 4));
        flightsExample2.add(new Flight("LAX", "SFO", 3, 5));
        Result result2 = getMinimumTimeAndPath("NYC", "SFO", flightsExample2);
        if (result2.arrivalTime != -1) {
            System.out.println("Example 2: Minimum Arrival Time: " + result2.arrivalTime);
            System.out.println("Flights taken:");
            for (Flight flight : result2.flights) {
                System.out.println("  " + flight);
            }
        } else {
            System.out.println("Example 2: Destination Unreachable.");
        }
    }
}
```

### Explanation

1. **Flight Class:**  
   This remains unchanged and represents each flight with its departure and arrival airports along with the corresponding times.

2. **State Class:**  
   Now includes a `List<Flight> path` that records the flights taken to reach that state (airport and time).

3. **Result Class:**  
   Wraps the final result which includes the minimum arrival time (`arrivalTime`) and the list of flights taken (`flights`). A value of -1 for `arrivalTime` and `null` for `flights` indicates that the destination is unreachable.

4. **BFS Process:**
   - We start at the origin at time 0 with an empty path.
   - For every state in the queue, we check if the destination is reached. If yes and the current arrival time is lower than the best seen, we update our best result.
   - For each outbound flight from the current airport that can be taken (departure time is no less than the current time), we update the state with the new arrival time and extended flight path.
   - A map `bestArrivalTime` is used to record the earliest time that an airport is reached. If a new state does not improve on this, it is skipped.

5. **Testing:**  
   The `main` method demonstrates the solution on two examples:
   - **Example 1:** A valid connection from `"NYC"` to `"SFO"`, expected to return a minimum arrival time of 7 along with the list of flights.
   - **Example 2:** A case where the timing doesn’t allow a valid transfer, returning unreachable.

This implementation efficiently finds the minimum time to reach the destination and collects the actual flights taken along that route.
