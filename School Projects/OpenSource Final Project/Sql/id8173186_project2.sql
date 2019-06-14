-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 09, 2018 at 01:17 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id8173186_project2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Password` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Password`, `username`) VALUES
('qwer', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `Group_ID` int(11) NOT NULL,
  `GroupName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`Group_ID`, `GroupName`) VALUES
(1, 'Group 1'),
(2, 'Group 2'),
(3, 'Group 3');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `FirstName`, `LastName`, `Address`, `Email`) VALUES
(36980, 'Hellen', 'Nova', 'Toronto', 'HellenNova@mnp.com'),
(640331, 'Sara', 'Jackson', 'Toronto', 'SaraJK@mnp.com'),
(707139, 'Mark', 'Van', 'Toronto', 'MarkVan@xyz.com'),
(750725, 'John', 'Smith', 'Toronto', 'JohnSmith@abc.com'),
(864112, 'Allen', 'Robson', 'Toronto', 'AllenR@abc.com'),
(877163, 'John', 'Olloviera', 'Toronto', 'JohnOL@abc.com'),
(913138, 'Mary', 'Silva', 'Toronto', 'Mary@xyz.com'),
(923068, 'Alp', 'Ozel', 'Toronto', 'alp@tdsb.ca'),
(959238, 'Sara', 'Parker', 'Toronto', 'SaraP@mnp.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_group`
--

CREATE TABLE `user_group` (
  `User_ID` int(11) NOT NULL,
  `Group_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_group`
--

INSERT INTO `user_group` (`User_ID`, `Group_ID`) VALUES
(750725, 1),
(913138, 1),
(864112, 1),
(959238, 2),
(640331, 2),
(707139, 2),
(36980, 3),
(877163, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`Group_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_ID`);

--
-- Indexes for table `user_group`
--
ALTER TABLE `user_group`
  ADD KEY `user_groups_ibfk_1` (`User_ID`),
  ADD KEY `user_groups_ibfk_2` (`Group_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_group_ibfk_2` FOREIGN KEY (`Group_ID`) REFERENCES `groups` (`Group_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
