WITH filtered_visit(
    id,
    age
) AS (
    SELECT
        visit.id,
        date_part('year',age(visit.accident_date, visit.birth_date))
    FROM visit
    where visit.branch_id <> :excludeBranchId
        and visit.birth_date > :minBirthDate
)
select
    id,
    age
from filtered_visit
    where filtered_visit.age >= 5