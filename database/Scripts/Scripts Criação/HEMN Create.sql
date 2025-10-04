CREATE TABLE Cliente (
  id_cli       SERIAL NOT NULL, 
  nome_cli     varchar(80) NOT NULL, 
  cpf_cli      varchar(11) NOT NULL UNIQUE, 
  telefone_cli varchar(12) NOT NULL, 
  email_cli    varchar(60) NOT NULL UNIQUE, 
  id_end       int4 NOT NULL, 
  CONSTRAINT cliente_pkey 
    PRIMARY KEY (id_cli));
COMMENT ON TABLE Cliente IS 'Tabela Cliente.';
COMMENT ON COLUMN Cliente.id_cli IS 'Id do cliente';
COMMENT ON COLUMN Cliente.nome_cli IS 'Nome do cliente';
COMMENT ON COLUMN Cliente.cpf_cli IS 'CPF do cliente';
COMMENT ON COLUMN Cliente.telefone_cli IS 'Telefone do cliente';
CREATE TABLE ComposicaoProduto (
  id_comp      SERIAL NOT NULL, 
  qtd_ing_comp numeric(5, 2) NOT NULL, 
  id_prod      int4 NOT NULL, 
  id_ing       int4 NOT NULL, 
  CONSTRAINT composicaoProduto_pkey 
    PRIMARY KEY (id_comp));
COMMENT ON TABLE ComposicaoProduto IS 'Tabela da composição do produto.';
COMMENT ON COLUMN ComposicaoProduto.id_comp IS 'ID da composição do produto.';
COMMENT ON COLUMN ComposicaoProduto.qtd_ing_comp IS 'Quantidade do produto na composição.';
CREATE TABLE Endereco (
  id_end          SERIAL NOT NULL, 
  complemento_end varchar(20) NOT NULL, 
  logradouro_end  varchar(20) NOT NULL, 
  numero_end      int4 NOT NULL, 
  cidade_end      varchar(80) NOT NULL, 
  bairro_end      varchar(40) NOT NULL, 
  pont_ref_end    varchar(80), 
  CONSTRAINT endereco_pkey 
    PRIMARY KEY (id_end));
COMMENT ON TABLE Endereco IS 'Tabela Endereco.';
COMMENT ON COLUMN Endereco.id_end IS 'Id do endereço';
COMMENT ON COLUMN Endereco.complemento_end IS 'Complemento do endereço';
COMMENT ON COLUMN Endereco.logradouro_end IS 'Logradouro do endereço';
COMMENT ON COLUMN Endereco.numero_end IS 'Número do endereço';
COMMENT ON COLUMN Endereco.cidade_end IS 'Cidade do endereço';
COMMENT ON COLUMN Endereco.bairro_end IS 'Bairro do endereço';
COMMENT ON COLUMN Endereco.pont_ref_end IS 'Ponto de referência do endereço';
CREATE TABLE Funcionario (
  id_fun       SERIAL NOT NULL, 
  nome_fun     varchar(80) NOT NULL, 
  cargo_fun    char(1) NOT NULL CHECK(cargo_fun in ('C', 'A', 'E')), 
  telefone_fun varchar(11), 
  CONSTRAINT funcionario_pkey 
    PRIMARY KEY (id_fun));
COMMENT ON TABLE Funcionario IS 'Tabela Funcionario.';
COMMENT ON COLUMN Funcionario.id_fun IS 'Id do funcionario';
COMMENT ON COLUMN Funcionario.nome_fun IS 'Nome do funcionario';
COMMENT ON COLUMN Funcionario.cargo_fun IS 'Cargos dos Funcionarios (''C'' - "Cozinheiro", ''A'' - "Atentende", ''E'' - "Entregador")';
COMMENT ON COLUMN Funcionario.telefone_fun IS 'Telefone do funcionario';
CREATE TABLE Ingrediente (
  id_ing             SERIAL NOT NULL, 
  nome_ing           varchar(60) NOT NULL UNIQUE, 
  unidade_medida_ing char(2) NOT NULL CHECK(unidade_medida_ing in ('G', 'ML', 'UN')), 
  CONSTRAINT ingrediente_pkey 
    PRIMARY KEY (id_ing));
COMMENT ON TABLE Ingrediente IS 'Tabela do Ingrediente.';
COMMENT ON COLUMN Ingrediente.id_ing IS 'ID do Ingrediente.';
COMMENT ON COLUMN Ingrediente.nome_ing IS 'Nome do Ingrediente.';
COMMENT ON COLUMN Ingrediente.unidade_medida_ing IS 'Unidade de medida ("G" - "Grama", "ML" - "Mililitro", "UN" - "Unidade").';
CREATE TABLE Item (
  id_ite             SERIAL NOT NULL, 
  qtd_ite            int4 NOT NULL, 
  preco_unitario_ite numeric(4, 2) NOT NULL, 
  id_prod            int4 NOT NULL, 
  id_ped             int4 NOT NULL, 
  CONSTRAINT item_pkey 
    PRIMARY KEY (id_ite));
COMMENT ON TABLE Item IS 'Tabela Item - Representa cada item do pedido.';
COMMENT ON COLUMN Item.qtd_ite IS 'Quantidade de itens do pedido';
COMMENT ON COLUMN Item.preco_unitario_ite IS 'preço unitario do item';
CREATE TABLE Pagamento (
  id_pag             SERIAL NOT NULL, 
  valor_total_pag    numeric(4, 2) NOT NULL, 
  forma_pagameto_pag char(1) NOT NULL CHECK(forma_pagameto_pag in ('D','C','P')), 
  data_pag           timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, 
  id_ped             int4 NOT NULL, 
  CONSTRAINT pagamento_pkey 
    PRIMARY KEY (id_pag));
COMMENT ON TABLE Pagamento IS 'Tabela Pagamento.';
COMMENT ON COLUMN Pagamento.id_pag IS 'id do pagamento';
COMMENT ON COLUMN Pagamento.valor_total_pag IS 'Valor total do pagamento';
COMMENT ON COLUMN Pagamento.forma_pagameto_pag IS 'Forma de pagamento (''D'' - "Dinheiro",''C'' - "Cartão",''P'' - "Pix")';
COMMENT ON COLUMN Pagamento.data_pag IS 'Data de pagamento';
CREATE TABLE Pedido (
  id_ped        SERIAL NOT NULL, 
  data_hora_ped timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, 
  status_ped    char(1) NOT NULL CHECK(status_ped in ('A', 'P','E')), 
  id_cli        int4 NOT NULL, 
  id_fun        int4 NOT NULL, 
  CONSTRAINT pedido_pkey 
    PRIMARY KEY (id_ped));
COMMENT ON TABLE Pedido IS 'Tabela Pedido.';
COMMENT ON COLUMN Pedido.id_ped IS 'Id do pedido';
COMMENT ON COLUMN Pedido.data_hora_ped IS 'Data e hora do pedido';
COMMENT ON COLUMN Pedido.status_ped IS 'Status do pedido (''A'' - "Aguarde", ''P'' - "Pronto", ''E'' - "Entregue")';
CREATE TABLE Produto (
  id_prod        SERIAL NOT NULL, 
  nome_prod      varchar(40) NOT NULL, 
  descricao_prod varchar(100) NOT NULL, 
  preco_prod     numeric(4, 2) NOT NULL, 
  tipo_prod      char(1) NOT NULL CHECK(tipo_prod in ('L' , 'B' , 'A' )), 
  CONSTRAINT produto_pkey 
    PRIMARY KEY (id_prod));
COMMENT ON TABLE Produto IS 'Tabela Produto.';
COMMENT ON COLUMN Produto.nome_prod IS 'Nome do produto';
COMMENT ON COLUMN Produto.descricao_prod IS 'Descrição do produto';
COMMENT ON COLUMN Produto.preco_prod IS 'Preço do produto';
COMMENT ON COLUMN Produto.tipo_prod IS 'Tipo de produto (''L'' - "Lanche", ''A'' - "Acompanhamento", ''B'' - "Bebida")';
ALTER TABLE Cliente ADD CONSTRAINT cliente_id_end_fkey_001 FOREIGN KEY (id_end) REFERENCES Endereco (id_end) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE ComposicaoProduto ADD CONSTRAINT composicaoProduto_id_ing_fkey_002 FOREIGN KEY (id_ing) REFERENCES Ingrediente (id_ing) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE ComposicaoProduto ADD CONSTRAINT composicaoProduto_id_prod_fkey_001 FOREIGN KEY (id_prod) REFERENCES Produto (id_prod) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE Item ADD CONSTRAINT item_id_ped_fkey_001 FOREIGN KEY (id_ped) REFERENCES Pedido (id_ped) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE Item ADD CONSTRAINT item_id_prod_fkey_002 FOREIGN KEY (id_prod) REFERENCES Produto (id_prod) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE Pagamento ADD CONSTRAINT pagamento_id_ped_fkey_001 FOREIGN KEY (id_ped) REFERENCES Pedido (id_ped) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE Pedido ADD CONSTRAINT pedido_id_cli_fkey_002 FOREIGN KEY (id_cli) REFERENCES Cliente (id_cli) ON UPDATE Cascade ON DELETE Restrict;
ALTER TABLE Pedido ADD CONSTRAINT pedido_id_fun_fkey_001 FOREIGN KEY (id_fun) REFERENCES Funcionario (id_fun) ON UPDATE Cascade ON DELETE Restrict;
