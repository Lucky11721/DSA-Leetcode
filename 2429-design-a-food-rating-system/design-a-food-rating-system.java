import java.util.*;

public class FoodRatings {

    class Pair {
        String food;
        int rating;

        Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }

    Map<String, Integer> foodRating;
    Map<String, String> foodCuisine;
    Map<String, PriorityQueue<Pair>> cuisineToFoodPQ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineToFoodPQ = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodRating.put(food, rating);
            foodCuisine.put(food, cuisine);

            if (cuisineToFoodPQ.containsKey(cuisine)) {
                Pair pair = new Pair(food, rating);
                cuisineToFoodPQ.get(cuisine).add(pair);
            } else {
                cuisineToFoodPQ.put(cuisine, new PriorityQueue<>((a, b) -> {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating);  // Higher rating first
                    } else {
                        return a.food.compareTo(b.food);
                    }
                }));
                Pair pair = new Pair(food, rating);
                cuisineToFoodPQ.get(cuisine).add(pair);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        foodRating.put(food, newRating);

        Pair pair = new Pair(food, newRating);
        cuisineToFoodPQ.get(cuisine).add(pair);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair> heap = cuisineToFoodPQ.get(cuisine);

        while (!heap.isEmpty()) {
            Pair top = heap.peek();
            int currentRating = foodRating.get(top.food);

            if (top.rating == currentRating) {
                return top.food;
            }
            heap.poll();
        }

        return "";
    }
}
