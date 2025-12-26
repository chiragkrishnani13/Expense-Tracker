create database expense_tracker;
use expense_tracker;
create table users(
	user_id int primary key auto_increment,
    email varchar(500) unique not null,
    username varchar(500)  not null,
    name varchar(100) not null,
    active_yn int default 1,
    password varchar(255) not null,
    phone_no varchar(500),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table categorys(
	category_id int primary key auto_increment,
    user_id INT NOT NULL,
    category_name varchar(50),
    description varchar(200),
    icon_url varchar(255),
    transcation_type enum('INCOME','EXPENSE') not null default 'EXPENSE' ,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade
);
CREATE TABLE TRANSACTIONS(
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    category_id INT NOT NULL,
    note VARCHAR(255),
    amount DECIMAL(10,2) NOT NULL,
    transcation_date date not null,
    created_at TIMESTAMP default CURRENT_TIMESTAMP,
	updated_at TIMESTAMP default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	active_yn INT DEFAULT 1,
	FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade,
	FOREIGN KEY (category_id) REFERENCES categorys(category_id) on delete cascade

);
INSERT INTO users
(email, username, name, active_yn, password, phone_no)
VALUES
('chirag@gmail.com', 'chirag', 'Chirag Krishnani', 1, 'pass123', '9876543210'),
('rahul@gmail.com', 'rahul', 'Rahul Sharma', 1, 'pass456', '9123456780'),
('neha@gmail.com', 'neha', 'Neha Verma', 1, 'pass789', '9988776655');

INSERT INTO categorys
(user_id, category_name, description, icon_url, transcation_type)
VALUES
(1, 'Salary', 'Monthly salary', 'salary.png', 'INCOME'),
(1, 'Food', 'Daily food expenses', 'food.png', 'EXPENSE'),
(1, 'Travel', 'Transport & fuel', 'travel.png', 'EXPENSE'),

(2, 'Freelance', 'Freelance income', 'freelance.png', 'INCOME'),
(2, 'Shopping', 'Clothes & gadgets', 'shopping.png', 'EXPENSE'),

(3, 'Business', 'Business income', 'business.png', 'INCOME'),
(3, 'Bills', 'Electricity & water bills', 'bills.png', 'EXPENSE');

INSERT INTO TRANSACTIONS
(user_id, category_id, note, amount, transcation_date, active_yn)
VALUES
(1, 1, 'August Salary', 50000.00, '2025-08-01', 1),
(1, 2, 'Lunch at restaurant', 450.00, '2025-08-02', 1),
(1, 3, 'Petrol refill', 1200.00, '2025-08-03', 1),

(2, 4, 'Website project payment', 20000.00, '2025-08-01', 1),
(2, 5, 'Bought shoes', 3500.00, '2025-08-04', 1),

(3, 6, 'Client payment', 75000.00, '2025-08-02', 1),
(3, 7, 'Electricity bill', 1800.00, '2025-08-05', 1);

