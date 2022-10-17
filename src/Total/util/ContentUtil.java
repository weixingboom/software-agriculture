package Total.util;

import java.util.ArrayList;
import java.util.List;

public class ContentUtil {
    public static List<String> ContentList=new ArrayList<>();
    static {
        ContentList.add("主程序/子程序风格将系统组织成层次结构，\n包括一个主程序和一系列子程序，\n"
                + "主要用于能够将系统功能依层次分解为多个顺序执行步骤的系统。");
        ContentList.add("面向对象式风格将系统组织为多个独立的对象，\n每个对象封装其内部的数据，\n并基于数据对外提供服务，\n"
                + "适用于那些能够基于数据信息分解和组织的软件系统。");
        ContentList.add("观察者模式定义了一种一对多的依赖关系，\n让多个观察者对象同时监听某一个主题对象。\n"
                + "这个主题对象在状态变化时，\n会通知所有的观察者对象，\n使他们能够自动更新自己。\n它可以实现表示层和数据逻辑层的分离。");
        ContentList.add("管道-过滤器模式结构就像是一条产品加工流水线，\n原材料在流水线上经过一个个工人的加工，\n最终生产出产品。\n"
                + "适用于很容易地被分解成一组离散的、独立的步骤的软件。");

    }

}
