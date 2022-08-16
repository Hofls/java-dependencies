CREATE FUNCTION generate_text_for_search() RETURNS TRIGGER AS '
    BEGIN
        NEW.text_for_search := NEW.name || ''. '' || NEW.address || '' - '' || NEW.status;
        RETURN NEW;
    END
' language plpgsql;

CREATE TRIGGER patient_text_for_search_trigger
BEFORE INSERT OR UPDATE ON campus
FOR EACH ROW EXECUTE PROCEDURE generate_text_for_search();
