/**
 * 
 */
package netbanking0219;

import java.sql.Timestamp;

/**
 * @author WITC_RieMatsui
 *
 */
public class Timestamp_bank {
	/**
	 * 
	 */
	public Timestamp_bank() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Timestamp createTimeStamp() {
		Timestamp timestamp = null;
		timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timestamp str = null;
	    str = new Timestamp(System.currentTimeMillis());
	    System.out.println(str);

	}

}
