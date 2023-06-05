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
    data_nascita VARCHAR(60),
    
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
    visualizza INT NOT NULL, -- inserire 0 per non visualizzare il prodotto, 1 altrimenti
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

CREATE TABLE carta
(
	nomeTitolare VARCHAR(60),
    cognomeTitolare VARCHAR(60),
    numeroCarta VARCHAR(16) NOT NULL,
    scadenza VARCHAR(60),
    cvv INT,
    visualizza INT NOT NULL, -- inserire 0 per non visualizzare la carta, 1 altrimenti
    PRIMARY KEY(numeroCarta)
);

CREATE TABLE Ha
(
	id_ha INT AUTO_INCREMENT,
    email_u VARCHAR(60) NOT NULL,
    n_card VARCHAR(16) NOT NULL,
    PRIMARY KEY(id_ha),
    FOREIGN KEY(email_u) REFERENCES cliente(e_mail) ON DELETE CASCADE,
    FOREIGN KEY(n_card) REFERENCES carta(numeroCarta) ON DELETE CASCADE
);