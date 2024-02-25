-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2024 at 05:46 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `confirmPassword` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `verificationCode` varchar(20) DEFAULT NULL,
  `otp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `password`, `confirmPassword`, `email`, `verificationCode`, `otp`) VALUES
('turjo', '1234', '123456', 'tdas41380@gmail.com', '5825', '4565'),
('t123', '1234', '1234', 'tdas41380@gmail.com', '7155', '4710'),
('Turjo', '1234', '123456', 'tdas41380@gmail.com', '3568', '6084');

-- --------------------------------------------------------

--
-- Table structure for table `bookhotel`
--

CREATE TABLE `bookhotel` (
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `persons` varchar(10) DEFAULT NULL,
  `days` varchar(10) DEFAULT NULL,
  `ac` varchar(10) DEFAULT NULL,
  `food` varchar(10) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookhotel`
--

INSERT INTO `bookhotel` (`username`, `name`, `persons`, `days`, `ac`, `food`, `id`, `number`, `price`) VALUES
('Turjo', 'Hotel Vista Bay', '8', '8', 'AC', 'Yes', '222551451', '123456', '243200TK/-');

-- --------------------------------------------------------

--
-- Table structure for table `bookpackage`
--

CREATE TABLE `bookpackage` (
  `username` varchar(20) DEFAULT NULL,
  `package` varchar(30) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookpackage`
--

INSERT INTO `bookpackage` (`username`, `package`, `persons`, `id`, `number`, `price`) VALUES
('Turjo', 'Bronze Package', '2', '222551451', '123456', '16000TK/-');

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`name`, `email`, `comment`) VALUES
('dsfdsfds', 'fddsfds', 'fdsfdsfds');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `username` varchar(20) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`username`, `id`, `number`, `name`, `gender`, `country`, `address`, `email`) VALUES
('Turjo', '222551451', '123456', 'TurjoDas Dip', 'Male', 'India', 'Mumbai', 'tdas41380@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `hno` varchar(50) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `costperperson` varchar(30) DEFAULT NULL,
  `acroom` varchar(10) DEFAULT NULL,
  `foodincluded` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`hno`, `name`, `costperperson`, `acroom`, `foodincluded`) VALUES
('1', 'Hotel Vista Bay', '1800', '1200', '1000'),
('2', 'Hotel Bay Marina', '2200', '1200', '800'),
('3', 'White Orchid', '2900', '1500', '1200'),
('4', 'Hotel Sea Queen', '1600', '700', '500'),
('5', 'Auster Echo', '3000', '1500', '800'),
('6', 'Sea View Apartment', '7000', '2000', '1500');

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

CREATE TABLE `packages` (
  `pno` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `cost` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`pno`, `name`, `cost`) VALUES
('1', 'Student Package', '5600'),
('2', 'Bronze Package', '8000'),
('3', 'Silver Package', '12000'),
('4', 'Gold Package', '15000'),
('5', 'Platinum Package', '18000');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `rating` int(20) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`rating`, `comments`) VALUES
(3, 'fdsfsdfd');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
