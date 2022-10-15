package homework.controller;

import homework.enums.TypeEnum;
import homework.service.event.EventMain;
import homework.service.main.Demo1;
import homework.service.object.ObjectMain;
import homework.service.pipe.PipeMain;
import homework.util.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @Author zsh
 * @Date 2022/10/12 17:30
 * @Description
 **/
public class MainController {
    public static void start() throws IOException {

        JFrame frame = new JFrame("经典软件体系结构教学软件");
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("file");
        MenuItem openItem = new MenuItem("open");
        final String[] fileName = new String[1];
        openItem.addActionListener(e -> {
            FileDialog oDialog = new FileDialog(frame);
            oDialog.setVisible(true);
            String dir = oDialog.getDirectory();
            String file = oDialog.getFile();
            fileName[0] = dir + file;
        });
        
        mb.add(menu);
        menu.add(openItem);

        frame.setMenuBar(mb);

        frame.setBounds(200,200,800,600);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 700);

        JTabbedPane tab = new JTabbedPane();

        tab.add("面向对象",createPanel(TypeEnum.OBJECT.getValue(),fileName[0]));
        tab.add("主程序-子程序",createPanel(TypeEnum.MAIN.getValue(),fileName[0]));
        tab.add("管道-过滤",createPanel(TypeEnum.PIPE.getValue(),fileName[0]));
        tab.add("事件系统",createPanel(TypeEnum.EVENT.getValue(),fileName[0]));

        tab.setSelectedIndex(0);

        frame.setVisible(true);
        frame.setContentPane(tab);
    }

    private static JComponent createPanel(int type,String filePath) {
        System.out.println(filePath);
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        String contentDescription;
        String contentImgUrl;
        String contentCode;

        if(type == TypeEnum.OBJECT.getValue()) {
            contentDescription = "面向对象体系结构风格的组件是类和对象。\n" +
                    "连接件是对象之间通过功能与函数调用实现交互。\n" +
                    "对象是通过函数和过程的调用-返回机制来交互的,而类是通过定义对\n" +
                    "象,再采用调用-返回机制进行交互";
            contentImgUrl = "images/object.png";
            contentCode = "核心代码块:\r\n"
                    + "public static void homework.service.main(String[] args) {\r\n"
                    + "        Input input = new Input();\r\n"
                    + "        input.input(\"files/input.txt\");\r\n"
                    + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                    + "        shift.shift();\r\n"
                    + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                    + "        alphabetizer.sort();\r\n"
                    + "        Output output = new Output(alphabetizer.getKwicList());\r\n"
                    + "        output.output(\"files/output.txt\");\r\n"
                    + "    }";
        }
        else if(type == TypeEnum.MAIN.getValue()) {
            contentDescription = "主程序/子程序风格严格的层次分解使得整个系统的结构组织非常符合 \n" +
                    "功能分解和分而治之的思维方式，从而能够清晰地描述整个系统的执行流程，易于理解";
            contentImgUrl = "images/main.png";
            contentCode = "核心代码块:\r\n"
                    + "public static void homework.service.main(String[] args) {\r\n"
                    + "        Demo1 kwic = new Demo1();\r\n"
                    + "        kwic.input(\"files/input.txt\");\r\n"
                    + "        kwic.shift();\r\n"
                    + "        kwic.alphabetizer();\r\n"
                    + "        kwic.output(\"files/output.txt\");\r\n"
                    + "    }";
        }
        else if(type == TypeEnum.PIPE.getValue()) {
            contentDescription = "管道过滤器风格的组件是过滤器，即处理数据\n" +
                    "的模块，组件的关系是管道，即传输数据\n" +
                    "的模块，该风格把数据经过滤器A处理后，通过管道A\n" +
                    "传输到过滤器B，然后再由过滤器B处理，以次类推。。";
            contentImgUrl = "images/pipe.png";
            contentCode = "核心代码:\r\n"
                    + "public static void homework.service.main(String[] args) throws IOException {\r\n"
                    + "        File inFile = new File(\"files/input.txt\");\r\n"
                    + "        File outFile = new File(\"files/output.txt\");\r\n"
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
                    + "    }";
        }
        else if(type == TypeEnum.EVENT.getValue()) {
            contentDescription = "指多个对象间存在一对多的依赖关系，当一个对象的状态发生改变时\n" +
                    "，所有依赖于它的对象都得到通知并被自动更新。这种模式有时又称作发\n" +
                    "布-订阅模式、模型-视图模式，它是对象行为型模式。";
            contentImgUrl = "images/event.png";
            contentCode = "核心代码:\r\n"
                    + "public static void homework.service.main(String[] args) {\r\n"
                    + "        //创建主题\r\n"
                    + "        KWICSubject kwicSubject = new KWICSubject();\r\n"
                    + "        //创建观察者\r\n"
                    + "        Input input = new Input(\"files/input.txt\");\r\n"
                    + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                    + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                    + "        Output output = new Output(alphabetizer.getKwicList(), \"files/output.txt\");\r\n"
                    + "\r\n"
                    + "        // 将观察者加入主题\r\n"
                    + "        kwicSubject.addObserver(input);\r\n"
                    + "        kwicSubject.addObserver(shift);\r\n"
                    + "        kwicSubject.addObserver(alphabetizer);\r\n"
                    + "        kwicSubject.addObserver(output);\r\n"
                    + "        // 逐步调用各个观察者\r\n"
                    + "        kwicSubject.startKWIC();\r\n"
                    + "    }";

        } else {
            return null;
        }

        JTextArea desc = new JTextArea(contentDescription);
        JScrollPane scrollDesc = new JScrollPane(desc);

        scrollDesc.setFont(new Font(null, Font.ITALIC, 100));
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();

        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.gridheight = 2;
        gridBagConstraints1.weightx = 1;
        gridBagConstraints1.weighty = 0.5;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;

        panel.add(scrollDesc, gridBagConstraints1);


        ImageIcon img = new ImageIcon(contentImgUrl);

        img.setImage(img.getImage().getScaledInstance(500, 340, 0));

        JLabel label = new JLabel(img);
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();

        gridBagConstraints2.gridx = 1;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.weightx = 0.5;
        gridBagConstraints2.weighty = 0.5;
        gridBagConstraints2.fill = GridBagConstraints.BOTH;

        panel.add(label, gridBagConstraints2);

        JTextArea result = new JTextArea("运行结果");
        JScrollPane scrollResult = new JScrollPane(result);

        scrollResult.setFont(new Font(null, Font.PLAIN, 80));
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();

        gridBagConstraints5.gridy = 0;
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.weightx = 0.5;
        gridBagConstraints5.weighty = 0.5;
        gridBagConstraints5.gridheight = 1;

        gridBagConstraints5.fill = GridBagConstraints.BOTH;

        panel.add(scrollResult, gridBagConstraints5);

        JTextArea code = new JTextArea(contentCode);
        JScrollPane scrollCode = new JScrollPane(code);

        scrollResult.setFont(new Font(null, Font.PLAIN, 10));
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();

        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.weightx = 0.5;
        gridBagConstraints3.weighty = 0.5;


        gridBagConstraints3.fill = GridBagConstraints.BOTH;

        panel.add(scrollCode, gridBagConstraints3);

        JButton button = new JButton("运行");
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();

        button.setFont(new Font(null, Font.BOLD, 30));
        button.setForeground(Color.RED);
        button.setBackground(Color.WHITE);

        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.weightx = 0.5;
        gridBagConstraints4.weighty = 0.5;

        gridBagConstraints4.ipadx = 200;
        gridBagConstraints4.ipady = 100;

        panel.add(button, gridBagConstraints4);

        //分情况加监听器
        if(type == TypeEnum.MAIN.getValue()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //运行
                        result.setText("主程序-子程序演示运行结果：");//表示清空
                        FileUtil.clearFile();
                        Demo1.main(filePath);
                        String resultContent = FileUtil.getFileContent();
                        result.append(resultContent);
                    }
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } else if(type == TypeEnum.OBJECT.getValue()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //运行
                        result.setText("面向对象演示运行结果：");
                        FileUtil.clearFile();//清空文件内容
                        ObjectMain.main(filePath);
                        //读取文件，显示结果
                        String resultContent = FileUtil.getFileContent();
                        result.append(resultContent);
                    }
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } else if(type == TypeEnum.EVENT.getValue()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //运行
                        result.setText("事件系统-观察者模式演示运行结果：");//表示清空
                        FileUtil.clearFile();//清空文件内容
                        EventMain.main(filePath);
                        //读取文件，显示结果
                        String resultContent = FileUtil.getFileContent();
                        result.append(resultContent);
                    }
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } else if(type == TypeEnum.PIPE.getValue()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //运行
                        result.setText("管道-过滤演示运行结果：");//表示清空
                        FileUtil.clearFile();//清空文件内容
                        PipeMain.main(filePath);
                        //读取文件，显示结果
                        String resultContent = FileUtil.getFileContent();
                        result.append(resultContent);
                    }
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } else {
            return null;
        }

        return panel;
    }


}
