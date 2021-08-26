import java.util.Scanner;

/**
 *   1 2   |  5 6
 *   3 4   |  7 8
 * ------------------
 *   9 10  |  13 14
 *  11 12  |  15 16
 *
 *  Ist quadrant   -> {1,2,3,4}     IInd quadrant -> {5,6,7,8}
 *  IIIrd quadrant -> {9,10,11,12}  IVth quadrant -> {13,14,14,16}
 *
 *  This quadrant values will be rotated like (Ist quad values to IInd quad) , (IInd quad values to IVth quad)
 **/

public class MatrixQuadrantRotate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt(); //getting total no.of.rows count
        int c = sc.nextInt(); //getting total no.of.columns count

        int matrix[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j] = sc.nextInt(); //getting the (r,c) sized matrix input
            }
        }

        int rotate = sc.nextInt(); //total no.of.times to rotate
        int midR = r/2 , midC = c/2; //finding the midpoints to segregate and rotate matrix
        int startR , startC;
        while(rotate-- != 0){
            startR = 0; startC = 0;
            int temp1[] = getElements(matrix,startR,startC,midR,midC); //1st quad values
            startR = 0; startC = midC;
            int temp2[] = getElements(matrix,startR,startC,midR,midC); //2nd quad values
            startR = midR; startC = 0;
            int temp3[] = getElements(matrix,startR,startC,midR,midC); //3rd quad values
            startR = midR; startC = midC;
            int temp4[] = getElements(matrix,startR,startC,midR,midC); //4th quad values

            startR = 0; startC = 0;
            rotate(matrix,temp3,startR,startC,midR,midC); //shifting 3rd quad value to 1st quad

            startR = 0; startC = midC;
            rotate(matrix,temp1,startR,startC,midR,midC); //shifting 1st quad value to 2nd quad

            startR = midR; startC = 0;
            rotate(matrix,temp4,startR,startC,midR,midC); //shifting 4th quad value to 3rd quad

            startR = midR; startC = midC;
            rotate(matrix,temp2,startR,startC,midR,midC); //shifting 2nd quad value to 4th quad
        }

        for(int[] i : matrix){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private static int[] getElements(int matrix[][],int rIndex,int cIndex,int r,int c){
        int temp[] = new int[r*c];
        int index = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                temp[index++] = matrix[rIndex][cIndex++];
            }
            rIndex++;
            cIndex-=c;
        }
        return temp;
    }

    private static void rotate(int matrix[][],int temp[],int rIndex,int cIndex,int r,int c){
        int index=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[rIndex][cIndex++] = temp[index++];
            }
            rIndex++;
            cIndex-=c;
        }
    }
}
