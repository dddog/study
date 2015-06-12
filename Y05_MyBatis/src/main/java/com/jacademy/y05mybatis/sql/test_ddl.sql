select * from hero order by sno desc;

create table hero(
	sno number(6) not null primary key,
	name varchar2(20) not null,
	age number(3) not null
);

create sequence hero_seq
	start with 1 increment by 1
	nocache nocycle nomaxvalue;
	
insert into hero(sno, name, age) values(hero_seq.NEXTVAL, 'superman', 33);

select count(*) from hero;

select * from (
	select rownum as rnum, a.* from (select * from hero order by sno desc) a
) where sno >= 1 and sno <= 10;

select last_number from user_sequences where sequence_name='HERO_SEQ';

select * from hero
where 1=1 and name like '%iron%' and age=33;
