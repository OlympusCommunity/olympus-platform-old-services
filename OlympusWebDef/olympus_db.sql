-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-07-2019 a las 02:21:45
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `olympus_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos_red`
--

CREATE TABLE `grupos_red` (
  `id_grupo` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL,
  `costo` decimal(10,2) NOT NULL,
  `foto` text NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grupos_red`
--

INSERT INTO `grupos_red` (`id_grupo`, `nombre`, `descripcion`, `costo`, `foto`, `time`, `id`) VALUES
(1, 'ＳＵＲＶＩＶＡＬ♨', 'El grupo integral Off-Topic del Olympus llamado Survival, es un grupo creado con el objetivo de generar conversación, amistad y fortalecer lazos a distancia con una amplia variedad social e intercambio cultural.', '0.00', 'survival.jpg', '2019-05-15 05:35:01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos_tema`
--

CREATE TABLE `grupos_tema` (
  `id_tema` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `charts` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos_tema_red`
--

CREATE TABLE `grupos_tema_red` (
  `id_tema_re` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  `id_tema` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma_social`
--

CREATE TABLE `plataforma_social` (
  `id_plat` int(11) NOT NULL,
  `plataforma` varchar(100) NOT NULL,
  `button` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plataforma_social`
--

INSERT INTO `plataforma_social` (`id_plat`, `plataforma`, `button`, `image`) VALUES
(1, 'GRUPO DE WHATSAPP', 'btn btn-outline-success', 'fab fa-whatsapp'),
(2, 'PÁGINA DE FACEBOOK', 'btn btn-outline-primary', 'fab fa-facebook-f'),
(3, 'GRUPO DE TELEGRAM', 'btn btn-outline-info', 'fab fa-telegram'),
(4, 'TWITTER', 'btn btn-info', 'fab fa-twitter'),
(5, 'INSTAGRAM', 'btn btn-outline-danger', 'fab fa-instagram'),
(6, 'DISCORD', 'btn btn-outline-dark', 'fab fa-discord'),
(7, 'GRUPO DE LINE', 'btn btn-success', 'fab fa-line');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `red_social`
--

CREATE TABLE `red_social` (
  `id_red` int(11) NOT NULL,
  `link` longtext NOT NULL,
  `id_grupo` int(11) NOT NULL,
  `id_plat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `red_social`
--

INSERT INTO `red_social` (`id_red`, `link`, `id_grupo`, `id_plat`) VALUES
(1, 'https://chat.whatsapp.com/CIioeBSlDWD2OKvtc500l5', 1, 1),
(2, 'https://www.facebook.com/S-U-R-V-I-V-A-L-inc-611925105935121/', 1, 2),
(3, 'https://www.instagram.com/survivalincorporated/', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `clave` text NOT NULL,
  `nombre` text NOT NULL,
  `correo` text NOT NULL,
  `foto` text NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `clave`, `nombre`, `correo`, `foto`, `time`) VALUES
(1, '5d1f6a887aab00194233482622f51e1858fadbce', 'Kevin Guti&eacute;rrez', 'julius.sauco@gmail.com', 'https://lh3.googleusercontent.com/-7nNBy6FdPv8/AAAAAAAAAAI/AAAAAAAAADY/kYrth-zV_Nk/photo.jpg', '2019-05-15 05:29:32'),
(2, '5d0dc843fbb93cc38a70abd5698e771c53a55ba4', 'Benjamin Jhonshon', 'lag.jhonshon@gmail.com', 'https://lh6.googleusercontent.com/-rbJ7uNm-Wss/AAAAAAAAAAI/AAAAAAAAABk/mNUg91gJwiA/photo.jpg', '2019-06-30 16:09:06');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `grupos_red`
--
ALTER TABLE `grupos_red`
  ADD PRIMARY KEY (`id_grupo`);

--
-- Indices de la tabla `grupos_tema`
--
ALTER TABLE `grupos_tema`
  ADD PRIMARY KEY (`id_tema`);

--
-- Indices de la tabla `grupos_tema_red`
--
ALTER TABLE `grupos_tema_red`
  ADD PRIMARY KEY (`id_tema_re`);

--
-- Indices de la tabla `plataforma_social`
--
ALTER TABLE `plataforma_social`
  ADD PRIMARY KEY (`id_plat`);

--
-- Indices de la tabla `red_social`
--
ALTER TABLE `red_social`
  ADD PRIMARY KEY (`id_red`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `grupos_red`
--
ALTER TABLE `grupos_red`
  MODIFY `id_grupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `grupos_tema`
--
ALTER TABLE `grupos_tema`
  MODIFY `id_tema` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `grupos_tema_red`
--
ALTER TABLE `grupos_tema_red`
  MODIFY `id_tema_re` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plataforma_social`
--
ALTER TABLE `plataforma_social`
  MODIFY `id_plat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `red_social`
--
ALTER TABLE `red_social`
  MODIFY `id_red` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
