insert into TASK(title, reg_date, upd_date, fin_yn) values('집안일', sysdate, sysdate,'N');
insert into TASK(title, reg_date, upd_date, fin_yn) values( '운동', sysdate, sysdate, 'N');
insert into TASK(title, reg_date, upd_date, fin_yn, parent_id) values('청소', sysdate, sysdate, 'Y', '1');
insert into TASK(title, reg_date, upd_date, fin_yn, parent_id) values('빨래', sysdate, sysdate, 'N', '1');

