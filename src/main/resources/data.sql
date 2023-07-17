-- Line added for challenged
-------------------------------------
CREATE DTABASE IF NOT EXISTS `supera-bank`;
-------------------------------------


CREATE TABLE conta_tb
(
    id_conta BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia_tb
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    data_transferencia DATETIME NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    nome_operador_transacao VARCHAR(50),
    conta_id BIGINT NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES conta_tb (id_conta)
);

INSERT INTO conta_tb (nome_responsavel) VALUES ('Fulano');
INSERT INTO conta_tb (nome_responsavel) VALUES ('Sicrano');

INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-01-01 12:00:00',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-02-03 09:53:27',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-05-04 08:12:45',-500.50,'SAQUE', null,1);
INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-08-07 08:12:45',-530.50,'SAQUE', null,2);
INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2020-06-08 10:15:01',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia_tb (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2021-04-01 12:12:04',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
