-- Relatorio de cardapio ativo
select produto.nome_prod,produto.tipo_prod,produto.preco_prod
from produto
order by produto.nome_prod asc;