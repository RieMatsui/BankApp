package netbanking0214;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NetbankingUI04 {

	private JFrame frame;
	private JTextField tfPassword;
	private JTextField tfPwConf;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private int error = 0;
	private String str_userId = null;
	private String str_userPW = null;
	private String str_sei = null;
	private String str_mei = null;
	private String str_birthday = null;
	private Timestamp timestamp = null;
	private String str_createName = null;
	private int num_brId = 0;
	private String str_brName = null;
	private int num_subId = 0;
	private String str_subName = null;


	/**
	 * Launch the application.
	 */
	public static void main(final DTO_tmp_netbanking _paramDTO) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI04 window = new NetbankingUI04(_paramDTO);
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
	public static String[] getSaveData(String[] _paramData) {
		String[] array = _paramData;
		return array;
	}


	public NetbankingUI04(DTO_tmp_netbanking _paramData) {
		initialize();
		str_userId = _paramData.getStr_userId();
		tfPassword.setText(str_userPW);
		str_sei = _paramData.getStr_sei();
		str_mei = _paramData.getStr_mei();
		str_birthday = _paramData.getStr_birthday();
		timestamp = _paramData.getTimestamp();
		str_createName = _paramData.getStr_createName();
		num_brId = _paramData.getNum_brId();
		str_brName = _paramData.getStr_brName();
		num_subId = _paramData.getNum_subId();
		str_subName = _paramData.getStr_subName();

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

		JLabel lblNewLabel = new JLabel("銀行システム操作＞新規お申込み");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(38, 40, 357, 33);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("新規お申込みのお客様");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 94, 341, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("暗証番号ご入力の上、「次へ」ボタンを押してください");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label.setBounds(38, 147, 341, 33);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("○ご本人情報");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(38, 275, 341, 33);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("暗証番号");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(38, 360, 121, 33);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("暗証番号(再確認)");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(38, 447, 144, 33);
		frame.getContentPane().add(label_3);

		tfPassword = new JTextField();
		tfPassword.setBounds(212, 365, 201, 24);
		frame.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);

		tfPwConf = new JTextField();
		tfPwConf.setColumns(10);
		tfPwConf.setBounds(212, 452, 201, 24);
		frame.getContentPane().add(tfPwConf);

		JLabel lblacbd = new JLabel("(例:acbd123)");
		lblacbd.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblacbd.setBounds(436, 447, 144, 33);
		frame.getContentPane().add(lblacbd);

		JLabel label_5 = new JLabel("※半角英数字で7桁以上15桁で入力してください");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_5.setBounds(194, 506, 409, 24);
		frame.getContentPane().add(label_5);


		JLabel label_4 = new JLabel("-------------------------------------------------");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_4.setBounds(25, 613, 640, 24);
		frame.getContentPane().add(label_4);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(38, 202, 602, 30);
		frame.getContentPane().add(menuBar);

		textField_2 = new JTextField();
		textField_2.setText("ご利用規約");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(SystemColor.activeCaptionBorder);
		textField_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		menuBar.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("認証情報入力");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(SystemColor.activeCaptionBorder);
		textField_3.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		menuBar.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.textHighlight);
		menuBar.add(textField_4);
		textField_4.setText("暗証番号入力");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(SystemColor.text);
		textField_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_4.setEditable(false);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setText("確認・実行");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(SystemColor.activeCaptionBorder);
		textField_5.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		menuBar.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("受付終了");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(SystemColor.activeCaptionBorder);
		textField_6.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		menuBar.add(textField_6);

		JButton btnNewButton = new JButton("次へ");
		btnNewButton.addMouseListener(new MouseAdapter() {

			//次へボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {

				String str_password = null;
				String str_pwCfm = null;


				str_password = tfPassword.getText();
				str_pwCfm = tfPwConf.getText();

				DTO_netbankingUI04 vrb_DTOUI4 = new DTO_netbankingUI04(str_userId,
																	   str_password,
																	   str_sei,
																	   str_mei,
																	   str_birthday,
																	   timestamp,
																	   str_createName,
																	   num_brId,
																	   str_brName,
																	   num_subId,
																	   str_subName,
																	   str_pwCfm);




		        BL_netbankingUI04 vrb_BL04 = new BL_netbankingUI04();

		        System.out.println();

		        if (!vrb_BL04.cfmSamePw(vrb_DTOUI4) && vrb_BL04.checkAvailableInfomation(vrb_DTOUI4)){
		        	countTime();
		        	System.out.println(error);
		        	if (error >= 3) {
		        		vrb_BL04.createErrorData(vrb_DTOUI4);
						NetbankingUI01.main(null);
						frame.setVisible(false);

					}
				}

		        else if (vrb_BL04.cfmSamePw(vrb_DTOUI4) && vrb_BL04.checkAvailableInfomation(vrb_DTOUI4)) {
		        	NetbankingUI05.main(vrb_DTOUI4);
					frame.setVisible(false);

				}


			}
		});

		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(256, 570, 157, 33);
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
		button.setBounds(25, 661, 157, 33);
		frame.getContentPane().add(button);

	}

	public int countTime() {

		return error += 1;

	}

}
