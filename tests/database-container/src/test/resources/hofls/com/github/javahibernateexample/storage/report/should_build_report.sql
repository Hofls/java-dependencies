
-- this visit is excluded from report (because of branch_id)
INSERT INTO visit (id, branch_id, birth_date, accident_date)
VALUES (43010, 932, '2002-05-20', '2019-05-20');

-- this visit is excluded from report (because of birth_date)
INSERT INTO visit (id, branch_id, birth_date, accident_date)
VALUES (43020, 67, '1819-05-20', '2002-05-20');

-- this visit is excluded from report (because age is too small)
INSERT INTO visit (id, branch_id, birth_date, accident_date)
VALUES (43030, 67, '2017-05-20', '2019-05-20');

-- this visit is included in report
INSERT INTO visit (id, branch_id, birth_date, accident_date)
VALUES (43040, 67, '2019-05-21', '2119-05-20');

-- this visit is included in report
INSERT INTO visit (id, branch_id, birth_date, accident_date)
VALUES (43050, 67, '2019-05-19', '2119-05-20');
