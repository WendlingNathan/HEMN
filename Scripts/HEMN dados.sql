-- ENDEREÇOS
INSERT INTO Endereco (complemento_end, logradouro_end, numero_end, cidade_end, bairro_end, pont_ref_end) VALUES
('Casa', 'Rua das Flores', 123, 'Porto Alegre', 'Centro', 'Próximo ao mercado'),
('Apto 301', 'Av. Brasil', 456, 'Porto Alegre', 'Cidade Baixa', 'Em frente à padaria'),
('Casa', 'Rua A', 789, 'Canoas', 'Harmonia', null),
('Fundos', 'Rua B', 101, 'Gravataí', 'Cohab', 'Perto do posto'),
('Casa', 'Rua C', 202, 'Alvorada', 'Centro', null);

-- CLIENTES
INSERT INTO Cliente (nome_cli, cpf_cli, telefone_cli, email_cli, id_end) VALUES
('João Silva', '12345678901', 51999999901, 'joao@email.com', 1),
('Maria Souza', '23456789012', 51999999902, 'maria@email.com', 2),
('Carlos Lima', '34567890123', 51999999903, 'carlos@email.com', 3),
('Ana Beatriz', '45678901234', 51999999904, 'ana@email.com', 4),
('Lucas Martins', '56789012345', 51999999905, 'lucas@email.com', 5);

-- FUNCIONÁRIOS
INSERT INTO Funcionario (nome_fun, cargo_fun, telefone_fun) VALUES
('José Cozinheiro', 'C', '51988880001'),
('Carla Atendente', 'A', '51988880002'),
('Bruno Entregador', 'E', '51988880003');

-- PRODUTOS
INSERT INTO Produto (nome_prod, descricao_prod, preco_prod, tipo_prod) VALUES
('X-Burguer', 'Pão, carne e queijo', 18.90, 'L'),
('Refrigerante Lata', '350ml de refrigerante', 6.00, 'B'),
('Porção de Batata', '150g de batata frita', 8.50, 'A'),
('X-Salada', 'Pão, carne, queijo, alface e tomate', 21.00, 'L'),
('Suco Natural', 'Copo 400ml de suco', 7.50, 'B');

-- PEDIDOS
INSERT INTO Pedido (data_hora_ped, status_ped, id_cli, id_fun) VALUES
(NOW(), 'E', 1, 2), -- João
(NOW(), 'P', 1, 2), -- João (pedido repetido)
(NOW(), 'A', 2, 2), -- Maria
(NOW(), 'E', 3, 2), -- Carlos
(NOW(), 'P', 4, 2), -- Ana
(NOW(), 'E', 5, 2); -- Lucas

-- ITENS (duplicações em produtos e múltiplos pedidos por cliente)
INSERT INTO Item (qtd_ite, preco_unitario_ite, id_prod, id_ped) VALUES
-- João - 2 pedidos
(1, 18.90, 1, 1),
(1, 6.00, 2, 1),
(1, 21.00, 4, 2),
(2, 6.00, 2, 2),

-- Maria
(1, 21.00, 4, 3),
(1, 6.00, 2, 3),
(1, 8.50, 3, 3),

-- Carlos
(2, 18.90, 1, 4),
(1, 6.00, 2, 4),

-- Ana
(1, 18.90, 1, 5),
(1, 7.50, 5, 5),

-- Lucas
(1, 21.00, 4, 6),
(1, 8.50, 3, 6),
(1, 6.00, 2, 6);

-- PAGAMENTOS
INSERT INTO Pagamento (valor_total_pag, forma_pagameto_pag, data_pag, id_ped) VALUES
(24.90, 'C', NOW(), 1),
(33.00, 'D', NOW(), 2),
(35.50, 'P', NOW(), 3),
(44.80, 'D', NOW(), 4),
(26.40, 'C', NOW(), 5),
(35.50, 'P', NOW(), 6);

INSERT INTO Ingrediente (nome_ing, unidade_medida_ing) VALUES
('Pão de hambúrguer', 'UN'),
('Carne bovina 150g', 'G'),
('Queijo prato', 'UN'),
('Alface', 'G'),
('Tomate', 'G'),
('Batata frita', 'G'),
('Refrigerante Cola', 'ML'),
('Suco de fruta', 'ML'),
('Maionese', 'G');

-- X-Burguer (Produto ID = 1)
INSERT INTO ComposicaoProduto (id_prod, id_ing, qtd_ing_comp) VALUES
(1, 1, 1),   -- Pão
(1, 2, 150), -- Carne
(1, 3, 1),   -- Queijo
(1, 9, 20);  -- Maionese

-- Refrigerante Lata (Produto ID = 2)
INSERT INTO ComposicaoProduto (id_prod, id_ing, qtd_ing_comp) VALUES
(2, 7, 350); -- Refrigerante Cola

-- Porção de Batata (Produto ID = 3)
INSERT INTO ComposicaoProduto (id_prod, id_ing, qtd_ing_comp) VALUES
(3, 6, 150); -- Batata frita

-- X-Salada (Produto ID = 4)
INSERT INTO ComposicaoProduto (id_prod, id_ing, qtd_ing_comp) VALUES
(4, 1, 1),   -- Pão
(4, 2, 150), -- Carne
(4, 3, 1),   -- Queijo
(4, 4, 20),  -- Alface
(4, 5, 20),  -- Tomate
(4, 9, 20);  -- Maionese

-- Suco Natural (Produto ID = 5)
INSERT INTO ComposicaoProduto (id_prod, id_ing, qtd_ing_comp) VALUES
(5, 8, 400); -- Suco de fruta
