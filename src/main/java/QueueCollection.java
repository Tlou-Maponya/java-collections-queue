import java.util.*;

public class QueueCollection {

    public void addNumbersToQueue(int intNumber, int subArraySize, int ... list) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int highestUniqueNum = 1;
        Integer[] subArray = new Integer[subArraySize];

        for (int i = 0; i < intNumber; i++) {
            queue.add(list[i]);
        }

        // converting queue to a list
        Integer [] queueArray = new Integer[queue.size()];
        queue.toArray(queueArray);

        System.out.println("intNumber: " + queue.size());
        System.out.println("subArraySize: " + subArraySize);
        System.out.println("Queue Array: " + Arrays.toString(queueArray) + "\n");

        int start = 0;
        int finish = subArraySize;

        for (int i = 0; i < intNumber; i++) {
            //Copies the content of the queue into the subsets
            subArray = Arrays.copyOfRange(queueArray, start, finish);
          if (queueArray[i].equals(queueArray[intNumber - finish + 2])) {
            continue;
          }
            int uniqueNum = uniqueNumber(subArraySize, subArray);

            System.out.println(Arrays.toString(subArray) + " has " + uniqueNum + " unique numbers." );
            if (highestUniqueNum <= uniqueNum) {
                highestUniqueNum = uniqueNum;
                start++;
                finish++;
            }

        }
        System.out.println("Highest number of unique integers in subArray: " + highestUniqueNum);
        System.out.println("");
        // find highest number of unique val

    }

    public int uniqueNumber(int size, Integer[] uniqueArray) {
        int totalUniqueNum = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(uniqueArray));
        totalUniqueNum = hashSet.size();
        return totalUniqueNum;
    }
}
