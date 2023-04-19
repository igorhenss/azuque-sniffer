create table if not exists "azuque-sniffer".azure_query (
    id serial not null,
    created_at timestamp not null default now(),
    is_active boolean not null default true,
    title varchar(256) not null,
    azure_token varchar(64) not null,
    constraint azure_query_pk primary key (id)
);
