insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'street', 'street', 'city', '11-111'),
                   (2, 'street2', 'street2', 'city2', '22-222');
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, gender)
VALUES (1, 'Janina', 'Kowalska', '121-121-121', 'janina@kowalska.pl', 'P123', '1990-05-07', 'FEMALE'),
       (2, 'Robert', 'Bak', '212-323-555', 'robert@bak.pl', 'P456', '1992-01-10', 'MALE');
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Jan', 'Kowalski', '123-999-999', 'jan@kowalski.pl', 'D123', 'OCULIST'),
       (2, 'Michalina', 'Janowska', '555-555-555', 'michalina@janowska.pl', 'D456', 'GP');
INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES (1, 'FIRST VISIT', '2024-05-18 12:00:00', 1, 1),
       (2, 'EYE CHECK', '2024-05-18 09:30:00', 2, 2);
