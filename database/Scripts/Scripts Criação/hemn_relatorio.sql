-- 1°: Relatório de cardápio ativo
select produto.nome_prod as "Produto", produto.tipo_prod as "Tipo de produto", produto.preco_prod as "Preço (R$)"
from produto
order by produto.nome_prod asc;

-- 2°: Relatório de Ingredientes por Produto do Cardápio
select 
  p.nome_prod as "Produto",
  i.nome_ing as "Ingrediente",
  cp.qtd_ing_comp || ' ' || i.unidade_medida_ing as "Quantidade"
from ComposicaoProduto cp
join Produto p on p.id_prod = cp.id_prod
JOIN Ingrediente i on i.id_ing = cp.id_ing
order by p.nome_prod, i.nome_ing;

-- 3°: Relatório de Pedidos Realizados no Mês Atual 
select 
  ped.id_ped as "ID Pedido",
  ped.data_hora_ped as "Data",
  cli.nome_cli as "Cliente",
  pag.valor_total_pag as "Valor Total (R$)"
from Pedido ped
join Cliente cli on cli.id_cli = ped.id_cli
join Pagamento pag on pag.id_ped = ped.id_ped
where extract(month from ped.data_hora_ped) = extract(month from CURRENT_DATE)
  and extract(YEAR from ped.data_hora_ped) = extract(YEAR from CURRENT_DATE)
order by ped.data_hora_ped desc;

-- 4°: Relatório de faturamento por Item do cardápio
select 
  p.nome_prod as "Produto",
  sum(i.qtd_ite) as "Total Vendido (unidades)",
  sum(i.qtd_ite * i.preco_unitario_ite) as "Faturamento Total (R$)"
from Item i
join Produto p on p.id_prod = i.id_prod
group by p.nome_prod
having sum(i.qtd_ite) > 0
order by "Faturamento Total (R$)" desc;
