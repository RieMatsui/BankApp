package netbanking0219;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		// TODO 先生にあとで確認

		String miseban ="015";
		String kouza = "015628";

		String res_miseban = String.format("%3s",miseban ).replace(" ", "0");
		String res_kouza = String.format("%7s", kouza).replace(" ", "0" );
		Pattern p =  Pattern.compile("(00[1-9]4)|(01[1-5]4)(123)|(234)|(345)|(456)|(567)|(678)|(789)*$");
		final  Matcher m = p.matcher(res_kouza);
		System.out.println(res_kouza.substring(0, 3));
		System.out.println(res_miseban);
		int num_miseban = Integer.parseInt(res_miseban);
		int num_koza = Integer.parseInt(res_kouza.substring(0,3));

		if (num_miseban != num_koza || !m.find()) {
			System.out.println("店番と支店名が違います");

		}


	}


}
