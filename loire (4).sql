-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2019 a las 10:53:28
-- Versión del servidor: 8.0.16
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `loire`
--
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombres`, `apellidos`, `estado`) VALUES
(1, 'Elivar Oswaldo', 'Largo Rios', '1'),
(5, 'Juan', 'Vargas', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `persona_idpersona` int(11) NOT NULL,
  `razonsocial` varchar(45) NOT NULL,
  `nit` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `tiposervicio` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `mensaje` varchar(300) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `estado1` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `persona_idpersona`, `razonsocial`, `nit`, `direccion`, `telefono`, `tiposervicio`, `fecha`, `mensaje`, `estado`, `estado1`) VALUES
(1, 1, 'SENA', '800957854', 'Cra65 13-04', '7448585', 'recoleccion', '14/07/2019', 'Recoger dos veces a ala semana', 'validando', 1),
(2, 2, 'ELINTE', '800456854', 'Cll 18 33-01', '2374126', 'recoleccion', '20/08/2019', 'llamar  a la administradora antes de recoger los residuos', 'en proceso', 1),
(3, 3, 'LITO', '900123854', 'Cll 12 36-81', '4057373', 'recoleccion', '15/07/2019', 'llamar  a la administradora antes de recoger los residuos', 'completado', 1),
(4, 4, 'ECOLCIN', '900123456', 'Cra 43 11-27', '3689066', 'Dispocision', '16/08/2019', 'Se anexa informe con informacion de los residuos', 'en proceso', 1),
(5, 5, 'Planeta Verde', '987456123', 'Cra 65 4-59', '2606062', 'Disposicion de Residuos', '09/08/2019', 'Se anexa informe con descripcion de los residuos', 'en proceso', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clienteempresa`
--

CREATE TABLE `clienteempresa` (
  `idClienteEmpresa` int(6) NOT NULL,
  `razonSocial` varchar(45) NOT NULL,
  `telefonoFijo` int(7) NOT NULL,
  `celular` int(12) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `nit` bigint(12) NOT NULL,
  `idDepartamento` int(2) NOT NULL,
  `idCiudad` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

CREATE TABLE `conductor` (
  `idConductor` int(11) NOT NULL,
  `tipodocumento` varchar(50) NOT NULL,
  `documento` bigint(12) NOT NULL,
  `primerApellido` varchar(25) NOT NULL,
  `segundoApellido` varchar(25) NOT NULL,
  `primerNombre` varchar(25) NOT NULL,
  `segundoNombre` varchar(25) NOT NULL,
  `estado1` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `conductor`
--

INSERT INTO `conductor` (`idConductor`, `tipodocumento`, `documento`, `primerApellido`, `segundoApellido`, `primerNombre`, `segundoNombre`, `estado1`) VALUES
(1, 'cedula de ciudadadania', 13245678, 'perez', 'cortes', 'paul', 'enrique', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costosadicionales`
--

CREATE TABLE `costosadicionales` (
  `idAdicionales` int(6) NOT NULL,
  `idFormulario` int(6) NOT NULL,
  `valorCombustible` float NOT NULL,
  `valorPeaje` float NOT NULL,
  `valorTiqBascula` float NOT NULL,
  `valorTotalViaticos` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se van a guardar los datos de los costos adicionales de cada recorrido.';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

CREATE TABLE `cotizacion` (
  `idCotizacion` int(6) NOT NULL,
  `idCliente` int(6) NOT NULL,
  `tipoServicio` varchar(50) CHARACTER SET latin1 NOT NULL,
  `fechaServicio` date NOT NULL,
  `valorUnitario` float NOT NULL,
  `subtotal` float NOT NULL,
  `iva` int(3) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='datos que se le enviaran al cliente como cotizacion al servicio solicitado ';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidad`
--

CREATE TABLE `disponibilidad` (
  `idValidarServicio` int(11) NOT NULL,
  `idServicioDisposicion` int(6) NOT NULL,
  `idSolicitudServicio` int(6) NOT NULL,
  `fechaDisponible` datetime NOT NULL,
  `tiposervicio` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(6) NOT NULL,
  `idCliente` int(11) NOT NULL DEFAULT '0',
  `valoruni` float NOT NULL,
  `iva` float NOT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='factura final despues de completar un servicio';

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idFactura`, `idCliente`, `valoruni`, `iva`, `costo`) VALUES
(1, 3, 454545, 16, 858585),
(2, 3, 454545, 16, 858585);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formulariorecoleccion`
--

CREATE TABLE `formulariorecoleccion` (
  `idFormularioRecoleccion` int(6) NOT NULL,
  `idConductor_conductor` int(6) NOT NULL,
  `tipovehiculo` varchar(15) NOT NULL,
  `idvehiculo` int(11) NOT NULL DEFAULT '0',
  `fechaRecorrido` datetime NOT NULL,
  `idbascula` int(11) NOT NULL,
  `idprecintoseguridad` int(11) NOT NULL,
  `CargaRegistrada` float NOT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `formulariorecoleccion`
--

INSERT INTO `formulariorecoleccion` (`idFormularioRecoleccion`, `idConductor_conductor`, `tipovehiculo`, `idvehiculo`, `fechaRecorrido`, `idbascula`, `idprecintoseguridad`, `CargaRegistrada`, `idcliente`) VALUES
(1, 1, 'jhgfhgdfxgh', 1, '2019-09-24 00:00:00', 8964, 6555, 9461630, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE `mantenimiento` (
  `idMantenimiento` int(6) NOT NULL,
  `fechaInicio` varchar(45) NOT NULL,
  `fechaFin` varchar(45) DEFAULT NULL,
  `daños` text,
  `repuestos` varchar(200) DEFAULT NULL,
  `idsolicitud` int(4) NOT NULL,
  `valorRepuestos` float DEFAULT NULL,
  `valorRevision` float DEFAULT NULL,
  `mecanico` varchar(45) DEFAULT NULL,
  `taller` varchar(45) DEFAULT NULL,
  `estado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `Dni` int(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(80) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombreUsuario` varchar(30) NOT NULL,
  `contrasenaUsuario` varchar(20) NOT NULL,
  `rol_idRol` varchar(20) NOT NULL,
  `tipodoc_idTipoDoc` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `Dni`, `nombres`, `apellidos`, `direccion`, `telefono`, `email`, `nombreUsuario`, `contrasenaUsuario`, `rol_idRol`, `tipodoc_idTipoDoc`) VALUES
(1, 0, 'Mauricio', 'Bermudez', 'cra 45 #30-01', '4567891', 'vjvalencia2000@gmail.com', 'mau38', '123', '1', '2'),
(2, 0, 'Carolina', 'Vargas', 'cra 26 #15-03', '5487961', 'sakuribito13@outlook.com', 'carol26', '123456', '1', '2'),
(3, 0, 'Eduardo', 'Herrera', 'CRA 30#25-08', '8594566', 'vjvalencia89@misena.edu.co', 'Eduar30', '789', '3', '2'),
(4, 0, 'Xiomara', 'Rodriguez', 'Cll 100#16-09', '4567894', 'YANIZANGULO10@gmail.com', 'Xiomara1', '456', '1', '1'),
(5, 0, 'marth', 'bermudez', 'cra 68 32-04', '7589898', 'krolyn886@gmail.com', 'mar45', '456789', '1', '1'),
(6, 123456, 'Mauricio', 'Bermudez', 'cra 45 #30-01', '4567891', 'vjvalencia2000@gmail.com', 'mau38', 'lol', '1', '2'),
(7, 897857, 'Carolina', 'Vargas', 'cra 26 #15-03', '5487961', 'sakuribito13@outlook.com', 'carol26', 'miaw', '1', '2'),
(8, 102557879, 'Eduardo', 'Herrera', 'CRA 30#25-08', '8594566', 'vjvalencia89@misena.edu.co', 'Eduar30', 'miaw', '3', '2'),
(9, 108795799, 'Xiomara', 'Rodriguez', 'Cll 100#16-09', '4567894', 'YANIZANGULO10@gmail.com', 'Xiomara1', 'miaw', '1', '1'),
(10, 97894564, 'marth', 'bermudez', 'cra 68 32-04', '7589898', 'krolyn886@gmail.com', 'mar45', 'miaw', '1', '1'),
(11, 123456, 'Mauricio', 'Bermudez', 'cra 45 #30-01', '4567891', 'vjvalencia2000@gmail.com', 'mau38', '123', '1', '2'),
(12, 897857, 'Carolina', 'Vargas', 'cra 26 #15-03', '5487961', 'sakuribito13@outlook.com', 'carol26', '123456', '1', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personax`
--

CREATE TABLE `personax` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `residuosinventario`
--

CREATE TABLE `residuosinventario` (
  `idResiduosInventario` int(6) NOT NULL,
  `idDestinatario` int(6) DEFAULT NULL,
  `idFormulario` int(6) DEFAULT NULL,
  `tipoResiduo` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `generador` varchar(50) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `residuosinventario`
--

INSERT INTO `residuosinventario` (`idResiduosInventario`, `idDestinatario`, `idFormulario`, `tipoResiduo`, `cantidad`, `generador`, `estado`, `fecha`) VALUES
(1, 0, 1, 'Tamiz', 52, 'miu system', 1, '2019-09-01'),
(2, 1, 1, 'residuo de frutas electronicas', 20, 'miu system', 1, '2019-08-19'),
(3, NULL, 1, 'residuo de neuronas', 60, 'miu system', 1, '2019-06-17'),
(4, NULL, 1, 'residuo de neuronas', 60, 'miu system', 1, '2019-06-10'),
(5, NULL, 1, 'tu basura', 55, 'tu', 1, '2019-05-27'),
(8, NULL, 1, 'tus basuras', 60, 'miu system', 1, '2019-09-10'),
(9, NULL, 1, 'miaw', 45, 'miaw', 1, '2019-08-20'),
(10, NULL, 1, 'nulo', 52, 'what?', 1, '2019-06-10'),
(11, NULL, 1, 'miaw', 888, 'miaw', 1, '2019-07-22'),
(12, NULL, 1, 'odi', 45, 'y mas odio', 1, '2019-05-13'),
(13, NULL, 1, 'lol', 999, 'lol', 1, '2019-05-21'),
(14, NULL, 1, 'segundo intento', 455, 'tiene que funcionar', 1, '2019-06-24'),
(17, NULL, 1, 'Planta', 52, 'miu system', 1, '2019-07-31'),
(18, NULL, 1, 'Planta', 52, 'miu system', 1, '2019-05-12'),
(19, NULL, 1, 'Ruminal', 45, 'miu system', 1, '2019-07-29'),
(20, NULL, 1, 'miaw', 45, 'miaw', 1, '2019-09-15'),
(57, NULL, 1, 'planta', 58, 'miu system', 0, '2019-10-31'),
(58, NULL, 1, 'miaw', 15, 'you', 1, '2019-10-10'),
(59, NULL, 1, 'planta', 58, 'miu system', 1, '2019-10-10'),
(60, NULL, 1, 'planta', 58, 'miu system', 1, '2019-10-10'),
(61, NULL, 1, 'planta', 58, 'miu system', 1, '2019-10-10'),
(62, NULL, 1, 'planta', 58, 'miu system', 1, '2019-10-10'),
(63, NULL, 1, 'planta', 58, 'miu system', 1, '2019-10-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `idRuta` int(11) NOT NULL,
  `id_Validacion_Servicios` int(11) NOT NULL,
  `fechaRuta` datetime NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `idVehiculo` int(6) NOT NULL,
  `idConductor` int(6) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`idRuta`, `id_Validacion_Servicios`, `fechaRuta`, `Direccion`, `idVehiculo`, `idConductor`, `estado`) VALUES
(1, 2, '2019-10-05 00:00:00', 'cra 80 m#73 d 26 sur', 1, 1, 1),
(2, 2, '2019-10-11 00:00:00', 'guadalajara', 1, 1, 1),
(3, 2, '2019-10-10 00:00:00', 'cra 80 m#73 d 26 sur', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serviciodisposicion`
--

CREATE TABLE `serviciodisposicion` (
  `idserviciosDiposicion` int(6) NOT NULL,
  `fechasolicitud` datetime NOT NULL,
  `fechaservicio` datetime NOT NULL,
  `DireccionDestinatario` varchar(45) NOT NULL,
  `pesoTransportado` float NOT NULL,
  `idCliente_clienteempresa` int(6) NOT NULL,
  `idValidacionServicio` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serviciorecoleccion`
--

CREATE TABLE `serviciorecoleccion` (
  `idServicio_recoleccion` int(11) NOT NULL,
  `fecha_recoleccion` date NOT NULL,
  `residuo-carga` float NOT NULL,
  `lugargeneracion` varchar(25) NOT NULL,
  `generacion` varchar(20) NOT NULL,
  `Estado_residuos` char(10) NOT NULL,
  `presentacion_residuos` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudmante`
--

CREATE TABLE `solicitudmante` (
  `idSolicitud` int(4) NOT NULL,
  `idconductor` int(4) NOT NULL,
  `idvehiculo` int(4) NOT NULL,
  `descripcion` varchar(700),
  `estado` int(1) NOT NULL,
  `estado1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitudmante`
--

INSERT INTO `solicitudmante` (`idSolicitud`, `idconductor`, `idvehiculo`, `descripcion`, `estado`, `estado1`) VALUES
(1, 1, 1, 'kmxlkmlks', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `idvehiculo` int(6) NOT NULL,
  `modelo` varchar(45),  `placa` varchar(45),
  `tipo` varchar(45),
  `idconductor` int(11) DEFAULT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`idvehiculo`, `modelo`, `placa`, `tipo`, `idconductor`, `estado`) VALUES
(1, 'nkjbhgcfv', 'jjj-456', 'kljbhgf', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `fk_cliente_persona_idx` (`persona_idpersona`);

--
-- Indices de la tabla `clienteempresa`
--
ALTER TABLE `clienteempresa`
  ADD PRIMARY KEY (`idClienteEmpresa`) USING BTREE,
  ADD KEY `idClienteEmpresa` (`idClienteEmpresa`),
  ADD KEY `idCiudad` (`idCiudad`);

--
-- Indices de la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD PRIMARY KEY (`idConductor`),
  ADD KEY `idConductor` (`idConductor`);

--
-- Indices de la tabla `costosadicionales`
--
ALTER TABLE `costosadicionales`
  ADD PRIMARY KEY (`idAdicionales`),
  ADD KEY `idFormulario` (`idFormulario`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`idCotizacion`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD PRIMARY KEY (`idValidarServicio`),
  ADD KEY `idValidarServicio` (`idValidarServicio`),
  ADD KEY `idServicioDisposicion` (`idServicioDisposicion`,`idSolicitudServicio`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `fkcliente` (`idCliente`);

--
-- Indices de la tabla `formulariorecoleccion`
--
ALTER TABLE `formulariorecoleccion`
  ADD PRIMARY KEY (`idFormularioRecoleccion`),
  ADD KEY `idFormularioRecoleccion_2` (`idConductor_conductor`) USING BTREE,
  ADD KEY `Index 3` (`idcliente`),
  ADD KEY `Index 4` (`idvehiculo`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`idMantenimiento`),
  ADD KEY `idsolicitd` (`idsolicitud`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `personax`
--
ALTER TABLE `personax`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `residuosinventario`
--
ALTER TABLE `residuosinventario`
  ADD PRIMARY KEY (`idResiduosInventario`),
  ADD KEY `idResiduos_Inventario` (`idResiduosInventario`),
  ADD KEY `idResiduos_Inventario_2` (`idResiduosInventario`),
  ADD KEY `id_residuos_destinatario` (`idDestinatario`,`idFormulario`),
  ADD KEY `FK_residuosinventario_formulariorecoleccion` (`idFormulario`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`idRuta`),
  ADD KEY `idRuta` (`idRuta`),
  ADD KEY `id_Validacion_Servicios` (`id_Validacion_Servicios`,`idVehiculo`,`idConductor`);

--
-- Indices de la tabla `serviciodisposicion`
--
ALTER TABLE `serviciodisposicion`
  ADD PRIMARY KEY (`idserviciosDiposicion`),
  ADD KEY `idserviciosDiposicion` (`idserviciosDiposicion`),
  ADD KEY `idCliente_clienteempresa` (`idCliente_clienteempresa`,`idValidacionServicio`);

--
-- Indices de la tabla `serviciorecoleccion`
--
ALTER TABLE `serviciorecoleccion`
  ADD PRIMARY KEY (`idServicio_recoleccion`),
  ADD KEY `idServicio_recoleccion` (`idServicio_recoleccion`);

--
-- Indices de la tabla `solicitudmante`
--
ALTER TABLE `solicitudmante`
  ADD PRIMARY KEY (`idSolicitud`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`idvehiculo`),
  ADD KEY `idconductor_idx` (`idconductor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `clienteempresa`
--
ALTER TABLE `clienteempresa`
  MODIFY `idClienteEmpresa` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `conductor`
--
ALTER TABLE `conductor`
  MODIFY `idConductor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `costosadicionales`
--
ALTER TABLE `costosadicionales`
  MODIFY `idAdicionales` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  MODIFY `idCotizacion` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  MODIFY `idValidarServicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idFactura` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `formulariorecoleccion`
--
ALTER TABLE `formulariorecoleccion`
  MODIFY `idFormularioRecoleccion` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  MODIFY `idMantenimiento` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `personax`
--
ALTER TABLE `personax`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `residuosinventario`
--
ALTER TABLE `residuosinventario`
  MODIFY `idResiduosInventario` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT de la tabla `ruta`
--
ALTER TABLE `ruta`
  MODIFY `idRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `serviciodisposicion`
--
ALTER TABLE `serviciodisposicion`
  MODIFY `idserviciosDiposicion` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `serviciorecoleccion`
--
ALTER TABLE `serviciorecoleccion`
  MODIFY `idServicio_recoleccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `solicitudmante`
--
ALTER TABLE `solicitudmante`
  MODIFY `idSolicitud` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `idvehiculo` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_persona` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`);

--
-- Filtros para la tabla `costosadicionales`
--
ALTER TABLE `costosadicionales`
  ADD CONSTRAINT `idFormulario` FOREIGN KEY (`idFormulario`) REFERENCES `formulariorecoleccion` (`idFormularioRecoleccion`);

--
-- Filtros para la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `clienteempresa` (`idClienteEmpresa`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `FKcliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`);

--
-- Filtros para la tabla `formulariorecoleccion`
--
ALTER TABLE `formulariorecoleccion`
  ADD CONSTRAINT `FK_formulariorecoleccion_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  ADD CONSTRAINT `FK_formulariorecoleccion_conductor` FOREIGN KEY (`idConductor_conductor`) REFERENCES `conductor` (`idConductor`),
  ADD CONSTRAINT `FK_formulariorecoleccion_vehiculo` FOREIGN KEY (`idvehiculo`) REFERENCES `vehiculo` (`idvehiculo`);

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `idsolicitud` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitudmante` (`idSolicitud`);

--
-- Filtros para la tabla `residuosinventario`
--
ALTER TABLE `residuosinventario`
  ADD CONSTRAINT `FK_residuosinventario_formulariorecoleccion` FOREIGN KEY (`idFormulario`) REFERENCES `formulariorecoleccion` (`idFormularioRecoleccion`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `idconductor` FOREIGN KEY (`idconductor`) REFERENCES `conductor` (`idConductor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
