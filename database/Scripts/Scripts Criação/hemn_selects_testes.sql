-- GERAL TODAS TABELAS
select * from cliente; 
select * from endereco;
select * from funcionario;
select * from item;
select * from pagamento;
select * from pedido;
select * from produto;

-- Listar todos os pedidos com o nome  cliente status e total  pedido
CREATE VIEW listPedido AS
SELECT
    cliente.id_cli AS id_cliente,
    pedido.id_cli AS id_cliente_pedido,
    pagamento.valor_total_pag,
    pagamento.id_ped AS id_ped_pagamento,
    pedido.id_ped AS id_ped_pedido,
    pedido.status_ped
FROM cliente
INNER JOIN pedido ON cliente.id_cli = pedido.id_cli
INNER JOIN pagamento ON pedido.id_ped = pagamento.id_ped;

-- Consultar o cardápio completo com nome descrição tipo e preço
CREATE VIEW vw_produto AS
SELECT 
    produto.nome_prod,
    produto.descricao_prod,
    produto.preco_prod
FROM produto;


-- Listar clientes que fizeram pedidos  último mês
CREATE VIEW vw_pedidos_pagamentos AS
SELECT
    pedido.id_ped AS id_pedido,
    pagamento.id_ped AS id_pedido_pagamento,
    pedido.data_hora_ped
FROM pedido
INNER JOIN pagamento ON pedido.id_ped = pagamento.id_ped;


-- Produtos mais vendidos quantidade total último trimestre
CREATE VIEW vw_produtos_vendidos_trimestre AS
SELECT
    item.id_ped AS id_pedido_item,
    pedido.id_ped AS id_pedido,
    item.qtd_ite AS quantidade,
    pedido.data_hora_ped AS data_pedido
FROM item
INNER JOIN pedido ON item.id_ped = pedido.id_ped;

-- Funcionários que entregaram mais pedidos  mês atual
CREATE VIEW vw_funcionarios_pedidos AS
SELECT
    funcionario.id_fun AS id_funcionario,
    pedido.id_fun AS id_funcionario_pedido,
    pedido.data_hora_ped AS data_pedido
FROM funcionario
INNER JOIN pedido ON funcionario.id_fun = pedido.id_fun;

CREATE OR REPLACE VIEW vw_funcionarios_top_mes AS
SELECT
    f.id_fun AS id_funcionario,
    COUNT(p.id_ped) AS total_pedidos,
    DATE_TRUNC('month', p.data_hora_ped) AS mes_referencia
FROM funcionario f
INNER JOIN pedido p ON f.id_fun = p.id_fun
WHERE DATE_TRUNC('month', p.data_hora_ped) = DATE_TRUNC('month', CURRENT_DATE)
GROUP BY f.id_fun, DATE_TRUNC('month', p.data_hora_ped)
ORDER BY total_pedidos DESC;



