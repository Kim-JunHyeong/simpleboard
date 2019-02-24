INSERT INTO user (id, login_id, password, alias, email) VALUES (1, 'kjh4685', '{bcrypt}$2a$10$tgJYSm768my7yKl/nTTFquRHoPCN84HDzsHEKCURslksDDCF6QEXy', 'crazy', 'jhkim4685@gmail.com');

INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);

INSERT INTO category (id, name) VALUES (1, 'JAVA');
INSERT INTO category (id, name) VALUES (2, 'Spring');
INSERT INTO category (id, name) VALUES (3, 'JPA');

INSERT INTO board_body (id, content) VALUES (1, 'java를 열심히?');
INSERT INTO board_body (id, content) VALUES (2, 'spring을 열심히!');
INSERT INTO board_body (id, content) VALUES (3, 'jpa도 열심히...');

INSERT INTO board (id, title, parent_board_id, category_id, user_id, board_body_id)
VALUES (1, 'Java!!', null, 1, 1, 1);
INSERT INTO board (id, title, parent_board_id, category_id, user_id, board_body_id)
VALUES (2, 'Spring!!', null, 2, 1, 2);
INSERT INTO board (id, title, parent_board_id, category_id, user_id, board_body_id)
VALUES (3, 'JPA!!', null, 3, 1, 3);

INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (1, 'Java 댓글?!', 1, 1, 1);
INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (2, 'Spring 댓글?!', 2, 2, 1);
INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (3, 'JPA 댓글?!', 3, 3, 1);

INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (4, 'Java 댓글22?!', 4, 1, 1);
INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (5, 'Java 1번 댓글의 댓글?!', 1, 1, 1);
INSERT INTO comment (id, content, parent_comment_id, board_id, user_id)
VALUES (6, 'Java 1번 댓글의 댓글?!', 1, 1, 1);

INSERT INTO file_info (id, original_file_name, stored_file_name, content_type, size, board_id)
VALUES (1, '원본파일이름.jpg', '저장경로인데 지금은 일단...', '해당 파일의 타입', 777, 1);