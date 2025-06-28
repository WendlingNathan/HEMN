-- Relatorio de cardapio ativo
select produto.nome_prod,produto.tipo_prod,produto.preco_prod
from produto
order by produto.nome_prod asc;

-- Relatorio de produtos por item do cardapio pedidos
select item.id_prod, produto.id_prod, produto.nome_prod,item.qtd_ite,pedido.id_ped,item.id_ped
from  item 
inner join produto on produto.id_prod = item.id_prod
inner join pedido on pedido.id_ped =item.id_ped
order by  item.id_ped desc;

--Relatorio de pedidos realizados 
select cliente.nome_cli,cliente.id_cli,pedido.id_cli,to_char (pedido.data_hora_ped,'dd/mm/yyyy'),
pagamento.id_ped,pedido.id_ped,pagamento.valor_total_pag
from pedido 
inner join cliente  on cliente.id_cli  = pedido.id_cli
inner join pagamento on pagamento.id_ped = pedido.id_ped
order by cliente.nome_cli asc;

--Relatorio de faturamento por item do cardapio
select (item.preco_unitario_ite * item.qtd_ite)valtot ,item.qtd_ite,item.id_prod,
produto.id_prod,item.id_ped,pedido.id_ped,to_char (pedido.data_hora_ped,'dd/mm/yyyy')
from item 
inner join pedido on pedido.id_ped = item.id_ped
inner join produto on produto.id_prod = item.id_prod
order by valtot desc;
