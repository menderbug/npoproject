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

CREATE TABLE Donation
(
	donor_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Donor,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	donation_date DATE NOT NULL,
	amount NUMERIC(9, 2) NOT NULL CHECK(amount <= 1000000),
	recurrence VARCHAR(10) NOT NULL CHECK (recurrence IN ('one-time', 'monthly', 'yearly')),
	CONSTRAINT PK_donation PRIMARY KEY (donor_id, nonprofit_id, donation_date)
);


CREATE TABLE Pledge
(
	donor_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Donor,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	pledge_date DATE NOT NULL,
	amount NUMERIC(9, 2) NOT NULL CHECK(amount <= 1000000),
	recurrence VARCHAR(10) NOT NULL CHECK (recurrence IN ('one-time', 'monthly', 'yearly')),
	CONSTRAINT PK_pledge PRIMARY KEY (donor_id, nonprofit_id, pledge_date)
);

CREATE TABLE Employee
(
	emp_id VARCHAR(10) PRIMARY KEY,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	emp_name VARCHAR(50) NOT NULL,
	phone_number numeric(11, 0) NOT NULL,
	salary numeric(9, 2) NOT NULL
);

CREATE TABLE Expense
(
	amount NUMERIC(9, 2) NOT NULL CHECK(amount <= 1000000),
	exp_id VARCHAR(10) PRIMARY KEY,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	expense_date DATE NOT NULL,
	type VARCHAR(10)
);


CREATE TABLE Department
(
	dept_name VARCHAR(50) NOT NULL PRIMARY KEY,
	director VARCHAR(50),
	budget VARCHAR(10) NOT NULL,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit
);
					       
CREATE TABLE CurrentDate
(
	date DATE NOT NULL,
);


CREATE TABLE Volunteer
(
	vol_id VARCHAR(10) NOT NULL PRIMARY KEY,
	vol_name VARCHAR(50) NOT NULL,
	field VARCHAR(50)
);

/* give everyone name, email, phone number */
/* directors are volunteers? */
