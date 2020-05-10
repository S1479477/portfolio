--This procedure will enroll a student in a class.
CREATE OR REPLACE PROCEDURE enroll student
in class (p_stu_id IN enrollments.stu_id%TYPE,
p_class_id IN enrollments.class_id%TYPE)
IS
 v_times_enrolled PLS_INTEGER;
e_already_enrolled EXCEPTION;
BEGIN
SELECT COUNT(*) INTO v_times_enrolled
FROM enrollments
WHERE class_id=p_class_id
AND stu_id = p_stu_id;
IF v_times_enrolled <> 0
THEN RAISE e_already_enrolled;
END IF;
INSERT INTO enrollments
(enroll_date, class_id, stu_id, status)
VALUES
(SYSDATE, p_class_id, p_stu_id, 'Enrolled');
COMMIT;
EXCEPTION
WHEN e_already_enrolled THEN
DBMS OUTPUT.PUT_LINE('Student ' || p_stu_id ||
' is already enrolled in class ' || p_class_id);
END enroll student in class;