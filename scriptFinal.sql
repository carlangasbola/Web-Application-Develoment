
create database BaseDeDatosWAD;

use BaseDeDatosWAD;

create table usuarios(
	idUser int not null auto_increment,
	userNameIn varchar(30) not null,
	passwordIn varchar(30) not null,
	tipoIn	   varchar(30) not null,
	primary key(idUser)
);

create table grupo(
	nombregrupo varchar(30) not null,
  	primary key(nombregrupo)
);

create table diagrama(
	id_diagrama int not null auto_increment,
	json varchar(6000) not null,
  	primary key(id_diagrama)
);



create table relacionGrupos(
	ref_idUser  int not null,
	ref_nombreGrupo varchar(30) not null,
	foreign key (ref_idUser) references usuarios(idUser) on delete cascade,
	foreign key (ref_nombreGrupo) references  grupo(nombregrupo) on delete cascade,
	primary key ( ref_idUser, ref_nombreGrupo )

);

create table relacionDiagramas(
	ref_nombreGrupo varchar(30) not null,
	ref_idDiagrama  int not null,
	foreign key (ref_nombreGrupo) references  grupo(nombregrupo) on delete cascade,
	foreign key (ref_idDiagrama)  references  diagrama(id_diagrama) on delete cascade,
	primary key ( ref_nombreGrupo, ref_idDiagrama )
);


