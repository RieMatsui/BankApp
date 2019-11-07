package netbanking0219;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class NetbankingUI07 {

	private JFrame frame;
	private JTextField tfAccount;
	private JPasswordField pfPassword;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI07 window = new NetbankingUI07();
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



	public NetbankingUI07() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		frame.setBounds(100, 100, 706, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ログイン");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(38, 40, 357, 33);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("すでに新規登録可能なお客様は「口座番号」と「ログインパスワード」");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 94, 542, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("をご入力のうえ「ログイン」ボタンを押してください。");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label.setBounds(38, 126, 542, 33);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("○ご本人情報");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(38, 217, 150, 33);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("口座番号");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(38, 301, 121, 33);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("暗証番号(再確認)");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(38, 395, 144, 33);
		frame.getContentPane().add(label_3);



		JLabel lblacbd = new JLabel("(例:acbd123)");
		lblacbd.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblacbd.setBounds(446, 395, 144, 33);
		frame.getContentPane().add(lblacbd);

		JLabel label_5 = new JLabel("※半角英数字で7桁以上15桁で入力してください");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_5.setBounds(222, 440, 409, 24);
		frame.getContentPane().add(label_5);


		JLabel label_4 = new JLabel("-------------------------------------------------");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_4.setBounds(25, 575, 640, 24);
		frame.getContentPane().add(label_4);

		JButton btnNewButton = new JButton("ログイン");
		btnNewButton.addMouseListener(new MouseAdapter() {

			//次へボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {

				String str_accountNum = null;
				String str_password = null;

				str_accountNum = tfAccount.getText();
				str_password = pfPassword.getText();
				System.out.println(str_accountNum);
				System.out.println(str_password);

				DTO_netbankingUI07 vrb_dto_UI07 = new DTO_netbankingUI07(str_accountNum,
																		 str_password);

				BL_netbankingUI07 vrb_bl_UI07 = new BL_netbankingUI07();

				if (vrb_bl_UI07.checkInfomation(vrb_dto_UI07)) {
					NetbankingUI01.main(null);
					frame.setVisible(false);
				}


			}
		});

		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(256, 513, 157, 33);
		frame.getContentPane().add(btnNewButton);


		JButton button = new JButton("戻る");
		button.addMouseListener(new MouseAdapter() {

			//戻るボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {

				NetbankingUI01.main(null);
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button.setBounds(25, 634, 157, 33);
		frame.getContentPane().add(button);

		tfAccount = new JTextField();
		tfAccount.setBounds(194, 304, 229, 33);
		frame.getContentPane().add(tfAccount);
		tfAccount.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.setBounds(194, 395, 229, 34);
		frame.getContentPane().add(pfPassword);

	}

}
