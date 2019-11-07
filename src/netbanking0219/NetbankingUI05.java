package netbanking0219;

import java.awt.Color;
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
	private JTextField tfSitenmei;

	String str_SubjId = null;
	String str_birthday = null;
    String str_password = null;
	String str_creatUser = null;
	int num_userId = 0;
	int num_tmpUserId = 0;
	int num_acoountNo = 0;
	int num_BrncId = 0;
	String str_userId = null;
	String str_createUser = null;
    int num_miseban = 0;



	/**
	 * Launch the application.
	 */
	public static void main(final DTO_netbankingUI04 _paramDTO) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NetbankingUI05 window = new NetbankingUI05(_paramDTO);
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
	public NetbankingUI05(DTO_netbankingUI04 _paramDTO) {

		initialize(_paramDTO);



	}

	/**
	 * Initialize the contents of the frame.
	 * @param _paramDTO
	 * @param _paramDTO
	 */
	private void initialize(DTO_netbankingUI04 _paramDTO) {

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

		tfMiseban = new JTextField();
		tfMiseban.setBounds(138, 462, 176, 28);
		frame.getContentPane().add(tfMiseban);
		tfMiseban.setEditable(false);
		tfMiseban.setColumns(10);
		tfMiseban.setBackground(SystemColor.menu);

		tfSitenmei = new JTextField();
		tfSitenmei.setBounds(405, 462, 242, 28);
		frame.getContentPane().add(tfSitenmei);
		tfSitenmei.setEditable(false);
		tfSitenmei.setColumns(10);
		tfSitenmei.setBackground(SystemColor.menu);

		label_1 = new JLabel("○ご本人様情報");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(50, 290, 112, 24);
		frame.getContentPane().add(label_1);

		label_3 = new JLabel("カナ氏名");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(50, 354, 106, 24);
		frame.getContentPane().add(label_3);

		label_2 = new JLabel("生年月日");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(50, 403, 86, 30);
		frame.getContentPane().add(label_2);

		label_4 = new JLabel("店番");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_4.setBounds(50, 460, 86, 30);
		frame.getContentPane().add(label_4);

		label_5 = new JLabel("科目");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_5.setBounds(50, 515, 86, 24);
		frame.getContentPane().add(label_5);

		label_6 = new JLabel("支店名");
		label_6.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_6.setBounds(330, 460, 86, 30);
		frame.getContentPane().add(label_6);

		pfPassword = new JPasswordField();
		pfPassword.setBackground(SystemColor.control);
		pfPassword.setEditable(false);
		pfPassword.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		pfPassword.setBounds(138, 563, 176, 30);
		frame.getContentPane().add(pfPassword);

		JLabel label_7 = new JLabel("暗証番号");
		label_7.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_7.setBounds(50, 566, 411, 24);
		frame.getContentPane().add(label_7);

		label_8 = new JLabel("---------------------------------------------");
		label_8.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label_8.setBounds(50, 624, 602, 24);
		frame.getContentPane().add(label_8);

		tfSei = new JTextField();
		tfSei.setEditable(false);
		tfSei.setBackground(SystemColor.control);
		tfSei.setBounds(138, 352, 176, 30);
		frame.getContentPane().add(tfSei);
		tfSei.setColumns(10);

		tfMai = new JTextField();
		tfMai.setEditable(false);
		tfMai.setBackground(SystemColor.control);
		tfMai.setColumns(10);
		tfMai.setBounds(356, 352, 176, 30);
		frame.getContentPane().add(tfMai);

		label_9 = new JLabel("年");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_9.setBounds(237, 403, 30, 30);
		frame.getContentPane().add(label_9);

		label_10 = new JLabel("月");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_10.setBounds(377, 403, 30, 30);
		frame.getContentPane().add(label_10);

		label_11 = new JLabel("日");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_11.setBounds(530, 403, 30, 30);
		frame.getContentPane().add(label_11);

		tfYear = new JTextField();
		tfYear.setEditable(false);
		tfYear.setColumns(10);
		tfYear.setBackground(SystemColor.menu);
		tfYear.setBounds(138, 404, 86, 30);
		frame.getContentPane().add(tfYear);

		tfMonth = new JTextField();
		tfMonth.setEditable(false);
		tfMonth.setColumns(10);
		tfMonth.setBackground(SystemColor.menu);
		tfMonth.setBounds(279, 404, 86, 30);
		frame.getContentPane().add(tfMonth);

		tfDay = new JTextField();
		tfDay.setEditable(false);
		tfDay.setColumns(10);
		tfDay.setBackground(SystemColor.menu);
		tfDay.setBounds(426, 404, 86, 30);
		frame.getContentPane().add(tfDay);

		tfKamoku = new JTextField();
		tfKamoku.setEditable(false);
		tfKamoku.setColumns(10);
		tfKamoku.setBackground(SystemColor.menu);
		tfKamoku.setBounds(138, 513, 176, 30);
		frame.getContentPane().add(tfKamoku);

		String str_sei = null;
		String str_mei = null;
		String str_year = null;
		String str_month = null;
		String str_day = null;
		String str_miseban = null;
		String str_shitenmei = null;
		String str_kamoku = null;

		//初期値を代入
		str_sei = _paramDTO.getStr_sei();
		str_mei = _paramDTO.getStr_mei();
		str_birthday = _paramDTO.getStr_birthday();
		str_year = str_birthday.substring(0, 4);
		str_month = str_birthday.substring(5, 7);
		str_day = str_birthday.substring(8, str_birthday.length());
		num_miseban = _paramDTO.getNum_brId();
		str_miseban = String.valueOf(num_miseban);
		str_miseban = String.format("%3s",str_miseban).replace(" ", "0");
		str_shitenmei = _paramDTO.getStr_brName();
		str_kamoku =  _paramDTO.getStr_subName();
		str_SubjId =  String.valueOf(_paramDTO.getNum_subId());
		str_password = _paramDTO.getStr_pwCfm();
		str_creatUser = _paramDTO.getStr_createName();
		num_tmpUserId = _paramDTO.getNum_userId();


		//各部品の初期値を代入
		tfSei.setText(str_sei);
		tfMai.setText(str_mei);
		tfYear.setText(str_year);
		tfMonth.setText(str_month);
		tfDay.setText(str_day);
		tfMiseban.setText(str_miseban);
		tfSitenmei.setText(str_shitenmei);
		tfKamoku.setText(str_kamoku);
		pfPassword.setText(str_password);
		setStr_birthday(_paramDTO.getStr_birthday());
		setStr_creatUser(_paramDTO.getStr_createName());
		setNum_BrncId(Integer.valueOf(str_miseban));


		JButton btnNewButton = new JButton("次へ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				DTO_userTable_netbankingUI05 vrb_t_user = new DTO_userTable_netbankingUI05(


						num_userId,
						num_tmpUserId,
						str_password,
						getStr_birthday(),
						num_acoountNo,
						timestamp,
						getStr_creatUser(),
						str_SubjId,
						num_BrncId
						);

				System.out.println(num_tmpUserId);
				System.out.println(num_userId);
				System.out.println(str_password);
				System.out.println(num_acoountNo);
				System.out.println(getStr_birthday());
				System.out.println(timestamp);
				System.out.println(getStr_creatUser());
				System.out.println(str_SubjId);
				System.out.println(num_BrncId);


				BL_netbankingUI05 vrb_bl_UI5 = new BL_netbankingUI05();


				if (vrb_bl_UI5.finishBankRegister(vrb_t_user)) {

					NetbankingUI06.main(vrb_t_user);
					frame.setVisible(false);
				}

			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(405, 563, 148, 30);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("戻る");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NetbankingUI03.main(null);
			}
		});
		button.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		button.setBounds(50, 666, 148, 30);
		frame.getContentPane().add(button);

	}

	public String getStr_birthday() {
		return str_birthday;
	}

	public void setStr_birthday(String str_birthday) {
		this.str_birthday = str_birthday;
	}

	public String getStr_creatUser() {
		return str_creatUser;
	}

	public void setStr_creatUser(String str_creatUser) {
		this.str_creatUser = str_creatUser;
	}

	public int getNum_BrncId() {
		return num_BrncId;
	}

	public void setNum_BrncId(int num_BrncId) {
		this.num_BrncId = num_BrncId;
	}


}
