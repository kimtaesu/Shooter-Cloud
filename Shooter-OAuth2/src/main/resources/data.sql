insert into of_role (role_id, role_type) values (null, 'ROLE_ADMIN');
insert into of_role (role_id, role_type) values (null, 'ROLE_USER');

insert into account (
  account_id,
  is_account_non_expired,
  is_account_non_locked,
  is_credentials_non_expired,
  is_enabled,
  password,
  user_email,
  user_name)
  values (null, 1, 1, 1, 1, 'test1', 'test1@testasdz.com', 'test1');
insert into user_role (user_id, role_id) values (1, 1);

insert into account (
  account_id,
  is_account_non_expired,
  is_account_non_locked,
  is_credentials_non_expired,
  is_enabled,
  password,
  user_email,
  user_name)
  values (null, 1, 1, 1, 1, 'test2', 'test2@testasdz.com', 'test2');
insert into user_role (user_id, role_id) values (2, 2);