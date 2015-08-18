//************************************************************************
// > File Name: Calculator.java
// > Author: niurenpeng
//************************************************************************
import javax.swing.*;
import java.awt.*;
public class Calculator {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Calculator");
		frame.setResizable(false);

		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		
		final JButton b1 = new JButton("+");
		final JButton b2 = new JButton("-");
		final JButton b3 = new JButton("*");
		final JButton b4 = new JButton("/");
		final JButton b5 = new JButton("ok");

		GridLayout grid = new GridLayout(2,5);
		contentPane.setLayout(grid);


		final JLabel l1 = new JLabel();
		final JLabel l2 = new JLabel("=");
		final JLabel l3 = new JLabel();

		final JTextField text1 = new JTextField();
		final JTextField text2 = new JTextField();
		
		contentPane.add(text1);
		contentPane.add(l1);
		contentPane.add(text2);
		contentPane.add(l2);
		contentPane.add(l3);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(b5);

		b1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				l1.setText(b1.getText());
			}
		});
		b2.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				l1.setText(b2.getText());
			}
		});
		b3.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				l1.setText(b3.getText());
			}
		});
		b4.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				l1.setText(b4.getText());
			}
		});
		b5.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (text1.getText().length() == 0 || text2.getText().length() == 0) {
					showErrorMessage("请输入正确数据");
					return;
				}
				if (l1.getText().length() == 0) {
					showErrorMessage("请选择操作!");
					return;
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
			}
		});

		frame.pack();
	}
	private static void showErrorMessage(String str) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, str, "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
	}
}

