CREATE DATABASE pichanga_vip;

CREATE TABLE equipo (
	id_equipo NUMERIC (4) PRIMARY KEY,
	nombre VARCHAR (50),
	ciudad VARCHAR (30)
);

CREATE TABLE jugador (
	id_jugador NUMERIC (4) PRIMARY KEY,
	numero NUMERIC (2),
	nombres VARCHAR (50),
	flg_habilitado NUMERIC (1),
	id_equipo NUMERIC (4),
	FOREIGN KEY (id_equipo) REFERENCES equipo (id_equipo)
);

CREATE TABLE partido (
	id_partido NUMERIC (4) PRIMARY KEY,
	id_equipo_local NUMERIC (4),
	id_equipo_visitante NUMERIC (4),
	fecha CHAR (10),
	hora CHAR (5),
	FOREIGN KEY (id_equipo_local) REFERENCES equipo (id_equipo),
	FOREIGN KEY (id_equipo_visitante) REFERENCES equipo (id_equipo)
);

CREATE TABLE goles (
	id_gol NUMERIC (4),
	id_partido NUMERIC (4),
	id_jugador NUMERIC (4),
	minuto NUMERIC (3),
	FOREIGN KEY (id_partido) REFERENCES partido (id_partido),
	FOREIGN KEY (id_jugador) REFERENCES jugador (id_jugador)
);

INSERT INTO equipo VALUES (1,'cremas','lima');
INSERT INTO equipo VALUES (2,'intimos','lima');
INSERT INTO equipo VALUES (3,'el papa','cuzco');
INSERT INTO equipo VALUES (4,'la academia','lima');

INSERT INTO jugador VALUES (1,7,'Vargas, Juan',1,1);
INSERT INTO jugador VALUES (2,9,'Saenz, Waldir',1,2);
INSERT INTO jugador VALUES (3,9,'Carty, German',1,3);
INSERT INTO jugador VALUES (4,9,'Marengo, Manuel',1,4);
INSERT INTO jugador VALUES (5,6,'Carranza, Jose',1,1);
INSERT INTO jugador VALUES (6,6,'Jayo, Juan',1,2);
INSERT INTO jugador VALUES (7,11,'Ibarra, Sergio',1,3);
INSERT INTO jugador VALUES (8,10,'Challe, Roberto',1,4);
INSERT INTO jugador VALUES (9,10,'Martinez, Roberto',1,1);
INSERT INTO jugador VALUES (10,11,'Muchotrigo, Dario',1,2);
INSERT INTO jugador VALUES (11,10,'Lobaton, Carlos',1,3);
INSERT INTO jugador VALUES (12,8,'Drago, Roberto',1,4);

INSERT INTO goles VALUES (1,1,2,40);
INSERT INTO goles VALUES (2,1,10,60);
INSERT INTO goles VALUES (3,1,9,75);
INSERT INTO goles VALUES (4,1,2,85);
INSERT INTO goles VALUES (5,1,2,89);
INSERT INTO goles VALUES (6,2,3,20);
INSERT INTO goles VALUES (7,2,8,45);
INSERT INTO goles VALUES (8,2,7,50);
INSERT INTO goles VALUES (9,2,12,65);
INSERT INTO goles VALUES (10,3,2,5);
INSERT INTO goles VALUES (11,3,12,15);
INSERT INTO goles VALUES (12,3,2,75);
INSERT INTO goles VALUES (13,3,6,90);
INSERT INTO goles VALUES (14,4,1,5);
INSERT INTO goles VALUES (15,4,11,15);
INSERT INTO goles VALUES (16,4,9,20);
INSERT INTO goles VALUES (17,4,3,85);

INSERT INTO partido VALUES (1,1,2,'07/05/2020','14:00');
INSERT INTO partido VALUES (2,3,4,'08/05/2020','16:00');
INSERT INTO partido VALUES (3,1,4,'14/05/2020','12:00');
INSERT INTO partido VALUES (4,3,2,'15/05/2020','18:00');


SELECT
	p.id_partido,
	loc.nombre 'equipoLocal',
	vis.nombre 'equipoVisitante',
	p.fecha,
	p.hora,
	j.nombres 'autorGol',
	g.minuto
FROM partido p 
INNER JOIN equipo loc ON (loc.id_equipo = p.id_equipo_local)
INNER JOIN equipo vis ON (vis.id_equipo = p.id_equipo_visitante)
INNER JOIN goles g ON (g.id_partido = p.id_partido)
INNER JOIN jugador j ON (g.id_jugador = j.id_jugador)
ORDER BY p.id_partido, g.minuto;

SELECT
    j.id_jugador,
    j.nombres,
    e.nombre AS nombre_equipo,
    COUNT(g.id_jugador) AS goles
FROM equipo e
INNER JOIN jugador j ON j.id_equipo = e.id_equipo
INNER JOIN goles g ON g.id_jugador = j.id_jugador
GROUP BY j.id_jugador, j.nombres, e.nombre
HAVING COUNT(g.id_jugador) > 1
ORDER BY COUNT(g.id_jugador) DESC;

INSERT INTO equipo VALUES (?,?,?);

