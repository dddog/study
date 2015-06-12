
select * from (
select rownum as rnum, a.* from ( select * from emp ) a )
where rnum >=1 and rnum <= 10