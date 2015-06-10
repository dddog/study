package onj.edu.jdbc.p228.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import onj.edu.jdbc.p228.model.Emp;
import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao extends StoredProcedure {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	//3번째 방법에서 사용
	private static final String SQL = "getEmp";

	@Autowired
	public EmpDao(DataSource dataSource) {
		//3번째 방법에서 사용
		super(dataSource, SQL);
		setFunction(true);
		declareParameter(new SqlOutParameter("emp_cursor", OracleTypes.CURSOR, new EmpMapper()));
		declareParameter(new SqlParameter("v_deptno", Types.INTEGER));
		
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//1. SimpleJdbcCall을 이용하는 방법
	@SuppressWarnings("unchecked")
	public List<Emp> listEmp(Integer deptno) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.dataSource)
				.withSchemaName("scott")
				.withFunctionName("getEmp")
				.declareParameters(
						new SqlOutParameter("emp_cursor", OracleTypes.CURSOR,
								new EmpMapper()),
						new SqlParameter("v_deptno", Types.INTEGER))
				.withoutProcedureColumnMetaDataAccess();

		SqlParameterSource params = new MapSqlParameterSource("v_deptno",
				deptno);

		// execute 메서드는 Map형태로 리턴
		Map<String, Object> resultSet = simpleJdbcCall.execute(params);
		return (List<Emp>) resultSet.get("emp_cursor");
	}

	//2. 기존 JDBC처럼 CallableStatement 이용
	public List<Emp> listEmp2(final Integer deptno) {

		CallableStatementCallback<List<Emp>> cb = new CallableStatementCallback<List<Emp>>() {
			@Override
			public List<Emp> doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {

				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.setInt(2, deptno);
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(1);

				List<Emp> emps = new ArrayList<Emp>();
				EmpMapper mapper = new EmpMapper();
				for (int i = 0; rs.next(); i++) {
					emps.add(mapper.mapRow(rs, i));
				}
				return emps;
			}
		};

		return jdbcTemplate.execute("{? = call getEmp(?)}", cb);
	}

	//3. Spring Framework의 StoredProcedure를 상속 받아 구현
	@SuppressWarnings("unchecked")
	public List<Emp> listEmp3(Integer deptno) {
		Map<String, Object> resultSet = execute(deptno);
		ArrayList<Emp> list = (ArrayList<Emp>) resultSet.get("emp_cursor");
		return list;
	}
}
