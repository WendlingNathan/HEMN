//GERAL TODAS TABELAS
select * from cliente; 
select * from endereco;
select * from funcionario;
select * from item;
select * from pagamento;
select * from pedido;
select * from produto;

//Listar todos os pedidos com o nome  cliente status e total  pedido
select cliente.id_cli,pedido.id_cli,pagamento.valor_total_pag,pagamento.id_ped,pedido.id_ped,pedido.status_ped
from cliente
inner join pedido on cliente.id_cli = pedido.id_cli
inner join pagamento on pedido.id_ped = pagamento.id_ped;

//Consultar o cardápio completo com nome descrição tipo e preço
select produto.nome_prod,produto.descricao_prod,produto.preco_prod
from produto;
