package netbanking00;

//JDBCに用いるJava標準ライブラリをimportする

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//*;であらゆるデータベースを読みだすことができるが処理速度が遅くなる

/*
 *
 * Java - JDBC データを検索ロジック・サンプルDatabass:MySQLとして、
 * その内部で保管しているデータ項目に対してJavaクラスよりアクセス
 * MySQL接続→データテーブルに対するSQL文発行→データ取得)・表示を行う
 *
 * @since 2017/1
 * @version 1.0
 *
 *
 */
public class JDBC_ReadDataTest {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ

        StringBuilder sb = new StringBuilder(); //
        Connection con = null;
        ResultSet rst = null;
        PreparedStatement pstmt = null;

        String param_Id = null;
        String param_password = null;
        String rsCol_Id = null;
        String rsCol_birth = null;

        try {
            //JDBCのダウンロード
            //JDBCドライバを読み込む・Classの静的メソッドで
            //JDBCドライバをロードする（JDBC Driver登録）
            Class.forName("com.mysql.jdbc.Driver");

            //MySQLデータベースへの接続取得・引数の設定
            //localhost はIPアドレスでもOK/データベース名/ユーザー名/パスワードを記載
            String url = "jdbc:mysql://localhost/witc_si_kenshu?user=root&password=root";

            //コネクションの取得
            //ドライバマネージャーからデータベースへ接続
            con = DriverManager.getConnection(url);

            //SQLステートメントの作成

            sb.append("SELECT");
            sb.append(" *");
            sb.append(" FROM");
            sb.append(" T_M_BANK_USER");
            sb.append(" WHERE");
            sb.append(" USER_ID= ");
            sb.append(" ?");

            pstmt = con.prepareStatement(sb.toString()); //QSL文を宣言することを記載
            pstmt.setString(1, "admin");

            //SQL文実行
            rst = pstmt.executeQuery(); //resultset 結果を設定

            System.out.println("USER_ID" + "\t" + "USER_BIRTH");
            System.out.println("------------------");

            while (rst.next()) {
                //データベース内のテーブル：T_MST_USER内カラム
                //「U_ID」を参照・取得（列番号による指定）
                rsCol_Id = rst.getString("USER_ID"); //SQLからの文字列の取得
                rsCol_birth = rst.getString("USER_BIRTH"); //SQLからの文字列の取得
                System.out.println(rsCol_Id + "\t" + rsCol_birth);
            }
        } catch(Exception ec){    //例外処理
            ec.printStackTrace();   //エラーの状態を表示
        } finally {
            try{
                //データ結果をセットインスタンスがクローズされていない場合、クローズ
                if (rst!= null) {
                    //結果セットをクローズ
                    rst.close();
                }
                //PreparedStatementインスタンスがクローズされていない場合クローズ
                if (pstmt != null) {
                    //接続をクローズ
                    rst.close();
                }
                //コネクションインスタンスがクローズされていない場合クローズ
                if (con != null) {
                    //接続をクローズ
                    con.close();
                }
                sb = null;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
