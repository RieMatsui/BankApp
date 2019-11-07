package netbanking0219;
/**
 * @author WITC_Rie Matsui
 * @since 2017/02/07
 * @viesion 01
 *
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NetbankingUI03 {

	private JFrame frame;
	private JTextField tfSei;
	private JTextField tfMei;
	private JTextField tfSitenmei;
	private JTextField tfKamoku;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	//メンバ変数をコンボボックスを定義
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JComboBox cbMiseban;

	//メンバ変数として口座番号を定義
	private String kouzanum = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetbankingUI03 window = new NetbankingUI03();
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
	public NetbankingUI03() {
		initialize();
		//初期値を代入
		CalendarEnvSetting.createNen(cbYear);
		CalendarEnvSetting.createTuki(cbMonth);
		CalendarEnvSetting.createDay(cbDay, 0);
		CalendarEnvSetting.createMiseban(cbMiseban);

	}
	private int calcLastDay(int year ,int month) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month -1);
		cal.set(Calendar.DATE, 1);

		//与えられた日付を返す
		return cal.getActualMaximum(Calendar.DATE);
	}

	public String getBranchName(String _paramBranchID) {


		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setBounds(100, 100, 703, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tfSitenmei = new JTextField();
		tfSitenmei.setEditable(false);
		tfSitenmei.setColumns(10);
		tfSitenmei.setBounds(378, 396, 277, 26);
		frame.getContentPane().add(tfSitenmei);

		cbMiseban = new JComboBox();
		cbMiseban.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (cbMiseban.getSelectedIndex()> 0 ) {

					JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
					Connection vrb_con = null;
					String res =null;

					try {
						vrb_con = vrb_abs.dbConection();
					    res = vrb_abs.getSitenMei(vrb_con,((String)cbMiseban.getSelectedItem()));
					    System.out.println(res);
					    tfSitenmei.setText(res);


					} catch (SQLException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
				}

			}
		});
		cbMiseban.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));;
		cbMiseban.setBounds(145, 397, 87, 23);
		frame.getContentPane().add(cbMiseban);

		cbYear = new JComboBox();
		cbYear.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		cbYear.addItemListener(new ItemListener() {
			//cbYearのitemの状態が変化したとき
			public void itemStateChanged(ItemEvent e) {
				//選択したコンボボックスのアイテムの配列が0以上のとき
				//配列の最初は数字に変換できない文字列のため
				if (cbYear.getSelectedIndex() > 0 && cbMonth.getSelectedIndex() > 0) {

					//選択された「年」アイテムの文字列を整数に変換して代入
					int year = Integer.parseInt((String)cbYear.getSelectedItem());
					//選択された「月」アイテムの文字列を整数型に変換して代入
					int month = Integer.parseInt((String)cbMonth.getSelectedItem());
					//日時の取得
					CalendarEnvSetting.createDay(cbDay, calcLastDay(year, month));
				}
			}
		});
		cbYear.setBounds(145, 325, 87, 25);
		frame.getContentPane().add(cbYear);

		cbMonth = new JComboBox();
		cbMonth.addItemListener(new ItemListener() {
			//cbMonthのitemの状態が変化したとき
			public void itemStateChanged(ItemEvent e) {
				//選択したコンボボックスのアイテムの配列が0以上のとき
				//配列の最初は数字に変換できない文字列のため
				if (cbYear.getSelectedIndex() > 0 && cbMonth.getSelectedIndex() > 0) {
					int year = Integer.parseInt((String)cbYear.getSelectedItem());
					int month = Integer.parseInt((String)cbMonth.getSelectedItem());
					CalendarEnvSetting.createDay(cbDay, calcLastDay(year, month));
				}

			}
		});
		cbMonth.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		cbMonth.setBounds(291, 325, 87, 25);
		frame.getContentPane().add(cbMonth);

		cbDay = new JComboBox();
		cbDay.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		cbDay.setBounds(450, 325, 87, 25);
		frame.getContentPane().add(cbDay);

		tfSei = new JTextField();
		tfSei.setBounds(212, 267, 143, 26);
		frame.getContentPane().add(tfSei);
		tfSei.setColumns(10);

		tfMei = new JTextField();
		tfMei.setColumns(10);
		tfMei.setBounds(430, 266, 143, 26);
		frame.getContentPane().add(tfMei);


		JLabel lblNewLabel = new JLabel("銀行システム操作＞新規お申込み");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(40, 39, 292, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("新規お申込みのお客様");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 93, 248, 25);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("「ご本人情報」「代表口座情報」を入力の上「次へ」ボタンを押してください");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(40, 128, 437, 25);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("○ご本人情報");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label.setBounds(37, 230, 225, 25);
		frame.getContentPane().add(label);

		JLabel lblNewLabel_3 = new JLabel("カナ氏名");
		lblNewLabel_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(40, 273, 95, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblS = new JLabel("姓");
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		lblS.setBounds(147, 269, 40, 24);
		frame.getContentPane().add(lblS);

		JLabel label_2 = new JLabel("名");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_2.setBounds(378, 273, 40, 16);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("生年月日");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_3.setBounds(40, 332, 95, 16);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("年");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_4.setBounds(246, 330, 40, 14);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("月");
		label_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_5.setBounds(390, 328, 40, 16);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("店番");
		label_6.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_6.setBounds(40, 400, 95, 16);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("科目");
		label_7.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_7.setBounds(40, 475, 95, 16);
		frame.getContentPane().add(label_7);

		JLabel label_9 = new JLabel("支店名");
		label_9.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_9.setBounds(300, 400, 95, 16);
		frame.getContentPane().add(label_9);

		JLabel label_1 = new JLabel("日");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(556, 328, 40, 16);
		frame.getContentPane().add(label_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(40, 172, 602, 30);
		frame.getContentPane().add(menuBar);


		textField_4 = new JTextField();
		textField_4.setText("ご利用規約");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(SystemColor.activeCaptionBorder);
		textField_4.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		menuBar.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.textHighlight);
		textField_5.setForeground(SystemColor.text);
		textField_5.setText("認証情報入力");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		menuBar.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setForeground(SystemColor.activeCaptionBorder);
		textField_6.setText("暗証番号入力");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		menuBar.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setForeground(SystemColor.activeCaptionBorder);
		textField_7.setText("確認・実行");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		menuBar.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setForeground(SystemColor.activeCaptionBorder);
		textField_8.setText("受付終了");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		menuBar.add(textField_8);

		tfKamoku = new JTextField();
		tfKamoku.setEditable(false);
		tfKamoku.setBackground(SystemColor.control);
		tfKamoku.setText("普通");
		tfKamoku.setColumns(10);
		tfKamoku.setBounds(147, 471, 143, 26);
		frame.getContentPane().add(tfKamoku);

		JButton btnNewButton = new JButton("次へ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//次へボタンを押下したとき
			@Override
			public void mouseClicked(MouseEvent e) {


				//「姓」
				String str_sei = null;
				//「名」
				String str_mei = null;
				//「年」
				String str_year = null;
				//「月」
				String str_month = null;
				//「日」
				String str_day = null;
				//文字列データ「店番」を初期化
				String str_miseban = null;
				//文字列データ「科目」を初期化
				String str_kamoku = null;
				//文字列データ「支店名」を初期化
				String str_shitenmei = null;

				//「姓」を取得
				str_sei = tfSei.getText();
				System.out.println(str_sei);
				//「名」を取得
				str_mei = tfMei.getText();
				System.out.println(str_mei);
				//「年」を取得
				str_year =(String)cbYear.getSelectedItem();
				System.out.println(str_year);
				//「月」を取得
				str_month = (String)cbMonth.getSelectedItem();
				System.out.println(str_month);
				//「日」を取得
				str_day = (String)cbDay.getSelectedItem();
				System.out.println(str_day);
				//「店番」を取得
				str_miseban = (String) cbMiseban.getSelectedItem();
				System.out.println(str_miseban);
				//「科目」を取得
				str_kamoku = tfKamoku.getText();
				System.out.println(str_kamoku);
				//「支店名」を取得
				str_shitenmei = tfSitenmei.getText();
				System.out.println(str_shitenmei);
				//ふりがなの取得
				StringBuilder sbFurigana = new StringBuilder();
				sbFurigana.append(str_sei);
				sbFurigana.append(str_mei);
				System.out.println(sbFurigana.toString());

				//誕生日の取得
				StringBuilder sbBirthday = new StringBuilder();

				str_month = String.format("%2s",str_month).replace(" ", "0");
				str_day = String.format("%2s", str_day).replace(" ", "0" );


				sbBirthday.append(str_year);
				sbBirthday.append("/");
				sbBirthday.append(str_month);
				sbBirthday.append("/");
				sbBirthday.append(str_day);


				System.out.println(sbBirthday.toString());

				//DTOのコンストラクタに代入
				DTO_netbankingUI03 vrb_dtoUI3 = new DTO_netbankingUI03(sbFurigana.toString(),
																	str_sei,
																	str_mei,
																	sbBirthday.toString(),
																	str_year,
																	str_month,
																	str_day,
																	str_miseban,
																	str_kamoku,
																	str_shitenmei
																	 );

				BL_netbankingUI03 vrb_BLui03 = new BL_netbankingUI03();

				//すべてのチェックがtrueのとき次の画面にうつる
				if (vrb_BLui03.checkAvailableInfomation(vrb_dtoUI3)) {

					//DTOを作成し次の画面に映す
					NetbankingUI04.main(vrb_BLui03.saveDto(vrb_dtoUI3));

					frame.setVisible(false);

				}

			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(278, 615, 125, 32);
		frame.getContentPane().add(btnNewButton);

	}
}
