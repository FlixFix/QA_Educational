USE EDUCATION;
DROP TABLE if exists messages;
DROP TABLE if exists users;

CREATE TABLE users (
                       id MEDIUMINT NOT NULL AUTO_INCREMENT,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       primary key (id)
);

CREATE TABLE messages
(
    id      MEDIUMINT   NOT NULL AUTO_INCREMENT,
    message VARCHAR(80) NOT NULL,
    user_id MEDIUMINT NOT NULL,
    primary key (id),
    foreign key (user_id) references users(id)
);

insert into users (username, password) VALUES ('Andreas', 'Password'),('Felix', 'Password');
