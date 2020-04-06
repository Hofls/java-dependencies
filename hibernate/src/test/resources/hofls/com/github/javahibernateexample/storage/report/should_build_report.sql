-- there is "AGE" function in POSTGRES, but there is no such function in H2DB, so lets create one
CREATE ALIAS AGE FOR "hofls.com.github.javahibernateexample.storage.report.VisitCountTest.age";
-- there is "DATE_PART" function in POSTGRES, but there is no such function in H2DB, so lets create one
CREATE ALIAS DATE_PART FOR "hofls.com.github.javahibernateexample.storage.report.VisitCountTest.datePart";

-- this visit is excluded from report (because of branchId)
INSERT INTO visit (id, branchId, birthDate, accidentDate)
VALUES (43010, 932, '2002-05-20', '2019-05-20');

-- this visit is excluded from report (because of birthDate)
INSERT INTO visit (id, branchId, birthDate, accidentDate)
VALUES (43020, 67, '1819-05-20', '2002-05-20');

-- this visit is excluded from report (because age is too small)
INSERT INTO visit (id, branchId, birthDate, accidentDate)
VALUES (43030, 67, '2017-05-20', '2019-05-20');

-- this visit is included in report
INSERT INTO visit (id, branchId, birthDate, accidentDate)
VALUES (43040, 67, '2019-05-21', '2119-05-20');

-- this visit is included in report
INSERT INTO visit (id, branchId, birthDate, accidentDate)
VALUES (43050, 67, '2019-05-19', '2119-05-20');
