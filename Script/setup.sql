create table ristoranti (
ristoranti_id integer primary key,
name varchar2(30),
posizione varchar2(30),
specialita varchar2(2),
recensione varchar(7));

INSERT INTO ristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (1, 'Primo Fiore', 'Taurianova', 'carne', '3Stelle');
INSERT INTO ristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (2, 'Il Parco Dei Principi', 'Gioiosa Ionica', 'pesce', '5Stelle');
