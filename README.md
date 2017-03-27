# SpringBoot-Seed

## Introduction

> An example project based on SpringBoot integrated with oauth2 ( token persisted on mysql ), swagger2, restful API, druid, mybatis ( generator and pagehelper included).

## Preparation

> Create mysql database named `seed` by `db/schema.sql` & `db/data.sql`, then Run SpringBoot Application

## Features


#### druid
> see `http://localhost:8080/druid/login.html`

> username `root` and password `root` is same as mysql database


#### mybatis generator
> run `mvn mybatis-generator:generate`

#### swagger
> see `http://localhost:8080/swagger-ui.html `

#### oauth2
>use `curl http://localhost:8080/oauth/token -X POST -u client:security -d "grant_type=password&username=admin&password=admin"` to get access token

> use `curl http://localhost:8080/user/1 -X DELETE -H "Authorization: Bearer {access token}"` to access authenticated url