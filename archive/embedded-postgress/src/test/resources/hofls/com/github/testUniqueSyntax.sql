select date_part('year', age(timestamp '1957-06-13'));
select extract(month from interval '2 years 3 months');
select isfinite(interval '4 hours')	;
select justify_hours(interval '27 hours');
