import java.util.Arrays;
// Functional interface
@FunctionalInterface
interface IntOp
{
    int apply(int a, int b);
}
public class LambdaDemo
{
    public static void main(String[] args)
    {
        // 1. Lambdas for addition, max, min
        IntOp addition = (a, b) -> a + b;
        IntOp max = (a, b) -> (a > b ? a : b);
        IntOp min = (a, b) -> (a < b ? a : b);
        System.out.println("Addition: " + addition.apply(10, 20));
        System.out.println("Max: " + max.apply(10, 20));
        System.out.println("Min: " + min.apply(10, 20));
        // 2. Runnable using lambda
        Runnable task = () -> System.out.println("Runnable running in a thread!");
        Thread t = new Thread(task);
        t.start();
        // 3. Sort string array using comparator lambda
        String[] names = {"Charlie", "alice", "Bob", "diana"};
        Arrays.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted names (case-insensitive):");
        for (String name : names)
        {
            System.out.println(name);
        }
    }
}