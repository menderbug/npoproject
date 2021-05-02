/* TODO replace homebrew day/month/year with a DATE type? */

CREATE TABLE Nonprofit
(
	nonprofit_id VARCHAR(10) NOT NULL PRIMARY KEY,
	npo_name VARCHAR(50) NOT NULL,
	npo_address VARCHAR(50) NOT NULL,
	npo_email VARCHAR(50) NOT NULL
);

CREATE TABLE Donor
(
	donor_id VARCHAR(10) NOT NULL PRIMARY KEY,
	donor_name VARCHAR(50) NOT NULL,
	donor_address VARCHAR(50) NOT NULL,
	donor_email VARCHAR(50) NOT NULL
);


/* TODO check that foreign key syntax works */
CREATE TABLE Donation
(
	donor_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Donor,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	year NUMERIC(4, 0) NOT NULL,
	month NUMERIC(2, 0) NOT NULL,
	day NUMERIC(2, 0) NOT NULL,
	amount NUMERIC(7, 2) NOT NULL CHECK(amount <= 1000000),
	recurrence VARCHAR(10) NOT NULL CHECK (recurrence IN ('one-time', 'monthly', 'yearly')),
	CONSTRAINT PK_donation PRIMARY KEY (donor_id, nonprofit_id, year, month, day)
);


CREATE TABLE Pledge
(
	donor_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Donor,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	year NUMERIC(4, 0) NOT NULL,
	month NUMERIC(2, 0) NOT NULL,
	day NUMERIC(2, 0) NOT NULL,
	amount NUMERIC(7, 2) NOT NULL CHECK(amount <= 1000000),
	recurrence VARCHAR(10) NOT NULL CHECK (recurrence IN ('one-time', 'monthly', 'yearly')),
	CONSTRAINT PK_pledge PRIMARY KEY (donor_id, nonprofit_id, year, month, day)
);




CREATE TABLE Employee
(
	emp_id VARCHAR(10) PRIMARY KEY,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	emp_name VARCHAR(50) NOT NULL,
	phone_number numeric(11, 0) NOT NULL,
	salary numeric(7, 2) NOT NULL
);

CREATE TABLE Expense
(
	exp_id VARCHAR(10) PRIMARY KEY,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	year NUMERIC(4, 0) NOT NULL,
	month NUMERIC(2, 0) NOT NULL,
	day NUMERIC(2, 0) NOT NULL,
	type VARCHAR(10)
);


CREATE TABLE Department
(
	dept_name VARCHAR(50) NOT NULL PRIMARY KEY,
	director VARCHAR(50),
	budget VARCHAR(10) NOT NULL,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit
);


CREATE TABLE Volunteer
(
	vol_id VARCHAR(10) NOT NULL PRIMARY KEY,
	vol_name VARCHAR(50) NOT NULL,
	field VARCHAR(50)
);


CREATE TABLE CurrentDate
(
	year NUMERIC(4, 0) NOT NULL,
	month NUMERIC(2, 0) NOT NULL,
	day NUMERIC(2, 0) NOT NULL
);
