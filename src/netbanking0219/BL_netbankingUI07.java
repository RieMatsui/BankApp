/**
 *
 */
package netbanking0219;

import java.sql.Connection;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import netbanking0219.PatternUtil_NetBanking.PatternEnum;





/**
 * @author matsuirie
 *
 */
public class BL_netbankingUI07 {

	/**
	 *
	 */
	public BL_netbankingUI07() {
	}

	//正規表現にあっているかどうかの確認
	public boolean confirmAccount(DTO_netbankingUI07 _paramData) {
		System.out.println(_paramData.getStr_accountNum());
		System.out.println(_paramData.getStr_password());

		//口座番号の正規表現
		final Pattern p_kouza = PatternEnum.KOUZA_NUM.toPattern();
		final boolean res_01 = PatternUtil.findMatches(p_kouza, _paramData.getStr_accountNum());

		final Pattern p_password = PatternEnum.PASSWORD_ALLDEF.toPattern();
		final boolean res_02 = PatternUtil.findMatches(p_password, _paramData.getStr_password());

		//口座番号の正規表現でない時

		if (!res_01) {
			JOptionPane.showMessageDialog(null,
			  "TESTMESSAGE>口座番号は5桁から7桁です",
			  "TESTTITLE>エラーメッセージ",
			  JOptionPane.INFORMATION_MESSAGE);
              return false;
		}

		else if (!res_02) {
			JOptionPane.showMessageDialog(null,
                    "TESTMESSAGE>半角英数字で7桁以上15文字以内で入力してください",
                    "TITLE>エラー",
                    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;

	}

	public boolean checkDataBase(DTO_netbankingUI07 _paramData){
		int AccoutNum = 0;
		int res = 0;
		AccoutNum = Integer.parseInt(_paramData.getStr_accountNum());
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;

		try {
			vrb_con = vrb_abs.dbConection();

			res = vrb_abs.selectLogin(vrb_con,
									Integer.parseInt(_paramData.getStr_accountNum()),
									_paramData.getStr_password());

			if (res == 0) {
				JOptionPane.showMessageDialog(null,
	                    "TESTMESSAGE>パスワードまたは口座番号が違います。",
	                    "TITLE>エラー",
	                    JOptionPane.INFORMATION_MESSAGE);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean checkInfomation(DTO_netbankingUI07 _pramDto){

		if (!confirmAccount(_pramDto)) {
			return false;
		}
		else if (!checkDataBase(_pramDto)) {
			return false;
		}
		JOptionPane.showMessageDialog(null,
                "TESTMESSAGE>ログインが完了しました。メニュー画面に戻ります。",
                "TITLE>ログイン完了",
                JOptionPane.INFORMATION_MESSAGE);

		return true;
	}


}
