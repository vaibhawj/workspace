--1.	Provide SQL to show all inventory records sorted by Make
select * from INVENTORY order by MAKE;
--2.	Provide SQL to show all inventory records sorted by Make (Alphabetic order) and Cost (Highest cost at top)
select * from INVENTORY order by make, cost desc;
--3.	Provide SQL to show all HONDA cars
select * from INVENTORY where make='HONDA';
--4.	Provide SQL to show all HONDA cars before 2011 year
select * from INVENTORY where make='HONDA' and year < 2011;
--5.	Provide SQL to show all HONDA or BMW cars 2011 or beyond
select * from INVENTORY where make in ('HONDA','BMW') and year >= 2011;
--6.	Provide SQL to show total cost of all Honda cars
select sum(cost) from INVENTORY where make='HONDA';
--7.	Provide SQL to show total cost of cars grouped by MAKE and YEAR
select make, year, sum(cost) from INVENTORY group by make,year;
--8.	Provide SQL to show all car makes with count of cars for each make
select make, count(1) from INVENTORY group by make;
--9.	Provide SQL to show all cars makes and year with counts of car for each MAKE and YEAR
select make, year, count(1) from INVENTORY group by make, year;
--10.	Provide SQL to show all cars having more than 1 car for same make and year e.g. 2 Honda 2011
select * from (select make, year, count(1) as CNT from INVENTORY group by make, year) where CNT>1;
--11.	Provide SQL to show cars for having max number of items by make
select * from INVENTORY where make in (
select make from (select * from (select make, count(1) as CNT  from INVENTORY group by make) order by CNT desc
) where ROWNUM=1);
--12.	Provide SQL to show cars with cost between $22000 and $30000
select * from INVENTORY where COST between 22000 and 30000;
--13.	Provide SQL to find most expensive car
select * from INVENTORY where COST = (select max(cost) from INVENTORY);
--14.	Provide SQL to find 2nd most expensive car
select * from (select * from INVENTORY where cost < (select max(cost) from INVENTORY)order by cost desc) where ROWNUM=1 ;
--15.	Provide SQL to find most expensive and least expensive cars
select * from INVENTORY where COST = (select max(cost) from INVENTORY) 
union
select * from INVENTORY where COST = (select min(cost) from INVENTORY) 
;
--16.	Provide SQL to find who put max number of bids
select offered_by from (select * from (select OFFERED_BY, count(1) as BID_COUNT from AUCTION group by OFFERED_BY) order by BID_COUNT desc)
where ROWNUM=1;
--17.	Provide SQL to find who won max number of cars in auction
with WINNING_BIDS as (select item_id,  max(offer) as MAX_BID from auction group by ITEM_ID)
select offered_by as MOST_WINS from (select * from (select a.offered_by, count(1) as WINS from auction a inner join WINNING_BIDS w on a.ITEM_ID=w.item_id and a.offer=w.max_bid
group by a.offered_by) order by WINS desc) where ROWNUM=1;
--18.	Provide SQL to show which car had max number of bids
select * from INVENTORY where ITEM_ID in (
select item_id from (select * from (select item_id, count(1) as NUM_OF_BIDS from auction group by item_id) order by NUM_OF_BIDS desc) where ROWNUM=1
);
--19.	Provide SQL to show which cars did not have any bids
select * from INVENTORY where ITEM_ID not in (select item_id from auction);
--20.	Provide SQL to show all cars with their corresponding bids
-- Doubt- only winning bid?
select i.*, a.OFFER, a.OFFERED_BY from INVENTORY i
left outer join auction a on a.item_id = i.item_id;
--21.	Provide SQL to show all cars with their max bid
with WINNING_BIDS as (select item_id,  max(offer) as MAX_BID from auction group by ITEM_ID)
select i.*, w.MAX_BID from INVENTORY i
inner join WINNING_BIDS w on w.item_id = i.item_id;
--22.	Provide SQL to calculate Profit or loss for each car
with WINNING_BIDS as (select item_id,  max(offer) as MAX_BID from auction group by ITEM_ID)
select i.*, w.MAX_BID, (w.MAX_BID-i.COST) as PROFIT_LOSS from INVENTORY i
inner join WINNING_BIDS w on w.item_id = i.item_id;
--23.	Provide SQL to show AVERAGE bid for each car
with AVG_BIDS as (select item_id,  avg(offer) as AVG_BID from auction group by ITEM_ID)
select i.*, a.AVG_BID from INVENTORY i
inner join AVG_BIDS a on a.item_id = i.item_id;
--24.	How would you change the table model if we had to keep track of status of each car’s auction?

