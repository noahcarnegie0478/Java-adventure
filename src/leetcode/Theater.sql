-- import this database to mysql server
-- write FASTEST query for (OR MAKE IT FAST) :
use cinema;
create fulltext index ft_idx on film (name, country_code, type);
-- 1 Show film over 100mins
select * from film where length_min > 100;
-- 2 Which film over average length of all films
select * from film where length_min > (select avg(length_min) as avarage_duration from film);
-- 3 Which film has name start with letter 't'
select * from film where name like 't%';
-- select * from film where match (name, country_code, type  ) against ('t*' in boolean mode );
-- 4 Which film contain letter 'a'
select * from film where name like '%a%' or country_code like '%a%' or type like '%a%';
-- 5 How many film in US?
select count(name) from film where country_code = 'US';
-- 6 what is the longest, and shortest length of all film
select max(length_min) as MaxLength, min(length_min) as MinLength from film;
-- 7 Show unique film types of all film (NO DUPLICATE)
select type as movie_type from film group by type;
-- 8 What is the distance (in days) of the 1st and the last film
-- note: maybe y thay la giua phim dau va phim cuoi cach nhau may ngay
select datediff(max(start_time),min(start_time) ) as dayDiff from screening;

-- 9 Show all Screening Information including film name, room name, time of film "Tom&Jerry"

select screening.Id as screening_id,film.name as film, length_min as duration, start_time, room.name as room 
from film inner join screening on film.id = screening.film_id inner join room on screening.room_id = room.id  
where film.name = "Tom&Jerry";

-- 10 show all screening in 2 day '2022-05-25' and '2022-05-25'
select * from screening where start_time >= '2022-05-24 00:00:00' and start_time <=  '2022-05-25 23:59:59';
-- 11. Show film which dont have any screening
select film.id as id_from_film, film.name as title, screening.film_id as id_from_screening from film left join screening on film.id = screening.film_id where screening.film_id is null ;
-- 12 Who book more than 1 seat in 1 booking
select booking.customer_id, customer.first_name ,booking_id, count(booking_id) as seat_quantity from reserved_seat 
inner join booking on booking.id = reserved_seat.booking_id 
inner join customer on booking.customer_id = customer.id
group by booking_id having count(booking_id) > 1  ;
-- 13 Show room show more than 2 film in one day
-- NOTE: trong 1 ngay , phong lap lai hon 2 lan. 
select date(start_time) as day_time, room_id, count(room_id) as count_per_day 
from screening group by day_time, room_id 
having count_per_day > 2 order by day_time ;
-- 14 which room show the least film ?
-- NOTE: the amout of screening time per room, and the min of that amount
select room_id, count(room_id) as show_time_quantity from screening group by room_id order by show_time_quantity limit 1; 
-- 15 what film don't have booking
select screening.film_id as film_id, film.name as title from screening
left join booking on booking.screening_id = screening.id 
inner join film on screening.film_id = film.id
where booking.screening_id is null group by screening.film_id; ;
-- 16 WHAT film have show the biggest number of room?
-- note: find different room count that group by film
select film_id ,name, count(distinct room_id) as number_of_diff_room from screening right join film on film.id = film_id group by film_id order by number_of_diff_room desc limit 1 ;
-- 17 Show number of film that show in every day of week and order descending
-- note: maybe y thay la so phim khac nhau moi ngay
select date(start_time) as day, count(distinct film_id) as film_per_day from screening group by day order by film_per_day desc;
-- 18 show total length of each film that showed in 28/5/2022
-- note maybe y thay la phim do da duoc chieu bao nhieu tieng trong ca ngay 28/05/2022
select film_id, count(film_id) as times, film.length_min,(film.length_min * count(film_id)) as total 
from screening inner join film on film_id = film.id 
where date(start_time) = '2022-05-28' group by film_id ;
-- 19 What film has showing time above and below average show time of all film

-- 20 what room have least number of seat?
select room_id,name,count(number) as amount  from seat 
inner join room on room_id = room.id 
group by room_id order by amount limit 1 ;
-- 21 what room have number of seat bigger than average number of seat of all rooms
-- note: avarage of seat of all room - get amount per room an compare
select room_id,count(number) as amount from seat 
group by room_id 
having count(number) > 
(select avg(amount) from (select room_id,count(number) as amount from seat 
group by room_id ) as second_table);
-- 22 Ngoai nhung seat mà Ong Dung booking duoc o booking id = 1 thi ong CÓ THỂ (CAN) booking duoc nhung seat nao khac khong?
-- 23 Show Film with total screening and order by total screening. BUT ONLY SHOW DATA OF FILM WITH TOTAL SCREENING > 10
-- 24 TOP 3 DAY OF WEEK based on total booking
-- 25 CALCULATE BOOKING rate over screening of each film ORDER BY RATES.
-- 26 CONTINUE Q15 -> WHICH film has rate over/below/equal average ?.
-- 27 TOP 2 people who enjoy the least TIME (in minutes) in the cinema based on booking info - only count who has booking info (example : Dũng book film tom&jerry 4 times -> Dũng enjoy 90 mins x 4)