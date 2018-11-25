create table Spittle (
  id identity,
  message varchar(140) not null,
  time timestamp not null,
  latitude double,
  longitude double
);

insert into Spittle(message, time, latitude, longitude) values ('Hello world', '2013-09-02', 0.0, 0.0);