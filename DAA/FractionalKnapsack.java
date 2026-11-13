import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    static class Item {
        double value, weight;

        Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double fractionalKnapsack(double W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        double totalValue = 0.0;
        double remaining = W;

        for (Item item : items) {
            if (item.weight <= remaining) {
                totalValue += item.value;
                remaining -= item.weight;
                System.out.println("Took full item (value=" + item.value + ", weight=" + item.weight + ")");
            } else {
                double fraction = remaining / item.weight;
                totalValue += item.value * fraction;
                System.out.printf("Took %.2f of item (value=%.1f, weight=%.1f)%n", fraction, item.value, item.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " value: ");
            double value = sc.nextDouble();
            System.out.print("Item " + (i + 1) + " weight: ");
            double weight = sc.nextDouble();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of the knapsack: ");
        double W = sc.nextDouble();

        double maxValue = fractionalKnapsack(W, items);
        System.out.printf("Maximum value in Knapsack = %.2f%n", maxValue);
        sc.close();
    }
}
