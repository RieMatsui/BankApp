package netbanking00;
/**
 *
 *
 * @author matsuirie
 * @since 2017/02/08
 * @version 1.0
 */

public class DTO_netbankingUI03 {

    private String str_name = null;
    private String str_sei = null;
    private String str_mei = null;
    private String str_birthday = null;
    private String str_year = null;
    private String str_month = null;
    private String str_day = null;
    private String str_kouzanum = null;
    private String str_miseban = null;
    private String str_kamoku = null;
    private String str_shitenmei = null;


    //コンストラクタ
    public DTO_netbankingUI03() {

    }

    //オーバーロードしたコンストラクタ
    public DTO_netbankingUI03(final String _paramName,
                              final String _paramSei,
                              final String _paramMei,
                              final String _paramBirthday,
                              final String _paramYear,
                              final String _paramMonth,
                              final String _paramDay,
                              final String _paramMiseban,
                              final String _paramShitenmei,
                              final String _paramKamoku
                              ) {

        this.setStr_name(_paramName);
        this.setStr_sei(_paramSei);
        this.setStr_mei(_paramMei);
        this.setStr_birthday(_paramBirthday);
        this.setStr_year(_paramYear);
        this.setStr_month(_paramMonth);
        this.setStr_day(_paramDay);
        this.setStr_miseban(_paramMiseban);
        this.setStr_shitenmei(_paramShitenmei);
        this.setStr_kamoku(_paramKamoku);
    }

    public String getStr_name() {
        return str_name;
    }

    public void setStr_name(String str_name) {
        this.str_name = str_name;
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

    public String getStr_year() {
        return str_year;
    }

    public void setStr_year(String str_year) {
        this.str_year = str_year;
    }


    public String getStr_month() {
        return str_month;
    }


    public void setStr_month(String str_month) {
        this.str_month = str_month;
    }


    public String getStr_day() {
        return str_day;
    }


    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    public String getStr_kouzanum() {
        return str_kouzanum;
    }

    public void setStr_kouzanum(String str_kouzanum) {
        this.str_kouzanum = str_kouzanum;
    }

    public String getStr_miseban() {
        return str_miseban;
    }

    public void setStr_miseban(String str_meseban) {
        this.str_miseban = str_meseban;
    }

    public String getStr_kamoku() {
        return str_kamoku;
    }

    public void setStr_kamoku(String str_kamoku) {
        this.str_kamoku = str_kamoku;
    }

    public String getStr_shitenmei() {
        return str_shitenmei;
    }

    public void setStr_shitenmei(String str_shitenmei) {
        this.str_shitenmei = str_shitenmei;
    }
}
