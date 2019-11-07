/**
 *
 */
package netbanking0219;

import java.sql.Timestamp;

/**
 * @author WITC_RieMatsui
 *
 */
public class DTO_userTable_netbankingUI05 {

	private int num_userId = 0;
	private int tmp_userId = 0;
	private String str_userPW = null;
	private String str_birthday = null;
	private int num_accountNo = 0;
	private Timestamp timestamp = null;
	private String str_createUer = null;
	private String str_subId = null;
	private int num_brId = 0;
	/**
	 *
	 */
	public DTO_userTable_netbankingUI05() {
	}

	public DTO_userTable_netbankingUI05(final int _paramUserId,
										final int _paramTempUserID,
										final String _paramUserPW,
										final String _paramBirthday,
										final int _paramAccountNo,
										final Timestamp _paramTime,
										final String _paramCrtUser,
										final String _paramSubID,
										final int _paramBrId) {

		this.setNum_userId(_paramUserId);
		this.setTmp_userId(_paramTempUserID);
		this.setStr_userPW(_paramUserPW);
		this.setStr_birthday(_paramBirthday);
		this.setNum_accountNo(_paramAccountNo);
		this.setTimestamp(_paramTime);
		this.setStr_createUer(_paramCrtUser);
		this.setStr_subId(_paramSubID);
		this.setNum_BrId(_paramBrId);

	}

	public int getNum_userId() {
		return num_userId;
	}


	public void setNum_userId(int num_user) {
		this.num_userId = num_user;
	}


	public String getStr_userPW() {
		return str_userPW;
	}


	public void setStr_userPW(String str_userPW) {
		this.str_userPW = str_userPW;
	}


	public String getStr_birthday() {
		return str_birthday;
	}


	public void setStr_birthday(String str_birthday) {
		this.str_birthday = str_birthday;
	}


	public int getNum_accountNo() {
		return num_accountNo;
	}


	public void setNum_accountNo(int num_accountNo) {
		this.num_accountNo = num_accountNo;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	public String getStr_createUer() {
		return str_createUer;
	}


	public void setStr_createUer(String str_createUer) {
		this.str_createUer = str_createUer;
	}


	public String getStr_subId() {
		return str_subId;
	}


	public void setStr_subId(String str_subId) {
		this.str_subId = str_subId;
	}


	public int getNum_brId() {
		return num_brId;
	}


	public void setNum_BrId(int num_brId) {
		this.num_brId = num_brId;
	}


	public int getTmp_userId() {
		return tmp_userId;
	}

	public void setTmp_userId(int tmp_userId) {
		this.tmp_userId = tmp_userId;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
