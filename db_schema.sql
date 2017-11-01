CREATE TABLE user (
first_name text,
last_name text,
username text unique,
mobile_number text,
address_id integer,
avatar_filename text,
user_id integer primary key
);

CREATE TABLE address (
address_line1 text,
address_line2 text,
address_line3 text,
city text,
postcode text,
country text,
user_id integer unique,
FOREIGN KEY(user_id) REFERENCES user(user_id)
);

CREATE TABLE login_log (
user_id integer,
timestamp integer,
FOREIGN KEY(user_id) REFERENCES user(user_id)
);

CREATE TABLE bid ( 
user_id integer,
amount real,
timestamp integer,
auction_id integer,
FOREIGN KEY(user_id) REFERENCES user(user_id)
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
reserved_price real,
FOREIGN KEY(artwork_id) REFERENCES artwork(artwork_id)
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
