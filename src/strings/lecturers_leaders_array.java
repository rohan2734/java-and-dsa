package strings;

public class lecturers_leaders_array {

	public static void leaders() {
		int size = input.length;
        for (int i = 0; i < size; i++)  
       { 
           int j; 
           for (j = i + 1; j < size; j++)  
           { 
               if (input[i] < input[j]) 
                   break; 
           } 
           if (j == size) // the loop didn't break 
               System.out.print(input[i] + " "); 

                
           } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
