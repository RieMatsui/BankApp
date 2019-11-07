package netbanking00;
/**
 * @author WITC_Rie Mastui
 * @since 2017/0207
 * @virsion 01
 *
 * メニュー画面を作成
 * ボタンはログインをしないと押せないボタンが複数あり
 * ログインしないで押せるボタンは
 *
 * 「ご利用開始登録」
 * 「ログイン」
 * 「終了」
 *
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NetbankingUI01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI01 window = new NetbankingUI01();
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
	public NetbankingUI01() {
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

		JLabel lblNewLabel = new JLabel("銀行システム操作一覧");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(189, 30, 298, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ご覧になりたい項目を選択すると案内画面が開始します");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(41, 88, 497, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("ご利用開始登録");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//ご利用開始ボタンを押下したとき
			public void mouseClicked(MouseEvent e) {

				//利用規約画面を表示
				NetbankingUI02.main(null);
				//メニュー画面を閉じる
				frame.setVisible(false);

			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(44, 171, 157, 36);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("振込(新規登録)");
		button.setEnabled(false);
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(274, 171, 183, 36);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("パスワード変更");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 16));
		button_1.setBounds(44, 241, 157, 36);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("振込(登録先振込)");
		button_2.setEnabled(false);
		button_2.setFont(new Font("Dialog", Font.BOLD, 16));
		button_2.setBounds(274, 241, 183, 36);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("ログイン");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 16));
		button_3.setBounds(44, 318, 157, 36);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("登録口座残高");
		button_4.setEnabled(false);
		button_4.setFont(new Font("Dialog", Font.BOLD, 16));
		button_4.setBounds(45, 459, 157, 36);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("お預け入れ");
		button_5.setEnabled(false);
		button_5.setFont(new Font("Dialog", Font.BOLD, 16));
		button_5.setBounds(274, 459, 157, 36);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("お引き出し");
		button_6.setEnabled(false);
		button_6.setFont(new Font("Dialog", Font.BOLD, 16));
		button_6.setBounds(496, 459, 157, 36);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("終了");
		button_7.addMouseListener(new MouseAdapter() {

			//終了ボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {
				//メニュー画面を閉じる
				frame.setVisible(false);
			}
		});
		button_7.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button_7.setBounds(45, 595, 157, 36);
		frame.getContentPane().add(button_7);

		JLabel lblNewLabel_2 = new JLabel("はじめに");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(46, 150, 83, 17);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("振込");
		label.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		label.setBounds(274, 153, 83, 17);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("照会サービス");
		label_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		label_1.setBounds(46, 440, 107, 17);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("お預入れ");
		label_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		label_2.setBounds(274, 443, 83, 17);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("お引き出し");
		label_3.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		label_3.setBounds(497, 443, 83, 17);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("本サービス終了");
		label_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		label_4.setBounds(46, 578, 128, 17);
		frame.getContentPane().add(label_4);
	}
}
