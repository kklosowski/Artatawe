CREATE TABLE user (
first_name text,
last_name text,
username text unique,
mobile_number text,
address_id integer,
avatar_id integer,
user_id integer primary key
);
CREATE TABLE address (
address_id integer primary key,
address_line1 text,
address_line2 text,
address_line3 text,
city text,
postcode text,
country text
);
CREATE TABLE avatar (
avatar_id integer primary key,
avatar_filename text unique
);
CREATE TABLE login_log (
user_id integer,
timestamp integer
);
CREATE TABLE bid ( 
user_id integer,
amount real,
timestamp integer,
auction_id integer
);
CREATE TABLE artwork (
artwork_id integer primary key,
artwork_type text,
artwork_spec_id integer unique,
title text,
description text,
artist text,
year_created integer
);
CREATE TABLE auction (
auction_id integer primary key,
artwork_id integer unique,
bids_total integer,
bids_left integer,
reserved_price real
);
CREATE TABLE painting (
artwork_spec_id integer primary key,
dimension_x real,
dimension_y real
);
CREATE TABLE sculpture (
artwork_spec_id integer primary key,
dimension_x real,
dimension_y real,
dimension_z real,
material text
);
