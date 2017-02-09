create table account 
(account_id bigint not null auto_increment, password varchar(255), 
user_email varchar(255), 
user_name varchar(255), 
primary key (account_id));

alter table account 
add constraint UKskhco1bnerd2fmixrjickvmy5 unique (user_email, user_name);