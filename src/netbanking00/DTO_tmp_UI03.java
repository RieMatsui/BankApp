/**
 *
 */
package netbanking00;

import java.sql.Timestamp;

/**
 * @author matsuirie
 *
 */
public class DTO_tmp_UI03 {
    private String str_userId = null;
    private String str_password = null;
    private String str_sei = null;
    private String str_mei = null;
    private String str_birthday = null;
    private Timestamp timestamp = null;
    private String str_createUser = null;
    private int num_brId = 0;
    private String str_brName = null;
    private int num_sbId = 0;
    private String str_sbName = null;

    /**
     *
     */
    public DTO_tmp_UI03() {
    }
    public DTO_tmp_UI03(final String _paramUserID,
                        final String _paramPassword,
                        final String _paramSei,
                        final String _paramMei,
                        final String _paramBirthday,
                        final Timestamp _paramTimestamp,
                        final String _paramCreateUser,
                        final int _paramBrId,
                        final String _paramBrName,
                        final int _paramSbId,
                        final String _paramSbName) {

        this.setStr_userId(_paramUserID);
        this.setStr_password(_paramPassword);
        this.setStr_sei(_paramSei);
        this.setStr_mei(_paramMei);
        this.setStr_birthday(_paramBirthday);
        this.setTimestamp(_paramTimestamp);
        this.setStr_createUser(_paramCreateUser);
        this.setNum_brId(num_brId);
        this.setStr_brName(_paramBrName);
        this.setNum_sbId(_paramSbId);
        this.setStr_sbName(_paramSbName);

    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ

    }

    public String getStr_userId() {
        return str_userId;
    }

    public void setStr_userId(String str_userId) {
        this.str_userId = str_userId;
    }

    public String getStr_password() {
        return str_password;
    }

    public void setStr_password(String str_password) {
        this.str_password = str_password;
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

    public String getStr_createUser() {
        return str_createUser;
    }

    public void setStr_createUser(String str_createUser) {
        this.str_createUser = str_createUser;
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

    public int getNum_sbId() {
        return num_sbId;
    }

    public void setNum_sbId(int num_sbId) {
        this.num_sbId = num_sbId;
    }

    public String getStr_sbName() {
        return str_sbName;
    }

    public void setStr_sbName(String str_sbName) {
        this.str_sbName = str_sbName;
    }
}
