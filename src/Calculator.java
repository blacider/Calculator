//************************************************************************
// > File Name: Calculator.java
// > Author: niurenpeng
//************************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
	public static void main(String[] args) {
		new Calculator();
	}
	private JButton[] b = new JButton[5];
	private JFrame frame;
	private JPanel contentPane;
	private GridLayout grid;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JTextField text1;
	private JTextField text2;
	public Calculator() {
		initComponent();
	}
	private void initComponent() {
		frame = new JFrame();

		initFrame();

		contentPane = new JPanel();
		
		frame.setContentPane(contentPane);
		
		grid = new GridLayout(2,5);
		contentPane.setLayout(grid);

		b[0] = new JButton("+");
		b[1] = new JButton("-");
		b[2] = new JButton("*");
		b[3] = new JButton("/");
		b[4] = new JButton("ok");

		l1 = new JLabel();
		l2 = new JLabel("=");
		l3 = new JLabel();

		text1 = new JTextField();
		text2 = new JTextField();

		addComponent();
	}
	private void addComponent() {
		contentPane.add(text1);
		contentPane.add(l1);
		contentPane.add(text2);
		contentPane.add(l2);
		contentPane.add(l3);
		for (int i = 0; i < b.length; i++) contentPane.add(b[i]);

		addListener();

		frame.pack();
	}
	private void addListener() {
		for (int i = 0; i < b.length; i++) b[i].addActionListener(this);
	}
	private void initFrame() {
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Calculator");
		frame.setResizable(false);
	}
	public void actionPerformed (ActionEvent e){
  		String op = e.getActionCommand();
  		switch(op) {
			case "+":
			case "-":
			case "*":
			case "/":
				l1.setText(op);
				break;
			case "ok":
				if (text1.getText().length() == 0 || text2.getText().length() == 0) {
					showErrorMessage("请输入正确数据");
					break;
				}
				if (l1.getText().length() == 0) {
					showErrorMessage("请选择操作!");
					break;
				}
				Float val1 = Float.parseFloat(text1.getText());
				Float val2 = Float.parseFloat(text2.getText());
				switch(l1.getText()) {
					case "+":
						l3.setText(String.valueOf(val1+val2));
						break;
					case "-":
						l3.setText(String.valueOf(val1-val2));
						break;
					case "*":
						l3.setText(String.valueOf(val1*val2));
						break;
					case "/":
						if (Float.compare(val2, 0.0f) == 0) {
							showErrorMessage("请输入正确数据");
							return;
						}
						l3.setText(String.valueOf(val1/val2));
						break;
				}
				break;
		}
 	}
	private void showErrorMessage(String str) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, str, "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	}
}

