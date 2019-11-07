package netbanking0214;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	public abstract int insertUser01(Connection con,List<?> _paramListData) throws SQLException;
	/**
	 *
	 * @param con
	 * @param i
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertTmp(Connection con, DTO_tmp_netbanking dto_tmp_netbanking) throws SQLException;
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
	 * @param _paramDTO
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertUser(Connection con,DTO_netbankingUI05 _paramDTO) throws SQLException;
	/**
	 *
	 * @param con
	 * @param _paramUserID
	 * @return
	 * @throws SQLException
	 */
	public abstract int deleatTempUser(Connection con,DTO_netbankingUI05 _paramUserID) throws SQLException;

	public abstract int confirmPassword(Connection con,DTO_netbankingUI05 _paramPassword)throws SQLException;






}
