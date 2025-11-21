-- 1°: Relatório de cardápio ativo
create or replace view vw_cardapio_ativo as
select
	produto.nome_prod as "Produto",
	produto.tipo_prod as "Tipo de produto",
	produto.preco_prod as "Preço(R$)"
from
	produto
order by
	produto.nome_prod asc;

select * from vw_cardapio_ativo;

-- 2°: Relatório de Ingredientes por Produto do Cardápio
create or replace view vw_ingredientes_por_produto as
select
	p.nome_prod as "Produto",
	i.nome_ing as "Ingrediente",
	cp.qtd_ing_comp || ' ' || i.unidade_medida_ing as "Quantidade"
from
	ComposicaoProduto cp
join Produto p on p.id_prod = cp.id_prod
join Ingrediente i on i.id_ing = cp.id_ing
order by
	p.nome_prod,
	i.nome_ing;

select * from vw_ingredientes_por_produto;

-- 3°: Relatório de Pedidos Realizados no Mês Atual 
create or replace view vw_pedidos_mes_atual as
select
	ped.id_ped as "ID Pedido",
	ped.data_hora_ped as "Data",
	cli.nome_cli as "Cliente",
	pag.valor_total_pag as "Valor Total(R$)"
from
	Pedido ped
join Cliente cli on cli.id_cli = ped.id_cli
join Pagamento pag on pag.id_ped = ped.id_ped
where
	extract(month from ped.data_hora_ped) = extract(month from CURRENT_DATE)
	and extract(year from ped.data_hora_ped) = extract(year from CURRENT_DATE)
order by
	ped.data_hora_ped desc;

select * from vw_pedidos_mes_atual;

-- 4°: Relatório de faturamento por Item do cardápio
create or replace view vw_faturamento_por_item as
select
	p.nome_prod as "Produto",
	SUM(i.qtd_ite) as "Total Vendido (unidades)",
	SUM(i.qtd_ite * i.preco_unitario_ite) as "Faturamento Total(R$)" 
FROM Item i
JOIN Produto p ON p.id_prod = i.id_prod 
GROUP BY 
	p.nome_prod HAVING SUM(i.qtd_ite) > 0 
ORDER by
	"Faturamento Total(R$)"
desc;

select * from vw_faturamento_por_item;