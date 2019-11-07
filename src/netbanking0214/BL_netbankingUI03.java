package netbanking0214;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import netbanking0214.PatternUtil_NetBanking.PatternEnum;

public class BL_netbankingUI03 {

	public BL_netbankingUI03() {

	}
	//TODO プロパティファイルにエラーメッセージを記載
    //未入力チェックメソッド
	public boolean checkNull(final DTO_netbankingUI03 _paramData) {
		System.out.println("checkNullメソッド");
		if (_paramData.getStr_sei().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>カナ氏名の姓を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_mei().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>カナ氏名の名を入力してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_year().equals("----")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>西暦を選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_month().equals("--")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>誕生月を選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		else if (_paramData.getStr_day().equals("--")) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>誕生日の日にちを選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}


		else if (_paramData.getStr_shitenmei().isEmpty()) {
			JOptionPane.showMessageDialog(null,
										  "TESTMESSAGE>店番を選択してください",
										  "TESTTITLE>エラーメッセージ",
										  JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

	    return true;


	}



	public boolean  checkKanashimei(final DTO_netbankingUI03 _paramData) {
		System.out.println("カナ氏名チェックメソッド");

		String name = null;
		String sei = null;
		String mei = null;

//FIXME 文字列を正規表現の場所に移す
		String Zenkaku ="アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンァィゥェォャュョッ";
		String Hankaku = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｧｨｩｪｫｬｭｮｯ";
		String z_DakuHanbaku = "ガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴ";
		String h_Dakuon = "ｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾊﾟﾋﾞﾋﾟﾌﾞﾌﾟﾍﾞﾍﾟﾎﾞﾎﾟｳﾞ";
		String onemoji = null;
		String res = null;
		int index_num = 0;
		int counnt =0;
		StringBuilder sb = new StringBuilder();

		//文字列データをDTOから取得
		sei = _paramData.getStr_sei();
		mei = _paramData.getStr_mei();

		for (int i = 0; i < _paramData.getStr_name().length(); i++) {

			//一文字づつにする
			onemoji = _paramData.getStr_name().substring(i,i+1);
			System.out.println(onemoji);

			//半角カナの正規表現
			final Pattern p_hankaku = PatternEnum.HANKAKU_KATAKANA.toPattern();
			final boolean res_p_hankaku = PatternUtil_NetBanking.findMatches(p_hankaku, onemoji);

			//全角カナの正規表現

			final Pattern p_zenkaku = PatternEnum.ZENKAKU_KATAKANA.toPattern();
			final boolean res_p_zenkaku =  PatternUtil_NetBanking.findMatches(p_zenkaku, onemoji);

			//全角濁音、半濁音に一致する場合

			final Pattern p_dakuon_handakuon = PatternEnum.ZENKAKU_DAKU_HANDAKUON.toPattern();
			final boolean res_p_daku_handaku = PatternUtil_NetBanking.findMatches(p_dakuon_handakuon, onemoji);


			//半角カナ文字に一致するとき
			if (res_p_hankaku) {
				sb.append(onemoji);


			}

			//濁音半濁音の場合
			else if (res_p_daku_handaku) {
				//同じ文字の場所を取得
				index_num = Zenkaku.indexOf(onemoji);

				index_num = z_DakuHanbaku.indexOf(onemoji);
				res = h_Dakuon.substring(index_num*2, index_num*2+2);
				System.out.println(res);
				sb.append(res);
				counnt++;

			}

			//全角カナ文字に一致するとき
			else if(res_p_zenkaku){

					//同じ文字の場所を取得
					index_num = Zenkaku.indexOf(onemoji);

					res = Hankaku.substring(index_num, index_num +1);
System.out.println(res);
					sb.append(res);

			}

			//カタカナでない場合はエラーメッセージ
			else  {
				JOptionPane.showMessageDialog(null,
						"不正な文字が入力されました。半角カナで入力してください",
						"エラー",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}


		}

		System.out.println(sb.toString());

		//変換した名前をDTOにセットする
		_paramData.setStr_name(sb.toString());


		//姓、名を取得する
		sei = _paramData.getStr_sei();
		mei = _paramData.getStr_mei();

		sei = sb.toString().substring(0, sei.length() + counnt);
		mei = sb.toString().substring(sei.length(), sb.toString().length());

		System.out.println("変換後の「姓」" + sei);
		System.out.println("変換後の「名」" + mei);

		_paramData.setStr_sei(sei);
		_paramData.setStr_mei(mei);

		return true;

	}


	//ファサードパターンで一括で呼び出す

	public boolean checkAvailableInfomation(final DTO_netbankingUI03 _paramDto) {

		//TODO 先生に確認してもらう
		System.out.println("処理開始");
		if (!checkNull(_paramDto)) {
			return false;
		}

		else if (!checkKanashimei(_paramDto)) {
			return false;
		}

System.out.println("処理終了");
		return true;


	}


	//BLで編集した文字列をDTOに渡すメソッド
	public  DTO_tmp_netbanking saveDto(DTO_netbankingUI03 _paramData) {
		System.out.println("BLで編集した文字列をDTOに渡すメソッド");
		DTO_tmp_netbanking vrb_dto_tmp = new DTO_tmp_netbanking(
				null,
				null,
				_paramData.getStr_sei(),
				_paramData.getStr_mei(),
				_paramData.getStr_birthday(),
				new Timestamp(System.currentTimeMillis()),
				_paramData.getStr_name(),
				Integer.parseInt(_paramData.getStr_miseban()),
				_paramData.getStr_shitenmei(),
				4,
				_paramData.getStr_kamoku()
				);

		System.out.println(vrb_dto_tmp.getStr_userId());
		System.out.println(vrb_dto_tmp.getStr_sei());
		System.out.println(vrb_dto_tmp.getStr_mei());
		System.out.println(vrb_dto_tmp.getStr_birthday());
		System.out.println(vrb_dto_tmp.getTimestamp());
		System.out.println(vrb_dto_tmp.getStr_createName());
		System.out.println(vrb_dto_tmp.getNum_brId());
		System.out.println(vrb_dto_tmp.getStr_brName());
		System.out.println(vrb_dto_tmp.getNum_subId());
		System.out.println(vrb_dto_tmp.getStr_subName());

		//リストにする
	    List<DTO_tmp_netbanking> vrb_list = new ArrayList<DTO_tmp_netbanking>();
	    vrb_list.add(vrb_dto_tmp);

	    System.out.println(vrb_dto_tmp.getStr_brName());

		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;

		try {
			vrb_con = vrb_abs.dbConection();
			int rtn = vrb_abs.insertTmpUser(vrb_con, vrb_dto_tmp);

			if (rtn == 0) {
				System.out.println("登録エラー");
				JOptionPane.showMessageDialog(null,
						  "TESTMESSAGE>店番を正しく入力してください",
						  "TESTTITLE>エラーメッセージ",
						  JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vrb_dto_tmp;

	}

	public void regsterTmpUser() {
		System.out.println("一時テーブルに保存するメソッド");
		int res = 0;
		JDBCAbstractTemplate vrb_abs = new JDBCTmplMySQL();
		Connection vrb_con;

		try {
			vrb_con = vrb_abs.dbConection();
			DTO_netbankingUI03 vrb_ui3 = new DTO_netbankingUI03();
			res =  vrb_abs.insertTmp(vrb_con, saveDto(vrb_ui3));

			if (res == 0) {
				JOptionPane.showMessageDialog(null,
						"TESTMESSAGE>不正なデータが入力されました",
						"TITLE>エラー",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void prin() {

	}

	//文字を配列で登録しなおす
	public void saveArray(DTO_netbankingUI03 _paramData) {

		List<String> list_user  = new ArrayList<String>();

		list_user.add("USERID");
		list_user.add("PASSWORD");
		list_user.add(_paramData.getStr_sei());
		list_user.add(_paramData.getStr_mei());
		list_user.add(_paramData.getStr_birthday());
		list_user.add(_paramData.getStr_shitenmei());
		list_user.add("2000-01-01 12:00:00.000"); //テスト
		list_user.add(_paramData.getStr_miseban());

	}

	//画面でBLを呼び出す呼び出すことを想定した書き方
	public static void main(String[] args) {

	}

}
