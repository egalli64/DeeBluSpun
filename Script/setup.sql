drop sequence RISTORANTI_SEQ;
create sequence RISTORANTI_SEQ;

DROP TABLE bluristoranti;
create table bluristoranti (
ristoranti_id integer primary key,
name varchar2(30),
posizione varchar2(30),
specialita varchar2(10),
recensione integer);


INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (RISTORANTI_SEQ.nextval, 'Primo Fiore', 'Taurianova', 'carne', 3);
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (RISTORANTI_SEQ.nextval, 'Il Parco Dei Principi', 'Gioiosa Ionica', 'pesce', 5);
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (RISTORANTI_SEQ.nextval, 'Il Castello Degli Dei', 'San Giorgio Morgeto', 'pesce', 5);
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita, recensione)
values (RISTORANTI_SEQ.nextval, 'Caposperone', 'Tonnara Di Palmi', 'pesce', 5);
