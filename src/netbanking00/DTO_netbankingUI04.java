/**
 *
 */
package netbanking00;

/**
 * @author WITC_RieMatsui
 *
 * @since 2017/02/10
 *
 */
public class DTO_netbankingUI04 {

    private String str_password = null;
    private String str_pwCfm = null;

    /**
     *
     */
    public DTO_netbankingUI04() {
    }

    public DTO_netbankingUI04(final String _paramPassword,
                              final String _paramPwCfm){

        this.setStr_password(_paramPassword);
        this.setStr_pwCfm(_paramPwCfm);
    }

    public String getStr_password() {
        return str_password;
    }

    public void setStr_password(String str_password) {
        this.str_password = str_password;
    }

    public String getStr_pwCfm() {
        return str_pwCfm;
    }

    public void setStr_pwCfm(String str_pwCfm) {
        this.str_pwCfm = str_pwCfm;
    }
}
