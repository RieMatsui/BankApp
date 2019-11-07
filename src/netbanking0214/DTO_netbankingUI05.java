/**
 *
 */
package netbanking0214;

import java.sql.Timestamp;

/**
 * @author matsuirie
 *
 */
public class DTO_netbankingUI05 extends DTO_netbankingUI04 {

	/**
	 *
	 */
	public DTO_netbankingUI05() {
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
	public DTO_netbankingUI05(String _paramUserID,
							  String _paramPW,
							  String _paramSei,
							  String _paramMei,
			                  String _paramBirthDay,
			                  Timestamp _paramTimestamp,
			                  String _paramCreateName,
			                  int _paramBrId,
			                  String _paramBrName,
			                  int _paramSbId,
			                  String _paramSdName,
			                  String _paramPwCfm)

	{
		super(_paramUserID, _paramPW, _paramSei,
			  _paramMei, _paramBirthDay, _paramTimestamp,
			  _paramCreateName,_paramBrId, _paramBrName,
			  _paramSbId, _paramSdName, _paramPwCfm);
	}

}
