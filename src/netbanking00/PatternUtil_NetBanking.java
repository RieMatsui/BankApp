package netbanking00;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil_NetBanking {

	public PatternUtil_NetBanking() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public enum PatternEnum {

		//口座番号
		KOUZA_NUM("^(00[1-9]4)+(123|234|345|456|567|678|789)*$|^(01[1-5]4)+(123|234|345|456|567|678|789)*$"),

		//半角カタカナ
		HANKAKU_KATAKANA("^[ｧ-ﾝﾞﾟ]+$"),

		//全角ひらがなカタカナ
		ZENKAKU_KATAKANA("^[ァ-ン]+$"),

		//半角数字のみ 口座番号(1文字以上7文字以下):^[a-zA-Z-Z0-9] +$
		HANAKU_ALLNUM_7LEN("^[0-9]+$"),

		//全角英数字のみ(1文字以上20文字以下):^[a-zA-Z-Z0-9] +$
		ZENKAKU_ALLNUM_7LEN("^[０-９]+$"),

		//パスワード
		PASSWORD_ALLDEF("^[a-zA-Z0-9]{7,15}+$");
		private final String regex;

		private PatternEnum (final String regx) {
			this.regex = regx;
		}

		public Pattern toPattern(){
			return Pattern.compile(regex);
		}

	}

	public static boolean findMatches(Pattern pattern,CharSequence input) {

		//第一引数と第二引数を比較
		final Matcher m = pattern.matcher(input);
		//結果を真偽値で返す
		return m.find();
	}



	public static void main(String[] args) {
		final Pattern patternX = PatternEnum.KOUZA_NUM.toPattern();
		final boolean resultX = PatternUtil_NetBanking.findMatches(patternX, "0014567");
		System.out.println("MAIL MATCH 確認[test@]="+ resultX);



	}



}
