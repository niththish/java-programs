import java.util.Scanner;

/**
 input:-
    arr:- 1 2 3 4 5
    x:- 4

 output:-
     The adjacent forming numbers that are divisible by 4 are : 12, 32
**/

public class AdjacentDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arr[] = sc.nextLine().strip().split(" "); //arrays of numbers to be paired with their adjacent
        int x = sc.nextInt(); // the paired number should be checked whether it is divisible against x
        boolean flag = false;

        for(int i=0;i<arr.length-1;i++){
            String res = adjacentDivisibleChecker(arr[i],arr[i+1],x);
            if(!res.equals("")){
                System.out.println(res);
                flag = true; //if any adjacent divisible pair exists then we set flag = true
            }
        }

        if(!flag){
            System.out.println(-1); //if no such adjacent divisible pair exists then we print -1
        }

    }

    private static String adjacentDivisibleChecker(String n1,String n2,int x){
        double possibleNum = Double.parseDouble(n1+n2); //creating a num from arr[i] + arr[i+1] then checking
        if(possibleNum % x == 0){
            return n1+" "+n2;
        }else{
            possibleNum = Double.parseDouble(n2+n1); //if the above condition fails then we form a num from arr[i+1] + arr[i] then checking
            if(possibleNum % x == 0){
                return n2+" "+n1;
            }
        }
        return ""; //returning a empty string if both the conditions are not meet
    }
}
