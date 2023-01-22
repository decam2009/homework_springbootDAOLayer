create table customers
(
    id           serial
        constraint "CUSTOMERS_pk"
            primary key,
    name         varchar,
    surname      varchar,
    age          integer,
    phone_number varchar
);

alter table customers
    owner to postgres;

create table orders
(
    id           serial
        constraint "ORDERS_pk"
            primary key,
    date         date,
    customer_id  integer not null
        constraint "ORDERS_customers_id_fk"
            references customers,
    product_name varchar,
    amount       double precision
);

alter table orders
    owner to postgres;
