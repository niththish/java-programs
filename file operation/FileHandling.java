import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        File f = new File("s.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(f);

        if(!f.exists()){
            System.out.println( (f.createNewFile()) ?"Created":"Problem in creating a file");
        }

        write(fw); read(fr); append(fw);
        search(br,"zoho"); delete(f);

    }

    private static void search(BufferedReader br,String key) throws IOException {
        String s;
        while( (s=br.readLine()) != null ){
            System.out.print(s);
            String[] arr= s.split(" ");
            int index = 0;
            for(String i:arr){
                if(i.equals(key)){
                    System.out.print(index+1);
                }
                index++;
            }
        }
    }

    private static void write(FileWriter fw) throws IOException {
        String input = new Scanner(System.in).nextLine();
        fw.write(input);
        fw.close();
    }

    private static void read(FileReader fr ) throws IOException{
        int i;
        while( (i=fr.read())!=-1 )
            System.out.print((char)i);
    }

    private static void append(FileWriter fw) throws IOException {
        String input = new Scanner(System.in).nextLine();
        fw.write(input);
        fw.close();
    }

    private static void delete(File f){
        if(f.exists()){
            System.out.println( f.delete() ? "Deleted successfully":"Unable to delete" );
        }
    }
}
