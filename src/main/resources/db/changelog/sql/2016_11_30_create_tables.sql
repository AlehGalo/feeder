CREATE TABLE jobrequest(
server_time DOUBLE NOT NULL,
profile_access VARCHAR(50) NOT NULL,
PRIMARY KEY (server_time));

CREATE TABLE jobs(
server_time DOUBLE NOT NULL,
snippet VARCHAR(300) NOT NULL,
category2 VARCHAR(50) NOT NULL,
job_type VARCHAR(50) NOT NULL,
date_created VARCHAR(50) NOT NULL,
workload VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
url VARCHAR(50) NOT NULL,
duration VARCHAR(50) NOT NULL,
subcategory2 VARCHAR(50) NOT NULL,
job_status VARCHAR(50) NOT NULL,
id VARCHAR(50) NOT NULL,
budget DOUBLE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (server_time) REFERENCES jobrequest(server_time));


CREATE TABLE skills(
id INTEGER NOT NULL,
jobId VARCHAR(300) NOT NULL,
skills VARCHAR(50) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (jobId) REFERENCES jobs(id));

CREATE TABLE client(
id INTEGER NOT NULL,
server_time DOUBLE NOT NULL,
jobId VARCHAR(300) NOT NULL,
feedback DOUBLE NOT NULL,
country VARCHAR(50) NOT NULL,
past_hires DOUBLE NOT NULL,
payment_verification_status VARCHAR(50) NOT NULL,
jobs_posted DOUBLE NOT NULL,
reviews_count DOUBLE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (jobId) REFERENCES jobs(id));

CREATE TABLE auth_user(
id INTEGER NOT NULL,
server_time DOUBLE NOT NULL,
timezone VARCHAR(50) NOT NULL,
timezone_offset DOUBLE NOT NULL,
last_name VARCHAR(50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (server_time) REFERENCES jobrequest(server_time));

CREATE TABLE paging(
id INTEGER NOT NULL,
server_time DOUBLE NOT NULL,
total DOUBLE NOT NULL,
offset DOUBLE NOT NULL,
count DOUBLE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (server_time) REFERENCES jobrequest(server_time));
