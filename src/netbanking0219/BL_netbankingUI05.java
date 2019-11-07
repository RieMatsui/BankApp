/**
 *
 */
package netbanking0219;

import java.sql.Connection;
import java.text.Format;

import javax.swing.JOptionPane;

/**
 * @author WITC_NP02410A
 *
 */
public class BL_netbankingUI05 {

	/**
	 *
	 */
	public BL_netbankingUI05() {
	}

	//データベースに一括登録する
	public boolean registerUserTable(DTO_userTable_netbankingUI05 _paramDTO) {

		int res = 0;
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;

		try {
			vrb_con = vrb_abs.dbConection();

			res = vrb_abs.insertUser(vrb_con, _paramDTO);

			_paramDTO.setNum_userId(res);

			if (res == 0) {
				JOptionPane.showMessageDialog(null,
						"TESTMESSAGE>不正なデータが入力されました",
						"TITLE>エラー",
						JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				//取得したTempUserIDをDTOにセット
				_paramDTO.setNum_userId(res);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}

	//口座番号を発行する
	public boolean issueAccount(DTO_userTable_netbankingUI05 _paramDTO) {
		System.out.println("口座番号を発行するメソッド");

		String accountNo = null;
		String userId = null;

		userId = String.format("%3s",_paramDTO.getNum_userId()).replace(" ", "0");
		StringBuilder sb = new StringBuilder();

		sb.append(_paramDTO.getNum_brId());
		sb.append(_paramDTO.getStr_subId());
		sb.append(userId);

		System.out.println(sb.toString());
		accountNo = sb.toString();
		_paramDTO.setNum_accountNo(Integer.parseInt(accountNo));

		return true;
	}

	//発行した口座番号をデータベースに登録する
	public boolean  registerAccountNum(DTO_userTable_netbankingUI05 _paramDTO) {
		System.out.println("口座番号を発行するメソッド");

		int res = 0;
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;
		System.out.println(_paramDTO.getTmp_userId());

		try {
			vrb_con = vrb_abs.dbConection();
			res = vrb_abs.updateAccounNum(vrb_con, _paramDTO.getNum_accountNo(), _paramDTO.getNum_userId());

			if (res == 0) {
				JOptionPane.showMessageDialog(null,
						"TESTMESSAGE>不正なデータが入力されました",
						"TITLE>エラー",
						JOptionPane.INFORMATION_MESSAGE);

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return true;
	}
	/**
	 *
	 * @param _paramDTO
	 * @return
	 *
	 */
	private boolean tmpUserDelete(DTO_userTable_netbankingUI05 _paramDTO) {
		System.out.println("BL一時ユーザを削除するメソッド");

		int res = 0;
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;

		try {
			vrb_con = vrb_abs.dbConection();
			res = vrb_abs.deleatTempUser(vrb_con, _paramDTO.getTmp_userId());

			if (res == 0) {
				JOptionPane.showMessageDialog(null,
						"TESTMESSAGE>不正なデータが入力されました",
						"TITLE>エラー",
						JOptionPane.INFORMATION_MESSAGE);

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}


	public boolean finishBankRegister(DTO_userTable_netbankingUI05 _paramDTO) {

		if (!registerUserTable(_paramDTO)) {
			return false;
		}

		if (!issueAccount(_paramDTO)) {
			return false;
		}

		if (!registerAccountNum(_paramDTO)) {
			return false;
		}

		if (!tmpUserDelete(_paramDTO)) {
			return false;
		}

		return true;
	}



}
