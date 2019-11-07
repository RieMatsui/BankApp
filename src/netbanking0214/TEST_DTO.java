/**
 *
 */
package netbanking0214;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author WITC_NP02410A
 *
 */
public class TEST_DTO {

	/**
	 *
	 */
	public TEST_DTO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final String str_userId = null;
		final String str_pw = null;
		final String str_sei = "sei";
		final String str_mei = "mei";
		final String str_birthday = "2017/1/6";
		final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		final String str_createName = "test_name";
		final int num_brId = 1;
		final String str_brName = "test_brname";
		final int num_subId = 1;
	    final String str_subName = "test_sbName";

		DTO_tmp_netbanking dTmp_netbanking = new DTO_tmp_netbanking(str_userId,
																	str_pw,
																	str_sei,
																	str_mei,
																	str_birthday,
																	timestamp,
																	str_createName,
																	num_brId,
																	str_brName,
																	num_subId,
																	str_subName);


		System.out.println(dTmp_netbanking.getStr_userId());
		System.out.println(dTmp_netbanking.getStr_sei());
		System.out.println(dTmp_netbanking.getStr_mei());
		System.out.println(dTmp_netbanking.getStr_birthday());
		System.out.println(dTmp_netbanking.getTimestamp());
		System.out.println(dTmp_netbanking.getNum_brId());
		System.out.println(dTmp_netbanking.getStr_brName());
		System.out.println(dTmp_netbanking.getNum_subId());
		System.out.println(dTmp_netbanking.getStr_subName());

		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;


			try {
				vrb_con = vrb_abs.dbConection();
				int rtn = vrb_abs.insertTmpUser(vrb_con, dTmp_netbanking);


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


	}


}
