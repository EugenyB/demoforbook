-- we don't know how to generate root <with-no-name> (class Root) :(

create table city
(
    city_id int auto_increment
        primary key,
    name    varchar(125) not null
);

create table department
(
    department_id int auto_increment
        primary key,
    name          varchar(200) not null,
    head_id       int          null
);

create table major
(
    major_id int auto_increment
        primary key,
    title    varchar(120) null,
    code     varchar(5)   null,
    constraint major_pk
        unique (code)
);

create table position
(
    position_id int auto_increment
        primary key,
    title       varchar(125) not null
);

create table professor
(
    professor_id  int auto_increment
        primary key,
    first_name    varchar(20)  not null,
    last_name     varchar(40)  not null,
    degree        varchar(100) null,
    position_id   int          null,
    department_id int          null,
    constraint professor_department_department_id_fk
        foreign key (department_id) references department (department_id),
    constraint professor_position_position_id_fk
        foreign key (position_id) references position (position_id)
);

create table academ_group
(
    group_id      int auto_increment
        primary key,
    name          varchar(10) not null,
    curator_id    int         not null,
    major_id      int         not null,
    department_id int         not null,
    constraint academ_group_department_department_id_fk
        foreign key (department_id) references department (department_id),
    constraint academ_group_major_major_id_fk
        foreign key (major_id) references major (major_id),
    constraint academ_group_professor_professor_id_fk
        foreign key (curator_id) references professor (professor_id)
);

alter table department
    add constraint department_professor_professor_id_fk
        foreign key (head_id) references professor (professor_id);

create table student
(
    student_id     int auto_increment
        primary key,
    first_name     varchar(30)  not null,
    last_name      varchar(40)  not null,
    birthday       date         null,
    city_id        int          not null,
    street_address varchar(200) null,
    group_id       int          not null,
    constraint student_academ_group_group_id_fk
        foreign key (group_id) references academ_group (group_id),
    constraint student_city_city_id_fk
        foreign key (city_id) references city (city_id)
);

create table subject
(
    subject_id  int auto_increment
        primary key,
    title       varchar(100) not null,
    duration    int          null,
    semestr     int          null,
    description varchar(200) null
);

create index subject_semestr_index
    on subject (semestr);

create table subject_professor
(
    subject_id   int not null,
    professor_id int not null,
    primary key (subject_id, professor_id),
    constraint subject_professor_professor_professor_id_fk
        foreign key (professor_id) references professor (professor_id),
    constraint subject_professor_subject_subject_id_fk
        foreign key (subject_id) references subject (subject_id)
);

