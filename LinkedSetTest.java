

public class LinkedSetTest {
    public static void main(String[] args) {

        //creating a new empty Linked set
        SetInterface<String> bSet = new LinkedSet<>();

        //shows empty set
        showSet(bSet);

        //testing add method
        //String[] Set1 = {"A", "D", "B", "A", "C", "A", "D"};
        bSet.add("A");
        bSet.add("D");
        bSet.add("B");
        bSet.add("A");
        bSet.add("C");
        showSet(bSet);




    }

    private static void showSet(SetInterface<String> bSet) {

        System.out.println("The bag contains " + bSet.getCurrentSize() +
                " string(s), as follows:");
        Object[] LinkedSet = bSet.toArray();
        for (int index = 0; index < LinkedSet.length; index++) {
            System.out.print(LinkedSet[index] + " ");
        }
        System.out.println();
    }

}
