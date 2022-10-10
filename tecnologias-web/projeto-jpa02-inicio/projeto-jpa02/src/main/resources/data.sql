-- ao criamos um arquivo de nome "data.sql" na pasta "resources"
-- caso a configuração "spring.jpa.defer-datasource-initialization" no arquivo application.properties estiver true,
-- todas as instruções aqui serão executadas
-- PODEM haver mais de 1 insert, porém devem sempre terminar com ";"


insert into animal_estimacao
(castrado, cpf_dono, data_nascimento, email_dono, nome, peso, telefone_dono)
values
(false, '45750262049', '2020-09-09', 'aaaa@bbb', 'xuxu', 2.5, '9999-9999'),
(true, '71152763075', '2020-01-01', 'bbbb@bbb', 'xena', 5.5, '8888-9999'),
(true, '92132139059', '2018-12-12', 'cccc@bbb', 'cenourinha', 0.2, '11 7777-9999');

-- insert numa 2a tabela;

-- insert numa 3a tabela;