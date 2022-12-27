create if not exists table users(
    id          bigint autoincrement,
    username    varchar(30) not null unique,
    password    varchar(80) not null,
    email       varchar(255)unique,
    primary key (id)
);

create if not exists table roles(
    id          bigint autoincrement,
    username    varchar(50) not null,
    primary key (id)
);

create if not exists table users_role(
    user_id          bigint not null,
    role_id          bigint not null,
    primary key(user_id,role_id),
    foreign key(user_id) references users (id),
    foreign key(role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_MANAGER'),('ROLE_ADMIN');

insert into users (username, password, email)
values
('manager','$2a$12$ZLfs7UI5K810sffseoQc.uqvgRjrhcrHDkdK3NbpwX7FcTpQO2NHS'),
('admin','$2a$12$R0BMkKEuBFD2CBu9ZBDBLurboNehxnST8ghXEWa3LE5e4l4gJCNiO');

insert into users_role (user_id, role_id)
values
(1,1)
(2,2);


