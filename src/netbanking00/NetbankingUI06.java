package netbanking00;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NetbankingUI06 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI06 window = new NetbankingUI06();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NetbankingUI06() {
		initialize();


	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(50, 150, 577, 30);
		frame.getContentPane().add(menuBar);

		textField = new JTextField();
		textField.setText("ご利用規約");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(SystemColor.activeCaptionBorder);
		textField.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		menuBar.add(textField);

		textField_1 = new JTextField();
		textField_1.setText("認証情報入力");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(SystemColor.activeCaptionBorder);
		textField_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		menuBar.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("確認・実行");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);

		textField_4 = new JTextField();
		textField_4.setText("暗証番号入力");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(SystemColor.activeCaptionBorder);
		textField_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_4.setEditable(false);
	    textField_4.setColumns(10);
		menuBar.add(textField_4);

		textField_2.setForeground(SystemColor.activeCaptionBorder);
		textField_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		menuBar.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("受付完了");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.textHighlight);
		menuBar.add(textField_3);

		label = new JLabel("銀行システム操作＞新規お申込み");
		label.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		label.setBounds(50, 36, 329, 30);
		frame.getContentPane().add(label);

		label_1 = new JLabel("新規お申込みのお客様");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(50, 76, 168, 24);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("受付完了");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(50, 116, 168, 24);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("新規お申込みのお客様");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(50, 213, 532, 24);
		frame.getContentPane().add(label_3);

		label_4 = new JLabel("口座新規開設は、正常に完了いたしました。「操作メニューへ戻る」ボタンを押してください。");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_4.setBounds(50, 271, 532, 24);
		frame.getContentPane().add(label_4);

		label_5 = new JLabel("---------------------------------------------");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_5.setBounds(50, 614, 602, 24);
		frame.getContentPane().add(label_5);

		button = new JButton("操作メニューへ戻る");
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button.setBounds(241, 389, 190, 30);
		frame.getContentPane().add(button);
	}

}
