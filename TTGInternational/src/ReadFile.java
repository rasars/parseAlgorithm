import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {

    static String path="./resources/AccountList.txt";

    public static void main(String[] args) throws IOException {

        int accountCount=0;
        int accountStart=1;
        Integer testNumber;

        ArrayList<Integer> testCount =new ArrayList<Integer>() ;
        List accountList = new ArrayList();
        Map<String,Long> result = new TreeMap<>();
        String firstLine = Files.readAllLines(Paths.get(path)).get(0);
        testNumber=Integer.parseInt(firstLine);

        for(int i=0;i<testNumber;i++)
        {
            accountCount=Integer.parseInt(Files.readAllLines(Paths.get(path)).get(accountStart));
            accountStart++;
            accountCount=accountCount+accountStart;
            for(int j=accountStart;j<accountCount;j++)
            {
                String line = Files.readAllLines(Paths.get(path)).get(j);
                accountList.add(line);


                }

            accountStart=accountCount;
            accountList.stream().forEach(n -> {
                if(result.containsKey(n)){
                    result.put((String) n, result.get(n).intValue() + 1L);
                }else
                    result.put((String) n, 1L);
            });
            result.forEach((k,v) -> {
                System.out.println(k + " " + v);
            });
            accountList.clear();
            result.clear();
            System.out.println();
            }

        }


    }


