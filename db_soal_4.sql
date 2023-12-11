-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 11, 2023 at 06:57 AM
-- Server version: 5.7.39
-- PHP Version: 8.1.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `alamat` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama`, `alamat`) VALUES
(1, 'Russell Christiansen', '9071 Lowe Pass Apt. 646'),
(2, 'Malika Hegmann Jr.', '63719 Kristoffer Brook'),
(3, 'Dr. Justice Roberts', '9126 Kameron Crossing Suite 591'),
(4, 'Juana Stehr', '0307 Veum Walks Suite 962'),
(5, 'Felicity Lowe', '65377 Curtis Gardens Apt. 502'),
(6, 'Izaiah Nikolaus', '9655 Abshire Club'),
(7, 'Mr. Maxime Crist', '529 Hartmann Station Apt. 326'),
(8, 'Dr. Juliet Balistreri MD', '964 West Falls Apt. 023'),
(9, 'Dr. Ellis Mayer', '98014 Daryl Viaduct Suite 640'),
(10, 'Zella Lehner', '95089 Emerson Neck Apt. 925'),
(11, 'Prof. Chet Lakin I', '70023 Arlie Ford'),
(12, 'Valentina Kozey', '32005 Friesen Stravenue Apt. 326'),
(13, 'Ms. Anne Parker V', '786 Dare Inlet Apt. 854'),
(14, 'Dr. Noah Nader IV', '73162 Mireille River'),
(15, 'Theron Homenick', '49662 Schuppe Villages Apt. 713'),
(16, 'Prof. Maude Bogisich Sr.', '449 Herzog Fall Apt. 942'),
(17, 'Eriberto Volkman', '29617 McCullough Camp'),
(18, 'Terence Prohaska', '60479 Senger Crossroad Apt. 333'),
(19, 'Diana Witting II', '615 Ali Shoals'),
(20, 'Donnie Lowe Sr.', '673 Amiya Springs Suite 025'),
(21, 'Cooper Mante', '0255 Larson Park'),
(22, 'Prof. Modesto Howe DVM', '040 Jazmyn Isle'),
(23, 'Cortney Shields', '914 Abbott Pike Suite 413'),
(24, 'Xander Hintz', '0583 Leffler Causeway Suite 358'),
(25, 'Olga Boyer', '471 Gideon Trafficway Apt. 811'),
(26, 'Warren Brown', '0872 Hettinger Prairie'),
(27, 'Rusty Hettinger', '098 Wuckert Terrace Apt. 040'),
(28, 'Prof. Darrell Witting', '94520 Heaney View Suite 635'),
(29, 'Mrs. Vicenta Gibson', '4951 Dejuan Manors'),
(30, 'Dr. Nikolas Predovic', '7524 Russel Roads');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
