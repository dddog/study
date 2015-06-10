select * from emp3;

create table emp3(
	empno number(3) not null primary key,
	ename varchar2(20) not null,
	deptno number(2) not null
);

delete emp3 where 1=1;
commit;