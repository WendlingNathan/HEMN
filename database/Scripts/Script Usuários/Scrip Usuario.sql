
-- Criando roles (grupos)
create role grupo_admin nologin;
create role grupo_funcionario nologin;
create role grupo_clientes nologin;

-- Criando usuários 
create user Administrator with password 'admin20';
create user funcionario with password 'fun5420';
create user cliente with password 'cli123';


grant all privileges on all tables in schema public to grupo_admin;
grant select, insert, update on all tables in schema public to grupo_funcionario;
grant select on all tables in schema public to grupo_clientes;

-- Associando usuários aos grupos
grant grupo_admin to administrator;
grant grupo_funcionario to funcionario;
grant grupo_clientes to cliente;

