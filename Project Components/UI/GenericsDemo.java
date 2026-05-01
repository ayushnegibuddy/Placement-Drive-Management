// Generic class Box<T>
class Box<T>
{
    private T value;
    Box(T value)
    {
        this.value = value;
    }
    public T get()
    {
        return value;
    }
}
// Generic method
class GenericMethods
{
    public static <T> void printTwice(T x)
    {
        System.out.println(x);
        System.out.println(x);
    }
}
// Optional generic Pair<K, V>
class Pair<K, V>
{
    private K key;
    private V value;
    Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    public void printPair()
    {
        System.out.println("Pair: " + key + " = " + value);
    }
}
public class GenericsDemo
{
    public static void main(String[] args)
    {
        // Box<Integer>
        Box<Integer> intBox = new Box<>(100);
        System.out.println("Integer Box contains: " + intBox.get());
        // Box<String>
        Box<String> strBox = new Box<>("Hello Generics");
        System.out.println("String Box contains: " + strBox.get());
        // Generic method calls
        GenericMethods.printTwice(42);
        GenericMethods.printTwice("Generic Method Example");
        // Optional Pair<K, V>
        Pair<String, Integer> pair = new Pair<>("Age", 20);
        pair.printPair();
    }
}
