create sequence hibernate_sequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

create table staffing
(
    id int4 not null,
    name varchar(255),
    phone_number varchar (64),
    staff_role varchar (32),
    primary key (id)
);
create table hibernate_sequences
(
    sequence_name varchar(255) not null,
    next_val int8,
    primary key (sequence_name)
);
create table manufacturer
(
    id int4 not null,
    manufacturer_name varchar(255),
    primary key (id)
);
create table model_name
(
    id int4 not null,
    manufacturer_id int4,
    model_name varchar(255),
    primary key (id)
);
create table price
(
    id         int4 not null,
    price      varchar(255),
    price_name varchar(255),
    product_id int4,
    primary key (id)
);
create table product
(
    id           int4 not null,
    product_name varchar(255),
    primary key (id)
);
create table service_order
(
    id           int4 not null,
    service_type varchar(255),
    primary key (id)
);
create table status
(
    id          int4 not null,
    status_name varchar(255),
    primary key (id)
);
create table work_order
(
    id                         int4 not null,
    additional_price           varchar(255),
    chat_log                   varchar(8192),
    complection                varchar(1024),
    created_at                 varchar(32),
    customer_name              varchar(255),
    customer_phone             varchar(255),
    date_of_issue              varchar(32),
    final_price                varchar(32),
    given_out                  varchar(32),
    imei                       varchar(255),
    is_accepted                boolean,
    is_done                    boolean,
    is_done_is_called          boolean,
    is_given_out               boolean,
    is_need_call               boolean,
    is_waiting_foraspare_parts boolean,
    look                       varchar(1024),
    prepayment                 varchar(32),
    serial_number              varchar(255),
    trouble                    varchar(512),
    trouble_detected           varchar(1024),
    trouble_solving            varchar(1024),
    engineer_name              varchar (64),
    receiver_name              varchar (64),
    manufacturer_id            int4,
    model_id                   int4,
    price                      int4,
    product_id                 int4,
    service_id                 int4,
    status_id                  int4,
    primary key (id)
);

alter table work_order
    add constraint wo_manufacturer_fk foreign key (manufacturer_id) references manufacturer;
alter table work_order
    add constraint wo_model_name_fk foreign key (model_id) references model_name;
alter table work_order
    add constraint wo_price_fk foreign key (price) references price;
alter table work_order
    add constraint wo_product_fk foreign key (product_id) references product;
alter table work_order
    add constraint wo_service_order_fk foreign key (service_id) references service_order;
alter table work_order
    add constraint wo_status_fk foreign key (status_id) references status;