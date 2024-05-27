use jsp_servlet;
CREATE table role(
                     id bigint NOT NULL PRIMARY KEY auto_increment,
                     name VARCHAR(150) NOT NULL,
                     code VARCHAR(150) NOT NULL,
                     modifiedby VARCHAR(250) NULL,
                     createdby VARCHAR(250) NULL,
                     createddate TIMESTAMP NOT NULL,
                     modifieddate TIMESTAMP NOT NULL
);

-- alter table role add modifiedby VARCHAR(250) NULL;
-- alter table role add createdby VARCHAR(250) NULL;

create table user(
                     id bigint NOT NULL PRIMARY KEY auto_increment,
                     name VARCHAR(150) NOT NULL,
                     password VARCHAR(150) NOT NULL,
                     fullname VARCHAR(150) NULL,
                     status int NOT NULL,
                     roleid bigint NOT NULL,
                     createddate TIMESTAMP NOT NULL,
                     modifieddate TIMESTAMP NOT NULL,
                     createdby VARCHAR(250) NULL,
                     modifiedby VARCHAR(250) NULL
);

-- alter table user add roleid bigint NOT NULL;
alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news(
                     id bigint NOT NULL PRIMARY KEY auto_increment,
                     title VARCHAR(255)  NULL,
                     thumbnails VARCHAR(255)  NULL,
                     shortdescription TEXT NULL,
                     categoryid bigint NOT NULL,
                     content text NULL,
                     createddate TIMESTAMP NOT NULL,
                     modifieddate TIMESTAMP NOT NULL,
                     createdby VARCHAR(250) NULL,
                     modifiedby VARCHAR(250) NULL
);
create table category(
                         id bigint NOT NULL PRIMARY KEY auto_increment,
                         name VARCHAR(255) NOT NULL,
                         code VARCHAR(255) NOT NULL,
                         createddate TIMESTAMP NOT NULL,
                         modifieddate TIMESTAMP NOT NULL,
                         createdby VARCHAR(250) NULL,
                         modifiedby VARCHAR(250) NULL
);
alter table news add constraint fk_news_category foreign key (categoryid) references category(id);
create table comment(
                        id bigint NOT NULL PRIMARY KEY auto_increment,
                        content text NOT NULL,
                        user_id bigint NOT NULL,
                        news_id bigint NOT NULL,
                        createddate TIMESTAMP NOT NULL,
                        modifieddate TIMESTAMP NOT NULL,
                        createdby VARCHAR(250) NULL,
                        modifiedby VARCHAR(250) NULL
);
alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
alter table comment add constraint fk_comment_news foreign key (user_id) references news(id);