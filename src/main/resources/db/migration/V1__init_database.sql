# alter table orders
#     drop
#         foreign key if exists FK9qntjmy82o15pyak9igalicsn;
#
# alter table orders_products
#     drop
#         foreign key if exists FKqgxvu9mvqx0bv2ew776laoqvv;
#
# alter table orders_products
#     drop
#         foreign key if exists FKe4y1sseio787e4o5hrml7omt5;
#
# alter table persons
#     drop
#         foreign key if exists FK91lhgyogjpj1rlwiwwsuy21bo;

drop table if exists address;

drop table if exists orders;

drop table if exists orders_products;

drop table if exists persons;

drop table if exists products;

create table address
(
    id     bigint not null auto_increment,
    city   varchar(255),
    street varchar(255),
    primary key (id)
) engine = InnoDB;

create table orders
(
    id              bigint not null auto_increment,
    tracking_number binary(255),
    person_id       bigint,
    primary key (id)
) engine = InnoDB;

create table orders_products
(
    order_id    bigint not null,
    products_id bigint not null
) engine = InnoDB;

create table persons
(
    id         bigint not null auto_increment,
    active     bit    not null,
    age        integer,
    name       varchar(255),
    password   varchar(255),
    roles      varchar(255),
    user_name  varchar(255),
    address_id bigint,
    primary key (id)
) engine = InnoDB;

create table products
(
    id           bigint not null auto_increment,
    product_name varchar(255),
    primary key (id)
) engine = InnoDB;

alter table persons
    add constraint UKpgc67pertaq9r5tkqeerxephp unique (address_id);

alter table persons
    add constraint UK_h98ahfxk8ybwa7yx59y4i0n8o unique (password);

alter table persons
    add constraint UK_p4iorvsogtqgjt8m9twrsb81 unique (user_name);

alter table orders
    add constraint FK9qntjmy82o15pyak9igalicsn
        foreign key (person_id)
            references persons (id);

alter table orders_products
    add constraint FKqgxvu9mvqx0bv2ew776laoqvv
        foreign key (products_id)
            references products (id);

alter table orders_products
    add constraint FKe4y1sseio787e4o5hrml7omt5
        foreign key (order_id)
            references orders (id);

alter table persons
    add constraint FK91lhgyogjpj1rlwiwwsuy21bo
        foreign key (address_id)
            references address (id);