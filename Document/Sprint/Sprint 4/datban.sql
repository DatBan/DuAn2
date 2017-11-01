-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: datban
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenalbum` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idnhahang` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idalbum_UNIQUE` (`id`),
  KEY `idnhahang_idx` (`idnhahang`),
  CONSTRAINT `nhahangalbum` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anh`
--

DROP TABLE IF EXISTS `anh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenhinhanh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` bit(1) DEFAULT b'0',
  `idalbum` int(11) NOT NULL,
  `mota` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idanh_UNIQUE` (`id`),
  KEY `idalbum_idx` (`idalbum`),
  CONSTRAINT `idalbum` FOREIGN KEY (`idalbum`) REFERENCES `album` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anh`
--

LOCK TABLES `anh` WRITE;
/*!40000 ALTER TABLE `anh` DISABLE KEYS */;
/*!40000 ALTER TABLE `anh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baiviet`
--

DROP TABLE IF EXISTS `baiviet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baiviet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tieude` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noidung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `slug` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idloaibaiviet` int(11) NOT NULL,
  `idnguoiviet` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `ngaysua` datetime DEFAULT NULL,
  `mota` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tieude_UNIQUE` (`tieude`),
  KEY `idloaibaiviet_idx` (`idloaibaiviet`),
  KEY `idnguoidung_idx` (`idnguoiviet`),
  CONSTRAINT `idloaibaiviet` FOREIGN KEY (`idloaibaiviet`) REFERENCES `loaibaiviet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnguoidung` FOREIGN KEY (`idnguoiviet`) REFERENCES `nguoidung` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baiviet`
--

LOCK TABLES `baiviet` WRITE;
/*!40000 ALTER TABLE `baiviet` DISABLE KEYS */;
/*!40000 ALTER TABLE `baiviet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ban` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soban` int(11) NOT NULL,
  `songuoi` int(11) NOT NULL,
  `trangthai` bit(1) NOT NULL DEFAULT b'0',
  `idnhahang` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idban_UNIQUE` (`id`),
  KEY `idbannhahang_idx` (`idnhahang`),
  CONSTRAINT `idbannhahang` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitiethoadon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idhoadon` int(11) NOT NULL,
  `idmonan` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idmonancthd_idx` (`idmonan`),
  KEY `idhoadoncthd_idx` (`idhoadon`),
  CONSTRAINT `idhoadoncthd` FOREIGN KEY (`idhoadon`) REFERENCES `hoadon` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idmonancthd` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiettienich`
--

DROP TABLE IF EXISTS `chitiettienich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitiettienich` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnhahang` int(11) NOT NULL,
  `idtienich` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idnhahang_idx` (`idnhahang`),
  KEY `idtienichctti_idx` (`idtienich`),
  CONSTRAINT `idnhahangctti` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idtienichctti` FOREIGN KEY (`idtienich`) REFERENCES `tienich` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiettienich`
--

LOCK TABLES `chitiettienich` WRITE;
/*!40000 ALTER TABLE `chitiettienich` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitiettienich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhgia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tieude` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `noidung` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `doan` int(11) NOT NULL,
  `khongian` int(11) NOT NULL,
  `giaca` int(11) NOT NULL,
  `phucvu` int(11) NOT NULL,
  `diemdanhgia` int(11) NOT NULL,
  `idnhahang` int(11) NOT NULL,
  `idnguoidungdanhgia` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `trangthai` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `iddanhgia_UNIQUE` (`id`),
  KEY `idnguoidung_idx` (`idnguoidungdanhgia`),
  KEY `idnguoidanhgia_idx` (`idnguoidungdanhgia`),
  KEY `idnhahang_idx` (`idnhahang`),
  CONSTRAINT `idnguoidanhgia` FOREIGN KEY (`idnguoidungdanhgia`) REFERENCES `nguoidung` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnhahang` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnguoidung` int(11) DEFAULT NULL,
  `idban` int(11) NOT NULL,
  `tongtien` double NOT NULL,
  `ngaytao` datetime NOT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dienthoai` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `songuoi` int(11) NOT NULL,
  `thoigian` datetime NOT NULL,
  `nhandip` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT '0',
  `nhanemail` bit(1) NOT NULL DEFAULT b'0',
  `idkhuyenmai` int(11) NOT NULL,
  `idnhahang` int(11) NOT NULL,
  `ghichu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idhoadon_UNIQUE` (`id`),
  KEY `idkm_idx` (`idkhuyenmai`),
  KEY `idnh_idx` (`idnhahang`),
  KEY `idb_idx` (`idban`),
  KEY `idnd_idx` (`idnguoidung`),
  CONSTRAINT `idb` FOREIGN KEY (`idban`) REFERENCES `ban` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idkm` FOREIGN KEY (`idkhuyenmai`) REFERENCES `khuyenmai` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnd` FOREIGN KEY (`idnguoidung`) REFERENCES `nguoidung` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnh` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khuyenmai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnhahang` int(11) NOT NULL,
  `chude` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `thongtin` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `trangthai` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idnhahangkm_idx` (`idnhahang`),
  CONSTRAINT `idnhahangkm` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaiamthuc`
--

DROP TABLE IF EXISTS `loaiamthuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaiamthuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idloaiamthuc_UNIQUE` (`id`),
  UNIQUE KEY `tenloai_UNIQUE` (`tenloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaiamthuc`
--

LOCK TABLES `loaiamthuc` WRITE;
/*!40000 ALTER TABLE `loaiamthuc` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaiamthuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaibaiviet`
--

DROP TABLE IF EXISTS `loaibaiviet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaibaiviet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(50) CHARACTER SET utf8 NOT NULL,
  `mota` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idloaibaiviet_UNIQUE` (`id`),
  UNIQUE KEY `tenloai_UNIQUE` (`tenloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaibaiviet`
--

LOCK TABLES `loaibaiviet` WRITE;
/*!40000 ALTER TABLE `loaibaiviet` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaibaiviet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidoan`
--

DROP TABLE IF EXISTS `loaidoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaidoan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenloaidoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idloaidoan_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidoan`
--

LOCK TABLES `loaidoan` WRITE;
/*!40000 ALTER TABLE `loaidoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaidoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenmonan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL,
  `gia` double NOT NULL,
  `solandat` int(11) NOT NULL DEFAULT '0',
  `idnhahang` int(11) NOT NULL,
  `idloaidoan` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idmonan_UNIQUE` (`id`),
  KEY `idnhahang_idx` (`idnhahang`),
  KEY `idloaida_idx` (`idloaidoan`),
  CONSTRAINT `idloaida` FOREIGN KEY (`idloaidoan`) REFERENCES `loaidoan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnhahangmonan` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nguoidung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tendangnhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idfacebook` int(11) NOT NULL,
  `idgoogle` int(11) NOT NULL,
  `idquyen` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idnguoidung_UNIQUE` (`id`),
  UNIQUE KEY `idfacebook_UNIQUE` (`idfacebook`),
  UNIQUE KEY `idgoogle_UNIQUE` (`idgoogle`),
  UNIQUE KEY `tendangnhap_UNIQUE` (`tendangnhap`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `idquyen_idx` (`idquyen`),
  CONSTRAINT `idquyen` FOREIGN KEY (`idquyen`) REFERENCES `quyen` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhahang`
--

DROP TABLE IF EXISTS `nhahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhahang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tennhahang` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tinhthanh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quanhuyen` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phuongxa` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thumbnail` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `idloaiamthuc` int(11) NOT NULL,
  `gioithieu` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `giomocua` datetime NOT NULL,
  `giodongcua` datetime NOT NULL,
  `slug` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT '1',
  `mota` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idnhahang_UNIQUE` (`id`),
  KEY `idloaiamthuc_idx` (`idloaiamthuc`),
  CONSTRAINT `idloaiamthuc` FOREIGN KEY (`idloaiamthuc`) REFERENCES `loaiamthuc` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhahang`
--

LOCK TABLES `nhahang` WRITE;
/*!40000 ALTER TABLE `nhahang` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhahangyeuthich`
--

DROP TABLE IF EXISTS `nhahangyeuthich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhahangyeuthich` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnhahang` int(11) NOT NULL,
  `idnguoidung` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idnhahangyeuthich_UNIQUE` (`id`),
  KEY `idngdungyeuthich_idx` (`idnguoidung`),
  KEY `idnhahangyeuthich_idx` (`idnhahang`),
  CONSTRAINT `idngdungyeuthich` FOREIGN KEY (`idnguoidung`) REFERENCES `nguoidung` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idnhahangyeuthich` FOREIGN KEY (`idnhahang`) REFERENCES `nhahang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhahangyeuthich`
--

LOCK TABLES `nhahangyeuthich` WRITE;
/*!40000 ALTER TABLE `nhahangyeuthich` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhahangyeuthich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen`
--

DROP TABLE IF EXISTS `quyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quyen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenquyen` varchar(50) CHARACTER SET utf8 NOT NULL,
  `mota` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tenquyen_UNIQUE` (`tenquyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen`
--

LOCK TABLES `quyen` WRITE;
/*!40000 ALTER TABLE `quyen` DISABLE KEYS */;
/*!40000 ALTER TABLE `quyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao`
--

DROP TABLE IF EXISTS `thongbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongbao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idkhuyenmai` int(11) NOT NULL,
  `idnguoidungdk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idthongbao_UNIQUE` (`id`),
  KEY `idkhuyenmainh_idx` (`idkhuyenmai`),
  KEY `idhd_idx` (`idnguoidungdk`),
  CONSTRAINT `idhd` FOREIGN KEY (`idnguoidungdk`) REFERENCES `hoadon` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idkhuyenmainh` FOREIGN KEY (`idkhuyenmai`) REFERENCES `khuyenmai` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienich`
--

DROP TABLE IF EXISTS `tienich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tienich` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tentienich` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `icon` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idtienich_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienich`
--

LOCK TABLES `tienich` WRITE;
/*!40000 ALTER TABLE `tienich` DISABLE KEYS */;
/*!40000 ALTER TABLE `tienich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trang`
--

DROP TABLE IF EXISTS `trang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tieude` varchar(50) CHARACTER SET utf8 NOT NULL,
  `noidung` text COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `idnguoiviet` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `ngaysua` datetime DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tieude_UNIQUE` (`tieude`),
  KEY `nviet_idx` (`idnguoiviet`),
  CONSTRAINT `nviet` FOREIGN KEY (`idnguoiviet`) REFERENCES `nguoidung` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trang`
--

LOCK TABLES `trang` WRITE;
/*!40000 ALTER TABLE `trang` DISABLE KEYS */;
/*!40000 ALTER TABLE `trang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-22 16:17:16
