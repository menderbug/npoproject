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
	donor_gender VARCHAR(6) NOT NULL CHECK (donor_gender IN ('male', 'female')),
	donor_address VARCHAR(50) NOT NULL,
	donor_phone_number NUMERIC(11, 0) NOT NULL,
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

CREATE TABLE Department
(
	dept_name VARCHAR(50) NOT NULL,
	director_name VARCHAR(50),
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	CONSTRAINT PK_dept PRIMARY KEY (dept_name, nonprofit_id)
);
					       
CREATE TABLE Budget
(
	dept_name VARCHAR(50) NOT NULL, 
	nonprofit_id VARCHAR(10) NOT NULL,
	FOREIGN KEY(dept_name, nonprofit_id) REFERENCES Department,
	year NUMERIC(4, 0) NOT NULL,
	amount NUMERIC(9, 2) NOT NULL
);

CREATE TABLE Employee
(
	emp_id VARCHAR(10) PRIMARY KEY,
	dept_name VARCHAR(50) NOT NULL,
	nonprofit_id VARCHAR(10) NOT NULL REFERENCES Nonprofit,
	emp_name VARCHAR(50) NOT NULL,
	emp_gender VARCHAR(6) NOT NULL CHECK (emp_gender IN ('male', 'female')),
	emp_address VARCHAR(50) NOT NULL,
	emp_phone_number NUMERIC(11, 0) NOT NULL,
	emp_email VARCHAR(50) NOT NULL,
	salary NUMERIC(9, 2) NOT NULL,
	CONSTRAINT FK_dept_emp FOREIGN KEY (dept_name, nonprofit_id) REFERENCES Department (dept_name, nonprofit_id)
);

CREATE TABLE Expense
(
	amount NUMERIC(9, 2) NOT NULL CHECK(amount <= 1000000),
	exp_id VARCHAR(10) PRIMARY KEY,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	expense_date DATE NOT NULL
);
					       
CREATE TABLE Volunteer
(
	vol_id VARCHAR(10) NOT NULL PRIMARY KEY,
	dept_name VARCHAR(50) NOT NULL,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	vol_name VARCHAR(50) NOT NULL,
	vol_gender VARCHAR(6) NOT NULL CHECK (vol_gender IN ('male', 'female')),
	vol_address VARCHAR(50) NOT NULL,
	vol_phone_number NUMERIC(11, 0) NOT NULL,
	vol_email VARCHAR(50) NOT NULL,
	CONSTRAINT FK_dept_vol FOREIGN KEY (dept_name, nonprofit_id) REFERENCES Department (dept_name, nonprofit_id)
);
					      
CREATE TABLE VolunteerHours
(
	vol_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Volunteer,
	nonprofit_id VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Nonprofit,
	volunteer_date DATE NOT NULL,
	num_hours NUMERIC(2, 0) NOT NULL CHECK(num_hours < 24)
	CONSTRAINT PK_volunteerhours PRIMARY KEY (vol_id, nonprofit_id, volunteer_date)
);

CREATE TABLE CurrentDate
(
	date DATE NOT NULL,
);
