select * from emp;

select column_name, data_type from ALL_TAB_COLUMNS where TABLE_NAME='EMP';

select * from emp where deptno = 10;

--SqlDeveloper에서 실행 할 것
create or replace FUNCTION iffn(
	boolean_expression in BOOLEAN,
	true_number IN NUMBER,
	false_number IN NUMBER
)
RETURN NUMBER IS
BEGIN
    IF boolean_expression THEN
		RETURN true_number;
    ELSIF NOT boolean_expression THEN
		RETURN false_number;
    ELSE
		--nulls propagate, i.e. null input yields null output.
		RETURN NULL;
    END IF;
END;
/

--교재에서 사용하는 함수

create or replace package types as type currtype is ref cursor;
end;
/

create or replace function getEmp(v_deptno in number) return types.currtype
AS
	emp_cursor types.currtype;
	sql_string VARCHAR2(500);
BEGIN
	sql_string := 'SELECT empno, ename, sal FROM EMP WHERE DEPTNO = :1';
	OPEN emp_cursor FOR sql_string USING v_deptno;
	RETURN emp_cursor;
	CLOSE emp_cursor;
END;
/