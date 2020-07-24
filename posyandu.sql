-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Jul 2020 pada 03.31
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyandu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anak`
--

CREATE TABLE `anak` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(25) NOT NULL,
  `tgl` varchar(25) NOT NULL,
  `usia` varchar(5) NOT NULL,
  `ayah` varchar(25) NOT NULL,
  `ibu` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anak`
--

INSERT INTO `anak` (`id`, `nama`, `jk`, `tgl`, `usia`, `ayah`, `ibu`, `alamat`, `telepon`) VALUES
(1, 'a', 'Laki-Laki', '1998-08-13', '2', 'Rahmad abe', 'a', 's', '3');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ibuhamil`
--

CREATE TABLE `ibuhamil` (
  `id` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tgl` varchar(25) NOT NULL,
  `usia` varchar(5) NOT NULL,
  `nama_suami` varchar(25) NOT NULL,
  `telepon` varchar(25) NOT NULL,
  `alamat` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `imunisasianak`
--

CREATE TABLE `imunisasianak` (
  `id` int(11) NOT NULL,
  `no_imunisasi` varchar(25) NOT NULL,
  `id_anak` int(25) NOT NULL,
  `jenis_vitamin` varchar(25) NOT NULL,
  `id_imunisasi` varchar(5) NOT NULL,
  `jenis_imunisasi` varchar(25) NOT NULL,
  `ket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `lansia`
--

CREATE TABLE `lansia` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` varchar(25) NOT NULL,
  `tanggal` varchar(25) NOT NULL,
  `usia` varchar(5) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `telepon` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelayananibuhamil`
--

CREATE TABLE `pelayananibuhamil` (
  `id` int(11) NOT NULL,
  `no_layanan` varchar(25) NOT NULL,
  `id_ibuhamil` int(11) NOT NULL,
  `berat` varchar(5) NOT NULL,
  `usia_hamil` varchar(5) NOT NULL,
  `tensi` varchar(25) NOT NULL,
  `keterangan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelayananlansia`
--

CREATE TABLE `pelayananlansia` (
  `id` int(11) NOT NULL,
  `no_layanan` varchar(25) NOT NULL,
  `id_lansia` int(11) NOT NULL,
  `berat` varchar(25) NOT NULL,
  `tensi` varchar(5) NOT NULL,
  `ket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `timbanganak`
--

CREATE TABLE `timbanganak` (
  `id` int(11) NOT NULL,
  `no_timbang` varchar(25) NOT NULL,
  `id_anak` varchar(25) NOT NULL,
  `berat` varchar(25) NOT NULL,
  `tinggi` varchar(5) NOT NULL,
  `ket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anak`
--
ALTER TABLE `anak`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `ibuhamil`
--
ALTER TABLE `ibuhamil`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
