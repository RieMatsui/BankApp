/**
 *
 */
package netbanking00;
import java.awt.Frame;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class BL_netbankingUI03_02 {

	public BL_netbankingUI03_02() {

	}
	//TODO プロパティファイルにエラーメッセージを記載
    //未入力チェックメソッド
	public boolean checkNull(DTO_netbankingUI03 _paramData) {
		System.out.println("checkNullメソッド");
		if (_paramData.getStr_sei().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>カナ氏名の姓を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_mei().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>カナ氏名の名を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_year().equals("----")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>西暦を選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_month().equals("--")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>誕生月を選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_day().equals("--")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>誕生日の日にちを選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_miseban().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>店番を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_kouzanum().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>口座番号を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

	    return true;


	}

	private boolean checkBranch(final DTO_netbankingUI03 _paramMiseban){
		System.out.println("店番チェックメソッド");
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();

		Connection vrb_com;

		try {
			vrb_com = vrb_abs.dbConection();

			int rtn =  vrb_abs.findBrichID(vrb_com, _paramMiseban.getStr_miseban());
			System.out.println(rtn + "rtnの値");

			if (rtn == 0) {
				System.out.println("店番のエラーメッセージ");
				JOptionPane.showMessageDialog(null,
						  "TESTMESSAGE>店番を正しく入力してください",
						  "TESTTITLE>エラーメッセージ",
						  JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			else  {
				System.out.println("正しい店番です");

			}


		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;
	}

	public boolean checkAccountNo(final DTO_netbankingUI03 _paramDTO) {

		//7桁であればOK


		String kouza = null;

		String miseban = null;
		String res_miseban =  null;
		String res_kouza = null;


		kouza = _paramDTO.getStr_kouzanum();
		miseban = _paramDTO.getStr_miseban();
		res_miseban = String.format("%3s",miseban).replace(" ", "0");
		res_kouza = String.format("%7s", kouza).replace("", "0");



		Pattern p01 =  Pattern.compile("([1-9]4)(123|234|345|456|567|678|789)*$");
		Pattern p02 =  Pattern.compile(_paramDTO.getStr_miseban()+"(4)(123|234|345|456|567|678|789)*$");
		final Matcher m01 = p01.matcher(res_kouza);
		final Matcher m02 = p02.matcher(res_kouza);




		if (res_kouza.length() == 7 && !m02.find()) {

				JOptionPane.showConfirmDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);

			return m02.find();

		}

		else if (res_kouza.length() == 5 ) {
		    res_kouza =  res_kouza.replaceAll(p01.pattern(),"00" + res_kouza);
			System.out.println(res_kouza);

			if (!m01.find()) {
				JOptionPane.showConfirmDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("五文字のとき[照合結果] " + m01.find());
			return m01.find();

		}

		else if (res_kouza.length() == 6) {
		    res_kouza =  res_kouza.replaceAll(p01.pattern(),res_kouza);

			if (!m01.find()) {
				JOptionPane.showConfirmDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);
			}

			System.out.println("六文字[照合結果] " + m01.find());
			System.out.println(res_kouza);
			return m01.find();
		}

		System.out.println("すべての処理[照合結果]" + m01.find());
		if (!m01.find()) {

			JOptionPane.showConfirmDialog(null,
					"TESTMESSAGE>口座番号が違います。もう一度確認してください",
					"エラー",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return m01.find();

	}

	public void checkKanashimei() {



	}

	public void convertNumber_Zenkaku_Hankaku(){

	}

	//ファサードパターンで一括で呼び出す
	public void checkAvailableInfomation(final DTO_netbankingUI03 _paramDto) {

		System.out.println("処理開始");
		if (!checkNull(_paramDto)) {
			return;
		}

		else if (!checkBranch(_paramDto)) {
			return;
		}

		else if (!checkAccountNo(_paramDto)) {
			return;
		}
		System.out.println("処理終了");

	}


	//次の画面に映る処理
	public void nextDisplay(Frame _Frame) {

		NetbankingUI04 vrb_ui4 = new NetbankingUI04();
		vrb_ui4.main(null);
		_Frame.setVisible(false);

	}

	//画面でBLを呼び出す呼び出すことを想定した書き方
	public static void main(String[] args) {

		//7桁であればOK
		String miseban1 = "01";
		String num ="1234";

		Pattern p01 =  Pattern.compile("([1-9]4)(123|234|345|456|567|678|789)*$");
		Pattern p02 =  Pattern.compile(num +"(123|234|345|456|567|678|789)*$");
		final Matcher m01 = p01.matcher(num);
		final Matcher m02 = p02.matcher(num);

		if (num.length() == 7 && !m02.find() && num.substring(0, 3) == miseban1) {
				JOptionPane.showMessageDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);


		}

		else if (num.length() == 5 ) {
			num =  num.replaceAll(p01.pattern(),"00" + num);
			System.out.println(num);

			if (!m01.find()) {
				JOptionPane.showMessageDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("五文字のとき[照合結果] " + m01.find());


		}

		else if (num.length() == 6) {
			num =  num.replaceAll(p01.pattern(),num);

			if (!m01.find()) {
				JOptionPane.showMessageDialog(null,
											"TESTMESSAGE>口座番号が違います。もう一度確認してください",
											"エラー",
											JOptionPane.INFORMATION_MESSAGE);
			}

			System.out.println("六文字[照合結果] " + m01.find());
			System.out.println(num);

		}

		System.out.println("すべての処理[照合結果]" + m01.find());
		if (!m01.find()) {

			JOptionPane.showMessageDialog(null,
					"TESTMESSAGE>口座番号が違います。もう一度確認してください",
					"エラー",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}



}
