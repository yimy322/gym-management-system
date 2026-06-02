INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');

INSERT INTO db_strke.users
(id, username, password, enabled, created_at, updated_at)
VALUES(1, 'admin', '$2a$10$H6WKPQBlp7rpZX.7tEkTYeMdobWM3uP5clJG.KxkVMW4Oq3PTemS.', 1, '2026-06-02 13:07:36', '2026-06-02 13:07:36');

INSERT INTO db_strke.user_roles
(user_id, role_id)
VALUES(1, 1);