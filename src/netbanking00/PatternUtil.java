package netbanking00;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 列挙型で記載
 *
 * 「正しい規定」を定義するクラス
 *  画面>「Email」、「電話番号」これらの項目は
 *  「Email」 :xxxxx@example.comの形式
 *  「携帯電話番号」:090-9999-9999
 *
 * @author WITC_Rie_Matsui
 * @since 2017/02/03
 * @version 0.1
 *
 */
public class PatternUtil {

	//列挙型で条件を記載し、条件を設定し呼び出すためのメソッド
	public enum PatternEnum{

		//英数字のみ:^[a-zA-Z-Z0-9] +$
		ALLNUM_DEF("^[a-zA-Z0-9]+$"),

		//英数字のみ(1文字以上20文字以下):^[a-zA-Z-Z0-9] +$
		ALLNUM_20LEN("^[a-zA-Z0-9]{1,20}+$"),
		
		//

		//すべてのASCⅡ文字[\x00-\x7F]
		//アスキーⅡとはアルファベットや記号で使われる文字コード表
		ASCⅡ("[\\x00-\\x7f]"),

		//10進数字のみ1文字以上20文字以下の整数:^[0-9]+$
		DIDIT_DEF("^[0-9]{1,20}+$"),

		//10進数字のみ1～2文字:^[0-9]+$
		DIGIT_ACCOUNT_2LEN("^[0-9]{1,2}+$"),

		//10進数字のみ1文字:^[0-9]+$
		DIGIT_ACC0UNT_1LEN("^[0-9]{1}+ $"),

		//小文字の英字のみ
		LOWER("^[a-z]+$"),

		//句読点文字:!"#$%&'()*+,-./:;<=>?@[]^_`{}+$"),
		PUNCT("#$%&'()*+,-./:;<=>?@[]^_`{}"),

		//郵便番号:半角数値3桁 半角ハイフン 半角数値4桁
		POSTNUMBER("^\\d{3}-\\d{4}-\\{4}$"),

		//携帯電話番号:半角数値3ケタ 半角ハイフン 半角数値４桁 半角ハイフン 半角数値４桁
		HANDPHONENUMBER("^\\d{3}-\\d{4}-\\d{4}$"),

		//固定電話番号:半角数値3ケタ 半角ハイフン 半角数値3桁 半角ハイフン 半角数値４桁
		FIXEDPHONENUMBER("^\\d{3}-\\d{3}-\\d{4}$"),

		//メールアドレス
		MAIL("^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$");


		//正規表現

		/**
		 * @param regex
		 *
		 */
		private final String regex;

		private PatternEnum(final String regx){
			this.regex = regx;
		}


		//正規表現を保持する{@code Pattern}オブジェクトを返却する
		@SuppressWarnings("unqualified-fild-access")
		public Pattern toPattern(){
			return Pattern.compile(regex);
		}

	}

	public PatternUtil() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//チェックメソッド
	public void check01() {

			//判定する文字列
			String str = "12345";
	
			//判定するパターンを生成
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(str);
	
			//画面表示
			//ルールにあっている場合 :true
			//ルールに合っていない場合：false
			System.out.println(m.find());

	}
	/**
	 * @param pattern
	 * @param input
	 * @return
	 *
	 */
	//第一引数と第二引数の値があっているかを真偽値で返す処理
	public static boolean findMatches(Pattern pattern,CharSequence input) {

		//第一引数と第二引数を比較
		final Matcher m = pattern.matcher(input);
		//結果を真偽値で返す
		return m.find();
	}

//TODO 消去予定 START-----------------------------------------------------
	/**
	 * TEST Driver
	 * @param args
	 */
	public static void main(String[] args) {

		//携帯電話番号の正規表現を取得
		final Pattern patternHANDPHONENUMBER=
				PatternEnum.HANDPHONENUMBER.toPattern();

		//結果と入力された値があっているかを確認
		final boolean resultHANDPHONENUMBER =
				PatternUtil.findMatches(patternHANDPHONENUMBER, "090-7581-0434");

		//ログを真偽値で出力
		System.out.println
		("携帯電話 MATCH確認[HANDPHONENUMBER]="+resultHANDPHONENUMBER);


		//Mailの確認(@以降未入力の場合)
		final Pattern patternX = PatternEnum.MAIL.toPattern();
		final boolean resultX = PatternUtil.findMatches(patternX, "test");
		System.out.println("MAIL MATCH 確認[test@]="+ resultX);

		//ドメイン未入力の場合
		final boolean resultY = PatternUtil.findMatches(patternX, "test@example");
		System.out.println("MAIL MATCH 確認[test@example]=" + resultY);

		//メールアドレス形式の場合
		final boolean resultZ = PatternUtil.findMatches(patternX, "test@example.com");
		System.out.println("MAIL MATHCH 確認[test@example.com]="	+resultZ );

		//ドメインのみの場合
		final boolean resultA = PatternUtil.findMatches(patternX, "@example.com");
		System.out.println("MAIL MATHCH 確認[@example.com]="	+resultA);

		//間に.が入る場合
		final boolean resultB = PatternUtil.findMatches
				(patternX, "test.co.jp@example.com");
		System.out.println("MAIL MATHCH 確認[test.co.jp@example.com]="+ resultB);

		//数字のみの場合
		final Pattern pattern0 = PatternEnum.DIDIT_DEF.toPattern();
		final boolean result0 = PatternUtil.findMatches(pattern0, "1234567890");
		System.out.println("数字 確認[1234567890]=" + result0);

		//２ケタの場合
		final Pattern pattern1 = PatternEnum.DIGIT_ACCOUNT_2LEN.toPattern();
		final boolean result1 = PatternUtil.findMatches(pattern1, "12");
		System.out.println("数字２ケタ 確認[12]="+ result1);

		//一文字の確認
		final Pattern pattern2 = PatternEnum.DIGIT_ACCOUNT_2LEN.toPattern();
		final boolean result2 = PatternUtil.findMatches(pattern2, "1");
		System.out.println("数字１ケタ 確認[1]=" + result2);

		//英数字もしくは記号のみ
		final Pattern pattern3 = PatternEnum.ASCⅡ.toPattern();
		final boolean result3 = PatternUtil.findMatches(pattern3, "あいう");
		System.out.println("すべてASCⅡ文字であるか=" + result3);


	}

	//TODO 消去予定エンド

}
