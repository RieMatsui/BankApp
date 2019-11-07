package netbanking00;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NetbankingUI05 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JPasswordField pfPassword;
	private JLabel label_8;
	private JTextField tfSei;
	private JTextField tfMai;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tfMiseban;
	private JTextField tfKamoku;
	private JTextField tfKouza;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI05 window = new NetbankingUI05();
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
	public NetbankingUI05() {
		initialize();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("銀行システム操作＞新規お申込み");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(50, 55, 329, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("新規お申込みのお客様");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 118, 168, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("お客様情報をご確認の上、「次へ」ボタンを押してください");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label.setBounds(50, 168, 411, 24);
		frame.getContentPane().add(label);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(50, 220, 602, 30);
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

		textField_4 = new JTextField();
		textField_4.setText("暗証番号入力");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(SystemColor.activeCaptionBorder);
		textField_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		menuBar.add(textField_4);

		textField_2 = new JTextField();
		textField_2.setText("確認・実行");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.textHighlight);
		menuBar.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("受付終了");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(SystemColor.activeCaptionBorder);
		textField_3.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		menuBar.add(textField_3);

		label_1 = new JLabel("○ご本人様情報");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(50, 277, 112, 24);
		frame.getContentPane().add(label_1);

		label_3 = new JLabel("カナ氏名");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(50, 322, 106, 24);
		frame.getContentPane().add(label_3);

		label_2 = new JLabel("生年月日");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(50, 371, 86, 30);
		frame.getContentPane().add(label_2);

		label_4 = new JLabel("店番");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_4.setBounds(50, 418, 86, 30);
		frame.getContentPane().add(label_4);

		label_5 = new JLabel("科目");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_5.setBounds(50, 465, 86, 24);
		frame.getContentPane().add(label_5);

		label_6 = new JLabel("口座番号");
		label_6.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_6.setBounds(50, 514, 86, 30);
		frame.getContentPane().add(label_6);

		pfPassword = new JPasswordField();
		pfPassword.setBackground(SystemColor.control);
		pfPassword.setEditable(false);
		pfPassword.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		pfPassword.setBounds(168, 564, 187, 30);
		frame.getContentPane().add(pfPassword);

		JLabel label_7 = new JLabel("暗証番号");
		label_7.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_7.setBounds(50, 566, 411, 24);
		frame.getContentPane().add(label_7);

		label_8 = new JLabel("---------------------------------------------");
		label_8.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_8.setBounds(50, 624, 602, 24);
		frame.getContentPane().add(label_8);

		JButton btnNewButton = new JButton("次へ");
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(473, 565, 148, 30);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("戻る");
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button.setBounds(50, 666, 148, 30);
		frame.getContentPane().add(button);

		tfSei = new JTextField();
		tfSei.setEditable(false);
		tfSei.setBackground(SystemColor.control);
		tfSei.setBounds(168, 320, 176, 30);
		frame.getContentPane().add(tfSei);
		tfSei.setColumns(10);

		tfMai = new JTextField();
		tfMai.setEditable(false);
		tfMai.setBackground(SystemColor.control);
		tfMai.setColumns(10);
		tfMai.setBounds(409, 320, 176, 30);
		frame.getContentPane().add(tfMai);

		label_9 = new JLabel("年");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_9.setBounds(272, 371, 30, 30);
		frame.getContentPane().add(label_9);

		label_10 = new JLabel("月");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_10.setBounds(418, 371, 30, 30);
		frame.getContentPane().add(label_10);

		label_11 = new JLabel("日");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_11.setBounds(567, 371, 30, 30);
		frame.getContentPane().add(label_11);

		tfYear = new JTextField();
		tfYear.setEditable(false);
		tfYear.setColumns(10);
		tfYear.setBackground(SystemColor.menu);
		tfYear.setBounds(168, 372, 86, 30);
		frame.getContentPane().add(tfYear);

		tfMonth = new JTextField();
		tfMonth.setEditable(false);
		tfMonth.setColumns(10);
		tfMonth.setBackground(SystemColor.menu);
		tfMonth.setBounds(314, 371, 86, 30);
		frame.getContentPane().add(tfMonth);

		tfDay = new JTextField();
		tfDay.setEditable(false);
		tfDay.setColumns(10);
		tfDay.setBackground(SystemColor.menu);
		tfDay.setBounds(460, 371, 86, 30);
		frame.getContentPane().add(tfDay);

		tfMiseban = new JTextField();
		tfMiseban.setEditable(false);
		tfMiseban.setColumns(10);
		tfMiseban.setBackground(SystemColor.menu);
		tfMiseban.setBounds(168, 418, 131, 30);
		frame.getContentPane().add(tfMiseban);

		tfKamoku = new JTextField();
		tfKamoku.setEditable(false);
		tfKamoku.setColumns(10);
		tfKamoku.setBackground(SystemColor.menu);
		tfKamoku.setBounds(168, 468, 131, 30);
		frame.getContentPane().add(tfKamoku);

		tfKouza = new JTextField();
		tfKouza.setEditable(false);
		tfKouza.setColumns(10);
		tfKouza.setBackground(SystemColor.menu);
		tfKouza.setBounds(168, 514, 131, 30);
		frame.getContentPane().add(tfKouza);
	}
}
