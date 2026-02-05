
public class MyHashSet {
	int primaryArraySize;
    int secondaryArraySize;

    boolean[][] customHashArray;

    public MyHashSet() {
        this.primaryArraySize = 1001;
        this.secondaryArraySize = 1000;
        this.customHashArray = new boolean[primaryArraySize][];
    }
    
    public int getPrimaryHashValue(int key) {
        return key / primaryArraySize + 1;
    }

    public int getSecondaryHashValue(int key) {
        return key % secondaryArraySize;
    }

    public void add(int key) {

        int primaryPos = getPrimaryHashValue(key);
        int secondaryPos = getSecondaryHashValue(key);

        if(customHashArray[primaryPos] == null) {
            customHashArray[primaryPos] = new boolean[secondaryArraySize];
        }
        customHashArray[primaryPos][secondaryPos] = true;
    }
    
    public void remove(int key) {
        int primaryPos = getPrimaryHashValue(key);
        int secondaryPos = getSecondaryHashValue(key);
        if(customHashArray[primaryPos] != null) {
            customHashArray[primaryPos][secondaryPos] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int primaryPos = getPrimaryHashValue(key);

        if(customHashArray[primaryPos] == null) {
            return false;
        }
        int secondaryPos = getSecondaryHashValue(key);
        return customHashArray[primaryPos][secondaryPos];

    }
}
