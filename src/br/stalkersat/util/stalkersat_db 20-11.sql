-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Nov-2016 às 22:32
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stalkersat_db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bem`
--

CREATE TABLE `bem` (
  `idBem` int(11) NOT NULL,
  `idUsuarioFk` int(11) DEFAULT NULL,
  `chassi` varchar(45) DEFAULT NULL,
  `placa` varchar(45) DEFAULT NULL,
  `idTipoBemFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `bem`
--

INSERT INTO `bem` (`idBem`, `idUsuarioFk`, `chassi`, `placa`, `idTipoBemFk`) VALUES
(1, 1, 'chassi', 'placa', 1),
(2, 1, 'chassi', 'placa', 2),
(3, 1, 'chassi', 'placa', 2),
(4, 2, 'aihsahs', 'okk1122', 2),
(5, 7, 'pgk123kkou4h5', 'kgi7499', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `idContato` int(11) NOT NULL,
  `idUsuarioFk` int(11) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `idTipoContatoFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`idContato`, `idUsuarioFk`, `telefone`, `idTipoContatoFk`) VALUES
(4, 1, '81 99468642', 2),
(6, 2, '81 32245585', 1),
(8, 1, '81 34273460', 1),
(9, 7, '81-999787504', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `numero` varchar(30) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `numero`, `complemento`, `rua`, `cep`) VALUES
(3, '552', 'Apartamento 1002', 'Av Costa Azevedo', '53200514'),
(5, '23', '', 'Av.  presidente kennedy', '12.223-223'),
(10, '2001', 'apartamento 1003', 'Rua 48', '55.230-11');

-- --------------------------------------------------------

--
-- Estrutura da tabela `localizacao`
--

CREATE TABLE `localizacao` (
  `idLocalizacao` int(11) NOT NULL,
  `Latitude` varchar(45) DEFAULT NULL,
  `Longitude` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `localizacao`
--

INSERT INTO `localizacao` (`idLocalizacao`, `Latitude`, `Longitude`) VALUES
(1, '-10.221492', '-9.072039'),
(2, '-6.027442', '-12.071099'),
(3, '-11.927242', '-42.291099'),
(4, '-8.063198', '-34.871217'),
(5, '-14.332412', '-34.871217'),
(6, '-4.130412', '-14.871237'),
(7, '-8.000412', '-22.173339'),
(8, '-87.2211412', '-2.172339'),
(9, '-7.2211412', '-21.172339'),
(10, '-17.2201492', '-9.072039');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_do_bem`
--

CREATE TABLE `tipo_do_bem` (
  `idTipoBem` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipo_do_bem`
--

INSERT INTO `tipo_do_bem` (`idTipoBem`, `tipo`) VALUES
(1, 'Carro'),
(2, 'Moto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_do_contato`
--

CREATE TABLE `tipo_do_contato` (
  `idTipoContato` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipo_do_contato`
--

INSERT INTO `tipo_do_contato` (`idTipoContato`, `tipo`) VALUES
(1, 'Fixo'),
(2, 'Celular');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_do_usuario`
--

CREATE TABLE `tipo_do_usuario` (
  `idTipoUsuario` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipo_do_usuario`
--

INSERT INTO `tipo_do_usuario` (`idTipoUsuario`, `tipo`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `idEnderecoFk` int(11) NOT NULL,
  `cpf` varchar(30) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `idTipoUsuarioFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `idEnderecoFk`, `cpf`, `nome`, `login`, `senha`, `idTipoUsuarioFk`) VALUES
(1, 1, '071.149.914-44', 'Adson Barbosa de Souza', 'absouza', 'abs1410', 1),
(2, 3, '00000000000', 'tarcisio', 'login', 'senha', 1),
(7, 10, '123.234.567-89', 'José Edson', 'jegsouza', 'jegs2399', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bem`
--
ALTER TABLE `bem`
  ADD PRIMARY KEY (`idBem`),
  ADD KEY `fk_Bem_Tipo_do_bem` (`idTipoBemFk`),
  ADD KEY `fk_Bem_Usuario` (`idUsuarioFk`);

--
-- Indexes for table `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`idContato`),
  ADD KEY `fk_contato_Usuario` (`idUsuarioFk`),
  ADD KEY `fk_Contato_Tipo_do_Contato` (`idTipoContatoFk`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Indexes for table `localizacao`
--
ALTER TABLE `localizacao`
  ADD PRIMARY KEY (`idLocalizacao`);

--
-- Indexes for table `tipo_do_bem`
--
ALTER TABLE `tipo_do_bem`
  ADD PRIMARY KEY (`idTipoBem`);

--
-- Indexes for table `tipo_do_contato`
--
ALTER TABLE `tipo_do_contato`
  ADD PRIMARY KEY (`idTipoContato`);

--
-- Indexes for table `tipo_do_usuario`
--
ALTER TABLE `tipo_do_usuario`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `fk_Usuario_Tipo_do_Usuario` (`idTipoUsuarioFk`),
  ADD KEY `fk_Usuario_Endereco` (`idEnderecoFk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bem`
--
ALTER TABLE `bem`
  MODIFY `idBem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `contato`
--
ALTER TABLE `contato`
  MODIFY `idContato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `localizacao`
--
ALTER TABLE `localizacao`
  MODIFY `idLocalizacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tipo_do_bem`
--
ALTER TABLE `tipo_do_bem`
  MODIFY `idTipoBem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tipo_do_contato`
--
ALTER TABLE `tipo_do_contato`
  MODIFY `idTipoContato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tipo_do_usuario`
--
ALTER TABLE `tipo_do_usuario`
  MODIFY `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
