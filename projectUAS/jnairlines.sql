-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2020 at 11:10 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jnairlines`
--

-- --------------------------------------------------------

--
-- Table structure for table `datadiri`
--

CREATE TABLE `datadiri` (
  `nama` char(30) NOT NULL,
  `noID` char(30) NOT NULL,
  `noTelp` int(13) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datadiri`
--

INSERT INTO `datadiri` (`nama`, `noID`, `noTelp`, `email`) VALUES
('asjdioj', '12415', 519027, 'ansdlka'),
('Johan Tjung', '317301345156', 85912512, 'johantj@gmail.com'),
('oaisjdioaj', '4121', 142142, 'qjdoqi'),
('qeqwe', '4121123', 12412, 'qwqds'),
('jasodjao', '5114', 1512, 'kjna');

-- --------------------------------------------------------

--
-- Table structure for table `datapesantiket`
--

CREATE TABLE `datapesantiket` (
  `id_tiket` int(11) NOT NULL,
  `jenis` char(25) NOT NULL,
  `destinasi` char(30) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `pelayanan` char(30) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datapesantiket`
--

INSERT INTO `datapesantiket` (`id_tiket`, `jenis`, `destinasi`, `jumlah`, `pelayanan`, `harga`) VALUES
(14, 'Bisnis', 'Surabaya - Bali', 2, 'Bagasi', 800000),
(15, 'First', 'Medan - Jakarta', 2, 'Bagasi', 1000000),
(16, 'First', 'Medan - Jakarta', 2, 'Antar - Jemput', 4000000),
(17, 'First', 'Surabaya - Bali', 2, 'Bagasi', 4200000),
(18, 'Bisnis', 'Surabaya - Bali', 2, 'Porter', 3200000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datadiri`
--
ALTER TABLE `datadiri`
  ADD PRIMARY KEY (`noID`);

--
-- Indexes for table `datapesantiket`
--
ALTER TABLE `datapesantiket`
  ADD PRIMARY KEY (`id_tiket`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datapesantiket`
--
ALTER TABLE `datapesantiket`
  MODIFY `id_tiket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
