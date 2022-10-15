package homework.util;

import java.io.*;


/**
 * @Author zsh
 * @Date 2022/10/13 14:57
 * @Description
 **/
public class FileUtil {
    public static String getFileContent(){
        File file = new File("files/output.txt");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            String res = null;
            while((res = bufferedreader.readLine())!=null){
                result.append(System.lineSeparator()+res);
            }
            bufferedreader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    public static void clearFile() {
        File file = new File("files/output.txt");
        FileWriter filewriter;
        try {
            filewriter = new FileWriter(file);
            filewriter.write("");
            filewriter.flush();
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
