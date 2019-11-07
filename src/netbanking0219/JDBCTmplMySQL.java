/**
 *
 */
package netbanking0219;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WITC_NP02410A
 *
 *
 *
 */
public class JDBCTmplMySQL extends JDBCAbstractTemplate {

	/**
	 *
	 */
	public JDBCTmplMySQL() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see netbanking00.JDBCAbstractTemplate#dbConection()
	 */
	@Override
	public Connection dbConection() throws SQLException {
		System.out.println("データベース接続");
		Connection con = null;
		try {

			// 接続ドライバの指定
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 接続先を指定:jdbc:mysql://【サーバー名】【データベース名】
		// TODO Mac用データベースと切り替える
		// FIXME データベースプロパティファイルにまとめる
		con = DriverManager.getConnection("jdbc:mysql://192.168.33.10/witc_si_kenshu", "root", "lFSi8Qnsl8zQ5hYU");
        //con = DriverManager.getConnection("jdbc:mysql://localhost/witc_si_kenshu","root","root");
		System.out.println();
		return con;

	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * netbanking00.JDBCAbstractTemplate#findBrichID(com.mysql.jdbc.Connection,
	 * java.lang.String)
	 *
	 * 店番と店名を照合し、データベース上に存在しているかを確認
	 */
	@Override
	public int findBrichID(Connection con, String brachNo) throws SQLException {
		// SQLステートメントの作成
		int rsCol_Id = 0;
		String rsCol_name = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rst = null;
		PreparedStatement pstmt = null;

		// SQL文の宣言
		sb.append("SELECT");
		sb.append(" BRANCH_ID,BRANCH_NAME");
		sb.append(" FROM");
		sb.append(" T_M_BANK_BRANCH");
		sb.append(" WHERE");
		sb.append(" BRANCH_ID= ");
		sb.append(" ?");

		pstmt = con.prepareStatement(sb.toString()); // QSL文を宣言することを記載
		pstmt.setInt(1, Integer.parseInt(brachNo));

		// SQL文実行
		rst = pstmt.executeQuery(); // resultset 結果を設定

		System.out.println("BRANCH_ID" + "\t" + "BRANCH_NAME");
		System.out.println("------------------");

		while (rst.next()) {

			// データベース内のテーブル：T_MST_USER内カラム
			// 「U_ID」を参照・取得（列番号による指定）

			rsCol_Id = rst.getInt("BRANCH_ID"); // SQLからの文字列の取得
			rsCol_name = rst.getString("BRANCH_NAME"); // SQLからの文字列の取得

			System.out.println(rsCol_Id + "\t" + rsCol_name);

		}

		return rsCol_Id;
	}

	/**
	 * 口座番号のデータが存在しているかどうか
	 *
	 */
	@Override
	public int findAccountNo(Connection con, String branc) throws SQLException {

		int rsAccountNo = 0;
		String param_accountNo = null;
		StringBuilder sb = new StringBuilder();
		ResultSet res = null;
		PreparedStatement pstmt = null;

		// SQL文の宣言
		sb.append("SELECT");
		sb.append("FROM");
		sb.append(" ACCOUNT_NO");
		sb.append(" t_m_bank_user");
		sb.append(" WHERE");
		sb.append(" ACCOUNT_NO = ");
		sb.append(" ?");

		// SQL文を宣言することを記載
		pstmt = con.prepareStatement(sb.toString());

		pstmt.setInt(1, Integer.parseInt(param_accountNo));

		// SQL文の実行
		res = pstmt.executeQuery();

		System.out.println("ACCOUNT_NO");

		while (res.next()) {
			rsAccountNo = res.getInt("ACCOUNT_NO");
			System.out.println(rsAccountNo);

		}

		return rsAccountNo;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * netbanking00.JDBCAbstractTemplate#insertUser(com.mysql.jdbc.Connection,
	 * java.util.List)
	 */
	@Override
	public int insertUser(Connection con, DTO_userTable_netbankingUI05 _paramDTO) throws SQLException {

		int res = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;

		sb.append("INSERT");
		sb.append(" INTO");
		sb.append(" T_M_BANK_USER");
		sb.append(" (");
		sb.append(" USER_ID,");
		sb.append(" USER_PW,");
		sb.append(" USER_BIRTH,");
		sb.append(" ACCOUNT_NO,");
		sb.append(" CREATE_DATE,");
		sb.append(" CREATE_USER,");
		sb.append(" SUBJECT_ID,");
		sb.append(" BRANCH_ID");
		sb.append(" )");
		sb.append(" VALUES");
		sb.append(" (");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?");
		sb.append(")");

		System.out.println("DEBUG sql = " + sb.toString());

		pstmt = con.prepareStatement(sb.toString());
		con.setAutoCommit(false);

		pstmt.setInt(1, _paramDTO.getNum_userId());
		pstmt.setString(2, _paramDTO.getStr_userPW());
		pstmt.setString(3, _paramDTO.getStr_birthday());
		pstmt.setInt(4, 0);
		pstmt.setTimestamp(5, _paramDTO.getTimestamp());
		pstmt.setString(6, _paramDTO.getStr_createUer());
		pstmt.setString(7, _paramDTO.getStr_subId());
		pstmt.setInt(8, _paramDTO.getNum_brId());

		pstmt.executeUpdate();

		res = getIncrementKey(con, sb.toString());

		con.commit();

		System.out.println(res);

		return res;

	}

	@Override
	public int insertTmpUser(Connection con, DTO_tmp_netbanking _paramDTO) throws SQLException {

		System.out.println("一時テーブルに保存するSQL文を宣言するメソッド");

		int res = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;

		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" TMP_T_M_BANK_USER");
		sb.append(" (USER_ID,");
		sb.append(" USER_PW,");
		sb.append(" PERSONAL_SEI,");
		sb.append(" PERSONAL_MEI,");
		sb.append(" USER_BIRTHDAY,");
		sb.append(" CREATE_DATE,"); // TIME STAMP 7
		sb.append(" CREATE_USER,");
		sb.append(" BRANCH_ID,"); // INT型 10
		sb.append(" BRANCH_NAME,");
		sb.append(" SUBJECT_ID,");
		sb.append(" SUBJECT_NAME)");
		sb.append(" VALUES");
		sb.append(" (");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?");
		sb.append(")");

		System.out.println("DEBUG sql = " + sb.toString());

		// connectionへのsqlの準備
		pstmt = con.prepareStatement(sb.toString());
		con.setAutoCommit(false);

		pstmt.setInt(1, _paramDTO.getNum_userId());
		pstmt.setString(2, _paramDTO.getStr_userPW());
		pstmt.setString(3, _paramDTO.getStr_sei());
		pstmt.setString(4, _paramDTO.getStr_mei());
		pstmt.setString(5, _paramDTO.getStr_birthday());
		pstmt.setTimestamp(6, _paramDTO.getTimestamp());
		pstmt.setString(7, _paramDTO.getStr_createName());
		pstmt.setInt(8, _paramDTO.getNum_brId());
		pstmt.setString(9, _paramDTO.getStr_brName());
		pstmt.setInt(10, _paramDTO.getNum_subId());
		pstmt.setString(11, _paramDTO.getStr_subName());

		pstmt.executeUpdate();

		res = getIncrementKey(con, sb.toString());

		System.out.println("結果:" + res);

		con.commit();

		if ("".equals("ABC")) {

			// ifで引っかかるようだったら例外で止まる（致命的なエラーのときにコンソールに表示させる）
			throw new SQLException();

		}

		return res;

	}

	@Override
	public int insertErrorTable(Connection con, DTO_netbankingUI04 _paramDTO) throws SQLException {

		int res = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;

		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" t_m_bank_error");
		sb.append(" (");
		sb.append(" ERROR_ID,");
		sb.append(" ERROR_USER,");
		sb.append(" ERROR_TIME,");
		sb.append(" ERROR_DATE");
		sb.append(" )");
		sb.append(" VALUES");
		sb.append("(");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?");
		sb.append(")");

		System.out.println("DEBUG sql = " + sb.toString());

		pstmt = con.prepareStatement(sb.toString());
		con.setAutoCommit(false);

		pstmt.setInt(1, _paramDTO.getNum_userId());
		pstmt.setString(2, _paramDTO.getStr_createName());
		pstmt.setInt(3, 3);
		pstmt.setTimestamp(4, _paramDTO.getTimestamp());

		res = pstmt.executeUpdate();

		con.commit();

		return res;
	}

	// 支店名を取得するメソッド
	@Override
	public String getSitenMei(Connection con, String branchNo) throws SQLException {

		int rsCol_ID = 0;
		String rsCol_name = null;
		StringBuilder sb = new StringBuilder();
		ResultSet res = null;
		PreparedStatement pstmt = null;

		sb.append(" SELECT");
		sb.append(" BRANCH_ID,BRANCH_NAME");
		sb.append(" FROM");
		sb.append(" T_M_BANK_BRANCH");
		sb.append(" WHERE");
		sb.append(" BRANCH_ID= ");
		sb.append(" ?");

		pstmt = con.prepareStatement(sb.toString());
		pstmt.setInt(1, Integer.parseInt(branchNo));

		// SQL文の宣言
		res = pstmt.executeQuery();

		System.out.println("BRANCH_ID" + "\t" + "BRANCH_NAME");
		System.out.println("------------------");

		while (res.next()) {

			rsCol_ID = res.getInt("BRANCH_ID"); // SQLからの文字列の取得
			rsCol_name = res.getString("BRANCH_NAME"); // SQLからの文字列の取得

			System.out.println(rsCol_ID + "\t" + rsCol_name);

		}

		return rsCol_name;

	}

	@Override
	public int getIncrementKey(Connection con, String sql) throws SQLException {

		System.out.println("最後のIDを取得する");
		int rsCol_Id = 0;
		StringBuilder sb = new StringBuilder();
		ResultSet res;
		PreparedStatement pstmt;

		sb.append("SELECT");
		sb.append(" LAST_INSERT_ID");
		sb.append(" ()");
		sb.append(" AS");
		sb.append(" LAST");

		pstmt = con.prepareStatement(sb.toString());
		res = pstmt.executeQuery();

		if (res != null && res.next()) {
			rsCol_Id = res.getInt("LAST");
		}

		System.out.println("最後にinsertしたID" + rsCol_Id);

		return rsCol_Id;
	}

	// 一時テーブルを削除するメソッド
	@Override
	public int deleatTempUser(Connection con, int _paramTmpUserId) throws SQLException {
		System.out.println("一時テーブルを削除するメソッド");
		int res = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;

		sb.append("DELETE");
		sb.append(" FROM");
		sb.append(" TMP_T_M_BANK_USER");
		sb.append(" WHERE");
		sb.append(" USER_ID =");
		sb.append(" ?");

		pstmt = con.prepareStatement(sb.toString());
		System.out.println("DEBUG sql = " + sb.toString());

		con.setAutoCommit(false);

		pstmt.setInt(1, _paramTmpUserId);

		res = pstmt.executeUpdate();

		if (res == 0) {

			// ifで引っかかるようだったら例外で止まる（致命的なエラーのときにコンソールに表示させる）
			throw new SQLException();
		}

		con.commit();
		return res;
	}

	// UPDATE `TMP_T_M_BANK_USER` SET `USER_PW` = 'riematsui' WHERE
	// `TMP_T_M_BANK_USER`.`USER_ID` = 1;

	@Override
	public int updateTmpUserPassword(Connection con, String str_userPassword, int userId) throws SQLException {

		int rsCol_ID = 0;
		String rsCol_Pw = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		int i = 0;

		sb.append("UPDATE");
		sb.append(" TMP_T_M_BANK_USER");
		sb.append(" SET");
		sb.append(" USER_PW =");
		sb.append(" ?");
		sb.append(" WHERE");
		sb.append(" USER_ID =");
		sb.append(" ?");

		System.out.println("DEBUG sql = " + sb.toString());

		pstmt = con.prepareStatement(sb.toString());
		con.setAutoCommit(false);

		System.out.println(str_userPassword);
		System.out.println(userId);

		pstmt.setString(1, str_userPassword);
		pstmt.setInt(2, userId);

		i = pstmt.executeUpdate();

		// 処理件数を表示する
		System.out.println("結果：" + i);

		con.commit();
		return i;
	}

	@Override
	public int updateAccounNum(Connection con, int _paramAccount, int _paramUserId) throws SQLException {

		int rsCol_ID = 0;
		String rsCol_Pw = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		int i = 0;

		sb.append("UPDATE");
		sb.append(" T_M_BANK_USER");
		sb.append(" SET");
		sb.append(" ACCOUNT_NO =");
		sb.append(" ?");
		sb.append(" WHERE");
		sb.append(" USER_ID =");
		sb.append(" ?");

		System.out.println("DEBUG sql = " + sb.toString());

		pstmt = con.prepareStatement(sb.toString());
		con.setAutoCommit(false);

		System.out.println(_paramAccount);
		System.out.println(_paramUserId);

		pstmt.setInt(1, _paramAccount);
		pstmt.setInt(2, _paramUserId);

		i = pstmt.executeUpdate();

		// 処理件数を表示する
		System.out.println("結果：" + i);

		con.commit();
		return i;

	}

	@Override
	public int selectLogin(Connection con, int _paramAccount, String _paramPassword) throws SQLException {
		int rsCol_Account = 0;
		String rsCol_Pw = null;
		int rsCol_Id = 0;

		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet res = null;

		sb.append("SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" T_M_BANK_USER");
		sb.append(" WHERE");
		sb.append(" ACCOUNT_NO =");
		sb.append(" ?");
		sb.append(" AND");
		sb.append(" USER_PW =");
		sb.append(" ?");


		System.out.println("DEBUG sql = " + sb.toString());
		pstmt = con.prepareStatement(sb.toString());

		pstmt.setInt(1, _paramAccount);
		pstmt.setString(2, _paramPassword);

		res = pstmt.executeQuery();

		while (res.next()) {

			rsCol_Account = res.getInt("ACCOUNT_NO"); // SQLからの文字列の取得
			rsCol_Pw = res.getString("USER_PW"); // SQLからの文字列の取得


			System.out.println(rsCol_Account + "\t" + rsCol_Pw);

		}

		if ((rsCol_Account != _paramAccount )|| (!rsCol_Pw.equals(_paramPassword))) {
			return 0;
		}

		return 1;
	}

	public static void main(String[] args) {

		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();

		Connection vrb_com;

		try {
			vrb_com = vrb_abs.dbConection();

			int rtn = vrb_abs.findBrichID(vrb_com, "1");
			System.out.println(rtn);

			// int rtn02 = vrb_abs.findAccountNo(vrb_com, "14567");
			// System.out.println(rtn02);
			//
			String rtn03 = vrb_abs.getSitenMei(vrb_com, "1");

			System.out.println(rtn03);

			int rtn04 = vrb_abs.selectLogin(vrb_com, 54020, "riebass01");

			// int rtn04 = vrb_abs.updateTmpUserPassword(vrb_com, "test", 10);

			// FIXME BLで呼ぶ場合

			// 1) int rtn = vrb_abs.findBrichID(vrb_com, "9");
			// 2)
			// if(rtn<0) 初期値を0で代入しているので
			// エラーメッセージ表示
			// if (rtn < 0) {
			//
			// }else {
			// //店番が存在するので後続処理を行う
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
