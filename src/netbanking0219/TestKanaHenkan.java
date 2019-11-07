package netbanking0219;

public class TestKanaHenkan {

	public TestKanaHenkan() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String name = "ｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾊﾟﾋﾞﾋﾟﾌﾞﾌﾟﾍﾞﾍﾟﾎﾞﾎﾟｳﾞ";
		String Zenkaku ="アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンァィゥェォャュョッ";
		String Hankaku = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｧｨｩｪｫｬｭｮｯ";
		String z_DakuHanbaku = "ガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴ";
		String h_Dakuon = "ｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾊﾟﾋﾞﾋﾟﾌﾞﾌﾟﾍﾞﾍﾟﾎﾞﾎﾟｳﾞ";
		String onemoji = null;
		String res = null;
		int index_num = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < name.length(); i++) {

			//一文字づつにする
			onemoji = name.substring(i,i+1);


			//同じ文字の場所を取得
			index_num = Zenkaku.indexOf(onemoji);

			//文字列の場所を取得
			System.out.println(index_num);

			//濁音半濁音の場合
			if (index_num  < 0) {

				index_num = z_DakuHanbaku.indexOf(onemoji);
				res = h_Dakuon.substring(index_num*2, index_num*2+2);
				System.out.println(res);
				sb.append(res);

			}

			//文字を取得
			else {
				res = Hankaku.substring(index_num, index_num +1);
				System.out.println(res);
				sb.append(res);
			}

		}

		System.out.println(sb.toString());


	}


}
