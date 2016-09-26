insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');
select * from users;
insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1004, '安定门', 1001);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1005, '北新桥', 1001);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1006, '朝阳门', 1001);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1007, '百万庄', 1002);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1008, '德胜门', 1002);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1009, '八宝山', 1003);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1010, '金顶街', 1003);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1011, '北大地', 1000);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1012, '菜户营', 1000);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1013, '东大桥', 1006);

insert into housetype (ID, NAME)
values (1000, '一室一厅');
insert into housetype (ID, NAME)
values (1001, '一室两厅');
insert into housetype (ID, NAME)
values (1002, '两室一厅');
insert into housetype (ID, NAME)
values (1003, '两室两厅');
insert into housetype (ID, NAME)
values (1004, '三室一厅');
insert into housetype (ID, NAME)
values (1005, '三室两厅');
insert into housetype (ID, NAME)
values (1006, '四室一厅');
insert into housetype (ID, NAME)
values (1007, '四室两厅');
insert into housetype (ID, NAME)
values (1008, '四十三厅');
delete from users;
insert into users (id,name ,password,telephone,username,isadmin) values 
(1,'admin','0cc175b9c0f1b6a831c399e269772661','1233456789','admin','1');
insert into users (id,name ,password,telephone,username,isadmin) 
values (2,'a','0cc175b9c0f1b6a831c399e269772661','1233456789','a','0');
         
         

