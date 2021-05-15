insert into movie values(0,'hero')
insert into movie values(1,'master')
insert into movie values(2,'doctor')
insert into movie values(3,'founder')

insert into CINIMA_HALL values(1000,'PVR')
insert into CINIMA_HALL values(1001,'IMAX')
insert into CINIMA_HALL values(1002,'Phoenix')

/*PVR*/
insert into SCREEN   values(100,'PVRSCREEN 1',1000)
insert into SCREEN   values(101,'PVRSCREEN 2',1000)
insert into SCREEN   values(102,'PVRSCREEN 3',1000)

/*IMAX*/
insert into SCREEN   values(103,'IMAXSCREEN 1',1001)
insert into SCREEN   values(104,'IMAXSCREEN 2',1001)
insert into SCREEN   values(105,'IMAXSCREEN 3',1001)
insert into SCREEN   values(106,'IMAXSCREEN 4',1001)

/*Phoenix*/
insert into SCREEN  values(107,'PhoenixSCREEN 1',1001)
insert into SCREEN  values(108,'PhoenixSCREEN 2',1001)
insert into SCREEN  values(109,'PhoenixSCREEN 3',1001)
insert into SCREEN  values(110,'PhoenixSCREEN 4',1001)
insert into SCREEN  values(111,'PhoenixSCREEN 5',1001)
insert into SCREEN  values(112,'PhoenixSCREEN 6',1001)

/*PVR saturday*/

/*PVR SCREEN  1 */
/*Mor Show*/
insert into SHOW values(10000,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),0,100)
/*Noon Show*/
insert into SHOW values(10001,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),3,100)
/*Eve Show*/
insert into SHOW values(10002,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,100)

/*PVR SCREEN  2 - 3 Shows*/
insert into SHOW values(10003,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
insert into SHOW values(10004,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
insert into SHOW values(10005,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
/*PVR SCREEN  3*/
insert into SHOW values(10006,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),2,102)
insert into SHOW values(10007,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),2,102)
insert into SHOW values(10008,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),3,102)

/*PVR Sunday*/

/*PVR SCREEN  1 - 3 Shows*/
insert into SHOW values(10009,7200,TO_TIMESTAMP('2021-05-16 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),0,100)
insert into SHOW values(10010,7200,TO_TIMESTAMP('2021-05-16 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),3,100)
insert into SHOW values(10011,7200,TO_TIMESTAMP('2021-05-16 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,100)
/*PVR SCREEN  2 - 3 Shows*/
insert into SHOW values(10012,7200,TO_TIMESTAMP('2021-05-16 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
insert into SHOW values(10013,7200,TO_TIMESTAMP('2021-05-16 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
insert into SHOW values(10014,7200,TO_TIMESTAMP('2021-05-16 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,101)
/*PVR SCREEN  3 - 3 Shows*/
insert into SHOW values(10015,7200,TO_TIMESTAMP('2021-05-16 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),2,102)
insert into SHOW values(10016,7200,TO_TIMESTAMP('2021-05-16 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),2,102)
insert into SHOW values(10017,7200,TO_TIMESTAMP('2021-05-16 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),3,102)


/*IMAX saturday*/

/*IMAX SCREEN  1 - 3 Shows*/
insert into SHOW values(10018,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),0,103)
insert into SHOW values(10019,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),3,103)
insert into SHOW values(10020,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,103)
/*IMAX SCREEN  2 - 3 Shows*/
insert into SHOW values(10021,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,104)
insert into SHOW values(10022,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),1,104)
insert into SHOW values(10023,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,104)
/*IMAX SCREEN  3 - 3 Shows */
insert into SHOW values(10024,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),2,105)
insert into SHOW values(10025,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),2,105)
insert into SHOW values(10026,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),3,105)
/*IMAX SCREEN  4 - 3 Shows*/
insert into SHOW values(10027,7200,TO_TIMESTAMP('2021-05-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),3,106)
insert into SHOW values(10028,7200,TO_TIMESTAMP('2021-05-15 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),0,106)
insert into SHOW values(10029,7200,TO_TIMESTAMP('2021-05-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'),3,106)



insert into BOOKING values('B1',0,CURRENT_TIMESTAMP,'user1',10000)
/*PVR saturday SCREEN  1 noon Show 2 seat*/
insert into BOOKING values('B2',0,CURRENT_TIMESTAMP,'user2',10001)
/*PVR saturday SCREEN  1 Eve Show 2 seat*/
insert into BOOKING values('B3',0,CURRENT_TIMESTAMP,'user2',10002)


/*PVR SCREEN1 Saturday MorShow Seats– 10000, 10001, 10002, 10009, 10010, 10011 */

insert into SEAT  values(10,0,1,'B1',100, 10000) 
insert into SEAT  values(11,0,2,null,100, 10000)
insert into SEAT  values(12,0,3,null,100, 10000)
insert into SEAT  values(13,1,1,null,100, 10000)
insert into SEAT  values(14,1,2,null,100, 10000)
insert into SEAT  values(15,1,3,null,100, 10000)


/*PVR SCREEN2  Sat 3 Mor Show Seats 10003,4,5*/
insert into SEAT  values(16,0,1,null,101, 10003)
insert into SEAT  values(17,0,2,null,101, 10003)
insert into SEAT  values(18,0,3,null,101, 10003)
insert into SEAT  values(19,1,1,null,101, 10003)
insert into SEAT  values(20,1,2,null,101, 10003)
insert into SEAT  values(21,1,3,null,101, 10003)

/*PVR SCREEN3 MOr Show  Seats */
insert into SEAT  values(22,0,1,null,103,10015)
insert into SEAT  values(23,0,2,null,103,10015)
insert into SEAT  values(24,0,3,null,103,10015)
insert into SEAT  values(25,1,1,null,103,10015)
insert into SEAT  values(26,1,2,null,103,10015)
insert into SEAT  values(27,1,3,null,103,10015)

/*IMAX SCREEN1 Sat Mor Seats */
insert into SEAT  values(28,0,1,null,103, 10018)
insert into SEAT  values(29,0,2,null,103, 10018)
insert into SEAT  values(30,0,3,null,103, 10018)
insert into SEAT  values(31,1,1,null,103, 10018)
insert into SEAT  values(32,1,2,null,103, 10018)
insert into SEAT  values(33,1,3,null,103, 10018)


/*PVR SCREEN1 Saturday NoonShow Seats */
insert into SEAT  values(34,0,1,null,100, 10001) 
insert into SEAT  values(35,0,2,null,100, 10001)
insert into SEAT  values(36,0,3,null,100, 10001)
insert into SEAT  values(37,1,1,null,100, 10001)
insert into SEAT  values(38,1,2,'B2',100, 10001)
insert into SEAT  values(39,1,3,'B2',100, 10001)

/*PVR SCREEN1 Saturday Evehow Seats */
insert into SEAT  values(40,0,1,null,100, 10002) 
insert into SEAT  values(41,0,2,null,100, 10002)
insert into SEAT  values(42,0,3,null,100, 10002)
insert into SEAT  values(43,1,1,null,100, 10002)
insert into SEAT  values(44,1,2,'B3',100, 10002)
insert into SEAT  values(45,1,3,'B3',100, 10002)

/*PVR SCREEN1 Sunday MorShow Seats */
insert into SEAT  values(46,0,1,null,100, 10009) 
insert into SEAT  values(47,0,2,null,100, 10009)
insert into SEAT  values(48,0,3,null,100, 10009)
insert into SEAT  values(49,1,1,null,100, 10009)
insert into SEAT  values(50,1,2,null,100, 10009)
insert into SEAT  values(51,1,3,null,100, 10009)

/*PVR SCREEN1 Sunday NoonShow Seats */
insert into SEAT  values(52,0,1,null,100, 10010) 
insert into SEAT  values(53,0,2,null,100, 10010)
insert into SEAT  values(54,0,3,null,100, 10010)
insert into SEAT  values(55,1,1,null,100, 10010)
insert into SEAT  values(56,1,2,null,100, 10010)
insert into SEAT  values(57,1,3,null,100, 10010)

/*PVR SCREEN1 Sunday EveShow Seats */
insert into SEAT  values(58,0,1,null,100, 10011) 
insert into SEAT  values(59,0,2,null,100, 10011)
insert into SEAT  values(60,0,3,null,100, 10011)
insert into SEAT  values(61,1,1,null,100, 10011)
insert into SEAT  values(62,1,2,null,100, 10011)
insert into SEAT  values(63,1,3,null,100, 10011)





/*PVR SCREEN2  Sat 3 noon Show Seats 10004,5*/

insert into SEAT  values(64,0,1,null,101, 10004)
insert into SEAT  values(65,0,2,null,101, 10004)
insert into SEAT  values(66,0,3,null,101, 10004)
insert into SEAT  values(67,1,1,null,101, 10004)
insert into SEAT  values(68,1,2,null,101, 10004)
insert into SEAT  values(69,1,3,null,101, 10004)

/*PVR SCREEN2  Sat 3 Eve Show Seats 10005*/


insert into SEAT  values(70,0,1,null,101, 10005)
insert into SEAT  values(71,0,2,null,101, 10005)
insert into SEAT  values(72,0,3,null,101, 10005)
insert into SEAT  values(73,1,1,null,101, 10005)
insert into SEAT  values(74,1,2,null,101, 10005)
insert into SEAT  values(75,1,3,null,101, 10005)





/*PVR SCREEN3 Noon Show  Seats */
insert into SEAT  values(76,0,1,null,103, 10016)
insert into SEAT  values(77,0,2,null,103, 10016)
insert into SEAT  values(78,0,3,null,103, 10016)
insert into SEAT  values(79,1,1,null,103, 10016)
insert into SEAT  values(80,1,2,null,103, 10016)
insert into SEAT  values(81,1,3,null,103, 10016)

/*PVR SCREEN3 Eve Show  Seats */
insert into SEAT  values(82,0,1,null,103, 10017)
insert into SEAT  values(83,0,2,null,103, 10017)
insert into SEAT  values(84,0,3,null,103, 10017)
insert into SEAT  values(85,1,1,null,103, 10017)
insert into SEAT  values(86,1,2,null,103, 10017)
insert into SEAT  values(87,1,3,null,103, 10017)





/*IMAX SCREEN1 Sat Noon Seats */
insert into SEAT  values(88,0,1,null,103, 10019)
insert into SEAT  values(89,0,2,null,103, 10019)
insert into SEAT  values(90,0,3,null,103, 10019)
insert into SEAT  values(91,1,1,null,103, 10019)
insert into SEAT  values(92,1,2,null,103, 10019)
insert into SEAT  values(93,1,3,null,103, 10019)


/*IMAX SCREEN1 Sat Eve Seats */
insert into SEAT  values(94,0,1,null,103, 10020)
insert into SEAT  values(95,0,2,null,103, 10020)
insert into SEAT  values(96,0,3,null,103, 10020)
insert into SEAT  values(97,1,1,null,103, 10020)
insert into SEAT  values(98,1,2,null,103, 10020)
insert into SEAT  values(99,1,3,null,103, 10020)


insert into SEAT_LOCK values(1,CURRENT_TIMESTAMP,'user1',CURRENT_TIMESTAMP + interval '120' second,10)
/*PVR saturday SCREEN1 noon Show 2(last row corner) seat*/
insert into SEAT_LOCK values(2,CURRENT_TIMESTAMP,'user2',CURRENT_TIMESTAMP + interval '120' second ,38)
insert into SEAT_LOCK values(3,CURRENT_TIMESTAMP,'user2',CURRENT_TIMESTAMP + interval '120' second,39)
/*PVR saturday SCREEN  1 Eve Show 2(last row corner) seat*/
insert into SEAT_LOCK values(4,CURRENT_TIMESTAMP,'user2',CURRENT_TIMESTAMP + interval '120' second,44)
insert into SEAT_LOCK values(5,CURRENT_TIMESTAMP,'user2',CURRENT_TIMESTAMP + interval '120' second,45)


//temp lock
insert into SEAT_LOCK values(6,CURRENT_TIMESTAMP,'user1',CURRENT_TIMESTAMP + interval '120' second,30)