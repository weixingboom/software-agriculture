package Total;

import Total.util.CodeUtil;
import Total.util.ContentUtil;
import Total.util.FileUtil;
import Total.util.ImageUtil;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import java.util.HashMap;

import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


public class Main {

	public static Map<String,Integer> typeMap = new HashMap<>();
	static {

		typeMap.put("主程序-子程序",0);
		typeMap.put("面向对象",1);
		typeMap.put("事件系统",2);
		typeMap.put("管道-过滤",3);

	}
	public static void main(String[] args){
		JFrame frame = new JFrame("软件体系结构实验软件");
		frame.setSize(1500, 800);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTabbedPane tab = new JTabbedPane();
		//分别设置四种panel的样式，大同小异，可以通过同一个模板产生
		tab.add("主程序-子程序",createPanel(0));
		tab.add("面向对象",createPanel(1));
		tab.add("事件系统",createPanel(2));
		tab.add("管道-过滤",createPanel(3));
		tab.setSelectedIndex(1);

		frame.setContentPane(tab);
		frame.setVisible(true);
	}
	private static JComponent createPanel(Integer type) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		String content_desc = new String();
		String content_imgurl = new String();
		String content_code = new String();
		if(type.equals(typeMap.get("主程序-子程序"))) {
			content_desc = CodeUtil.Codelist.get(type);
			content_imgurl = ImageUtil.Imagelist.get(type);
			content_code = ContentUtil.ContentList.get(type);
		}
		else if(type.equals(typeMap.get("面向对象"))) {
			content_desc =CodeUtil.Codelist.get(type);
			content_imgurl = ImageUtil.Imagelist.get(type) ;
			content_code =ContentUtil.ContentList.get(type) ;
		}
		else if(type.equals(typeMap.get("事件系统"))) {
			content_desc = CodeUtil.Codelist.get(type);
			content_imgurl =  ImageUtil.Imagelist.get(type);
			content_code =ContentUtil.ContentList.get(type) ;
		}
		else if(type.equals(typeMap.get("管道-过滤"))) {
			content_desc =CodeUtil.Codelist.get(type) ;
			content_imgurl =  ImageUtil.Imagelist.get(type);
			content_code =ContentUtil.ContentList.get(type) ;
		}
		else {
			return null;
		}
		//分为5块，文字说明、原理图、代码、运行按钮、展示区域
		JTextArea desc = new JTextArea(content_desc);
		JScrollPane scroll_desc = new JScrollPane(desc);
		scroll_desc.setFont(new Font(null, Font.PLAIN, 50));
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;//行
		gridBagConstraints_1.gridx = 1;//列
		gridBagConstraints_1.weightx = 0.2;
		gridBagConstraints_1.weighty = 0.3;
		gridBagConstraints_1.fill = GridBagConstraints.BOTH;
		panel.add(scroll_desc,gridBagConstraints_1);
		
		
		ImageIcon img = new ImageIcon(content_imgurl);
		//注意对每张图片改变一定的比例
		img.setImage(img.getImage().getScaledInstance(400, 340, 0));
		JLabel label = new JLabel(img);
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 0;//行
		gridBagConstraints_2.gridx = 0;//列

		gridBagConstraints_2.weightx = 0.3;
		gridBagConstraints_2.weighty = 0.3;
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		panel.add(label,gridBagConstraints_2);
		
		final JTextArea result = new JTextArea("运行结果");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 20));
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 2;//行
		gridBagConstraints_5.gridx = 0;//列
		gridBagConstraints_5.gridheight = 2;
		gridBagConstraints_5.weightx = 0.9;
		gridBagConstraints_5.weighty = 0.9;
		gridBagConstraints_5.fill = GridBagConstraints.BOTH;
		panel.add(scroll_result,gridBagConstraints_5);
		
		JTextArea code = new JTextArea(content_code);
		JScrollPane scroll_code = new JScrollPane(code);
		scroll_result.setFont(new Font(null, Font.PLAIN, 10));
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 1;//行
		gridBagConstraints_3.gridx = 0;//列
		gridBagConstraints_3.weightx = 1;
		gridBagConstraints_3.weighty =1;
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		panel.add(scroll_code,gridBagConstraints_3);
		
		JButton button = new JButton("运行程序");
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		button.setFont(new Font(null, Font.BOLD, 30));
		button.setForeground(Color.GRAY);
		button.setBackground(Color.WHITE);
		gridBagConstraints_4.gridy = 1;//行
		gridBagConstraints_4.gridx = 1;//列
		gridBagConstraints_4.weightx = 0.1;
		gridBagConstraints_4.weighty = 0.5;
		gridBagConstraints_4.ipadx = 100;
		gridBagConstraints_4.ipady = 100;
		panel.add(button,gridBagConstraints_4);
		
		//分情况加监听器
		if (part(type, result, button)) return null;

		return panel;
	}

	private static boolean part(int type, JTextArea result, JButton button) {
		if(type == 0) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("主程序-子程序演示运行结果：");//表示清空
						FileUtil.clearFile();//清空文件内容
						test1.Main.main(null);
	    				//读取文件，显示结果
						String result_content = FileUtil.getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 1) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("面向对象演示运行结果：");//表示清空
						FileUtil.clearFile();//清空文件内容
						test2.Main.main(null);
	    				//读取文件，显示结果
						String result_content = FileUtil.getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 2) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("事件系统-观察者模式演示运行结果：");//表示清空
						FileUtil.clearFile();//清空文件内容
						test3.Main.main(null);
	    				//读取文件，显示结果
						String result_content = FileUtil.getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else if(type == 3) {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//运行
						result.setText("管道-过滤演示运行结果：");//表示清空
						FileUtil.clearFile();//清空文件内容
						test4.Main.main(null);
	    				//读取文件，显示结果
						String result_content = FileUtil.getFileContent();
						result.append(result_content);
					}
					catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			});
		}
		else {
			return true;
		}
		return false;
	}


}