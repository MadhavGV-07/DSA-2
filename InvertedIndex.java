import java.util.*;

public class InvertedIndex {

    // Function to find intersection of two sorted lists
    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {

            if (list1.get(i).equals(list2.get(j))) {
                result.add(list1.get(i));
                i++;
                j++;
            }
            else if (list1.get(i) < list2.get(j)) {
                i++;
            }
            else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> list_machine =
                Arrays.asList(1, 4, 7, 12, 15, 20, 24, 30);

        List<Integer> list_learning =
                Arrays.asList(2, 4, 8, 12, 18, 24, 30);

        List<Integer> list_tutorial =
                Arrays.asList(4, 6, 9, 12, 17, 24, 30, 35);

        System.out.println("Posting Lists\n");

        System.out.println("Machine  : " + list_machine);
        System.out.println("Learning : " + list_learning);
        System.out.println("Tutorial : " + list_tutorial);

        // First intersection
        List<Integer> result1 = intersect(list_machine, list_learning);

        // Second intersection
        List<Integer> finalResult = intersect(result1, list_tutorial);

        System.out.println("\nIntersection of Machine & Learning:");
        System.out.println(result1);

        System.out.println("\nFinal Intersection of all three lists:");
        System.out.println(finalResult);
    }
}