/**
 *
 */
package netbanking0214;

import javax.swing.JComboBox;

/**
 * @author WITC_NP02410A
 *
 */
public class CalendarEnvSetting {

	/**
	 * コンストラクタ
	 */
	public CalendarEnvSetting() {

	}
	/**
	 *
	 *
	 * @param comb
	 * static メソッドで作成
	 * 年数を取得するメソッド
	 *
	 */
	//FIXME 15歳以上は口座を開設できないことになっていることが多いので将来的には改善する
	public static void createNen (JComboBox comb){

		String year = null;
		int num_year = 0;

		comb.removeAllItems();
		comb.addItem("----");
		//1900から2019年まで取得
		for (int i = 1900; i <= 2019; i++) {
			comb.addItem(String.valueOf(i));
		}

	}
	public static void createTuki(JComboBox comb) {

		String day = null;
		int num_day = 0;

		comb.removeAllItems();
		comb.addItem("--");
		//1～12月まで取得
		for (int i = 1; i <= 12; i++) {
			comb.addItem(String.valueOf(i));

		}


	}
	/**
	 *
	 *
	 * @param comb
	 * @param lastDay
	 * 最後の日までコンボボックスを表示できるようするメソッド
	 * 最後の日を取得する際は画面から行う
	 *
	 */
	public static void createDay(JComboBox comb ,int lastDay) {

		//アイテムを初期化
		comb.removeAllItems();
		comb.addItem("--");

		//最後の日まで取得
		for (int i = 1; i <= lastDay; i++) {
			//int型をString型に変換してアイテムに追加
			comb.addItem(String.valueOf(i));

		}
	}

	public static void createMiseban(JComboBox comb) {

		String miseban = null;
		String day = null;
		int num_day = 0;

		comb.removeAllItems();
		comb.addItem("--");
		//1～12月まで取得
		for (int i = 1; i <= 15; i++) {
			comb.addItem(String.valueOf(i));

		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
