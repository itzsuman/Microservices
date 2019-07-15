create table currency
(
   id integer not null,
   countryCode varchar(255) not null,
   conversionFactor double(10) not null,
   primary key(id)
);