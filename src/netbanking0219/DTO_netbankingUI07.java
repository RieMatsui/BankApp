package netbanking0219;

public class DTO_netbankingUI07 {

	private String str_accountNum = null;
	private String str_password = null;


	public DTO_netbankingUI07() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public DTO_netbankingUI07(final String _paramAccountNum,
							   final String _paramPassword) {

		this.setStr_accountNum(_paramAccountNum);
		this.setStr_password(_paramPassword);
	}

	public String getStr_accountNum() {
		return str_accountNum;
	}

	public void setStr_accountNum(String str_accountNum) {
		this.str_accountNum = str_accountNum;
	}

	public String getStr_password() {
		return str_password;
	}

	public void setStr_password(String str_password) {
		this.str_password = str_password;
	}



}
