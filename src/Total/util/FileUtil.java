package Total.util;

import java.io.*;

public class FileUtil {
    public static String getFileContent(){
        File file = new File("D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt");
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
    public static void clearFile(){
        File file = new File("D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt");
        FileWriter filewriter;
        try {
            filewriter = new FileWriter (file);
            filewriter.write("");
            filewriter.flush();
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
