package netbanking0219;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JDBCAbstractTemplate {

	public JDBCAbstractTemplate() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * DB接続
	 * @throws SQLEXceptoin
	 *
	 */
	public abstract Connection dbConection() throws SQLException;
	/**
	 *
	 * @param con
	 * @param startCom
	 * @throws SQLException
	 */
	public void setAutoCommit(Connection con, boolean startCom)throws SQLException {
		con.setAutoCommit(startCom);
	}
	/**
	 *
	 * @param con
	 * @throws SQLException
	 */
	public void commit(Connection con) throws SQLException {
		con.commit();
	}
	/**
	 *
	 * @param con
	 * @throws SQLException
	 */
	public void rollback(Connection con) throws SQLException {
		con.rollback();
	}
	/**
	 *
	 * @param con
	 * @throws SQLException
	 */
	public void conClose(Connection con) throws SQLException{
		if (con != null) {
			con.close();
		}
	}
	/**
	 *
	 * @param psmt
	 * @throws SQLException
	 */
	public void psmtClose(PreparedStatement psmt) throws SQLException{
		if (psmt != null) {
			psmt.close();
		}
	}

	public void rstClose(ResultSet rst) throws SQLException {
		if (rst != null) {
			rst.close();
		}
	}
	/**
	 *
	 * @param con
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public abstract int findBrichID (Connection con, String branch) throws SQLException;
	/**
	 *
	 * @param con
	 * @param branc
	 * @return
	 * @throws SQLException
	 */
	public abstract int findAccountNo(Connection con, String branch) throws SQLException;
	/**
	 *
	 *
	 * @param con
	 * @param _paramListData
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertUser(Connection con,DTO_userTable_netbankingUI05 _paramDTO) throws SQLException;
	/**
	 *
	 * @param con
	 * @param branchNo
	 * @return
	 * @throws SQLException
	 */
	public abstract String getSitenMei(Connection con, String branchNo) throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramDTO
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertTmpUser(Connection con, DTO_tmp_netbanking _paramDTO) throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramDTO
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertErrorTable(Connection con, DTO_netbankingUI04 _paramDTO)throws SQLException;
	/**
	 *
	 * @param con
	 * @param string
	 * @return
	 * @throws SQLException
	 */
	public abstract int updateTmpUserPassword(Connection con,String str_userPassword,int str_userId) throws SQLException;
	/**
	 *
	 * @param con
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public abstract int getIncrementKey(Connection con,String sql)throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramDTO
	 * @return
	 * @throws SQLException
	 */
	public abstract int deleatTempUser(Connection con, int _paramTmpUserId) throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramAccount
	 * @return
	 */
	public abstract int updateAccounNum(Connection con, int _paramAccount , int _paramUserId)throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramAccount
	 * @param _paramPassword
	 * @return
	 * @throws SQLException
	 */
	public abstract int selectLogin(Connection con, int _paramAccount, String _paramPassword)throws SQLException;
}
