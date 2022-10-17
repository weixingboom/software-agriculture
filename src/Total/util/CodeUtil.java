package Total.util;

import java.util.ArrayList;
import java.util.List;

public class CodeUtil {

    public static List<String> Codelist = new ArrayList<>();
    static {
        Codelist.add( "核心代码:\r\n"
                + "public static void main(String[] args) {\r\n"
                + "        demo1 kwic = new demo1();\r\n"
                + "        kwic.input(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt\");\r\n"
                + "        kwic.shift();\r\n"
                + "        kwic.alphabetizer();\r\n"
                + "        kwic.output(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt\");\r\n"
                + "    }");
        Codelist.add(" 核心代码:\r\n"
                + "public static void main(String[] args) {\r\n"
                + "        Input input = new Input();\r\n"
                + "        input.input(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt\");\r\n"
                + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                + "        shift.shift();\r\n"
                + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                + "        alphabetizer.sort();\r\n"
                + "        Output output = new Output(alphabetizer.getKwicList());\r\n"
                + "        output.output(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt\");\r\n"
                + "    }");
        Codelist.add("核心代码:\r\n"
                + "public static void main(String[] args) {\r\n"
                + "        //创建主题\r\n"
                + "        KWICSubject kwicSubject = new KWICSubject();\r\n"
                + "        //创建观察者\r\n"
                + "        Input input = new Input(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt\");\r\n"
                + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                + "        Output output = new Output(alphabetizer.getKwicList(), \"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt\");\r\n"
                + "\r\n"
                + "        // 将观察者加入主题\r\n"
                + "        kwicSubject.addObserver(input);\r\n"
                + "        kwicSubject.addObserver(shift);\r\n"
                + "        kwicSubject.addObserver(alphabetizer);\r\n"
                + "        kwicSubject.addObserver(output);\r\n"
                + "        // 逐步调用各个观察者\r\n"
                + "        kwicSubject.startKWIC();\r\n"
                + "    }");
        Codelist.add("核心代码:\r\n"
                + "public static void main(String[] args) throws IOException {\r\n"
                + "        File inFile = new File(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt\");\r\n"
                + "        File outFile = new File(\"D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt\");\r\n"
                + "        Pipe pipe1 = new Pipe();\r\n"
                + "        Pipe pipe2 = new Pipe();\r\n"
                + "        Pipe pipe3 = new Pipe();\r\n"
                + "        Input input = new Input(inFile, pipe1);\r\n"
                + "        Shift shift = new Shift(pipe1, pipe2);\r\n"
                + "        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\r\n"
                + "        Output output = new Output(outFile,pipe3);\r\n"
                + "        input.transform();\r\n"
                + "        shift.transform();\r\n"
                + "        alphabetizer.transform();\r\n"
                + "        output.transform();\r\n"
                + "    }");



    }

}
