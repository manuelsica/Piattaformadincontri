drop database if exists incontri; 

CREATE database incontri; 

USE incontri; 

create table profilo
( telefono bigint not null,
email varchar(45) not null,  
nome varchar(15) not null,
cognome varchar(15) not null,
password varchar(25) not null, 
genere varchar(20) default 'non specificato',
dataiscrizione date not null,
orientamento varchar(20) not null,
primary key(telefono)
);

create table foto
( profilo bigint not null, 
file varchar(20), 
primary key(profilo), 
foreign key(profilo) references profilo(telefono)
);

create table bio (
profilo bigint not null, 
testo_bio varchar(50) default 'non specificato', 
professione varchar(20) default 'non specificato', 
motivo varchar(30) default 'non specificato',  
social varchar(20) default 'non specificato', 
foreign key(profilo) references profilo(telefono)
); 


create table normale (
profilo bigint primary key, 
maxmatch int not null,
foreign key(profilo) references profilo(telefono)
); 

create table premium (
profilo bigint primary key,
costo double not null,
datasottoscrizione date not null, 
numero_di_like int default 0,
foreign key(profilo) references profilo(telefono)
); 

create table mi_piace (
premium bigint primary key, 
profilo bigint not null,
classifica bigint not null, 
data_mi_piace date not null,
ratedinteresse double not null,
foreign key(premium) references premium(profilo)
);

create table pagamento (
numero_carta int primary key, 
circuito varchar(20) not null, 
titolare varchar(45) not null, 
datascadenza date not null
);

create table classifica ( 
premium bigint not null, 
numero_posto int not null, 
foreign key(premium) references premium(profilo)
);

create table match_ (
id int primary key,
datamatch date not null,
numero_di_match int not null
); 

create table interazione (
codiceinterazione int primary key, 
testo_interazione varchar(50) not null, 
data_interazione date not null
); 


create table effettua(
premium bigint not null, 
pagamento int not null, 
foreign key(premium) references premium(profilo),
foreign key(pagamento) references pagamento(numero_carta)
);

create table fa(
profilo bigint not null, 
match_ int not null, 
foreign key(profilo) references profilo(telefono), 
foreign key(match_) references match_(id)
); 

create table con(
match_ int not null, 
profilo bigint not null,
foreign key(profilo) references profilo(telefono), 
foreign key(match_) references match_(id)
); 

create table sblocca(
match_ int not null, 
interazione int not null, 
foreign key(match_) references match_(id),
foreign key(interazione) references interazione(codiceinterazione)
); 

create table compie(
premium bigint not null, 
interazione int not null, 
foreign key(premium) references premium(profilo),
foreign key(interazione) references interazione(codiceinterazione)
); 


/*INIZIO INSERT*/

/*insert profilo*/
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3465473334, 'ilomastro@hotmail.com', 'Ilario', 'Mastroberti', 'TiVoglioBeneMamma','Uomo', 20191227, 'gay');
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3466748384,'gomorra@gmail.com','Imma','Savastano','GennyCresci','Donna',20200415, 'bisessuale');
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3880594328,'iole.52@tiscali.it','Iolanda','Pintus','AmoLeFoto23','Donna',20180506, 'lesbica');
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3873193832,'gcuore29@gmail.com','Giulio','Genovese','UFFAAAA01','Non binario', 20200809, 'etero');
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3859402819,'luciodalessio@hotmail.com', 'Lucio', 'D\'Alessio','SperiamonetrovoUna','Uomo',20221012, 'gay');
insert into profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento)
values (3799322317, 'ambrogioernetsto@gmail.com', 'Ernesto', 'Ambrogio', 'fiscianonelcuore', 'Uomo', 20200716, 'etero');

insert into foto(profilo, file) values (3465473334,'cagliari.jpg');
insert into foto(profilo, file) values (3466748384, 'naples2020.jpg'); 
insert into foto(profilo, file) values (3880594328, 'ischia.jpeg'); 
insert into foto(profilo, file) values (3873193832, 'foto1.jpg'); 
insert into foto(profilo, file) values (3859402819, 'foto2.png');  
insert into foto(profilo, file) values (3799322317, 'foto3.jpeg');  

insert into normale(profilo, maxmatch) values (3880594328, 100); 
insert into normale(profilo, maxmatch) values (3873193832, 100); 
insert into normale(profilo, maxmatch) values (3799322317, 100); 

insert into premium(profilo, costo, datasottoscrizione) values (3465473334, 10, 20200820);
insert into premium(profilo, costo, datasottoscrizione) values (3466748384, 10, 20221024);
insert into premium(profilo, costo, datasottoscrizione) values (3859402819, 10, 20200425);

insert into classifica (premium, numero_posto) values (3466748384, 1);
insert into classifica (premium, numero_posto) values (3465473334, 2);
insert into classifica (premium, numero_posto) values (3859402819, 3);

insert into mi_piace(profilo, premium, classifica, data_mi_piace,ratedinteresse) values (3880594328, 3465473334, 3466748384, 20220301, 50); 
insert into mi_piace(profilo, premium, classifica, data_mi_piace,ratedinteresse) values (3873193832, 3466748384, 3465473334, 20220403, 70); 
insert into mi_piace(profilo, premium, classifica, data_mi_piace,ratedinteresse) values (3799322317, 3859402819, 3859402819, 20220506, 30); 

insert into pagamento(numero_carta, circuito, titolare, datascadenza) values (4953, 'VISA', 'Mastroberti Ilario', 20270309); 
insert into pagamento(numero_carta, circuito, titolare, datascadenza) values (5299, 'Mastercard', 'Genovese Giulio', 20300105); 
insert into pagamento(numero_carta, circuito, titolare, datascadenza) values (3416, 'American Express', 'D\'Alessio Lucio', 20250501); 

insert into bio  (profilo, testo_bio, professione,  social, motivo) 
values (3465473334, 'Qualcuno di gradevole', 'Studente', 'Facebook','Nessuno');
insert into bio  (profilo, testo_bio, professione, social, motivo) 
values (3466748384, 'Dimmi qualcosa che non so', 'Ricercatrice', 'Tumblr' ,'Incontro');
insert into bio  (profilo, testo_bio, professione, social, motivo) 
values (3880594328, 'Contattatemi su ig', 'Cuoca', 'Pinterest' ,'L\'amore');
insert into bio  (profilo, testo_bio, professione, social, motivo) 
values (3873193832, 'Belle persone', 'Avvocato', 'Instagram' ,'Relazione');
insert into bio  (profilo, testo_bio, professione, social, motivo) 
values (3859402819, 'No perditempo', 'Studente', 'Facebook' ,'Incontro');
insert into bio  (profilo, testo_bio, professione, social, motivo) 
values (3799322317, 'Qui solo per parlare', 'Medico', 'Instagram','Chat');

insert into match_ (id, datamatch, numero_di_match) values (301344, 20221230, 1);
insert into match_ (id, datamatch, numero_di_match) values (907733, 20210304, 2);
insert into match_ (id, datamatch, numero_di_match) values (590178, 20201204, 3);
insert into match_ (id, datamatch, numero_di_match) values (511664, 20190212, 4);
insert into match_ (id, datamatch, numero_di_match) values (315906, 20200412, 5);
insert into match_ (id, datamatch, numero_di_match) values (719165, 20200706, 6);

insert into interazione (codiceinterazione, testo_interazione, data_interazione) values (009440, 'Ciao, come va?', 20210304); 
insert into interazione (codiceinterazione, testo_interazione, data_interazione) values (149650, 'Ciao', 20210101); 
insert into interazione (codiceinterazione, testo_interazione, data_interazione) values (289964, 'Ehi', 20210309); 
insert into interazione (codiceinterazione, testo_interazione, data_interazione) values (839118, 'Belle foto!', 20211003); 
insert into interazione (codiceinterazione, testo_interazione, data_interazione) values (696762, 'Ciao di dove?', 20211201);  

insert into effettua(premium, pagamento) values (3465473334, 4953);
insert into effettua(premium, pagamento) values (3466748384, 5299);
insert into effettua(premium, pagamento) values (3859402819, 3416);

insert into fa(profilo, match_) values (3465473334, 301344);
insert into fa(profilo, match_) values (3466748384, 907733);
insert into fa(profilo, match_) values (3880594328, 590178);
insert into fa(profilo, match_) values (3873193832, 511664);
insert into fa(profilo, match_) values (3859402819, 315906);
insert into fa(profilo, match_) values (3799322317, 719165);

insert into con(match_, profilo) values (301344, 3466748384);
insert into con(match_, profilo) values (907733, 3465473334);
insert into con(match_, profilo) values (590178, 3873193832);
insert into con(match_, profilo) values (511664, 3880594328);
insert into con(match_, profilo) values (315906, 3873193832);
insert into con(match_, profilo) values (719165, 3859402819);

insert into sblocca(match_, interazione) values (301344, 009440); 
insert into sblocca(match_, interazione) values (907733, 149650); 
insert into sblocca(match_, interazione) values (511664, 289964); 

insert into compie(premium, interazione) values (3465473334, 839118); 
/*insert into compie(premium, interazione) values (3873193832, 696762);*/ 
insert into compie(premium, interazione) values (3466748384, 149650); 
