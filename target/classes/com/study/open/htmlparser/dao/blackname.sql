-- MySQL dump 10.13  Distrib 5.5.20, for Win32 (x86)
--
-- Host: localhost    Database: homelink
-- ------------------------------------------------------
-- Server version	5.5.20

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
-- Table structure for table `blackname`
--

DROP TABLE IF EXISTS `blackname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blackname` (
  `url` varchar(200) DEFAULT NULL,
  `areatype` varchar(50) DEFAULT NULL,
  `opertype` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blackname`
--

LOCK TABLES `blackname` WRITE;
/*!40000 ALTER TABLE `blackname` DISABLE KEYS */;
INSERT INTO `blackname` VALUES ('http://beijing.homelink.com.cn/ershoufang/ff808081343ffd80013440eba4f0285b.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134c153a40134c1b8e8df0c6c.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081349333cb0134bd81c1ff3822.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081348cce5001348ceb90060894.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813530ed0e013532068abe1f8c.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813493325d0134b13878455865.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813493325d0134b138ebd55879.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081349330c70134b13cc8984944.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808135349abe013537ce50ae370d.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081333a99dd01333f74be31300d.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813441244b013455b9689a51db.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081354411fe0135476294a12ae0.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134c153a40134c1ab5ebb0b5a.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134411f1701344ebc0c95147b.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134d1457c0134d70a8148585c.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081333a99dd0133446392f154ee.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081349330c70134adbeaf3f1801.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133b215f60133cfcdc1ee7f3a.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134633dc001347e83b0fc117c.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813441244b0134596eff177feb.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133fd7fbe01340e4b30c64d57.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813387a02e013387c6433107fc.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813387a02e013387de030c0d70.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133966b9b0133afbe243e0176.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134d146670134d1c001c3093a.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081349333cb013493419594036f.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133ee5b080133f380026f6b74.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133b215f60133c41cd14b2184.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081339511d40133b04003ee0ccc.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081333a9bfa01333e6030304357.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133ee5b080133f3c5a5fe7835.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081345a2a7e013475338fbd2599.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134d1457c0134d534314b276e.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134e5bbea0134e5bd6f9b0013.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134d800d80134dc32b0d636fa.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133b224600133cf9cfdb11fb2.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081349330c70134a2d45a375e0e.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133b20fc10133c42380151cdd.shtml','FH',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081345a28140134732593d4772d.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081354b36fa01354db9d673529c.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808135546680013555dafd0d1b20.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081353aa1c701353ccd2dfb242a.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134cabc9f0134cc3c4e40308f.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813553775d01355606e6db1db2.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081345a2a7e0134699207cb439b.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808133966b9b0133a021c8734eca.shtml','FH',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813562e4bd0135662bb1a23128.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/ff80808134633dc0013479816929369d.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/d10b278/','C',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813295f43301329e0c386d652d.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/d12b271/','C',NULL),('http://beijing.homelink.com.cn/ershoufang/ff8080813493325d0134c0495d1444d9.shtml','H',NULL),('http://beijing.homelink.com.cn/xiaoqu/d12b271/','D',NULL),('http://beijing.homelink.com.cn/ershoufang/ff808081354a84a801354b6872de0c47.shtml','H',NULL),('http://beijing.homelink.com.cn/ershoufang/d11b266/','D',NULL),('http://beijing.homelink.com.cn/c-JINYUKELE8904/esf/','C',NULL);
/*!40000 ALTER TABLE `blackname` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-02-12 16:44:07
