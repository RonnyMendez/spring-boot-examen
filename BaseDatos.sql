CREATE TABLE Cliente (
    codigo INT PRIMARY KEY,
    DNI VARCHAR(8) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(15)
);

CREATE TABLE Garaje (
    idGaraje INT PRIMARY KEY,
    direccion VARCHAR(200) NOT NULL
);

CREATE TABLE Automovil (
    matricula VARCHAR(10) PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    color VARCHAR(30) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    idGaraje INT,
    FOREIGN KEY (idGaraje) REFERENCES Garaje(idGaraje)
);

CREATE TABLE Reserva (
    idReserva INT PRIMARY KEY,
    precioTotal DECIMAL(10, 2),
    entregado BOOLEAN NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFinal DATE NOT NULL,
    codigoCliente INT,
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigo)
);

CREATE TABLE Reserva_Automovil (
    idReserva INT,
    matricula VARCHAR(10),
    precioAlquiler DECIMAL(10, 2),
    galonesGasolina DECIMAL(5, 2),
    PRIMARY KEY (idReserva, matricula),
    FOREIGN KEY (idReserva) REFERENCES Reserva(idReserva),
    FOREIGN KEY (matricula) REFERENCES Automovil(matricula)
);
