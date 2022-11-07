insert into motorista (nome, data_inicio, suspenso) values
('Zé Buduia', '2020-01-10', false),
('Zé Ruela', '2019-01-10', true),
('Messi', '2018-01-10', false),
('Cristino Ronaldo', '2021-01-10', true),
('Maria Bigodenha', '2021-01-10', false);

insert into passageiro (nome, suspenso) values
('Lady Gaga', true),
('Jojo Todinho', false),
('Saitama', true),
('Bruce Wayne', false),
('Naruto', true);

insert into avaliacao_motorista
(data_hora_avaliacao, passageiro_id, motorista_id, nota)
values
('2022-10-20 10:30:00', 1, 1, 5),
('2022-07-20 10:30:00', 3, 1, 4),
('2022-01-20 10:30:00', 5, 1, 3),
('2022-10-20 10:30:00', 1, 3, 5),
('2022-02-20 10:30:00', 3, 3, 4),
('2022-01-20 10:30:00', 5, 3, 5);