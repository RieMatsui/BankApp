package netbanking00;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NetbankingUI02 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI02 window = new NetbankingUI02();
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
	public NetbankingUI02() {
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(47, 37, 274, 30);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("同意する");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//同意ボタンを押したとき
			@Override
			public void mouseClicked(MouseEvent e) {
				//個人情報入力画面を開く
				NetbankingUI03.main(null);
				//利用規約画面を閉じる
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(167, 416, 131, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel label = new JLabel("銀行システムご利用規定をよくお読みいただき、「同意します」をクリックしてください");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label.setBounds(47, 142, 627, 21);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("新規お申込みのお客様");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(47, 94, 152, 21);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("サービス利用規定");
		label_2.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		label_2.setBounds(47, 258, 152, 21);
		frame.getContentPane().add(label_2);

		JLabel lblNewLabel_1 = new JLabel("銀行サービス当行に次の取引依頼を行い、当行がその手続きを行うサービスをいいます。\r\n\r\n");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 307, 574, 21);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label_3 = new JLabel("なお、本サービスのご利用は日本国内在住の個人のお客さまに限定しており、お一人さまにつき一契約と\r\n\r\n");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(47, 329, 627, 21);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("させていただきます。");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_4.setBounds(47, 352, 627, 21);
		frame.getContentPane().add(label_4);

		JButton button = new JButton("同意しない");
		button.addMouseListener(new MouseAdapter() {
			//同意しないボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
											  "TESTMESSAGE>利用規約をお読みいただき同意ボタンを押してください",
											  "TESTMESSAGE>エラーです",
											  JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button.setBounds(381, 416, 131, 30);
		frame.getContentPane().add(button);

		JLabel label_5 = new JLabel("-------------------------------------------");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_5.setBounds(57, 482, 640, 24);
		frame.getContentPane().add(label_5);

		JButton button_1 = new JButton("戻る");
		button_1.addMouseListener(new MouseAdapter() {
			//戻るボタンを押すとメニュー画面に戻る
			@Override
			public void mouseClicked(MouseEvent e) {
				NetbankingUI01.main(null);
			}
		});
		button_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button_1.setBounds(34, 543, 131, 30);
		frame.getContentPane().add(button_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(47, 190, 602, 30);
		frame.getContentPane().add(menuBar);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(SystemColor.textHighlight);
		textField_1.setEditable(false);
		menuBar.add(textField_1);
		textField_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("ご利用規約");
		textField_1.setColumns(10);

		textField = new JTextField();
		textField.setForeground(SystemColor.activeCaptionBorder);
		textField.setEditable(false);
		menuBar.add(textField);
		textField.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("認証情報入力");
		textField.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setForeground(SystemColor.activeCaptionBorder);
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(textField_3);
		textField_3.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_3.setText("暗証番号入力");
		textField_3.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setForeground(SystemColor.activeCaptionBorder);
		textField_2.setEditable(false);
		menuBar.add(textField_2);
		textField_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_2.setText("確認・実行");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setForeground(SystemColor.activeCaptionBorder);
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(textField_4);
		textField_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_4.setText("受付終了");
		textField_4.setColumns(10);
	}

}
