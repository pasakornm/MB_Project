-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 08, 2020 at 03:25 PM
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
-- Database: `hotel_mb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Cus_ID` int(11) NOT NULL,
  `Cus_username` varchar(50) NOT NULL,
  `Cus_password` varchar(50) NOT NULL,
  `Cus_address` varchar(255) NOT NULL,
  `Cus_Tel` varchar(255) NOT NULL,
  `Cus_email` varchar(255) NOT NULL,
  `Cus_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_ID`, `Cus_username`, `Cus_password`, `Cus_address`, `Cus_Tel`, `Cus_email`, `Cus_type`) VALUES
(1, 'arm', '123456', '12-123', '0969935525', 'peeranut@kkumail.com', 0),
(10, 'fah', '123456', '123456/123', '0860333982', 'saasdasd', 1),
(11, 'aum', '', '', '', '', 0),
(12, 'bale2222', '123456789', '210 ', '0883251221', 'pasakorn@hotmail.com', 0),
(13, 'wut', 'wut', '144', '043', 'wut', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `Hotel_ID` int(11) NOT NULL,
  `Hotel_Name` varchar(250) NOT NULL,
  `Hotel_Address` varchar(250) NOT NULL,
  `Hotel_Tel` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Pay_ID` int(11) NOT NULL,
  `Reserve_ID` int(20) NOT NULL,
  `Total_Price` int(20) NOT NULL,
  `Payment_Date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Pay_ID`, `Reserve_ID`, `Total_Price`, `Payment_Date`) VALUES
(1, 11111, 2500, '2020-11-06 22:22:10'),
(2, 11112, 5000, '2020-11-09 22:23:47');

-- --------------------------------------------------------

--
-- Table structure for table `reserve`
--

CREATE TABLE `reserve` (
  `Reserve_ID` int(11) NOT NULL,
  `Cus_ID` int(11) NOT NULL,
  `Reserve_Date` datetime NOT NULL DEFAULT current_timestamp(),
  `Check_In_Date` varchar(255) NOT NULL,
  `Check_Out_Date` varchar(255) NOT NULL,
  `Total_Price` int(20) NOT NULL,
  `Room_Type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reserve`
--

INSERT INTO `reserve` (`Reserve_ID`, `Cus_ID`, `Reserve_Date`, `Check_In_Date`, `Check_Out_Date`, `Total_Price`, `Room_Type`) VALUES
(11124, 1, '2020-11-08 20:58:40', '08/11/2020', '10/11/2020', 5000, 1),
(11125, 1, '2020-11-08 20:59:00', '08/11/2020', '11/11/2020', 13500, 2),
(11126, 13, '2020-11-08 21:16:39', '08/11/2020', '09/11/2020', 2500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `Room_ID` int(11) NOT NULL,
  `Roomtype_ID` int(20) NOT NULL,
  `PricePerRoom` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Room_ID`, `Roomtype_ID`, `PricePerRoom`) VALUES
(1, 1, 2500),
(2, 2, 4500);

-- --------------------------------------------------------

--
-- Table structure for table `roomtype`
--

CREATE TABLE `roomtype` (
  `Roomtype_ID` int(11) NOT NULL,
  `Room_Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roomtype`
--

INSERT INTO `roomtype` (`Roomtype_ID`, `Room_Description`) VALUES
(1, 'ห้องพักหรูเตียงเดี่ยวรายวัน สี่แยกท่าพระ ใกล้ MRT สายสีน้ำเงินท่าพระ interchange เพียง 150 เมตร BTS วงเวียนใหญ่ ราคาเริ่มต้นเพียง 2500 บาท\r\n'),
(2, 'ห้องพักหรูสองเตียงนอน เป็นห้องพักรายวัน สี่แยกท่าพระ ใกล้ MRT สายสีน้ำเงินท่าพระ interchange เพียง 150 เมตร BTS วงเวียนใหญ่ , สถานีตลาดพลู , สถานีบางหว้า - ม.สยามเพียง 5 นาที / เทคโนโลยีสยาม เพียง 3 นาทีเท่านั้น ราคาเริ่มต้นเพียง 4500 บาท');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Cus_ID`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`Hotel_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Pay_ID`);

--
-- Indexes for table `reserve`
--
ALTER TABLE `reserve`
  ADD PRIMARY KEY (`Reserve_ID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Room_ID`);

--
-- Indexes for table `roomtype`
--
ALTER TABLE `roomtype`
  ADD PRIMARY KEY (`Roomtype_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Cus_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `Hotel_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Pay_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reserve`
--
ALTER TABLE `reserve`
  MODIFY `Reserve_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11127;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `Room_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `roomtype`
--
ALTER TABLE `roomtype`
  MODIFY `Roomtype_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
