WITH filtered_visit(
    id,
    age
) AS (
    SELECT
        visit.id,
        date_part('year',age(visit.accidentDate, visit.birthDate))
    FROM visit
    where visit.branchId <> :excludeBranchId
        and visit.birthDate > :minBirthDate
)
select
    id,
    age
from filtered_visit
    where filtered_visit.age >= 5