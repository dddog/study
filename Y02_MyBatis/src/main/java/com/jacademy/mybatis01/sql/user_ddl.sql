select * from user3;

CREATE TABLE  user3 (
  user_id number(10) NOT NULL primary key,
  email_id varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) default NULL
);

create sequence user3_seq 
	start with 1 increment by 1
	nomaxvalue nocache nocycle;

--시쿼스로부터 다음에 일련번호값을 구한다.
SELECT last_number
FROM user_sequences
WHERE sequence_name = 'USER3_SEQ';