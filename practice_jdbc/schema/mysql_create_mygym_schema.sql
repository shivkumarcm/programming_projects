/*
Do not run this! This is just to record what SQL commands
were run at the mysql CLI to create this database
*/

/*
Download and install MySQL Community Server: https://dev.mysql.com/downloads/
JDBC Driver for Mac (Platform Independent): https://dev.mysql.com/downloads/connector/j/
*/

/* ##### Command to start the MySQL server #####
sudo /usr/local/mysql/bin/mysqld_safe
*/

/* ##### Command to use the MySQL CLI to setup the database #####
/usr/local/mysql/bin/mysql -u root -p 
Enter password: mysqlte$t001
*/

/* Create MYGYM database */
CREATE DATABASE MYGYM;

/* Use this database to create tables */
USE MYGYM

CREATE TABLE MEMBER (
    ID CHAR(10) PRIMARY KEY,
    FNAME CHAR(10),
    LNAME CHAR(10) NOT NULL,
    TYPE CHAR(2),
    JOINED_DATE DATE);

/* payments made by a member */
CREATE TABLE PAYMENT (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    AMOUNT FLOAT(5,2),
    MEMBER_ID CHAR(10) NOT NULL,
    PAYMENT_DATE DATE);

/* Record each visit with in time, out time and a boolean to show if present. */
CREATE TABLE VISIT(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IN_TIME DATETIME NOT NULL,
    OUT_TIME DATETIME,
    PRESENT BOOLEAN);

/* Add a few more columns to the MEMBER table */
ALTER TABLE MEMBER ADD RENEWAL_DATE DATE; /* when to renew */
ALTER TABLE MEMBER ADD EMAIL CHAR(20);
ALTER TABLE MEMBER ACTIVE BOOLEAN; /* this an active member */

/*
Here's the table schema:

mysql> DESC MEMBER;
+--------------+------------+------+-----+---------+-------+
| Field        | Type       | Null | Key | Default | Extra |
+--------------+------------+------+-----+---------+-------+
| ID           | char(10)   | NO   | PRI | NULL    |       |
| FNAME        | char(10)   | YES  |     | NULL    |       |
| LNAME        | char(10)   | NO   |     | NULL    |       |
| TYPE         | char(2)    | YES  |     | NULL    |       |
| JOINED_DATE  | date       | YES  |     | NULL    |       |
| RENEWAL_DATE | date       | YES  |     | NULL    |       |
| EMAIL        | char(20)   | YES  |     | NULL    |       |
| ACTIVE       | tinyint(1) | YES  |     | NULL    |       |
+--------------+------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

mysql> DESC VISIT;
+----------+------------+------+-----+---------+----------------+
| Field    | Type       | Null | Key | Default | Extra          |
+----------+------------+------+-----+---------+----------------+
| ID       | int        | NO   | PRI | NULL    | auto_increment |
| IN_TIME  | datetime   | NO   |     | NULL    |                |
| OUT_TIME | datetime   | YES  |     | NULL    |                |
| PRESENT  | tinyint(1) | YES  |     | NULL    |                |
+----------+------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> DESC PAYMENT;
+--------------+------------+------+-----+---------+----------------+
| Field        | Type       | Null | Key | Default | Extra          |
+--------------+------------+------+-----+---------+----------------+
| ID           | int        | NO   | PRI | NULL    | auto_increment |
| AMOUNT       | float(5,2) | YES  |     | NULL    |                |
| MEMBER_ID    | char(10)   | NO   |     | NULL    |                |
| PAYMENT_DATE | date       | YES  |     | NULL    |                |
+--------------+------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

*/

/* Sample Data */
INSERT INTO MEMBER VALUES ("NOVI001", "TOM", "SMITH", "T1", "2024-03-31", "2025-03-31", "TOM.SMITH@GMAIL.COM", TRUE);
INSERT INTO MEMBER VALUES ("NTVL001", "RITA", "JONES", "T1", "2022-01-01", "2025-01-01", "RITA.JONES@AOL.COM", TRUE);
INSERT INTO MEMBER VALUES ("NOVI002", "JACK", "PAPA", "T2", "2024-04-25", "2024-10-25", "JACK.PAPA@CLOUD.COM", TRUE);
INSERT INTO MEMBER VALUES ("WLDLK001", "KEN", "KRAKER", "T1", "2021-10-01", NULL, "KKRAKER@INTL.COM", FALSE);

INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (49.99, "NOVI001", "2024-03-31");
INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (49.99, "NTVL001", "2024-01-01");

/* Fix the joined date for Jack */
UPDATE MEMBER SET JOINED_DATE="2024-03-25" WHERE ID="NOVI002";

INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (39.99, "NOVI002", "2024-03-25");
INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (39.99, "WLDLK001", "2021-10-01");
INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (39.99, "WLDLK001", "2022-10-01");
INSERT INTO PAYMENT(AMOUNT, MEMBER_ID, PAYMENT_DATE) VALUES (39.99, "WLDLK001", "2023-10-01");

/* Snapshot of the data we have:

mysql> SELECT * FROM MEMBER;
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
| ID       | FNAME | LNAME  | TYPE | JOINED_DATE | RENEWAL_DATE | EMAIL               | ACTIVE |
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
| NOVI001  | TOM   | SMITH  | T1   | 2024-03-31  | 2025-03-31   | TOM.SMITH@GMAIL.COM |      1 |
| NOVI002  | JACK  | PAPA   | T2   | 2024-03-25  | 2024-10-25   | JACK.PAPA@CLOUD.COM |      1 |
| NTVL001  | RITA  | JONES  | T1   | 2022-01-01  | 2025-01-01   | RITA.JONES@AOL.COM  |      1 |
| WLDLK001 | KEN   | KRAKER | T1   | 2021-10-01  | NULL         | KKRAKER@INTL.COM    |      0 |
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
4 rows in set (0.00 sec)


mysql> SELECT * FROM MEMBER;
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
| ID       | FNAME | LNAME  | TYPE | JOINED_DATE | RENEWAL_DATE | EMAIL               | ACTIVE |
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
| NOVI001  | TOM   | SMITH  | T1   | 2024-03-31  | 2025-03-31   | TOM.SMITH@GMAIL.COM |      1 |
| NOVI002  | JACK  | PAPA   | T2   | 2024-03-25  | 2024-10-25   | JACK.PAPA@CLOUD.COM |      1 |
| NTVL001  | RITA  | JONES  | T1   | 2022-01-01  | 2025-01-01   | RITA.JONES@AOL.COM  |      1 |
| WLDLK001 | KEN   | KRAKER | T1   | 2021-10-01  | NULL         | KKRAKER@INTL.COM    |      0 |
+----------+-------+--------+------+-------------+--------------+---------------------+--------+
4 rows in set (0.00 sec)

*/

/* Sample join */
SELECT EMAIL, AMOUNT, PAYMENT_DATE FROM MEMBER, PAYMENT WHERE MEMBER.ID = PAYMENT.MEMBER_ID;
