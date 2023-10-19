-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2023 a las 20:28:39
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecagrupo5`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `codigo` int(11) NOT NULL,
  `idLibro` int(13) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `condicion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`codigo`, `idLibro`, `cantidad`, `estado`, `condicion`) VALUES
(6, 3, 5, 0, 'DISPONIBLE'),
(35, 3, 6, 1, 'DISPONIBLE'),
(36, 3, 0, 1, 'PRESTADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `nroSocio` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `dni` int(13) NOT NULL,
  `domicilio` varchar(120) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`nroSocio`, `nombre`, `apellido`, `dni`, `domicilio`, `mail`, `estado`) VALUES
(1, 'Alberto Francisco', 'Alum', 33973606, 'Av. San Ramon 446', 'alberto75@gmail.com', 1),
(2, 'Juan Gustavo', 'Lopez', 30123123, 'Salta 123', 'jgl2005@outlook.com', 1),
(3, 'Susana', 'Saavedra', 30444111, 'Perú 2025', 'ss154@live.com.ar', 1),
(4, 'Luis', 'Lopez', 20254232, 'La Plata 223', 'luis899@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `isbn` bigint(13) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `autor` varchar(80) NOT NULL,
  `anio` int(11) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `editorial` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `isbn`, `titulo`, `autor`, `anio`, `tipo`, `editorial`, `estado`) VALUES
(1, 9788497938464, 'Memoria de mis putas tristes', 'Gabriel Garcia Marquez', 2004, 'LITERATURA', 'De Bolsillo', 1),
(2, 9788497592352, 'El Coronel no tiene quien le Escriba', 'Gabriel Garcia Marquez', 1985, 'LITERATURA', 'De Bolsillo', 1),
(3, 9788497592208, 'Cien Años de Soledad', 'Gabriel Garcia Marquez', 1967, 'NOVELA', 'De Bolsillo', 1),
(4, 123, 'El Principito', ' Antoine de Saint-Exupéry', 1951, 'NOVELA', 'Emecé', 1),
(5, 9788408096146, 'El Codigo Da Vinci', 'Dan Brown', 2003, 'LITERATURA', 'Planeta', 1),
(6, 9788408127413, 'Inferno', 'Dan Brown', 2013, 'LITERATURA', 'Planeta', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `codigo` int(11) NOT NULL,
  `nroSocio` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `ejemplar_ibfk_1` (`idLibro`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`nroSocio`),
  ADD UNIQUE KEY `mail` (`mail`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD UNIQUE KEY `ISBN` (`isbn`),
  ADD UNIQUE KEY `isbn_2` (`isbn`),
  ADD UNIQUE KEY `titulo` (`titulo`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `codigo` (`codigo`),
  ADD KEY `nroSocio` (`nroSocio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `nroSocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `ejemplar` (`codigo`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`nroSocio`) REFERENCES `lector` (`nroSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
