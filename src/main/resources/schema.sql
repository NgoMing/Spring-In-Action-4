create table Spittle (
  id identity,
  message varchar(140) not null,
  time timestamp not null,
  latitude double,
  longitude double
);

insert into Spittle values (1, 'Hello world', '2013-09-02', 0.0, 0.0);

create table Spitter (
  id identity,
  username varchar(20) unique not null,
  password varchar(20) not null,
  firstName varchar(30) not null,
  lastName varchar(30) not null,
  email varchar(30) not null
);