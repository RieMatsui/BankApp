/**
 *
 */
package netbanking0219;

import java.sql.Timestamp;

/**
 * @author matsuirie
 *
 */
public class DTO_netbankingUI05_02 extends DTO_netbankingUI04 {
	private int num_account  = 0;
	/**
	 *
	 */
	public DTO_netbankingUI05_02() {
	}

	/**
	 * @param _paramUserID
	 * @param _paramPW
	 * @param _paramSei
	 * @param _paramMei
	 * @param _paramBirthDay
	 * @param _paramTimestamp
	 * @param _paramCreateName
	 * @param _paramBrId
	 * @param _paramBrName
	 * @param _paramSbId
	 * @param _paramSdName
	 * @param _paramPwCfm
	 */
	public DTO_netbankingUI05_02(final int _paramUserID,
							  final String _paramPW,
							  final String _paramSei,
							  final String _paramMei,
							  final String _paramBirthDay,
							  final Timestamp _paramTimestamp,
							  final String _paramCreateName,
							  final int _paramBrId,
							  final String _paramBrName,
							  final int _paramSbId,
							  final String _paramSdName,
							  final String _paramPwCfm,
							  final int _paramAccount
							  )

	{
		super(_paramUserID, _paramPW, _paramSei,
			  _paramMei, _paramBirthDay, _paramTimestamp,
			  _paramCreateName,_paramBrId, _paramBrName,
			  _paramSbId, _paramSdName, _paramPwCfm);


	}

	public int getNum_account() {
		return num_account;
	}

	public void setNum_account(int num_account) {
		this.num_account = num_account;
	}



}
