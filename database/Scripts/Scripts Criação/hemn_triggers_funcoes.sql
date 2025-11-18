-- Criação das funções a serem executadas pelas triggers
-- Função para cuidado da auditoria da tabela Pedido
CREATE OR REPLACE FUNCTION fn_auditoria_pedido()
RETURNS TRIGGER LANGUAGE plpgsql AS 
$body$
BEGIN
  IF TG_OP = 'UPDATE' THEN
    INSERT INTO aud_pedido (id_ped, operacao, dados_anteriores, dados_novos, usuario)
    VALUES (OLD.id_ped, 'UPDATE', row_to_json(OLD)::jsonb, row_to_json(NEW)::jsonb, current_user);

    RETURN NEW;
  ELSIF TG_OP = 'DELETE' THEN
    INSERT INTO aud_pedido (id_ped, operacao, dados_anteriores, usuario)
    VALUES (OLD.id_ped, 'DELETE', row_to_json(OLD)::jsonb, current_user);

    RETURN OLD;
  ELSIF TG_OP = 'INSERT' THEN
    INSERT INTO aud_pedido (id_ped, operacao, dados_novos, usuario)
    VALUES (NEW.id_ped, 'INSERT', row_to_json(NEW)::jsonb, current_user);

    RETURN NEW;
  END IF;
END;
$body$;

-- Função para cuidade de auditoria do preço da tabela Produto
CREATE OR REPLACE FUNCTION fn_auditoria_preco_produto()
RETURNS TRIGGER LANGUAGE plpgsql as
$body$
BEGIN
  IF (OLD.preco_prod IS DISTINCT FROM NEW.preco_prod) THEN
    INSERT INTO aud_produto_preco (id_prod, preco_antigo, preco_novo, usuario)
    VALUES (OLD.id_prod, OLD.preco_prod, NEW.preco_prod, current_user);
  END IF;

  RETURN NEW;
END;
$body$;

-- Triggers para as tabelas Pedido e Produto, respectivamente
DROP TRIGGER IF EXISTS trg_auditoria_pedido ON Pedido;
CREATE TRIGGER trg_auditoria_pedido
AFTER INSERT OR UPDATE OR DELETE ON Pedido
FOR EACH ROW
EXECUTE FUNCTION fn_auditoria_pedido();

DROP TRIGGER IF EXISTS trg_auditoria_preco_produto ON Produto;
CREATE TRIGGER trg_auditoria_preco_produto
AFTER UPDATE ON Produto
FOR EACH ROW
WHEN (OLD.preco_prod IS DISTINCT FROM NEW.preco_prod)
EXECUTE FUNCTION fn_auditoria_preco_produto();