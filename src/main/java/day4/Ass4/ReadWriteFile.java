package day4.Ass4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void main(String[] args) {
        File file = new File("input.txt");
        File outputFile = new File("output.txt");
        BufferedReader br = null;
        BufferedWriter wb = null;
        //System.out.println(System.getProperty("user.dir"));

        List<String> result = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    String cur = calResult(line);
                    result.add(cur);
                }
            }
            br.close();
            fr.close();

            FileWriter wr = new FileWriter(outputFile, false);
            wb = new BufferedWriter(wr);
            for (int i = 0; i < result.size(); i++) {
                wb.write(result.get(i));
                wb.newLine();
                wb.newLine();
                //wb.append("\n");
            }
            wb.flush();

            wr.close();
            System.out.println("==============END==================");
            /*
            for(int i = 0; i< result.size();i++){
                System.out.println(i+" : " + result.get(i) );
            }
            */

        } catch (FileNotFoundException var20) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException var21) {
            System.out.println("Unable to read file: " + file.toString());
        } finally {                       // always close the file
            if (wb != null) try {
                wb.close();
            } catch (IOException ioe2) {
                // just ignore it
            }
        }
    }

    public static String calResult(String s){
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int sign = 1;

        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals("+")){
                sign = 1;
            }else if(strs[i].equals("-")){
                sign = -1;
            }else if(isNumeric(strs[i])){
                int num = Integer.parseInt(strs[i]);
                cur = cur + (num * sign);
            }

            if(i > 0){
                sb.append(" ");
            }
            sb.append(strs[i]);
        }

        sb.append(" ");
        sb.append("=");
        sb.append(" ");
        sb.append(cur);

        return sb.toString();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
