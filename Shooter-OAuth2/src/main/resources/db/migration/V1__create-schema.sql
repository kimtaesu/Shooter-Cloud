create table of_role (
  role_id bigint not null auto_increment,
  role_type varchar(255) not null,
primary key (role_id));

create table account (
  account_id bigint not null auto_increment,
  is_account_non_expired bit not null,
  is_account_non_locked bit not null,
  is_credentials_non_expired bit not null,
  is_enabled bit not null,
  password varchar(255) not null,
  user_email varchar(255),
  user_name varchar(255),
primary key (account_id));

CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (user_id, role_id)
);

alter table account
add constraint UK_mgx7cx34ipxrv397buqohsl07 unique (user_email);
alter table account
add constraint UK_f6xpj7h12wr185bqhfi1hqlbr unique (user_name);
alter table user_role
add constraint FKqcmhw2kdl3nxfdjarpemj6wcu foreign key (role_id) references of_role (role_id);
alter table user_role
add constraint FKlkhooy5w45r7bji6wv27a0wuq foreign key (user_id) references account (account_id);