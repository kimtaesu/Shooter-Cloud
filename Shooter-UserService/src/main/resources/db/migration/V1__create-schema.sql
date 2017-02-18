CREATE TABLE account (
  account_id                   BIGINT       NOT NULL AUTO_INCREMENT,
  is_account_non_expired     BIT          NOT NULL,
  is_account_non_locked      BIT          NOT NULL,
  is_credentials_non_expired BIT          NOT NULL,
  is_enabled                 BIT          NOT NULL,
  password                   VARCHAR(255) NOT NULL,
  user_email                 VARCHAR(255),
  user_name                  VARCHAR(255),
  PRIMARY KEY (account_id)
);

ALTER TABLE account
  ADD CONSTRAINT UK_mgx7cx34ipxrv397buqohsl07 UNIQUE (user_email);
ALTER TABLE account
  ADD CONSTRAINT UK_f6xpj7h12wr185bqhfi1hqlbr UNIQUE (user_name)