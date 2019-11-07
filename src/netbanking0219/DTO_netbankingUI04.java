/**
 *
 */
package netbanking0219;

import java.sql.Timestamp;

/**
 * @author WITC_RieMatsui
 *
 * @since 2017/02/10
 *
 */
public class DTO_netbankingUI04 extends DTO_tmp_netbanking{

	private String str_pwCfm = null;
	/**
	 *
	 */
	public DTO_netbankingUI04() {
	}

	public DTO_netbankingUI04(final int _paramUserID,
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
			                  final String _paramPwCfm
							  ){


		super(_paramUserID,_paramPW, _paramSei, _paramMei, _paramBirthDay,
			  _paramTimestamp, _paramCreateName, _paramBrId ,_paramBrName,
			  _paramSbId, _paramSdName);

		this.setStr_pwCfm(_paramPwCfm);
	}



	public String getStr_pwCfm() {
		return str_pwCfm;
	}

	public void setStr_pwCfm(String str_pwCfm) {
		this.str_pwCfm = str_pwCfm;
	}


}
