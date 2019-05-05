-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 05, 2019 lúc 10:02 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlsb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `booking_date` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`id`, `user_id`, `booking_date`) VALUES
(30, 1, '2019-05-24'),
(29, 1, '2019-05-18');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking_detail`
--

CREATE TABLE `booking_detail` (
  `id` int(11) NOT NULL,
  `sf_duration_id` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `booking_id` int(11) NOT NULL,
  `sp_id` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `booking_detail`
--

INSERT INTO `booking_detail` (`id`, `sf_duration_id`, `booking_date`, `booking_id`, `sp_id`, `price`, `status`) VALUES
(15, 3, '2019-05-24', 30, 4, 150000, 0),
(14, 2, '2019-05-24', 30, 4, 150000, 0),
(13, 2, '2019-05-18', 29, 1, 150000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `extra_booking`
--

CREATE TABLE `extra_booking` (
  `id` int(11) NOT NULL,
  `detail_booking_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21),
(21),
(21),
(21);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sc_pitch`
--

CREATE TABLE `sc_pitch` (
  `id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sc_pitch`
--

INSERT INTO `sc_pitch` (`id`, `address`, `description`, `name`) VALUES
(1, 'hihiih', 'mo ta', 'sân 1'),
(5, 'dia chi 1', 'mo ta', 'sang bong 4'),
(6, 'hung ha', 'khong co gi', 'san bong 1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sf_duration`
--

CREATE TABLE `sf_duration` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sf_duration`
--

INSERT INTO `sf_duration` (`id`, `name`, `price`, `description`) VALUES
(1, '8h-11h', 100000, '8h-11h'),
(2, '13h-15h', 150000, '13h-15h chieu y'),
(3, '15h-17h', 150000, '15h-17h chieu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `t_comment`
--

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `content` varchar(300) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `t_post`
--

CREATE TABLE `t_post` (
  `id` bigint(20) NOT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `t_role`
--

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `t_role`
--

INSERT INTO `t_role` (`id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'GUEST');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `t_user`
--

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `t_user`
--

INSERT INTO `t_user` (`id`, `active`, `avatar_url`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `role_id`) VALUES
(20, b'0', NULL, 'duy34@gmail.com', '42342', '242', '$2a$11$5Bh/ZswofbQFBjkPO6p7D.f85M7Jw8YboMcsajX8xo2.k.oUd88Di', '424242', 2),
(18, b'0', NULL, 'mem@gmail.com', 'hi', 'ha', '$2a$11$7oZ3Coih.cf/sqaetxYOX.YJu8q3UFtCrp2rv9PfJFKc5Ho2t3BwW', '42342', 2),
(17, b'1', NULL, '1@gmail.com', 'hoang', 'duy', '$2a$11$BretkfsjfD7FmdyzqNTwLOSmkyBZVQXCF1emVnCaNaGGTaDQTY.HC', '4084824234', 2),
(12, b'1', '56', 'duysexy@gmail.com', 'hoàng', 'duy98', '98', '0868130798', 1),
(19, b'1', NULL, 'edj@gmail.com', 'hlfhlds', '4342j', '$2a$11$pAqttgDNQWsX2ZB9wDyGLOlFSTl1pcN71YSulO8UAgX.cJ7uFPds.', '4324324', 2),
(16, b'1', NULL, 'a@gmail.com', 'hoang', 'duy', '$2a$11$lsIl3qZwVUXHA3L32jFwpuPKjBk7134UN.47pgqv5jcUNpd.JPEsG', '03850', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userid` (`user_id`);

--
-- Chỉ mục cho bảng `booking_detail`
--
ALTER TABLE `booking_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK59941ondg9nwaifm2umnrduev` (`booking_id`),
  ADD KEY `FKe726d13bqvuynlr4a2gi8pdh7` (`sp_id`);

--
-- Chỉ mục cho bảng `extra_booking`
--
ALTER TABLE `extra_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKal5lb6qrkp9mvsjjyxcel019r` (`detail_booking_id`);

--
-- Chỉ mục cho bảng `sc_pitch`
--
ALTER TABLE `sc_pitch`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sf_duration`
--
ALTER TABLE `sf_duration`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `t_comment`
--
ALTER TABLE `t_comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtamaoacctq4qpko6bvtv0ke1p` (`user_id`),
  ADD KEY `FKsa3hl9a6mu30dct1jnn2bwvem` (`post_id`);

--
-- Chỉ mục cho bảng `t_post`
--
ALTER TABLE `t_post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK18f01t655nkcuptq9oxp04sgn` (`user_id`);

--
-- Chỉ mục cho bảng `t_role`
--
ALTER TABLE `t_role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`),
  ADD KEY `FK76cs7cu4h4y8vc1vd4qyw36rt` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `booking_detail`
--
ALTER TABLE `booking_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `extra_booking`
--
ALTER TABLE `extra_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sc_pitch`
--
ALTER TABLE `sc_pitch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `sf_duration`
--
ALTER TABLE `sf_duration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
