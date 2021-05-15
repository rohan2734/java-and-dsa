import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lootHouses {
    public static int maxMoneyLootedHelper(int[] houses,int i){
        if(i >= houses.length){
            return 0;
        }
        int op1=    maxMoneyLootedHelper(houses,i+1);
        int op2 = houses[i]+ maxMoneyLootedHelper(houses, i+2);

        return Math.max(op1,op2);
    }
    public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        // return maxMoneyLootedHelper(houses,0);
        if(houses.length==0){
            return 0;
        }
        int storage[] = new int[houses.length];
        storage[0]=houses[0];
        storage[1]=houses[1];
        for(int i=2;i<houses.length;i++){
            int op1 = storage[i-1];
            int op2= houses[i] + storage[i-2];
            storage[i] = Math.max(op1,op2);
        }

        return storage[houses.length-1];
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
	}

    public static void main(String[] args) throws NumberFormatException, IOException {
            int[] arr = takeInput();
            System.out.println(maxMoneyLooted(arr));
    }
}
