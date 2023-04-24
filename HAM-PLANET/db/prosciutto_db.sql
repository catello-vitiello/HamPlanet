DROP DATABASE IF EXISTS prosciutto_db;
CREATE DATABASE prosciutto_db;

DROP USER IF EXISTS 'tsw'@'localhost';
CREATE USER 'tsw'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON prosciutto_db.* TO 'tsw'@'localhost';

USE prosciutto_db;

DROP TABLE IF EXISTS composto;
DROP TABLE IF EXISTS ordine;
DROP TABLE IF EXISTS prodotto;
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente
(
	e_mail    VARCHAR(60) NOT NULL,
    pass      VARCHAR(60) NOT NULL,
    nome      VARCHAR(60) NOT NULL,
    cognome   VARCHAR(60) NOT NULL,
    sesso 	  char NOT NULL,
    indirizzo VARCHAR(60) NOT NULL,
    cellulare VARCHAR(10) NOT NULL,
    
    PRIMARY KEY(e_mail)
);

CREATE TABLE ordine
(
	id INT auto_increment,
    data_acquisto DATE NOT NULL,
    stato ENUM('salvato', 'effettuato', 'spedito') DEFAULT 'salvato',
    metodo_pagamento VARCHAR(60) NOT NULL,
    email varchar(60),
    PRIMARY KEY(id),
    foreign key(email) references cliente(e_mail) on delete cascade
);

CREATE TABLE prodotto
(
	IAN INT NOT NULL,
    prezzo DOUBLE,
    peso DOUBLE,
    descrizione VARCHAR(300),
    image MEDIUMBLOB,
    nomeProdotto VARCHAR(60),
    PRIMARY KEY(IAN)
);

CREATE TABLE composto
(
	id_c INT auto_increment,
	id_ordine INT NOT NULL,
    ian_prodotto INT NOT NULL,
    prezzo DOUBLE,
    quantity INT,
    PRIMARY KEY(id_c),
    FOREIGN KEY(id_ordine) REFERENCES ordine(id) ON DELETE CASCADE,
    FOREIGN KEY(ian_prodotto) REFERENCES prodotto(IAN) ON DELETE CASCADE
);