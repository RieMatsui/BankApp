package netbanking0219;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import netbanking0219.PatternUtil_NetBanking.PatternEnum;

public class TestZenakuhankaku {

	public TestZenakuhankaku() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("口座座番号全角半角確認メソッド");
	    String kouza  = "０１４４５６";
	    String miseban = "０１";
	    String one_num = null;

	    StringBuilder sbPlus = new StringBuilder();
	    StringBuilder sb = new StringBuilder();



	    sbPlus.append(miseban);
	    sbPlus.append(kouza);


	    //半角数字の正規表現
	    final Pattern p_hankaku = PatternEnum.HANAKU_ALLNUM_7LEN.toPattern();
	    final boolean res_hanaku = PatternUtil_NetBanking.findMatches
	    								(p_hankaku, sbPlus.toString());
	    //全角数字正規表現
	    final Pattern p_zenkaku = PatternEnum.ZENKAKU_ALLNUM_7LEN.toPattern();
	    final boolean res_zenaku = PatternUtil_NetBanking.findMatches(p_zenkaku, sbPlus.toString());

	    //入力された文字を一文字づつ調べる
	    for (int i = 0; i < sbPlus.toString().length(); i++) {

	    	one_num	= sbPlus.toString().substring(i, i+1);

	    	System.out.println(sbPlus.toString());
	    	System.out.println(one_num);

	    	if (res_hanaku || res_zenaku) {
	    		
	       		String res =  Normalizer.normalize(one_num, Form.NFKC);
	       		
	    		sb.append(res);
	    	}

	    	else {
	    		
				JOptionPane.showMessageDialog(null,
						"不正な文字が入力されました。半角数字で入力してください",
						"エラー",
						JOptionPane.INFORMATION_MESSAGE);
				return ;
				
			}
	    	
		    System.out.println(sb.toString());

		}



	}

	    


}
