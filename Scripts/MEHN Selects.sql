-- GERAL TODAS TABELAS
select * from cliente; 
select * from endereco;
select * from funcionario;
select * from item;
select * from pagamento;
select * from pedido;
select * from produto;

-- Listar todos os pedidos com o nome  cliente status e total  pedido
select cliente.id_cli,pedido.id_cli,pagamento.valor_total_pag,pagamento.id_ped,pedido.id_ped,pedido.status_ped
from cliente
inner join pedido on cliente.id_cli = pedido.id_cli
inner join pagamento on pedido.id_ped = pagamento.id_ped;

-- Consultar o cardápio completo com nome descrição tipo e preço
select produto.nome_prod,produto.descricao_prod,produto.preco_prod
from produto;

-- Listar clientes que fizeram pedidos  último mês
select pedido.id_ped,pagamento.id_ped,pedido.data_hora_ped
from pedido
inner join pagamento on pedido.id_ped = pagamento.id_ped;

-- Produtos mais vendidos quantidade total último trimestre
select item.id_ped,pedido.id_ped,item.qtd_ite,pedido.data_hora_ped
from item
inner join pedido on item.id_ped = pedido.id_ped;

-- Funcionários que entregaram mais pedidos  mês atual
select funcionario.id_fun,pedido.id_fun,pedido.data_hora_ped
from funcionario
inner join pedido on funcionario.id_fun = pedido.id_fun;