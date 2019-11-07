/**
 *
 */
package netbanking00;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import netbanking00.PatternUtil_NetBanking.PatternEnum;

/**
 * @author WITC_Rie Matsui
 *
 */
public class BL_netbankingUI04 {



	public BL_netbankingUI04() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 *
	 * @param _paramData
	 * @return	boolean
	 * 未入力確認
	 */
	public boolean checkNull(DTO_netbankingUI04 _paramData) {
		System.out.println("パスワード未入力確認");
		//パスワード未入力時
		if (_paramData.getStr_password().isEmpty()) {
			JOptionPane.showConfirmDialog(null,
										"TESTMESSAGE>パスワードを入力してください",
										"TITLE>エラー",
										JOptionPane.INFORMATION_MESSAGE);
			return false;

		}
		//確認パスワード未入力時
		else if (_paramData.getStr_password().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										"TESTMESSAGE>確認用パスワードを入力してください",
										"TITLE>エラー",
										JOptionPane.INFORMATION_MESSAGE);
			return false;
		}


		return true;
	}
	/**
	 *
	 * @param _paramData
	 * @return boolean
	 *
	 * 入力データの使用確認(正規表現）
	 */
	public boolean confirmRegexpPw(DTO_netbankingUI04 _paramData) {
		System.out.println("正規確認用メソッド");
		final Pattern p_pw = PatternEnum.PASSWORD_ALLDEF.toPattern();
		final boolean res_pw = PatternUtil_NetBanking.findMatches
				(p_pw, _paramData.getStr_password());

		if (!res_pw) {

			JOptionPane.showMessageDialog(null,
					                    "TESTMESSAGE>半角英数字で7桁以上15文字以内で入力してください",
					                    "TITLE>エラー",
					                    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}
	//PWの入力と確認PWが同じであることを確認する
	public boolean cfmSamePw(DTO_netbankingUI04 _paramData) {

		System.out.println("PWと確認PWが一致しているかの確認メソッド");
		System.out.println(_paramData.getStr_password());
		System.out.println(_paramData.getStr_pwCfm());


		if (!_paramData.getStr_password().equals(_paramData.getStr_pwCfm())){

			JOptionPane.showMessageDialog(null,
                    "TESTMESSAGE>入力したパスワードと確認用パスワードが異なります",
                    "TITLE>エラー",
                    JOptionPane.INFORMATION_MESSAGE);

			return false;

		}

		return true;


	}
	public boolean checkAvailableInfomation(DTO_netbankingUI04 _paramDto) {

		if (!checkNull(_paramDto)) {
			return false;
		}

		if (!confirmRegexpPw(_paramDto)) {
			return false;
		}

		return true;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
