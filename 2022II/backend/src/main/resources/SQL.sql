CREATE DATABASE reparandoLAFiis;

CREATE TABLE cliente (
	id_cliente NUMERIC (4) PRIMARY KEY,
	nombre VARCHAR (30),
	dni CHAR (8)
);

CREATE TABLE tecnico (
	id_tecnico NUMERIC (4) PRIMARY KEY,
	nombre VARCHAR (30),
	direccion VARCHAR (50),
	codigo_empleado CHAR (6)
);

CREATE TABLE electrodomestico (
	id_electrodomestico NUMERIC (4) PRIMARY KEY,
	marca VARCHAR (30),
	anio NUMERIC (4)
);

CREATE TABLE lavadora (
	id_lavadora NUMERIC (4) PRIMARY KEY,
	capacidad_lavado NUMERIC (4),
	capacidad_secado NUMERIC (4),
	velocidad_centrifugado NUMERIC (4),
	codigo VARCHAR (20),
	id_electrodomestico NUMERIC (4),
	FOREIGN KEY (id_electrodomestico) REFERENCES electrodomestico (id_electrodomestico)
);

CREATE TABLE refrigeradora (
	id_refrigeradora NUMERIC (4) PRIMARY KEY,
	capacidad_litros NUMERIC (4),
	tiene_freezer CHAR (1),
	codigo VARCHAR (20),
	id_electrodomestico NUMERIC (4),
	FOREIGN KEY (id_electrodomestico) REFERENCES electrodomestico (id_electrodomestico)
);

CREATE TABLE reparacion (
	id_reparacion NUMERIC (4) PRIMARY KEY,
	fecha_inicio VARCHAR (10),
	fecha_cierre VARCHAR (10),
	costo NUMERIC (10,2),
	id_tecnico NUMERIC (4),
	id_cliente NUMERIC (4),
	id_electrodomestico NUMERIC (4),
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
	FOREIGN KEY (id_tecnico) REFERENCES tecnico (id_tecnico),
	FOREIGN KEY (id_electrodomestico) REFERENCES electrodomestico (id_electrodomestico)
);

INSERT INTO cliente VALUES (1,'Nino Zegarra','23654512');
INSERT INTO cliente VALUES (2,'Frankie Ruiz','23654535');
INSERT INTO cliente VALUES (3,'Tito Gomez','23654547');

INSERT INTO tecnico VALUES (1,'Ricardo Arjona','El poblado 154','EMP001');
INSERT INTO tecnico VALUES (2,'Fito Paez','Los Girasoles 456','EMP002');

INSERT INTO electrodomestico VALUES (1,'LG','2019');
INSERT INTO electrodomestico VALUES (2,'SAMSUNG','2018');
INSERT INTO electrodomestico VALUES (3,'LG','2021');
INSERT INTO electrodomestico VALUES (4,'SAMSUNG','2020');
INSERT INTO electrodomestico VALUES (5,'LG','2019');
INSERT INTO electrodomestico VALUES (6,'SAMSUNG','2020');

INSERT INTO reparacion VALUES (1,'02/01/2023','05/01/2023',300.00,1,1,1);
INSERT INTO reparacion VALUES (2,'01/01/2023','04/01/2023',200.00,2,2,2);
INSERT INTO reparacion VALUES (3,'04/01/2023','08/01/2023',150.00,2,3,3);
INSERT INTO reparacion VALUES (4,'08/01/2023','11/01/2023',700.00,1,3,4);
INSERT INTO reparacion VALUES (5,'06/01/2023','10/01/2023',250.00,1,2,5);
INSERT INTO reparacion VALUES (6,'05/01/2023','10/01/2023',600.00,2,1,6);

INSERT INTO lavadora VALUES (1,20,18,60,'WT13BSB',1);
INSERT INTO lavadora VALUES (2,15,11,80,'WA12T52',2);
INSERT INTO lavadora VALUES (3,17,12,90,'WM423KL',5);

INSERT INTO refrigeradora VALUES (1,457,'S','RT48A6620B1',3);
INSERT INTO refrigeradora VALUES (2,300,'S','RT29K500JS8',4);
INSERT INTO refrigeradora VALUES (3,250,'N','RT22FARADS3',6);

-- 1) PRIMERA PREGUNTA
INSERT INTO electrodomestico VALUES (?,?,?);
INSERT INTO lavadora VALUES (?,?,?,?,?,?);

-- 2) SEGUNDA PREGUNTA 
refrigeradora

-- 3) TERCERA PREGUNTA 
SELECT
	r.id_reparacion,
	r.fecha_inicio,
	r.fecha_cierre,
	r.costo,
	e.id_electrodomestico,
	e.marca,
	e.anio,
	l.id_lavadora,
	l.capacidad_lavado,
	l.capacidad_secado,
	l.velocidad_centrifugado,
	l.codigo,
	c.nombre 'nombre_cliente',
	t.nombre 'nombre_tecnico',
	t.codigo_empleado
FROM electrodomestico e
INNER JOIN reparacion r ON (r.id_electrodomestico = e.id_electrodomestico)
INNER JOIN lavadora l ON (l.id_electrodomestico = e.id_electrodomestico)
INNER JOIN cliente c ON (c.id_cliente = r.id_cliente)
INNER JOIN tecnico t ON (t.id_tecnico = r.id_tecnico)
WHERE l.capacidad_lavado >= ? AND l.capacidad_lavado <= ?
ORDER BY e.anio DESC;












