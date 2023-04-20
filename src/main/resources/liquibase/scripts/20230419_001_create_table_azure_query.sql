create table if not exists "azuque-sniffer"."query" (
    id varchar(64) not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    "active" boolean not null default true,
    "alias" varchar(256) not null,
    token varchar(64) not null,
    constraint query_pk primary key (id)
);
