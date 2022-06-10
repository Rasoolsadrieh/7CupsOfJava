-----------------------------------------
-------------C(reate)RUD-----------------
-- NOTE: MAKE SURE YOUR SCHEMA CONTAINS NONE OF THE FOLLOWING TABLE NAMES
	-- elemental_type
	-- abilites
	-- pokemon
-- Create ourselves a schema, un comment below command if you need to create it, 
-- then comment out again and execute script after selecting the appropriate schema in the toolbar above
-- create schema pokedex;

-- CREATE OUR TABLES & APPLY CONSTRAINTS

-- Added in the Trainer table to match the system

create table trainer (
	id int IDENTITY(1,1) primary key,
	fname varchar(20) not null,
	lname varchar(20) not null,
	email varchar(30) not null unique,
	user_password varchar(25) not null,
	dob varchar(15) not null
);

-- Need this incase we add any information pertaining to the element type and insuring consistency
create table element_type (
	id int IDENTITY(3,10) primary key,
	type_name varchar(30)
);

create table ability (
	ability_name varchar(25) primary key,
	atk_multiplier int,
	dmg_type int
);

alter table ability
add constraint fk_element_type
foreign key(dmg_type) references element_type(id);

create table pokemon (
	id int IDENTITY(1,1) primary key,
	pokemon_name varchar(50),
	hp int not null,
	atk int not null,
	element_type bit not null,
	ability1 varchar(255) not null,
	ability2 varchar(255) not null 
	--constraint fk_abilities foreign key(ability_1) references abilities(ability_name)
);

-- The best and most useful case for alter
alter table pokemon
add constraint fk_ability_1
foreign key(ability1) references ability(ability_name);

alter table pokemon
add constraint fk_ability_2 
foreign key(ability2) references ability(ability_name);

alter table pokemon
add constraint fk_element_type 
foreign key(element_type) references element_type(id);

------------------------------------
-- Uncomment and Only execute if you need to dropp
 drop table pokemon; 
 drop table ability;
 drop table element_type;
 drop table trainer;
------------------------------------

-- CREATING NEW ENTRIES
-- Insert some trainers

insert into trainer 
values
('Charles', 'Jester', 'cj@mail.com', 'password', '01-01-0001'),
('Maxwell', 'House', 'mh@mail.com', 'password', '02-20-1900'),
('Soyoung', 'Lee', 'sl@mail.com', 'password', '06-01-2002');

-- single insert type first
insert into element_type 
values
('normal');

insert into element_type 
values
('fire'),
('water'),
('lightning'),
('grass');

-- single insert
insert into ability
values
('Scratch', 2, 1);

-- multi-insert
insert into ability
values
('Tackle', 3, 1),
('Fire Breath', 3, 2),
('Water Gun', 5, 3),
('Shock', 3, 4),
('Vine Whip', 3, 5);

-- single insert into pokemon
insert into pokemon 
values
('rattata', '12', '2', 1, 'Scratch', 'Tackle');

-- multi-insert 
insert into pokemon 
values
('pidgey', '10', '1','Tackle', 'Scratch'),
('charmander', '25', '5', 2, 'Scratch', 'Fire Breath'),
('squirtle', '30', '3', 3, 'Scratch', 'Water Gun'),
('pikachu', '15', '10', 4, 'Tackle', 'Shock'),
('bulbasaur', '22', '6', 5, 'Tackle', 'Vine Whip');

-------------Create End------------------

-----------------------------------------
---------------CR(ead)UD-----------------



select * from trainer; 

select * from element_type et ;

select * from pokemon p ;
--select * from abilities a ;
select * from ability;

-------------Read End--------------------

-----------------------------------------
-------------CRU(pdate)D-----------------

-- update trainer set dob = '06-01-2002' where email = 'sl@mail.com' ;

-------------Update End------------------

-----------------------------------------
-------------CRUD(elete)-----------------

--delete from trainer where fname = 'valid';

-------------Delete End------------------
