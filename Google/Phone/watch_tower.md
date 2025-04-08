## Problem Statement: 

Just had my phone screen today. Got asked these two questions:

Q1: A town is building a watchtower. The watchtower is located at (0, 0). Each unit height of the watchtower has a cost H. There are N houses located at (x, y) coordinates. Each house will pay cost C if it comes under the surveillance of the watchtower. The horizontal distance covered by the watchtower is the same as it's height. Find out the max profit you can make.

Inputs:

N number of houses
list of (x, y) coordinates
H cost to build unit height
C cost each house pays the watchtower
In the beginning the watchtower was located at the origin. For the followup he said watchtower location will be provided. The (x, y) coordinates can be floats as well as H and C.



We can model the problem as choosing a tower height, say **h**, that “reaches” a certain set of houses. In our example the watchtower is at a fixed location (initially the origin), and its “footprint” is a circle of radius **h** (i.e. it covers any house that lies within distance **h**). Each unit height costs **H** while each house covered pays **C**. Our goal is to pick **h** so that

\[
\text{Profit}(h) = \text{(number of houses covered)} \times C - h \times H 
\]

is maximized.

---

## Step 1. Model the Coverage

For a tower located at \((x_0, y_0)\) (initially \((0, 0)\)) any house at coordinate \((x, y)\) is “covered” if the Euclidean distance from the watchtower to the house is less than or equal to the height \(h\). That is, a house is covered if

\[
\sqrt{(x - x_0)^2 + (y - y_0)^2} \le h.
\]

In the beginning, since \( (x_0,y_0) = (0, 0) \), the condition simplifies to

\[
\sqrt{x^2 + y^2} \le h.
\]

---

## Step 2. Formulate the Profit Function

Let the total number of houses be \(N\) and denote by \(d_i\) the distance from the watchtower to house \(i\).  
For any chosen height \(h\), denote

\[
k(h) = \text{number of houses with } d_i \le h.
\]

Then the profit can be written as:

\[
\text{Profit}(h) = k(h) \cdot C - h \cdot H.
\]

Notice that \( k(h) \) is a step function: it jumps by 1 whenever \(h\) passes one of the distances \(d_i\). Hence, while \(h\) can be chosen continuously, it is optimal to consider the “critical” values where \(h\) is exactly the distance to one of the houses. (You can also check \(h=0\), which yields profit \(0\).)

---

## Step 3. How to Find the Optimal Height

1. **Compute Distances**: For each house with coordinate \((x, y)\), compute

   \[
   d = \sqrt{x^2 + y^2}
   \]

   (or, more generally, \( \sqrt{(x-x_0)^2+(y-y_0)^2} \) for a watchtower at \((x_0, y_0)\)).

2. **Sort the Distances**: Order the distances \(d_1 \le d_2 \le \cdots \le d_N\).

3. **Evaluate Profit at Each Critical Height**:  
   For the \(i\)th house (with distance \(d_i\)), if you set \(h = d_i\) then exactly \(i\) houses are covered. The profit then is:

   \[
   P_i = i \cdot C - d_i \cdot H.
   \]

   Also consider \(h=0\) (which gives 0 profit) if it turns out that building any height gives a loss.

4. **Choose the Maximum**:  
   Find the index \(i^*\) such that \(P_{i^*}\) is maximized. The corresponding optimal tower height is \(h = d_{i^*}\).

*Note*: If houses are very sparse (or building the tower is very expensive compared to the income from houses), the best option might even be to build nothing (i.e. profit = 0).

---

## Step 4. Followup: Changing the Tower Location

In the followup, if the watchtower’s base is moved to a coordinate \((x_0, y_0)\), the only thing that changes is the distance calculation for each house. You would now compute the distance for each house as

\[
d = \sqrt{(x - x_0)^2 + (y - y_0)^2}.
\]

The same procedure as above then applies.



## Final Answer

**For a tower at \((0,0)\):**  
1. Compute each house’s Euclidean distance \(d_i = \sqrt{x_i^2 + y_i^2}\).  
2. Sort these distances.  
3. For each \(d_i\) (with \(i\) houses covered if \(h = d_i\)), compute profit \(P_i = i \cdot C - d_i \cdot H\).  
4. The optimal tower height is the \(d_i\) corresponding to the maximum profit. The maximum profit is \( \max\{i \cdot C - d_i \cdot H\} \).  

**For a tower at an arbitrary location \((x_0, y_0)\):**  
Compute distances using \(d_i = \sqrt{(x_i - x_0)^2 + (y_i - y_0)^2}\) and follow the same procedure.

This method gives you the maximum profit while only constructing the tower as high as needed to cover the optimal number of houses.



```java
import java.util.Arrays;

public class WatchTowerProfitCalculator {

    // A simple helper class to represent a point or house coordinates.
    static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Computes the maximum profit and the corresponding optimal tower height.
     *
     * @param houses An array of Point objects representing the house coordinates.
     * @param H      The cost per unit height of the tower.
     * @param C      The revenue per house covered.
     * @param tower  The base location of the tower as a Point.
     * @return       An array where index 0 holds the optimal height and index 1 holds the maximum profit.
     */
    public static double[] maxProfit(Point[] houses, double H, double C, Point tower) {
        int n = houses.length;
        double[] distances = new double[n];
        
        // Calculate the Euclidean distance from the tower to each house.
        for (int i = 0; i < n; i++) {
            double dx = houses[i].x - tower.x;
            double dy = houses[i].y - tower.y;
            distances[i] = Math.hypot(dx, dy);
        }
        
        // Sort the distances in non-decreasing order.
        Arrays.sort(distances);
        
        double maxProfit = 0.0;
        double optimalHeight = 0.0;
        
        // Iterate over each critical height (distance to each house).
        // When the tower's height is set exactly to distances[i], exactly (i+1) houses are covered.
        for (int i = 0; i < n; i++) {
            double currentHeight = distances[i];
            int housesCovered = i + 1;  // since i is 0-based index
            double currentProfit = housesCovered * C - currentHeight * H;
            
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                optimalHeight = currentHeight;
            }
        }
        
        return new double[]{optimalHeight, maxProfit};
    }

    public static void main(String[] args) {
        // Example input:
        // List of houses (x, y). Using the origin for the initial tower location.
        Point[] houses = new Point[] {
            new Point(3, 4),   // distance = 5.0 from (0,0)
            new Point(1, 1),   // distance = approx. 1.414
            new Point(2, 2),   // distance = approx. 2.828
            new Point(10, 10)  // distance = approx. 14.142
        };
        
        double H = 2.0;  // Cost per unit height
        double C = 10.0; // Revenue per house covered

        // Case 1: Tower at origin (0,0)
        Point towerOrigin = new Point(0, 0);
        double[] resultOrigin = maxProfit(houses, H, C, towerOrigin);
        System.out.println("Tower at (0,0):");
        System.out.printf("Optimal Tower Height: %.3f\n", resultOrigin[0]);
        System.out.printf("Maximum Profit: %.3f\n\n", resultOrigin[1]);
        
        // Case 2: Tower at a new location, for example (5, 5)
        Point towerNew = new Point(5, 5);
        double[] resultNew = maxProfit(houses, H, C, towerNew);
        System.out.println("Tower at (5,5):");
        System.out.printf("Optimal Tower Height: %.3f\n", resultNew[0]);
        System.out.printf("Maximum Profit: %.3f\n", resultNew[1]);
    }
}
```