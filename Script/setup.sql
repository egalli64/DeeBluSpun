drop sequence RISTORANTI_SEQ;
drop sequence RECENSIONI_SEQ;
DROP SEQUENCE utenti_seq;

drop table blurecensioni;
DROP TABLE bluristoranti;
DROP TABLE bluutenti;

create sequence RISTORANTI_SEQ;
create sequence RECENSIONI_SEQ;
CREATE SEQUENCE utenti_seq;

create table bluristoranti (
ristoranti_id integer primary key,
name varchar2(30),
posizione varchar2(30),
specialita varchar2(10));


INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita)
values (RISTORANTI_SEQ.nextval, 'Primo Fiore', 'Taurianova', 'carne');
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita)
values (RISTORANTI_SEQ.nextval, 'Il Parco Dei Principi', 'Gioiosa Ionica', 'pesce');
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita)
values (RISTORANTI_SEQ.nextval, 'Il Castello Degli Dei', 'San Giorgio Morgeto', 'pesce');
INSERT INTO bluristoranti(ristoranti_id, name, posizione, specialita)
values (RISTORANTI_SEQ.nextval, 'Caposperone', 'Tonnara Di Palmi', 'pesce');




create table bluutenti(
utenti_id integer primary key,
utenti_nome varchar2(20),
utenti_cognome varchar2(20)
);

INSERT INTO bluutenti(utenti_id,utenti_nome,utenti_cognome)
values (utenti_SEQ.nextval, 'Piero', 'Bocchinfuso' );
INSERT INTO bluutenti(utenti_id,utenti_nome,utenti_cognome)
values (utenti_SEQ.nextval,'Manuel', 'Ciervo');
INSERT INTO bluutenti(utenti_id,utenti_nome,utenti_cognome)
values (utenti_SEQ.nextval,'Paolo', 'Petrin' );
INSERT INTO bluutenti(utenti_id,utenti_nome,utenti_cognome)
values (utenti_SEQ.nextval,'Sunday','Furfaro' );


create table blurecensioni (
recensioni_id integer primary key,
ristoranti_id integer constraint recensioni_ristoranti_id_fk references bluristoranti(ristoranti_id) on delete cascade,
stelle integer constraint recensioni_stelle_ck check (stelle between 1 and 5),
utenti_id integer constraint recensioni_utenti_id_fk references bluutenti(utenti_id) on delete CASCADE) ;


INSERT INTO blurecensioni(recensioni_id ,ristoranti_id, stelle,utenti_id)
values (recensioni_SEQ.nextval, 1, 4,1);
INSERT INTO blurecensioni(recensioni_id, ristoranti_id, stelle,utenti_id)
values (recensioni_SEQ.nextval, 2, 5,2);
INSERT INTO blurecensioni(recensioni_id, ristoranti_id, stelle,utenti_id)
values (recensioni_SEQ.nextval, 3, 3,3);
INSERT INTO blurecensioni(recensioni_id, ristoranti_id, stelle,utenti_id)
values (recensioni_SEQ.nextval, 4, 1,4);