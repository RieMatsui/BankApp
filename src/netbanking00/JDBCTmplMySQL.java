/**
 *
 */
package netbanking00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

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
	/* (非 Javadoc)
	 * @see netbanking00.JDBCAbstractTemplate#dbConection()
	 */
	@Override
	public Connection dbConection() throws SQLException {
		System.out.println("データベース接続");
		Connection con = null;
		try {

			//接続ドライバの指定
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//接続先を指定:jdbc:mysql://【サーバー名】【データベース名】
		con = DriverManager.getConnection("jdbc:mysql://192.168.33.10/witc_si_kenshu","root","lFSi8Qnsl8zQ5hYU");

System.out.println();
		return con;

	}

	/* (非 Javadoc)
	 * @see netbanking00.JDBCAbstractTemplate#findBrichID(com.mysql.jdbc.Connection,
	 * java.lang.String)
	 *
	 *店番と店名を照合し、データベース上に存在しているかを確認
	 */
	@Override
	public int findBrichID(Connection con, String brachNo) throws SQLException {
		//SQLステートメントの作成
		int rsCol_Id =  0;
		String rsCol_name = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rst = null;
		PreparedStatement pstmt = null;

		//SQL文の宣言
	    sb.append("SELECT");
	    sb.append(" BRANCH_ID,BRANCH_NAME");
	    sb.append(" FROM");
	    sb.append(" T_M_BANK_BRANCH");
	    sb.append(" WHERE");
	    sb.append(" BRANCH_ID= ");
	    sb.append(" ?");

	    pstmt = con.prepareStatement(sb.toString()); //QSL文を宣言することを記載
	    pstmt.setInt(1, Integer.parseInt(brachNo));

	    //SQL文実行
	    rst = pstmt.executeQuery(); //resultset 結果を設定

System.out.println("BRANCH_ID" + "\t" + "BRANCH_NAME");
System.out.println("------------------");

		while (rst.next()) {


			//データベース内のテーブル：T_MST_USER内カラム
			//「U_ID」を参照・取得（列番号による指定）

			rsCol_Id = rst.getInt("BRANCH_ID"); //SQLからの文字列の取得
			rsCol_name = rst.getString("BRANCH_NAME"); //SQLからの文字列の取得


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



		//SQL文の宣言
		sb.append("SELECT");
		sb.append( "FROM");
		sb.append(" ACCOUNT_NO");
		sb.append(" t_m_bank_user");
		sb.append(" WHERE");
		sb.append(" ACCOUNT_NO = ");
		sb.append(" ?");

		//SQL文を宣言することを記載
		pstmt = con.prepareStatement(sb.toString());

		pstmt.setInt(1, Integer.parseInt(param_accountNo));

		//SQL文の実行
		res = pstmt.executeQuery();

System.out.println("ACCOUNT_NO");

		while (res.next()) {
			rsAccountNo = res.getInt("ACCOUNT_NO");
			System.out.println(rsAccountNo);

		}

		return rsAccountNo;
	}
	/* (非 Javadoc)
	 * @see netbanking00.JDBCAbstractTemplate#insertUser(com.mysql.jdbc.Connection, java.util.List)
	 */
	@Override
	public int insertUser(Connection con, List<?> _paramListData) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;

	}
	/**
	 *
	 * @param con
	 * @param _paramListData
	 * @return
	 * @throws SQLException（メソッドの処理をせずに止めることができる）
	 * エラーテーブルにデータを挿入するメソッド
	 *
	 *
	 */
	public int insertTmpUser(Connection con, List<String> _paramListData) throws SQLException {


		StringBuilder sb = new StringBuilder();
		ResultSet res = null;
		PreparedStatement pstmp = null;

		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" tmp_t_m_bank_user");
		sb.append(" (USER_ID,");
		sb.append(" USER_PW,");
		sb.append(" PERSONAL_SEI,");
		sb.append(" PERSONAL_MEI,");
		sb.append(" USER_BIRTHDAY,");
		sb.append(" CREATE_DATE"); //TIME STAMP 7
		sb.append(" CREATE_USER,");
		sb.append(" SUBJECT_ID,");
		sb.append(" BRANCH_ID,"); //INT型 10
		sb.append(" VALUES");
		sb.append("(");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(")");

System.out.println("DEBUG sql = " + sb.toString());

		//connectionへのsqlの準備
		pstmp = con.prepareStatement(sb.toString());
		//カウンター変数
		int ival = 1;

		//配列のiteratorで展開
		for(Iterator<String> ite  = _paramListData.iterator();
				ite.hasNext();){
			//6 ACCOUNT_NO / 8 BRANCH_ID はINT型なので変換
			if (ival == 6 || ival ==10) {
				pstmp.setInt(ival, Integer.parseInt(ite.next()));
			}
			//テーブルフィールド
//			if (ival == 8) {
//				pstmp.setTimestamp(ival, "メソッドとクラスの呼び出し");
//
//			}
			//上記以外「テーブルフィールド」
			pstmp.setString(ival, ite.next());

			//カウンター変数インクリメント
			ival++;
		}

		if ("".equals("ABC")) {

			//ifで引っかかるようだったら例外で止まる（致命的なエラーのときにコンソールに表示させる）
			throw new SQLException();
		}

		return 0;
	}

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


		pstmt =  con.prepareStatement(sb.toString());
		pstmt.setInt(1, Integer.parseInt(branchNo));

		//SQL文の宣言
		res = pstmt.executeQuery();

System.out.println("BRANCH_ID" + "\t" + "BRANCH_NAME");
System.out.println("------------------");

		while (res.next()) {

			rsCol_ID = res.getInt("BRANCH_ID"); //SQLからの文字列の取得
			rsCol_name = res.getString("BRANCH_NAME"); //SQLからの文字列の取得

			System.out.println(rsCol_ID + "\t" + rsCol_name);

		}

		return rsCol_name;

	}
	
	@Override
	public int insertTmpData(Connection con, DTO_tmp_UI03 _paramData) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		ResultSet ret = null;
		PreparedStatement pstmt = null;
		
		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" tmp_t_m_bank_user");
		sb.append(" (USER_ID,");
		sb.append(" USER_PW,");
		sb.append(" PERSONAL_SEI,");
		sb.append(" PERSONAL_MEI,");
		sb.append(" USER_BIRTHDAY,");
		sb.append(" CREATE_DATE"); 
		sb.append(" CREATE_USER,");
		sb.append(" SUBJECT_ID,");
		sb.append(" BRANCH_ID,"); 
		sb.append(" VALUES");
		sb.append("(");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(")");
		
		pstmt =  con.prepareStatement(sb.toString());
		pstmt.setString(1, _paramData.getStr_userId());
		
		
		
		
		return 0;
	}


	public static void main(String[] args) {

		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();

		Connection vrb_com;

		try {
			vrb_com = vrb_abs.dbConection();

			int rtn =  vrb_abs.findBrichID(vrb_com, "1");
			System.out.println(rtn);

//			int rtn02 = vrb_abs.findAccountNo(vrb_com, "14567");
//			System.out.println(rtn02);
//
			String rtn03 = vrb_abs.getSitenMei(vrb_com, "1");

			System.out.println(rtn03);

			//FIXME BLで呼ぶ場合

			//1) int rtn = vrb_abs.findBrichID(vrb_com, "9");
			//2)
			//if(rtn<0) 初期値を0で代入しているので
			//エラーメッセージ表示
//			if (rtn < 0) {
//
//			}else {
//				//店番が存在するので後続処理を行う
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
