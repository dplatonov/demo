# Demo

The goal on this task, show how we should use SpringData.

## Java Version

This sample requires you to have
[Java8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).

## Download Maven

This sample uses the [Apache Maven][maven] build system. Before getting started,
be
sure to [download][maven-download] and [install][maven-install] it. When you use
Maven as described here, it will automatically download the needed client
libraries.

[maven]: https://maven.apache.org
[maven-download]: https://maven.apache.org/download.cgi
[maven-install]: https://maven.apache.org/install.html

## Download Docker

This sample uses the [Docker][docker].

[docker]: https://www.docker.com/. 

## Get Postgres DB container and create table

This sample uses the Postgres container. Check connection credential in `application.properties`. 
Create two table.
```postgresplsql
create table "user"
(
  id          bigserial             not null
    constraint user_pkey
    primary key,
  name        varchar(24)           not null,
  last_name   varchar(24)           not null,
  create_date timestamp             not null,
  last_update timestamp,
  deleted     boolean default false not null,
  enabled     boolean default false not null,
  company_id  bigint
    constraint user___fk_company
    references company
);

create unique index user_id_uindex
  on "user" (id);

create table company
(
  id          bigserial             not null
    constraint company_pkey
    primary key,
  name        varchar(24)           not null,
  create_date timestamp             not null,
  last_update timestamp,
  deleted     boolean default false not null,
  enabled     boolean default false not null
);

create unique index company_id_uindex
  on company (id);
``` 

and add default data

```postgresplsql
  INSERT INTO public."user" (id, name, last_name, create_date, last_update, deleted, enabled, company_id) VALUES (1, 'First', 'Last', '2018-03-29 22:24:29.435000', null, false, true, 1);
  INSERT INTO public.company (id, name, create_date, last_update, deleted, enabled) VALUES (1, 'First', '2018-03-29 22:23:21.552000', '2018-03-29 22:23:33.939000', false, true);
```

## Run the sample

To build this sample we use maven

```
  mvn clean package
```
We can then run the assembled JAR file with the java command.

```
  java -jar target/demo-0.0.1-SNAPSHOT.jar
```

**Notes** DB must be run when you build and start application

## Endpoints api company

`http://localhost:8080/api/company` `GET` request should return the list of companies

`http://localhost:8080/api/company/{id}` `GET` request should return the company by id

`http://localhost:8080/api/company` `PUT` request should create new company. 

Body for create new company with user: 

```json
{
    "createDate": null,
    "lastUpdate": null,
    "deleted": false,
    "enabled": true,
    "id": null,
    "name": "Next",
    "users": [
        {
            "createDate": null,
            "lastUpdate": null,
            "deleted": false,
            "enabled": true,
            "id": null,
            "name": "First",
            "lastName": "Last"
        }
    ]
}
```

`http://localhost:8080/api/company/{id}` `DELETE` request should delete company by id

## Endpoints api user

`http://localhost:8080/api/user` `GET` request should return the list of users

`http://localhost:8080/api/user/{id}` `GET` request should return the user by id

`http://localhost:8080/api/user` `PUT` request should create new user.

Body for create new user:

```json
        {
          "createDate": null,
          "lastUpdate": null,
          "deleted": false,
          "enabled": true,
          "id": null,
          "name": "First",
          "lastName": "Last"
        }

```

`http://localhost:8080/api/user/{id}` `DELETE` request should delete user by id

`http://localhost:8080/api/user/show/my/the/magic` `GET` request should return a list of users by SpringData magic :)