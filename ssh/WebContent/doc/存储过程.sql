--学生单门成绩
select (g.midscore * 0.5 + g.finalscore * 0.5) * c.credit stusimplescore
from grade g
left join course c on c.id = g.cono;

--学生总成绩
select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) stuallscore
from grade g
left join course c on c.id = g.cono
group by g.sid;

--学生所修学分之和
select sum(c.credit) stuallcredit
from grade g
left join course c on c.id = g.cono
group by g.sid; 

--学生平均成绩
select studentid, stuallscore , stuallcredit , stuallscore / stuallcredit as stuavgscore from
(select g.sid as studentid, sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) / sum(c.credit)
from grade g
left join course c on c.id = g.cono
where g.sid = 4
group by g.sid );
where (stuallscore / stuallcredit) > 75;

--班级成绩
select * from
classes cla
left join student stu on stu.classid = cla.id;


--创建一个游标
create or replace package sshpackage as
type ssh_cursor is ref cursor;
end;

--求学生平均成绩的过程
create or replace procedure pro_stuavgscore(stuid in number , stuavgscore out number , stuallscore out number , stuallcredit out number)
is
begin
select stuallscore/stuallcredit as stuavgscore , stuallscore , stuallcredit from
       (select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
       sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) /sum(c.credit)
       from grade g
       left join course c on c.id = g.cono
       where g.sid = stuid);
end;

--求学生平均成绩的过程
create or replace procedure pro_stuavgscore(stuid in number ,stu_cursor out sshpackage.ssh_cursor)
is
begin
open stu_cursor for select stuallscore/stuallcredit as stuavgscore , stuallscore , stuallcredit from
       (select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
       sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) /sum(c.credit)
       from grade g
       left join course c on c.id = g.cono
       where g.sid = stuid);
end;





