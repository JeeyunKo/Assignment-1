/** This class contains a main method to test all 11 methods I have implemented for the class ResizeableArraySet.
 *
 * */

public class ArraySetTest {
    public static void main(String[] args) {

        SetInterface<String> aSet = new ResizeableArraySet<>(3);

        // testing add method
        aSet.add("A");
        showSet(aSet);
        aSet.add("B");
        showSet(aSet);
        aSet.add("C");
        showSet(aSet);
        aSet.add("A");
        showSet(aSet);
        aSet.add("D");
        showSet(aSet);
        aSet.add("D");
        System.out.print("Testing what is added in the set: ");
        showSet(aSet);

        //testing getCurrentSize method
        System.out.print("\nTesting Current Size: ");
        aSet.getCurrentSize();
        showSet(aSet);

        //testing remove method (one unspecified, last entry)
//        System.out.print("\nTesting to remove the last entry: ");
//        aSet.remove();
//        showSet(aSet);
//
//        System.out.print("\nSecond time removing the last entry: ");
//        aSet.remove();
//        showSet(aSet);

        //Testing remove method (removing a specified entry that the user wants)
        System.out.print("\nTesting second remove method: ");
        aSet.remove("A");
        showSet(aSet);

        //testing isEmpty method
//        System.out.println("\nTesting if a set is empty: ");
//        if (aSet.isEmpty()) {
//            System.out.println("true");
//        }
//        else {
//            System.out.println("false");
//        }

        //testing contains method
        //System.out.print("\nTesting if the set contains an entry: ");

        //testing toArray method
        //System.out.print("\nTesting to retrieve all entries in a set: ");

        //testing clear method
        //System.out.print("\nTesting if a set is cleared: ");
//
//        showSet(aSet);
//
//        aSet.add("A");
//        showSet(aSet);

        //testing union method
        //System.out.print("\nTesting union method: ");

        //testing intersection method
        //System.out.print("\nTesting intersection method: ");

        //testing difference method
        //System.out.print("\nTesting difference method: ");




//        String[] contentsOfSet = {"A", "B"};
//        testAddFunction(aSet, contentsOfSet);
//
//        String[] contentsOfSet2 = {"B", "C"};
//        testAddFunction(aSet, contentsOfSet2);
//
//        String[] contentsOfSet3 = {"D", "F"};
//        testAddFunction(aSet, contentsOfSet3);

    }

    // test the add method
    private static void testAddFunction(SetInterface<String> aSet, String[] content ) {
        System.out.println("\nAdding: ");
        for (int index = 0; index < content.length; index++) {
            // need to find a way to only not add "B", while "C" is added.
            if (aSet.contains(content[index])) {
                System.out.println("This entry cannot be added since it already exists.");
                showSet(aSet);
                break;
            }
            else {
                aSet.add(content[index]);
                System.out.print(content[index] + " ");
            }
        }
        System.out.println();
        showSet(aSet);
    }

    private static void showSet(SetInterface<String> aSet) {

        Object[] setArray = aSet.toArray();
        System.out.print("\nSize: " + aSet.getCurrentSize() + ",");
        System.out.print(" Set: ");
        for (int index = 0; index < setArray.length; index++) {
            System.out.print(setArray[index] + " ");
        }
        System.out.println();
    }

}
