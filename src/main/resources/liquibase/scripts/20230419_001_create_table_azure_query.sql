create table if not exists "azuque-sniffer".azure_query (
    id serial not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    "active" boolean not null default true,
    title varchar(256) not null,
    token varchar(64) not null,
    url varchar(256) not null unique,
    constraint azure_query_pk primary key (id)
);
