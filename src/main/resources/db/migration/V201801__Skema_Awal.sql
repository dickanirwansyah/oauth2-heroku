create table tabel_user(
iduser varchar(255) not null,
name varchar(255) not null,
username varchar(255) not null unique,
email varchar(255) not null,
password varchar(255) not null,
activated boolean default true,
activationkey varchar(255) null,
resetpasswordkey varchar(255) null,

constraint pk_tabel_user primary key (iduser)
);

create table tabel_role(
idrole varchar(255) not null,
name varchar(255) not null,
description varchar(255) not null,

constraint pk_tabel_role primary key (idrole)
);

create table tabel_user_role(
iduser varchar(255) not null,
idrole varchar(255) not null,

constraint fk_tabel_user_role_iduser foreign key (iduser) references tabel_user(iduser),
constraint fk_tabel_user_role_idrole foreign key (idrole) references tabel_role(idrole) 
);

create table tabel_category(
idcategory varchar(255) not null,
name varchar(255) not null,
description varchar(255) not null,

constraint pk_tabel_category primary key (idcategory)
);

create table tabel_product(
idproduct varchar(255) not null,
name varchar(255) not null,
brand varchar(255) not null,
quantity int not null,
price int not null,
idcategory varchar(255) not null,

constraint pk_tabel_product_idproduct primary key (idproduct),
constraint fk_tabel_product_idcategory foreign key (idcategory)
references tabel_category (idcategory)
);

create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);


CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token bytea,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication bytea,
  refresh_token VARCHAR(256) DEFAULT NULL
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(256), 
  authentication bytea
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
