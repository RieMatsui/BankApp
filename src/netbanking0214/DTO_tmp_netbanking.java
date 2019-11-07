/**
 *
 */
package netbanking0214;

import java.sql.Timestamp;

/**
 * @author WITC_Rie Mastui
 * @since 2017/02/14
 * @version 01
 *
 * 一時テーブル用のDTO
 *
 */
public class DTO_tmp_netbanking extends DTO_netbankingUI03 {
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
	 *
	 */
	public DTO_tmp_netbanking() {
	}

	//オーバーロードしたコンストラクタ
	public DTO_tmp_netbanking(final String _paramUserID,
							  final String _paramPW,
							  final String _paramSei,
							  final String _paramMei,
							  final String _paramBirthDay,
							  final Timestamp _paramTimestamp,
							  final String _paramCreateName,
							  final int _paramBrId,
							  final String _paramBrName,
							  final int _paramSbId,
							  final String _paramSdName) {



		this.setStr_userId(_paramUserID);
		this.setStr_userPW(_paramPW);
		this.setStr_sei(_paramSei);
		this.setStr_mei(_paramMei);
		this.setStr_birthday(_paramBirthDay);
		this.setTimestamp(_paramTimestamp);
		this.setStr_createName(_paramCreateName);
		this.setNum_brId(_paramBrId);
		this.setStr_brName(_paramBrName);
		this.setNum_subId(_paramSbId);
		this.setStr_subName(_paramSdName);
		System.out.println("コンストラクタの作成");

	}
	/**
	 * @param args
	 *
	 *
	 */

	public String getStr_userId() {
		return str_userId;
	}

	public void setStr_userId(String str_userId) {
		this.str_userId = str_userId;
	}


	public String getStr_userPW() {
		return str_userPW;
	}

	public void setStr_userPW(String str_userPW) {
		this.str_userPW = str_userPW;
	}

	public String getStr_sei() {
		return str_sei;
	}

	public void setStr_sei(String str_sei) {
		this.str_sei = str_sei;
	}

	public String getStr_mei() {
		return str_mei;
	}

	public void setStr_mei(String str_mei) {
		this.str_mei = str_mei;
	}

	public String getStr_birthday() {
		return str_birthday;
	}

	public void setStr_birthday(String str_birthday) {
		this.str_birthday = str_birthday;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getStr_createName() {
		return str_createName;
	}

	public void setStr_createName(String str_createName) {
		this.str_createName = str_createName;
	}

	public int getNum_brId() {
		return num_brId;
	}

	public void setNum_brId(int num_brId) {
		this.num_brId = num_brId;
	}

	public String getStr_brName() {
		return str_brName;
	}

	public void setStr_brName(String str_brName) {
		this.str_brName = str_brName;
	}

	public int getNum_subId() {
		return num_subId;
	}

	public void setNum_subId(int num_subId) {
		this.num_subId = num_subId;
	}

	public String getStr_subName() {
		return str_subName;
	}

	public void setStr_subName(String str_subName) {
		this.str_subName = str_subName;
	}

}
