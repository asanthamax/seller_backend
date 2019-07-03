-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 03, 2019 at 03:29 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seller_admin`
--

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE `ads` (
  `id` int(11) NOT NULL,
  `ad_date` datetime NOT NULL,
  `expire_date` datetime NOT NULL,
  `status` tinyint(4) NOT NULL,
  `userID` int(11) NOT NULL,
  `adSlotID` int(11) NOT NULL,
  `artwork` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `adslots`
--

CREATE TABLE `adslots` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `max_width` int(11) NOT NULL,
  `max_height` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `authority`
--

CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authority`
--

INSERT INTO `authority` (`id`, `name`) VALUES
(1, 'COMPANY_CREATE'),
(2, 'COMPANY_READ'),
(3, 'COMPANY_UPDATE'),
(4, 'COMPANY_DELETE'),
(5, 'DEPARTMENT_CREATE'),
(6, 'DEPARTMENT_READ'),
(7, 'DEPARTMENT_UPDATE'),
(8, 'DEPARTMENT_DELETE'),
(9, 'ROOMS_READ');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `shipping_address` varchar(200) NOT NULL,
  `mobile_no` varchar(100) NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `oauth_access_token`
--

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `authentication_id` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `client_id` varchar(100) NOT NULL,
  `authentication` text NOT NULL,
  `refresh_token` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oauth_access_token`
--

INSERT INTO `oauth_access_token` (`token_id`, `token`, `authentication_id`, `user_name`, `client_id`, `authentication`, `refresh_token`) VALUES
('057f97f95c54f098db2b74d403f13238', '¬í\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken²ž6$úÎ\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6…ZÜçÐ\0\0xpsr\0java.util.DatehjKYt\0\0xpw\0\0k¦à{xsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valueq\0~\0xpt\0$1468b4c7-b5c5-4bba-b05f-f7ddd5ead06fsq\0~\0	w\0\0lAY\'©xsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writext\0bearert\0$68c8a67f-b2fa-4b71-8bf0-975b5b6ed789', 'd557e74143287f87984f133c7409755d', 'admin', 'spring-security-oauth2-read-write-client', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0?w\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xpsr\09org.springframework.security.oauth2.provider.TokenRequestÖ*„¸Ï8ø\0L\0	grantTypeq\0~\0xq\0~\01t\0(spring-security-oauth2-read-write-clientsq\0~\04sq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0\rrefresh_tokent\0\rrefresh_tokent\0$1468b4c7-b5c5-4bba-b05f-f7ddd5ead06fxsq\0~\0<sq\0~\0>w\0\0\0?@\0\0\0\0\0\0xq\0~\0Nsq\0~\0?w\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0?w\0\0\0?@\0\0\0\0\0\0xsr\0[org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Ypt\0\0sr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0_xp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0\\t\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin', '2452053f4b07e8b5437032ae14ffb49d'),
('d9aa8068a530cfbd658e6fef6311e8ca', '¬í\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken²ž6$úÎ\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6…ZÜçÐ\0\0xpsr\0java.util.DatehjKYt\0\0xpw\0\0k©\\i1xsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valueq\0~\0xpt\0$1970597f-f3f8-4941-8abd-2227d9c0d09bsq\0~\0	w\0\0lB&à1xsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writext\0bearert\0$1bbb9968-e744-4f8f-804c-ffbd75f8ffb5', 'f47e3c3c9dc5aafecf8eed17524770ee', 'admin@gmail.com', 'spring-security-oauth2-read-write-client', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0admin@gmail.comxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0?w\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0?w\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0?w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Nsr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\08q\0~\09q\0~\0:q\0~\0;x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Uxp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Rt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin@gmail.com', '73469d8da5a45909814ff29df5afd74b');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_approvals`
--

CREATE TABLE `oauth_approvals` (
  `userId` varchar(100) NOT NULL,
  `clientId` varchar(100) NOT NULL,
  `scope` varchar(100) NOT NULL,
  `expiresAt` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `lastModifiedAt` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_client_details`
--

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(100) NOT NULL,
  `resource_ids` varchar(100) NOT NULL,
  `scope` varchar(100) NOT NULL,
  `authorized_grant_types` varchar(100) NOT NULL,
  `web_server_redirect_uri` varchar(100) NOT NULL,
  `authorities` varchar(100) NOT NULL,
  `access_token_validity` int(100) NOT NULL,
  `refresh_token_validity` int(100) NOT NULL,
  `additional_information` varchar(100) NOT NULL,
  `autoapprove` varchar(100) NOT NULL,
  `client_secret` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oauth_client_details`
--

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`, `client_secret`) VALUES
('spring-security-oauth2-read-client', 'resource-server-rest-api', 'read', 'password,authorization_code,refresh_token,implicit', '', 'user', 180, 2592000, '{}', '', '$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km'),
('spring-security-oauth2-read-write-client', 'resource-server-rest-api', 'read,write', 'password,authorization_code,refresh_token,implicit', '', 'user', 180, 2592000, '{}', '', '$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_client_token`
--

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL,
  `authentication_id` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `client_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_code`
--

CREATE TABLE `oauth_code` (
  `code` varchar(100) NOT NULL,
  `authentication` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_refresh_token`
--

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `authentication` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oauth_refresh_token`
--

INSERT INTO `oauth_refresh_token` (`token_id`, `token`, `authentication`) VALUES
('2452053f4b07e8b5437032ae14ffb49d', '¬í\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valuet\0Ljava/lang/String;xpt\0$1468b4c7-b5c5-4bba-b05f-f7ddd5ead06fsr\0java.util.DatehjKYt\0\0xpw\0\0lAY\'©x', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0?w\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0?w\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0?w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Nsr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\08q\0~\09q\0~\0:q\0~\0;x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Uxp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Rt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin'),
('6ef4339e89f61d00d1e3e2266742c8c4', '¬í\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valuet\0Ljava/lang/String;xpt\0$4ce5b527-7297-44e2-bccd-4a24a65c7164sr\0java.util.DatehjKYt\0\0xpw\0\0lAE•Bx', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0	client_idt\0(spring-security-oauth2-read-write-clientt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0Aw\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0Aw\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0Aw\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Psr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\08q\0~\09q\0~\0:q\0~\0;q\0~\0<q\0~\0=x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Wxp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Tt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin'),
('73469d8da5a45909814ff29df5afd74b', '¬í\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valuet\0Ljava/lang/String;xpt\0$1970597f-f3f8-4941-8abd-2227d9c0d09bsr\0java.util.DatehjKYt\0\0xpw\0\0lB&à1x', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0admin@gmail.comxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0?w\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0?w\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0?w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Nsr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\08q\0~\09q\0~\0:q\0~\0;x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Uxp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Rt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin@gmail.com'),
('7fc3cd1a6e6ebe00d95d5e1048504e24', '¬í\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valuet\0Ljava/lang/String;xpt\0$1c43f4c1-0323-4e77-971c-94da692646aasr\0java.util.DatehjKYt\0\0xpw\0\0lA%ox', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0	w\0\0\0	sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0	t\0\nROOMS_READxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\00xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0.L\0scopeq\0~\00xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0.xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0	client_idt\0(spring-security-oauth2-read-write-clientt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0Aw\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\06?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0Aw\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0Aw\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0Psr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\06?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\08q\0~\09q\0~\0:q\0~\0;q\0~\0<q\0~\0=x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Wxp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Tt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xsq\0~\0\0\0\0	w\0\0\0	q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'q\0~\0*xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin'),
('bb04790085f9a6ebed203c98f11c8258', '¬í\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ßGcÐÉ·\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokensá\ncTÔ^\0L\0valuet\0Ljava/lang/String;xpt\0$239155ae-1f06-4b7b-bc5d-bbfb6f03ec46sr\0java.util.DatehjKYt\0\0xpw\0\0l4ÊÒJx', '¬í\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication½@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenÓª(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableListü%1µìŽ\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0€Ë^÷\0L\0cq\0~\0xpsr\0java.util.ArrayListxÒ™Ça\0I\0sizexp\0\0\0w\0\0\0sr\0 com.spring.demo.entity.Authority*rÿy&=«J\0L\0idt\0Ljava/lang/Long;L\0namet\0Ljava/lang/String;xpsr\0java.lang.Long;‹äÌ#ß\0J\0valuexr\0java.lang.Number†¬•”à‹\0\0xp\0\0\0\0\0\0\0t\0COMPANY_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0COMPANY_DELETEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_CREATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_READsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_UPDATEsq\0~\0\rsq\0~\0\0\0\0\0\0\0\0t\0DEPARTMENT_DELETExq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0-xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qi½\0L\0clientIdq\0~\0L\0requestParametersq\0~\0+L\0scopeq\0~\0-xpt\0(spring-security-oauth2-read-write-clientsr\0%java.util.Collections$UnmodifiableMapñ¥¨þtõB\0L\0mq\0~\0+xpsr\0java.util.HashMapÚÁÃ`Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0	client_idt\0(spring-security-oauth2-read-write-clientt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet€’Ñ›€U\0\0xq\0~\0	sr\0java.util.LinkedHashSetØl×Z•Ý*\0\0xr\0java.util.HashSetºD…•–¸·4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writexsq\0~\0>w\0\0\0?@\0\0\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0þ\0L\0roleq\0~\0xpt\0userxsq\0~\03?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0>w\0\0\0?@\0\0\0\0\0t\0resource-server-rest-apixsq\0~\0>w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0þ\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'xq\0~\0Msr\0java.util.LinkedHashMap4ÀN\\lÀû\0Z\0accessOrderxq\0~\03?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\05q\0~\06q\0~\07q\0~\08q\0~\09q\0~\0:x\0psr\0com.spring.demo.entity.Userx A\'R¯\0Z\0accountExpiredZ\0\raccountLockedZ\0credentialExpiredZ\0enabledL\0authoritiesq\0~\0L\0idq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0\0sr\0/org.hibernate.collection.internal.PersistentBag>j\r0I_ \0L\0bagq\0~\0xr\0>org.hibernate.collection.internal.AbstractPersistentCollectionW·]ŠºsT\0Z\0allowLoadOutsideTransactionI\0\ncachedSizeZ\0dirtyZ\0elementRemovedZ\0initializedZ\0\risTempSessionL\0keyt\0Ljava/io/Serializable;L\0ownerq\0~\0L\0roleq\0~\0L\0sessionFactoryUuidq\0~\0L\0storedSnapshotq\0~\0Txp\0ÿÿÿÿ\0\0\0q\0~\0q\0~\0Qt\0\'com.spring.demo.entity.User.authoritiespsq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'xsq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0q\0~\0!q\0~\0$q\0~\0\'xq\0~\0t\0<$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035hat\0admin');

-- --------------------------------------------------------

--
-- Table structure for table `refresh_token`
--

CREATE TABLE `refresh_token` (
  `id` int(11) NOT NULL,
  `refresh_token` varchar(200) NOT NULL,
  `created_at` varchar(100) NOT NULL,
  `expire_at` varchar(100) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `refresh_token`
--

INSERT INTO `refresh_token` (`id`, `refresh_token`, `created_at`, `expire_at`, `userid`) VALUES
(1, 'hWpcbwsg12fe1g1Vzaz1n8hU5eie1j8cyjqY3Y5e5qut7svsjocXnhlmymnv3wgaU5ckqZcaU2Ugs2f8qc99e5lj08Yfry1bY48n', '1553101407', '1553112207', 1),
(2, 'vudel1oV2br82szjZiekZfcWfza2zxkx9bhzb8m0iYgmjvWgkrrdmzasYmkfU4mXj0Z4YYleYybtVU8W3yswkz6iertgYiYjWegz', '1553101634', '1553112434', 1),
(3, '9p3re0Y78UWkxv2Wvl7pgq4c1gkjW1u17lu51udz5Vqg9UUbpVzkpih861rV5pU4ars5rcwx5WucVg33frc9i0ytly6v4uqvjx9X', '1553101955', '1553112755', 1),
(4, 'kVXx5U5dn2o51r6dy4z5lzwmlay31xZ8ip9w2bYxq1fX8ixqoiU9sXqX6qrk6czae42ZZyxZbfgYdkeWhW4hUj8mozu72eksvcc6', '1553102966', '1553113766', 1),
(5, 'o69uc3l318r72ax4aubcivv7WlXynseyu4ydUf8zn4glVewinmnxtnuVsjoltlqgy0je16fuyj6uW79Wluosoage2tk61Upqw0VY', '1553104830', '1553115630', 1),
(6, 'eddk679xul1pwdV702s464Uy4jgfpkdl0rb1ol41saYofbbZoxXrlZXd9fv5lja34rc7Ukjgalejzyic21zjsk2mab4cvVlw3slV', '1553107323', '1553118123', 1),
(7, 'V5bw0VUmfXnsZ99ccw0silXmufuskXlem42pjlY56nyUUaav5x8phk4ZilcefV63zhmYVd3z4mrZ9X2utq7g5eqkvokv8kw4q7v8', '1553107767', '1553118567', 1),
(8, 'odtifykjUelYU5c0k1beq45979l3c5vlU0caxXzZ1jiUbihjfv07U0g0lopX4xgg3gwy847lb9ujmmd57WZjXb7zzsm65pu3iZ71', '1553110170', '1553120970', 1),
(9, 'buu80Uep5o6xu8nvW9Ytyit1ZZ6dk82jWYUt5q7v9Vu7hYgk6pWlYt0Zt7pdbrdph30Y7Zb2gb9qislk8vUbk2h8j4j0kx87ynUb', '1553618631', '1553629431', 1),
(10, 'uy1hv0dVnuxW2gwtXs5Zvem7tthbY5ZWpfx3gqsZXjnvrhlVveYvUm3fZynX94W4z2dbidcphexb6VcnW3uVzV1mV5tar181lgZU', '1553619474', '1553630274', 1),
(11, 'j8ppXjkj9di548fnartjeWqxwXZvgmZVxr9r6zyjvYVxx27cea6Xkjy6upa14oYxgsvp45atr6xZWlg1oaU5Vsg8u6d8jq349s7d', '1553619807', '1553630607', 1),
(12, 'nWmmac89sVVuXm3pYYju68m9UVs1ngetpxXhxz46sufgVoue9f2b4vYpVvicrUtptqsWa92gju4b0xt4Z0td0vxhcb2cxhhVtgxk', '1553619997', '1553630797', 1),
(13, 'ev7d3Vbsr9owxz7wWY2tewveXuVywewkhXslg90dzxW9cW2bh364Xvph5zVhUtlZ5jtz8l1u0xhXseh5nuinphaht8g6h3bt5fi0', '1553620640', '1553631440', 1),
(14, '0ly5w3Xd7cpuql1h3g2kt9wxhmi50km94XWv6v2tj6gp50WwUUVsjqUg42aksiajVrx1dezWVkcrrWVhcbmcfs656khUaiVxsb3v', '1553622123', '1553632923', 1),
(15, 'Ykbe3zVm0o469cyv24onmZ9W5syobV7f8vYg9unYu7iqtp7xpVjzkUoguhYc5yV1t7dkmk1bf11fmgc09l93jXkx1vYXddjpf47l', '1553623135', '1553633935', 1),
(16, 'WVaeg7tmpn5XlvYfW1sk9fpbY7b7ivmZm6x6stf0VYUwZp4w21Vagpbv6t8xzp3flnVZVv0kZqj5w28Vj39tcnUtUf2c3Y8Vc3ZV', '1553624256', '1553635056', 1),
(17, 'cgjpj3Za2en02Zg56w2djib6Z5kvghvYU14snf92gYjVluZj1yje86d5W6glwytqffhx2VZY3umgXr81sbUxumxy8p7rZX4qmVot', '1553625459', '1553636259', 1),
(18, '3lcnvuyWZm9jXZl6003ow2wUioYnkpc58vw90qg15Y6nivs5yogpbZ7yl5lelwils1bsU6wUiZ9kv9j34sbsafqbrWmartoYxxs2', '1553625752', '1553636552', 1),
(19, 'ieVfzg0h7UVs0rwpzciU0gq7xojaUahaY6ye2w9dgq021lgvgropy4uok1g6xl890myfrpgpzf6r4jbVbcwk8bnj2Ww1jW74WUe1', '1553627228', '1553638028', 1),
(20, '4kV4245irkZm6yZ8xrws090sZ0o3j15vhtq5m0X23n0ype386yyr7bhkzXkVpcYlx1lad4pj6vZe5pr5z59poWbUuYtheoy7t5yW', '1553628241', '1553639041', 1),
(21, 'qwayyegv8summWu1Z1u78fqr8qipbtXeiuxbpj0jZ2qz4W6vb2omloXg3jklrt73hUqWy0livziwyginajut3l5Ztna4oojYcog8', '1553628982', '1553639782', 1),
(22, '8zb5qv75cfm5dkki5juobVvYp7Vqzrnskev43Ydidf31XtZ7gs9psY1zXqwocz0lpqfhvXwzwre9Ysghb8chhfxkW0d3sYs3761z', '1553706092', '1553716892', 1),
(23, 'iyzclq0udbai4oyd4idvyUwYadhddxq54xg7khda4V3697frguecprqxiubllsWpfzqxjvU3ZVrViVd67n11f01m8XXUbbkkhYzw', '1554009221', '1554020021', 1),
(24, 'uUf2Uq5494rZ4h7iqhZyXogbY1zccZ9xmsukyahs6n6se8r6s90a8ZisUobqq9s661l3menZmzrq4kdav5pmjxdUgYj90tkecUop', '1554009864', '1554020664', 1),
(25, '0be9nuai6Ukosqss9ssnZat4hgviZ2h1VbWawqak2f2cz9kZXbu7ndqcapk8ube2e45fbZoqkZ5f6aY4xjcz00Vwcpg5vmajwpWh', '1554010476', '1554021276', 1),
(26, '7sq5yihrmacp0pe4ljW9o20leY5r2uuw9uVYg6rpwo3grWhiZhjm0b28ebl6njUmXpYWupwcYtUntjui7X2kxeYskmYUhnodhf8X', '1554010845', '1554021645', 1),
(27, 'a43ztpws40i94tqd1qX8rda3du2dZxUXcXkcdt5lmW16vm61Wxurwxmkse1121212yeW7qqmqvlnU6VUvsxaqw4jilbYVxxeuhxu', '1554012402', '1554023202', 1),
(28, 'al4vjxiVtxoWjzwgljgn3qV3x7ofaUp5bqd6Ypdn9i44cmndl6y2xvgkV04mbXWaeeX2q01yvkz0fxu1hVZfv55X0Xkckq08tmes', '1554015446', '1554026246', 1),
(29, '80Yf5nyaj6W6q4zkv2orYfeX30WZhquo2mvU79qpp94kYvW5wpX7Xxhl1iniWtgb6mdf2lree2WunXpWhopaVdwVtWW8o044jW09', '1554015675', '1554026475', 1),
(30, 'oinwdyj25e65d1uVweg4mmxXkw5jbXfklqciW5d65q5g3j5i4qyubclzjskWjftu42k07UXX1yyrh7ekpo2azlv2kx47kX70U373', '1554015975', '1554026775', 1),
(31, 'jhZUgsotvfnfk9w33jobXozjmf2gwb9swvksh0gw93e0bxY0YVc48mjppYV1n4ak2opsxWqwXpkWaYXxk5VUo33lkX67ic6tivvb', '1554016284', '1554027084', 1),
(32, '32u6YkYzsaautp7hcgefn93fWrr09qV06Wqtsj0jV7zj5X9pXnUmzuU3futu5wlnWYkqmoXzfj2i6p3i7vilj76eiqXzm6emkk2Y', '1554018630', '1554029430', 1),
(33, 'oeXV34l1cob17jpsrk1gp6cVZf2u0sZddk4cg6cz1bem7kvY08dswyrUxhiyfXz1tzei95fXv1n9dwV0XzfWzhdf015zutgU54jp', '1554019046', '1554029846', 1),
(34, 'c5oYjequfblbdaifm6wgwy2mhoywjtoscahsz2YfYjpWlWd2fnVpZpdXs3zs5b5xeufWis8sewt6sXgu3qmiUonhwte8ryxXUmwu', '1554019203', '1554030003', 1),
(35, 'Whvp1s4eqvpi0wnqYWXjU1UzwX5ind80wiUu6t6Utpmf91Yfnebzeyu0juj3gZWbyjerjv60bynY6d30dk8aop649076Vlmovbd9', '1554019495', '1554030295', 1),
(36, 'prW9nm8vXa5gc43gzuybn519U06a62thwZrmWZosf7pkipd54jrvf8cXUUrbvz588yfbf528Y7vhi009mj7hmvsj58Zu14i0kxVj', '1554022720', '1554033520', 1),
(37, '9xozmla02sgW6v0UtbV51bWrvc0dnz9e8192eWZaWbexbkg24vveXqybjl2ZoYWkb2WW1oc38sc7dudtvWhl6m9m20y6pk3kmvpZ', '1554023553', '1554034353', 1),
(38, 'za3xrgfivlp3Ujyw4Vynodm0b7m3jaXwqfb0rYm53nYxuzzUxpo3uqcuu0ch585Z3hso77nVlempY2Xvolslbhhl74i4jhomkXfe', '1554023635', '1554034435', 1),
(39, 'mvU2Vgknh8U4zudn8f3fhdheUp4aZY0fzYrpbgzse7o2bpml35elp4uwq5z3YXdl6zZ5i0yjutlv5v5f1fj1ahxW6mWcqfXWZUcc', '1554023780', '1554034580', 1),
(40, 'Wnqb4gd94ZWkXZVfU9cgyfU1hpclabshd5eid7mwqw2jwxwpgu7pwyVremd30oX91er8ldgVepqsdVhWucypUVXZUf8xVoz9Wf1w', '1554023941', '1554034741', 1),
(41, '7nigbqp9k5eV2V11dd3ZvYs5vs4Vufowxny78bcd2u9zsqbjxrg39qc79Y2sv91izni4Uq0UzoZ5e0gs3xw9XcpUr1up4d5duZ22', '1554024060', '1554034860', 1),
(42, 'j4d09dgZ4yy5Wkay4smtxZ7yX2Z4ofqWWrsq4txte330vrnrmqV5decgdnyxuhUW7w933yxjpyXYa6trclpYtl1r0zp7783pyayp', '1554024148', '1554034948', 1),
(43, '1lkmia5a2iicX4th6xpnw9Vlz5XWpsfht409xlxllhcXm1xWao2jhmg7qfkh8Vhy0X8fywifbx2n3wf1td0ztpdseZv0cU49bWrd', '1554027953', '1554038753', 1),
(44, 'e5wloWab2Z1Yn0pavil7sv1XWd0p4Uo6pXsz3Wm29oy8Uaemg4smUzfisrpVikx5X80xUZon9tjm2YsxblzYtY6phgm3q4bUZtg1', '1554029215', '1554040015', 1),
(45, 'tVqo5xWrv3c7foqp90yVYhc6rgVs6eyez4pX6x5dlmm9ma05waj5rps72s4oz6WfX9ss6oUinmyw3iob1qXaq3xnZWj1sv5ox20o', '1554030261', '1554041061', 1),
(46, 'Zf0yb9cwh9Upxwl7yZYWnkUjcZ4hyuV6Zx0pt33aYcfbl8i1d04dt6tkWZhVWx21haeXa84yUV4bxZkXkWrVYtlW69gWgz8UUdo8', '1554030487', '1554041287', 1),
(47, 'dX8vXzktst3wznpXwzVtey29Zo6pkUi2y67XUvx0impV0v9ypeX583nl85cXd68i5ttj3cpzww5tu4wyc8yi9hY1sqtXh02qa3fv', '1554030858', '1554041658', 1),
(48, '3h56sVzV0qZm8qnfr5gh8zlZcYihV1cU2mv6Vyeuuol4fiYdwu2zxWi50WoqkkocmdfYwp90x41zjVW5g5dvl6e6ZdUgw67o1mi0', '1554031655', '1554042455', 1),
(49, 'ef5desf8ng9d3muppn06jayxeslcslk8Yattl1bVswxtufdy5Ua3oxy4di72xYjgsZ9p8eWzts3ebmp940j7t7xa8ezpds2rb9vk', '1554031922', '1554042722', 1),
(50, 'wfafmk5mr1Xj9waXVXsoZsyc4jp1mxZwni1oiYn2Ww9dzU5cxUvf28cggevZc6jfnhkaY1xyf3a2twsXcwyezbkrvbU8w1rg19di', '1554032873', '1554043673', 1),
(51, 'dgVi5wqWidezvWwtq2tpszVoeb86x9yzcxoo6g19YwcrmwU52ff9ytukY9YYljXraW8bypt7nY5V7yUyYycpxzoaVuV2ambw480f', '1554033604', '1554044404', 1),
(52, 'ZYVWeYux0cr89r02xZ9xtVdpz983yolaklaYhZYl5uYxricx7mo8cf6c8kopnUaUqY1gqaYxdX1u6V7UV5sp9Ys84z47zjYhiwZl', '1554034042', '1554044842', 1),
(53, '1X8Vv9s3Vmvwat8duXr78vg3Zlg7wVleyj7qtswm4mkhwxob8hau24qty988xvdipq0oZ8ztxetc658v23epw45vvZ76991xhr1d', '1554053927', '1554064727', 1),
(54, 'ZeVic593xnXy95z1rfyVkbsVbUYXwdXeahigk1Uhynxwe7fmdopkliXz55xUZupu9of4wfhchukx9cnjdjv0Uct3bvqytt07ecv2', '1554054222', '1554065022', 1),
(55, 'lmXmpnXnigWrymUX98gv5os6ao71XX3nWqoXtb45v1b426zald1h98nussVk8dVtfktt76ludarvnWZsuUXmxkt92p34n4iryZrw', '1554054339', '1554065139', 1),
(56, 'kUo4Zs8fdXlW61a4WvqYmW8kwYczns5fpbfkuxf8hXVx5jchpfxlo1glilwknw3igXgWc7f8rhhXrerkobYo45buh7pljqhyZkbe', '1554054894', '1554065694', 1),
(57, 'rjqlgkiqgkiUl8x3vn6v1h7jhklziVviybvb8dUqXozjWaVWmW2gjXdt2zvhof41myZX9klj9Xcr3p62rem6vvsib1a3f9zia0lw', '1554055534', '1554066334', 1),
(58, 'uYYc5iejeof7pnmvcor9vyozzknmgadseatw1n1lZ8Xlg12004bxgl0kpkrwsZg9b2arVl6osij4vUxvxk6s8U2ptbu6UhZwuaur', '1554055789', '1554066589', 1),
(59, '8ut6stWUkiWlgohz316kZV3v5fqY1ntbb085qqWmc0fejgoYnli5nv7yozi2veXi5W1g7q4pwg2kfz1rtlp3jbZouWrwrefmbp2c', '1554621164', '1554631964', 1),
(60, 'nsg6aqx4fem2q4Xe0aveUe0Uds1XYykkZb92kl8szWsxqw7uar93kj1ubZqg6WVrcu0oh9ta9wvZ70rw5itrhY5qm91v0zjxdzXy', '1554621436', '1554632236', 1),
(61, 'V22mzvlm8qqnnaoemknk3ikqVtv8pi2h2e37k3xno0uninhcwn3ytbXz833W7553ey62mgxgmct18ryrwvZvXq7Um36Wft35fjd4', '1554622379', '1554633179', 1),
(62, 'aUV7higVg64bxumv9hjZbej133Upru77oqgnZoahyeX1V39tf0Ysj9h2q3odb77fgiWnZ07406mUV5Yg6vV5ihoi8o1U20hrqVss', '1554623880', '1554634680', 1),
(63, 'Umym4a12jwVWpjaan3c8pxxuVviu7zsYZcmdgi9f6s9oVVWwi4jksjsdt2e0g2ljhb3zgV1lVeWspgfWVhfva5Vl9ap0cx3lsf5h', '1554624855', '1554635655', 1),
(64, 'rj8p402o3af7hr3jv79fgfYjZ1do5c9kwbxfjt47av3qpW5vwoZmys4bdtrnxV4b38skbi3ubh2buwdl39hUU11Xa7uZ3VZtV1ek', '1554632735', '1554643535', 1),
(65, 'y76kldxntm3bbeYzkbqadq91rwcckX0UoWmz4iuUh7pUhuuxngc0sXs5a7gz52pjryt3pz04jmlcs376eU3pp2dw0WitUmilYvUk', '1554633216', '1554644016', 1),
(66, 'fk75to7Uf5xf0bgxVlkXXa1tgjz9p0fnZdmhobg1fWZr5wyekpxiiurcebwa6f0k4fj9l7ZYiz5677b0yborZXlVwp9Uh0zj9rbl', '1554633383', '1554644183', 1),
(67, '0kV19oUVrdqpyapt32581csrX0y94Vxp9qwUz07r28Y0oUrVt0UpkZUg1sj3i9s2ylb7fU7vqmZcZr2hsX6drmfqgj2U7pe7843W', '1554634109', '1554644909', 1),
(68, '090dW2hjmZdjv5vXWc7Yyy46Zbso7hjXkX8oZ8c87udvl14sZXXXllrjx29d2hx4kbmthhmds3l63q26tZ9nv146hkpmwe69uwtk', '1554635287', '1554646087', 1),
(69, 'X95qcpat2ZicseWbrxsvy1pgt3n0jhV7tqytb1tY7W2b57Yd752Vypdbzft8nbmbzZdyUp2ZqfmUXZXouVt0iy06f337ohXzvexe', '1554637824', '1554648624', 1),
(70, 'bsbZct3exwv8d5pwp2dctfbei3en0vwiqcZrtch8dh5o4aujguY3agYkjz3n2mkmziy3schkf8WZioye4132inZ052mx0hZiX2w0', '1554638757', '1554649557', 1),
(71, 'jdYeYh2WX1i5iU1vmt9xhVrzlbm60hljZdYxox10b5V5hjqZpjZpyYpyh72qgm4Yivk8qj9xioXuhk4gklleX3pkv6UVYgy3i7qo', '1554917395', '1554928195', 1),
(72, 'jUpixl8tps6or8hp9z6tajrtqc7y4hhhbX1Yr4tW6bVu4gxUhomj6xdy8n805wY5W8Uygfl8fxrYXnoauoeusUdUsoXzfa36n34U', '1554917598', '1554928398', 1),
(73, 'V0uiisqe2X1oVhf0m034quuz321s4wb1s2WaZ9s9y86059rhxz0xVpgxyiXYt41q7jk2joerYzz8xi8xf6pv6a9ndVopphwxbcXu', '1554918136', '1554928936', 1),
(74, 'xflq53odfsbeZ0x0wXvm6f9eoxvYXmX0l2a9ua26fk8f64up48vxl43pmdwp9pvw0pwgzYrvcosaUfmVwnmgikopUu2X2mp08ywU', '1554918366', '1554929166', 1),
(75, 'edYozokzxrzabssj0lg9yhuom8ddwUni5yrlnw67ulnn6Z1b9xivrouX6vkz5pt2o5mzYUsU0smZhenUUY9X4fvqi1q3wmerVZ0v', '1554919122', '1554929922', 1),
(76, 'yerjYwcmrbU6sywh08li1ejk55Wm77tjlxVyo77fYYv9w9eoW19tVc239Y0lfb6i1Z20pdj214bWdfukbigjkj79quoX7yyuYiup', '1554919733', '1554930533', 1),
(77, '4g6of6tvv7ydclZ6x3WV3dfx055p5U4ieWZuqsjw80a3n9bnnU1Xstc76vmetfZ5tmUw5rqsVnlbxYpfUV9onoudXxae37qop2eu', '1554922758', '1554933558', 1),
(78, 'Yf5aoud18pksfqoZl4zaydowlXmsmpzrVdeUkV2wUzXwt6Z3ymVcqiqUso0xb7WhYl5cYUx8ZivWfwsn003jpnwcq9YmZVV9kqhV', '1554922936', '1554933736', 1),
(79, 'nin92x1X33gVhsghY6e52oX6qinhe2uY7a5sqb6yn6Ybh77Y8gZY5wxXy4f05odYVX320cf1stfvWX5q3ohZ0Yu2WXhsX6yadm7W', '1554923619', '1554934419', 1),
(80, '8kyopcmXsrjsxc7eVu7zevmugibnzbf3a6xlspuaU3nVww7vXxlisyg4afeds5YxrqicXVdgvzo29Xju9zY3ngu7865UpZk8oxoX', '1554923791', '1554934591', 1),
(81, '3woovYjuzlp5he2vUXX2tsbg4pd2a3ddYvrWZh5nVgd3U7Xpwh8cymqdb48640ua9dvkV6u0dsXUx6h1qtr9Vxj7st4m9qc3X28g', '1554924412', '1554935212', 1),
(82, 'gvVx1qozem8w508g64n9xkZXYrwyeg7V1lpialdo5pfey895j51rkUdx5bfbnrYUd0zhbhqo8fmnfz6UipYq2pj932w5yi3Uflf1', '1554959275', '1554970075', 1),
(83, 'u8Z9WhYauo3Z1dm6spcWcuZf4aWW9wm0jco7s7Xahyz9yWn1vYWc1tn8aaifunbVVY9vaiY6YkiiVeg33zktY5Zz6tmhx3nduxz4', '1554959956', '1554970756', 1),
(84, 't1aU6ZodWxbaox7VcskwvtbV5c1z03eznpa0siWUsY3xfojqfsWrVUbZcdqflfk13hqn93tfr9Zkdd8f6213n7csUaag1pdbvXnw', '1554961195', '1554971995', 1),
(85, 'tughtim8rgu7r2iZ2u1j935ytUV6ri0hdvpxl4x8g0dr6wXwc4UwwmemmzWskgsZdV3bydea7dpzsnWpbcidWqphwZn2b4kWf61s', '1554962516', '1554973316', 1),
(86, 'xzbk9zt5sjbwu42l068wwk0ZjVpZcdvucwbogjw5uosUk3x9fxsod9ywsppoX3czUqtaVYxqquncyvjUfqt7fqpttV7e9dXwtc7u', '1554962981', '1554973781', 1),
(87, '8xjr2wt0hvmyvbjiY2xljybr802jVZkWk6ghlYdV96wbg52iWYqhppchibsf2fz8xtjezcqhWWbb6Vzigju96l1Uqvdaq3fz5b0f', '1554982778', '1554993578', 1),
(88, 'ZUtszivy04emw0cb8vtng8ehgUv1xVjbn6VZ26gd1smvm27jZntZ22xeVymsdWpqaac3uxtgiyppZ5mmoux6gvic3Xf4VrZlpyz1', '1554983140', '1554993940', 1),
(89, 'wwxfaUeV6d5pi8W7mXv6kcpx5tivodaoYaauyqrWre9bsX8c6bc5n3UvfZeoypq5q7y9105wgjvY4wkuihmdis599oak87azgagj', '1554983358', '1554994158', 1),
(90, '5w4ZzfX8ki09zm1kc26thts4lqyidipqW442Ymfgsayi1vzq60bUfjxwdwWp0vxk9grY0hqZc1axy99Xbsbfhc6mUqh5iy3cmzxp', '1554984678', '1554995478', 1),
(91, 'gyfbaxg4euxhkae294V4ixpo6vnwovtnpnrtzatlyU03z99WVviwubh5nc0gmhppkaiyZZ7q48U1VvUkrpeuu9ZVV9kihvl3arkv', '1554984969', '1554995769', 1),
(92, 'ilh2fUviUakpmf70vvv823qztpgU8VscmevjdeYcye0bakuly18t72mugXwgtczjt3Vasfjbey31Y3yffk2vn7yvj1i9rv08joVb', '1554985526', '1554996326', 1),
(93, 'clZvj3jgqhjmhcdt3absujU0f7vY2q8cv5Z31xUgaput98hw397m45hqXo5XYc2W296baU4rsxkW374ht74XZ25iYr7ZkvUXuv55', '1554998036', '1555008836', 1),
(94, 'zhayws9U9ul09bkuj7f1U0hf3f47edWc8buqtv2oWhnt7sX7b3ne9Z8Vnlmk68c9ssxnfhbysc63lt4svY8osvlk7fnX3c2Y9qvl', '1554999538', '1555010338', 1),
(95, '9dUu9ZwypjwXY8tv52wegYzgY6WlX91hsewhfhvyiW0t3Z6W23pw782aUzfZ1xfm8Zyxwc17hc3oybtoXW3XtZdlarw5plvcfc1h', '1554999633', '1555010433', 1),
(96, '0vs755zVdpZyuzd6nYgnbeW97b4yl83Vb3jjl4gjW1Vtmib9X7Xwptwpzi0sXWuibn31iyzy59f1paitqrufgUYs2fvlell1Vw4w', '1555000270', '1555011070', 1),
(97, 'Uf1f7mW0i3wuep9yY8gn21oy3Y2pzqjlbzo34oo4uczq91ZpY9Z5onYb6re2xu2YWW0r65hvfUwa1VXfuxwZUk8lc2o4zzrVgffn', '1555001861', '1555012661', 1),
(98, '8YrXo3wk5aokvyv1ty4lZW0s9j15nat9gWjieY9tvzg6zhzts0bgael3iuxkm0p9szgvdhZdcttisx64yUhcsr0y2px2ybjkx04l', '1555002591', '1555013391', 1),
(99, '6gogW8k8Wqu79vmk7ddqw0gZUh3aXjbnvW20ppZwfm58v6p4a0rau9fYg1o1dpu62frXiw9zww7n28ffi5moXU09X790sos5fqUl', '1555003269', '1555014069', 1),
(100, 'loaXxrr7gV2v6z0gZhfy3fU2d9UzawjWczjw4z1wvuu1zr4wU1wZ6jXbyswt0mecZ0dpeu8347p3wml147Xo2Xx2ajZU2Yp3luia', '1555004634', '1555015434', 1),
(101, 'barWxn8f3acVqm7sudZZjypww70m8sleWi2VXflwj5W4fdr3XrnU94eYo1kgtfb8Vgg8cjlrneiz9fh60q4tvdlUp8YmolUXoYUp', '1555259070', '1555269870', 1),
(102, 'a3zvfVmlX5w77c947rfxWjWZheUVivq0vam4sjvo79Z0Yw8t2X9e1i1U6m7387X2txVahk6kflo3le6sd8baXq2W4ppUvu3ucgVd', '1555302311', '1555313111', 1),
(103, 'bm7Xxy8maqZZf17q1csldldzue53cm3UW8awryYoqqccXj0j7mgXapZUeWd46s79pjU0Yl7kbifx4Xubpor3t1sdue5axnxp62uw', '1555302667', '1555313467', 1),
(104, 'g9jmeYpmve2guUdmjyo2brpXUsti4ZVr8kbbqxdzbVkZnt60YVYs9dfWah1kemnywu198vand84qpdXWc1U0U5jwzd9qn9y93UyU', '1555302847', '1555313647', 1),
(105, 'W96ggpupwlktZieat4jvs20UwYmuq7Vu2mrwi7XlhwYonZsc8wxl5j83y4Vdubzryim2hfh9kVbwau2sYtphgVmVe9Z5e8f4xc0t', '1555302999', '1555313799', 1),
(106, '23ZXYmz37kfzUyZxqj3okZ0zdburx8WtUtrk3gbysyXcZm4vUgqfXgdt4vkpj4hwb2uaghfkowpvx7Ubeg4ioYwukizY7ykZc7W3', '1555303156', '1555313956', 1),
(107, 'mmfZzvU1vWk64h93ts42z4p7fqw11gkvswqdl00khw0U68m1xmgqjpfhrk9V7usqgu7UWWzbik6VW9XgrdllteYyZ3lllyt9tiZn', '1555303627', '1555314427', 1),
(108, '6mtuWog7Vbws4c1kbuglYkhuVYfzYW4Vsb1m9YzzjvtYoj4t2oycv1etyXtWVtWm0tVs2ftofdW9zwjrh9ZZufuVZbc832wtkmx7', '1555303727', '1555314527', 1),
(109, 'c7voayqp4fnfVakc9tWcrfl79oayoohXyV2W9jvXdlfqW3w33VsskmmcW4Wdkdudkjz1Vpesg3ys1zv2jsh384yw28jcfX2l3vdd', '1555304424', '1555315224', 1),
(110, 'uZxV4505xtXrX62kn9fifXjlqu0l2UaledU3e7fvrZe6ggm64ybec3W88Utg1yY32na39tw3VfxivXdquutrho1r6c00Ynnwigtj', '1555304712', '1555315512', 1),
(111, 'vU3msl8ZfaYh1a565kaXl3yw98dx9Yvso2Yxesagu18pZd5Uggw5s6d8WieYrybyvVl45XvfsmekX29fsiXcffact5uqZc1gh6fm', '1555304823', '1555315623', 1),
(112, 'zZ6obYsladz5nVp277rlvoYwpehYwcd6qfy0sxh3gd0sxz4fsW6h9yrd1VraYlhwqv1oiyvU7Yv72Umk8zt966ynu8nUng5ryrbe', '1555305106', '1555315906', 1),
(113, 'oUvZudo9Vp9g7ZfifUkk3W3yt7obYdUZsdyZwc7VuUUfxcgxjY6g5YWqXuW7k4k4p5dZxcpVeq7xy4xfl5qihUt9X77ccZomgker', '1555305178', '1555315978', 1),
(114, 'at8jcc6v9bY2U9U88nxq2UZ6vZgdmxy57rqWZ3h9w1Vg3UhuimXak49v0r2bmd8mlsrupcxwWum9jyzYdmbxdqnxpjvlwpswn95x', '1555305218', '1555316018', 1),
(115, 'kkwywnc46xramz26fsZgmicWh6Yhxtm2mUpxpgvWup9h8Wt1fnnaxX4Y2V96ocv2gg0kk04gfY6Xaodu41zXbbjseYVfl10whnwq', '1555305299', '1555316099', 1),
(116, 'VdivwjnUZ73WXtmt8g18c2dn50rg0eitq53nu4Zqj2dpYx7hV4geaaVk9W10klrpwpru1XttwlXndVjdXbmda6psitqdyaon8o9U', '1555305366', '1555316166', 1),
(117, 'qr8X3bkgVYc62pswa9j1ss0iXWp9X2u8aWsvrfmtdZn7xUcWzyUVtvt2ljtW9yzrl3b0vgg9e1oU1Uyl6nXx8UnyuYpdvu1hXXxz', '1555305662', '1555316462', 1),
(118, 'ZVxypugkcfWZyzca76c91rU9stYqWfetysm7t0fZo8oazkvgbn65bvzklc71z6dyW8vd9jlXiib90a0lkUv8toa49ghcpVYzeoat', '1555305844', '1555316644', 1),
(119, '1sWZb8grmZZWnln60flegtXiv9iuvfumq3otUlgwf2VkxzXes7y1ey4f49sZhfu1prgo3gZXz2k6zXU5iwc1i5goupe3uZoXasYU', '1555306913', '1555317713', 1),
(120, 'Wodb50zfak77Wlmekzf55ot3UhbkjX4mjadU9YwWe6cn8XWZ49p7mocrz4Wk0j1aY181YXod0vq1Yx009Zoa1d6vcp0sWVgeUlt4', '1555307002', '1555317802', 1),
(121, '8lwjqnhpe3irb3tW4186e4wsZj3vld67WYor6cXqUrepU3clko8u55uovrgqXdg9knZue8651u3r8djws4ngdesn2ybxiU1VhVsq', '1555307705', '1555318505', 1),
(122, '9vingWv9ymsf4Vjptt48sbiax7k5Upkz5hjfwkr4w5qkxmiytk0U26v00hhbl3zp4wr9q3kb3p5ddqcUgv16snbgVv4lU5uw6U79', '1555308871', '1555319671', 1),
(123, 'mpco08Uu69YtW9pv3ung2momlwjefb7Xa1qu5efbeh77r1vZxtlk5tiU7reuko2f8ehhWXzgUVm8ZvbzZj9gpVx9Yyrrkb5dz1jh', '1555309110', '1555319910', 1),
(124, 'Z1UZ50eo0nk1Y7cXn7WXoep5t6r3Utx4aWVnojbj06maj7ybXgoo8vXrtssbafdX9vxrrvcvn1XvUX5f6799qW2sj6Xkrn313d4j', '1555309210', '1555320010', 1),
(125, 'Y5guy0skZnWfeYmXrYrgxwod4b5s42y2ZtVo9prrvej3oqmprp86Xxmua41Z1bhn3dxcc8umshUUmni1lvnozyl6hnjzknapsgZu', '1555310597', '1555321397', 1),
(126, 'UqYVefZ4XjczZ84fmakbWuZVpafr3qmeeVyycy5twvotd9asrftaWt2ur1l7qzxZZ08caa8neZi8Ue8goaYy5jaeXufl2rWfZak4', '1555310719', '1555321519', 1),
(127, '3crllixnVpwUlx9pd9V9j1f7x2wtaZfusXYeb0v02hx0kawbg8nc35b0Y3tWn22UvhwfrlyZc4WU8nWUzhbt4slo7rzZbZy3gj1W', '1555310869', '1555321669', 1),
(128, 'm7ir6ompzyuezU6xiXsctjh741VYnU4g3q5tr3d995206tklUY4209ba8fefg98uZ2um9rZz7Y6YYWjtpZ3r8VZ7rnsVbqhflb9x', '1555310986', '1555321786', 1),
(129, 'etwy1UxYqkiWtX1ovVygzchiw4hmqvvZplyVgVsY498fpzcgiqys4Xl9qcy2wkiloogZe0h12nv0slrax79jm0zayXZxZimqYhs7', '1555313782', '1555324582', 1),
(130, 'ejkaoXvtk44kvf4w78ubgUZjm86kY3919va0lwzho5emUf52yvwWvWXr7xZhkj6sfgqsxaijmUo8z1ope3sudc4rmkvW4yhXYvn1', '1555346249', '1555357049', 1),
(131, 'yVgr5ffWV1ydVlkiwXke2Wqekdwu5hhgU2hb2s954hx0ih8wZ0pW9ifUma4fuwv29pbWuhna0xm50Uuw93lsyt7qhhXU0xwz7vb7', '1555346769', '1555357569', 1),
(132, 'icg8saxjyw4X34gftmXwi1irYnqncZqXZ8eg8Wwon3Vb50d5Xek4i99YpnZeZthfdqr5Unat5kVsuV6k6kV7su0YZ3vZ2VeekkpU', '1555346867', '1555357667', 1),
(133, '6Vgi0fb4eU8t8js3tVvjkbUtwUvdl37aehXexhz8kqe0V2YbX26i0h6n48in4vzYsXlb5db0y581zos2X8cnjudj8eWwf4tbWr02', '1555346982', '1555357782', 1),
(134, 'fqc2a734dw6na0cW3vX1tg0WlfUw00s9bvb117qplqqZuXX87ZY49prgxyWvcVfh5ooku7fplZ4jg09sUw4b0zbfr38p9typYZx3', '1555347335', '1555358135', 1),
(135, 'cYv47Umc1Vfe9xp0Zf8u9W8gklx7nq7prhcouykoru6tqYZt5etdqem84ql95ebYrqzr018lb27ax4X4yxjcabaws7j6X393bevz', '1555347443', '1555358243', 1),
(136, 'ka0uY3huvhepu7Z2j6acz7W5WYo3ykb3lwzads3nqehe3t58om5y1gU6byw0a15WWxg8sujyx7tVjp13Zboywrdsk6m03Vgxpo3c', '1555348012', '1555358812', 1),
(137, 'jcwfatci9ZXjw3Zwr3xV6hblf9Z4dz5fc90k4cXkeel9sh63hvzbyjVkywt8X573reodvujfa1UtXmszloh2rzwngbhx0m80ilVt', '1555348277', '1555359077', 1),
(138, 'ze1zvxVhlwu0c9rxocidX82sW9jWefomUzjvftgczruY0ax5X10vqz3hnw77cgeVtm3lyoZYZ4u29go17j42ytcl0Z60c1ZvVnsb', '1555348455', '1555359255', 1),
(139, 'ofpxWZbWlViyZd2ltW7U7v59b9sesUdx5zwfUs3g53d7rk7yfh5yxvifWY1n3uloU6m1iXwruhem2ymd3abxp7Zecuci3nc0mtwV', '1555348591', '1555359391', 1),
(140, 'mWf9voidf3nbX1leWaw2iVzaxg9ZWV0yq50owc7hu7fWbWrazYiU69bfmnnUVp77zUpm3dgrlqgbZ8iyxqp6p1qkozwut9lzfYcl', '1555348733', '1555359533', 1),
(141, '9oxasi9v54xkrV8w2iZx3cdYmgZfe72lnbXrd438u0fefy1lyiYY3kuxuebXW6Udh9tbet5gZhXpiZc9n9bY5WXa0tVe5Wevb6r7', '1555348849', '1555359649', 1),
(142, 'V53kwaktiUuzg72g18y8qzhvpolnwyWiXpuZeq8Xgo0y69zng1w8hetUs80ymYqyj8XwzwwgrlibzlZq7Ux32vtzrwXm5Vod8UVv', '1555348990', '1555359790', 1),
(143, 'gwrWegVrl3nfagjyidh6yarX1Vowt4qWqpfqZ21jvafbwh224eiUp502emjjbtjXX493lmW9569sYalw0cd1Ufen4rwhtZwgibh7', '1555349102', '1555359902', 1),
(144, 'ryY2yphU29t22k8ec4gnq69oa6dl3X8a9vt7pv6hvX9WmdzhmxagihtccWdYo14n6w6mWm3dx4urgqwythjdwVl3n6YfU24uob73', '1555349729', '1555360529', 1),
(145, '9VVvwocbypmxmmnYr20a1orgj2nddxtp7xtuXanfWwqpfhh1425njtcaUr2UbqlettzsiwuYbq94cr1z5Zy5Z8xdX4rosdi0fnwu', '1555350624', '1555361424', 1),
(146, 'WboXwWvbYpd2pWlyZzip0enWZdy29XZqtgnhUveZyVVlZtumhh7y8srymp194ikp0rw8mu3o35d53Xpkbyu8ivY8j1wW8a3mvuf8', '1555350939', '1555361739', 1),
(147, 'rwya6ic1hdc27suqxx3481z297pvymw1wvZx83lxxhu8l1t503cq0l60kVmi3uxc1ymj1l7Y0j5uUZfwuVYti5p4bjoi6blghqox', '1555351300', '1555362100', 1),
(148, 'WaUouVnrW9vYm4X5f0rrvyeyt3unhYh0mur7k1frt0b4Zawbiwk29hp7d8nh20mu3Vt8azaidbhs7fd9Vsizm8iyV09Uljfz4gii', '1555351757', '1555362557', 1),
(149, 'XojVkYnf4ysUeVp21sx1gmc65hm9y4tr1awnm4Vb1ros2zuUg9ZsmuYinZl8bqtiVsWvsZhsfvef8v2ZuYvmVhUra6Ytyzpwliqo', '1555351964', '1555362764', 1),
(150, '5i1yi2UUgu9cdhcjqpUd8spuYux3d3edasx38Yebgw3Y1V9k4wZbvzerhVlVdtpoYfil1mpxU0m8tq7yveZ3ohnrYwfm8X1dl0dp', '1555351998', '1555362798', 1),
(151, 'Y7312fcejlszZvrq7wUtsgZmkv3g1xk87van4ZZohZas0xzVh87xhcpk5Y1XZ1dckbysWW62x0cnWk3f5kv55buidmWwfvxe4d5X', '1555352285', '1555363085', 1),
(152, 'xXo13tyWuxeygWXwxgzr7lwjeZqitXzt0r22YeUa3phXsrhf60sleftoatY40Yf9wnhXkj48sliZZf8kcqXg5dibYX368c9W1Ypd', '1555387436', '1555398236', 1),
(153, 'rU3gnieo5oqw0b1hjrucWcYiU4rvxyVkw90384hpsxjh25Vvu8o00Zshxo0nvd6pkf4a7VktnigekZdlfpf7w2qovdtXqmYbkVr0', '1555388145', '1555398945', 1),
(154, 'ua42tqzXejrp26XcVik0g16nsz5jikgUUayozxjw79yuUdmjkpjz9ucpugUp90tqcU0x6naolVXncYaxbmuVkwyYd4l1j2pcy4u1', '1555388445', '1555399245', 1),
(155, '8bxjl4jbhb7uu6wo4tx3sc87wgjqvh4kZpnsqomwzVe9yu8hd0l9c210mdgion6qWzvmnX9V0Wk2ylvl9kdxo4Yk7xwbWpYpycey', '1555388601', '1555399401', 1),
(156, 'qgol2Wig9zbo9smZd6UjkvZq3unf1VizZmhw9i9nh9Zmo2es3yk6XVX43caVh96vzwy8lX1rn9vxu9aWhmvXXU7eufzrz4kxkg7Y', '1555389774', '1555400574', 1),
(157, '2piyYnq2hxf5la3m3Z8f7ride5ze2ybafauv66Y0UWnw455jqnbZjxnloarbgr5Uzupnz5qbvrWugxnykvoW8rr1mo2zij27jt3b', '1555389866', '1555400666', 1),
(158, 'j8xxsj3YrU7m7vcqxUcr8srg1fY95ggqxnhnnpdyVl3Vj2nhup8Z1bzauYU4eXXmzZ5fwlvs86otjvgi8qvms83xbznc12wgZwbl', '1555390071', '1555400871', 1),
(159, 'nnZ1hciUonmu4izkz0mslm41X69n4o4kr5pihVe56Vibft9uslZrWe8wuvd8o1oi8n7UeXuzeihszXzqUor7yorYXVoYfZpp2w3u', '1555390149', '1555400949', 1),
(160, 'Wx0z0gZ33akWgi7wft0oljp0sc4o058f7r7tvheoUmq2mw1lxxj10Yynwet9Vznko0k5ar127d4p3fw6Y2mmzumi5Xfw7iVYtdkp', '1555390437', '1555401237', 1),
(161, 'dctdvs2pVgnlXfYpw3gYs7o6aoaUfatrdb0qdccgwbxj96qwpxgljUhYqWmtvbk8bUXl0mVtW1r659U25rayvgqh3fml4gttxUij', '1555390581', '1555401381', 1),
(162, '9iUqekfVvzbaX824rv9w5tUk5qh585a0gh34WpY3Z2eb1zs8Xnr28YyiWZweejy4bd7yzp65ndvniujfvUxu5s7ew2Zu5kcdrhcU', '1555485586', '1555496386', 1),
(163, 'aycvyc2fzpnvbu6pbX376eeyY3WnZ8Xix1sikXirg6kg3oxox08Vv0jkZu9Y3b3ZUrZe2r0Y9roqX52ams24hj9cn6wVUcsZ4adb', '1555521430', '1555532230', 1),
(164, '3vo3YcZpo2xuVzevglnsznt4Yj7y9lckuqWhoUsoxzj6Xa2j0f29bYYuuilccU3kasn8q2y3UiaiWa7aotnWb6iob18WYift7Wyd', '1555527534', '1555538334', 1),
(165, 'Wofzp5YwhW3jwXU8hqp822fmbqkbV4pWql3XpmVkvqodU017h8zxwtVX22v45m0czqcbliawfgYuVmdb1ygztbilg4WoUitnXtX4', '1555577567', '1555588367', 1),
(166, 'myjViZt2ZU64i0kf7nm6Zt9Vyt7c0Xyccvod4UW6bicyzpWX25kU8fjh2v1kn2d89xiulmq4Y0YZjswwXUemvYWfm8mgpXuw3upj', '1555577733', '1555588533', 1),
(167, 'bdompcgVbxs2p6cg34fY34vsqru0cfoW8f0v9yZ9p741mWhWrmaa9fjsfw3067WXxunem60W4bVpqbqlVowUyiollcrUzZ506npq', '1555578605', '1555589405', 1),
(168, 'Zb4YreWUb6owZw5uWw2n2makwfXU9wk72frWy49YyqlbXb77dYVz6us65bp57iliuvzgkts99Vrvgi0ZU3vZXsYeyWlqVY5gwxnp', '1555579112', '1555589912', 1),
(169, '5sY6x175rojypomj3uqik22VtcXe6ru0q5u5l24y5xpUeuY49pw7a9ofUwih7YwV3ZclVtvcz3ambtvwzujyp1ZsiUyYYZqi5Uts', '1555579250', '1555590050', 1),
(170, 'tkj3db7dhrf9e2ut5uljmZyyhvgd5Xrdw7Vg0ibffurZsn35pldoblZy3u9kgW0y3zVy5kunzX0aZ1W406nppety0eymixcbaW4b', '1555581911', '1555592711', 1),
(171, 'W43y8c3WZp9mcd8cmc50gxWw6Wyfc5V582htdwrf8ox400eqeagxYvw28du3Ymomolpz57n7jtnWizY50akb3oY56zjnspoW03Yf', '1555582317', '1555593117', 1),
(172, 'Uto8VnV6xWn2as5n3YjUcdghbzsu6hxxyc12YVh5irrrVW9zhl6ds3V89rp0u4hkd198aimWupVYic49Y8o9ckl2U1wtrvm8llq1', '1555583161', '1555593961', 1),
(173, 'ywaZcsnaqa4jeohehia5k2ar2m1ZzhoioolpUntkv9sUtj7zkVY2fgVo90hh0XWriX42Zg3iasa5Xmwruh7vpeab2xj3duWklW8k', '1555583613', '1555594413', 1),
(174, 'eaxlW5zqbzu8t0csVztx1c3m7xYZlU65t3kp6yVZsdVaahhkXtUu2ZowxUUnUaWwYXquj2tm4ioVvvio4z8xjc3g1bWZd2u6wn7u', '1555584213', '1555595013', 1),
(175, 'iqct32f5hgpXjphd0jd43Ytx60q27y8ntYt1ipeizd4jUVgd6pdx0tZp6oct0bUulxaoYb7Wgfxy218afY17ZaqV67cUYX1ie6pl', '1555584420', '1555595220', 1),
(176, 'lmy96gbZ8fnewZcammyV2VUzpfWwY98w5kyZZwUVuf5ymqXmcu4tua9inm5g62j4cbdippgykhlXce3mazZX8VVo6lq0v0Z6Xc6f', '1555584914', '1555595714', 1),
(177, 'eiZU8fbccU03j24ufoqmhi6rswnW4ier3hsXkqU7jsabVqUd1jdffmvxui0lcw0gtdzurrkfxtjtnZ5d5bza0gda1gtm51tXgta3', '1555585004', '1555595804', 1),
(178, '3rY8uq1zY2U3s5el24b0i1Z6o7c75Yddkec6w3ZkkgZYY98i2i38ewjrVkszZv4hzpgi7yxz9f3lpy7965w86bUUUocvh068leiy', '1555585240', '1555596040', 1),
(179, 'gtijxjgftcjtpodq3Yrg3pg15u7qYYeYag0e0dZvfxqzj1ZaY1xoZxjqo0wewk3fV6oVtcjs0vs2opXyqW1y3Xso6YWyU511o9kc', '1555585460', '1555596260', 1),
(180, 'ss2jk82h0vki6e4ygltmiYisbf2goueV7pk1avnVZbrfl21xjj35lsziVy0fbpqm0knn8z16sfZ6V8lg3mbXZ5Wxtuy6ap3Y84cn', '1555585649', '1555596449', 1),
(181, 'Uman5Wkd1q4p4qUYh1qt32kc7rufxX5W1m7uma7o5z92U7cqyx6lryu2lrxjsjivny6fk147pVqby0pxa2adqjcdX9jzxxiyW0ZV', '1555585833', '1555596633', 1),
(182, '42n6tgffc9Vaca7lxxiycu7r9ve2zUaqdn4riX81Wnx9gvxncipznrtf4x02Wn7hrz7gkvxbkpcVgf4m644pmgiutjy3faixwbeU', '1555908907', '1555919707', 1),
(183, '1lW5ddbfb8fbpXUjiqhXllk52lw14Y2q0lpf4gzVavbwj7Xsjv4g36nZrW6Z4e2Ultm8nlo90Uxfl00n2Y52s58vz4iVYZye4kzu', '1555910504', '1555921304', 1),
(184, 'gXkobytorfkZqa79www09wU1lup0dm5p3l1Xkq313hfxohg94eg2hcuX5338Vqzf0vqiu61hVc8fsdW0vn1dzw9jrgqv3soohZZj', '1555910718', '1555921518', 1),
(185, 'lr7tcYs92i3hlcmfocyuir7hsvttYynpdqbf0wy50fptZ1aeeluwtdwg309XivfsZtU2ugu9c8l6pms7Xez8xxjUsy1nlzx9V3l5', '1556083446', '1556094246', 1),
(186, 'owh3pX3rlkbt8yhcoV2jsi71pynqo389jdyvUgio6W7Xtkut98idhinssVx13ef97gZ6iUso16V1iufV4WXrU5kWr9ltceoW9p6u', '1556083625', '1556094425', 1),
(187, 'dfyxccu7q4ttzbparwwWYn2pzY9s1Z46rduslschc2n8bW3zfu3oZt8schbu7yym82f0wgn119j8ckVst8j7YaacWl70sulYc7wn', '1556083754', '1556094554', 1),
(188, 'reaUY7UvY8u4i8Y2osfYUgpv6loyp8Zu3ixzqjcn0fa6z8r00c32veY3z858m0lwhWVUm4ucsmbss3lbousov0w8n2sngvvsqUh1', '1556083887', '1556094687', 1),
(189, 'XgtmZYckjcoxWx5dUc874tU4g7vXba4Y358XYnY5e5b3hkyy7cjwa3zZlZgyY9kuW2iifhg4Xmo13ve8hVtp51cu2Uz42tghWdXW', '1556088530', '1556099330', 1),
(190, 'bczw8zuXVeVsugtl9p6pZzxUdz1e41t4mb93sdZUkup228afdW3Wirw02Uzie9tZX5iuzzubV1oh0W0U6id7cx9jju19uU2ddgyj', '1556088776', '1556099576', 1),
(191, 'drr3qv4bY6keo4Vft5bpxW9pjZY4nmczsZtd5jdlYs7rXVkx52Wef2njlnzW8wuitWbX4XtprUzrYcdmhVlVn0U0ndb5jqgv94zc', '1556090931', '1556101731', 1),
(192, 'xhh1Zm5pnV03b642qxupe502hZZnrb27Wu0fWlYoicwb3mYjcafvvovcqfYXxlYp3U15mg60W2651ch273f0Uf8ViZ58ixl77eb5', '1556091308', '1556102108', 1),
(193, 'y3wn1bobfgyVcZ2ms9krknioy3ZWnbU6dewZpUbyl502ViwZo81j39zbnrudnluh7fVk9yopj2wyU81vgXYZW9fl4bwejfg1a1y9', '1556091442', '1556102242', 1),
(194, '99oj3v1lnaZab5166rkh6mt1XpceeiWnq10itVp3racfvpvqpXa8mjtYchbirjot4vZudpcfWqtnniYpsbaU7rzgb7yyUgxao2gq', '1556263101', '1556273901', 1),
(195, 'xU2bl1kwdiyZk6ydlVq29h2w0Znrn5e9gjcf5WZqowz1ndv9ydyrflba14cmq6bx8homw7h9aU2Zy3sksc7fofgyVjzhs2YmUkyv', '1556264372', '1556275172', 1),
(196, 'yqa7Wvf6pxZykf1efU8da9iUhU1qpln7h1elqyafix0mwh9ieq87W4lc71Wo8gcpV6z4o51coszkkqlp5yq3j4lgzlehgpnrmj3Z', '1556273764', '1556284564', 1),
(197, 'wconVYYxi7Z9sk80wrgmelkZY66X9c757Zi4qqxvr7hfm4wYbYZw2uZmcwzrawsdmsUof7sraowX1pfopnXhf1tqo19oXpyllzzb', '1556273891', '1556284691', 1),
(198, 'p5rtrfx6hVmdmdhgZkw19m33n3UXmZ7wgm7bb28oa0hv1adk3d1Ygmiapdmsrwe0kc8eafyZdl1oriarzV7nXYVV4gsu6fljrfug', '1556274303', '1556285103', 1),
(199, 'oXekZ7Zzbstn9k9Xi4Uy8xml0sqoiVdzfvdtVlgdce6b9l8xvpepfbeW98pvgdu5voogdyxUq2lY6hdhwrbk88loeg4ggvb9Wv9b', '1556274888', '1556285688', 1),
(200, 'qyvbmv8yllu7Wpjw06Vtmcp649ovdq8VdVnXdWq1uw4et3gjnqXfzuld716jXZc0Zfcmvwk9VdqgYo1uyydxjvYqp3xZ19Z6br0u', '1556275161', '1556285961', 1),
(201, 'vxx1Xo9a9yr1ds7dco2h8Yrhnacj0a0gt51mV3gw29te1f1h7utrw0Xgc4Uqgfde1lqjhfg0q42XbwaXlvxlsfxjkth7t3ly1uW1', '1556275254', '1556286054', 1),
(202, '5wwx3vr9n7Zuk1cr00fyy9hmYexfehug6m2bxsizkweVXVg6zn16suZXisf52n4i37317YjohvaZz2zY5Y0v3gjaWotjcn9XX0dW', '1556275880', '1556286680', 1),
(203, 'pphsV4pn28wiioiwsqhW9UYzua0kxmp0wg7lnv1fj2so1WVm7e1Vl7qZyqtt1oVon6dembybcxhuxuZpsxUogh6n2gnUobk22hwh', '1556276063', '1556286863', 1),
(204, '40llsyznce7ZUkZWqYoYn1eVYmclqs7aqZWuVackUnWYavXxWy8Vhooddcweh5ykp9cxUqej67rhpXvXl0g1U2qvdYvVsekexcpi', '1556276172', '1556286972', 1),
(205, 'UviUuYltrlU1yYl0cb00tr85h4l4e048Zu1Ym10Ul8sY8Xy8ziUZep7eds2V023bjf7xwl4oZW8uW44Yr1ezZ1a3irUuxUUxueo1', '1556276310', '1556287110', 1),
(206, 'v79xelZltYXl1w0f8ypWw5kzqz6V5h6ytlxpotZnf7Zb87quxmnfe8sZq5gWcb2uaf1W5Vlmigjy93WZ3v3f0ssYUs2UsWivy4YZ', '1556276409', '1556287209', 1),
(207, 'nq3ls9Znqmtwhrx0i8fwX7gqxd0i75essp1V0tm86mUrsxsravszkcjcbZU6hnq1lin238zX5up9oZtktydjje4tqcojocqjauY8', '1556276525', '1556287325', 1),
(208, '3pxr5eppnld0V6kZXlZru6ncxgsUis7hVm177rhk25nj4nvUZecd2bzsWljfapz5jWvi5Y29p65jl1fmfwzfXej3Zoizxs5d9vzi', '1556299007', '1556309807', 1),
(209, 'Ydppv6Z0WbY35jmhz6ylYkX3t3nfwbtu2uXza4vcm3nmp16ajtidycevZZ7s043wxn0eakjZ4YhsYsfV2gmrZ5s80v5rVyyvfwgY', '1556351205', '1556362005', 1),
(210, '0ikWwuX03yspxV9VYx7ysV45dq324kfeZ4gVbhXprZZhmsikuyqZlmprtjwm6ma63x98W8bauWmcX00lzrzxa8tmozkaib2sYU4l', '1556351408', '1556362208', 1),
(211, 'z1p23qYnjZVpUktzfqW9Wsifw9Ux9leeV6Uiyxz5rfU801wYapVigp8zcr2x5mze1ikyUo8x9UXhjUk9U2rZYyx1t9dwin9Ynftv', '1556352168', '1556362968', 1),
(212, 'qsa8wlriugZmzf2dabumXyvcUjrjjfvf4YgfzcgtggeXe2ta932Vk1z7oX2kiuxlrVVkonre8icun9ZXrncog0moj2tk1tugv6vw', '1556352295', '1556363095', 1),
(213, 'emmxjWyuY3uyoc49uz2unobzlulpvd5jZ86Xy0hZ0rr2ch5jX1woefxy1kmgr5fqytfzpYhoXchpckqenbyjWijunqYse69gYosu', '1556356454', '1556367254', 1),
(214, 'pzYsyvkypowzY4UlcVrr6fm3h16jzY5pauuvpXZapuppYpc2ngjpebZ1xb0cuoUWendlVqnybxqfft8qnnd7yrb8k8425699pVXh', '1556361272', '1556372072', 1),
(215, 'q08mrmt2UUVovm822jYzkh24mxjV1tv6vzVW2XhUdqwV41ua1tY1UUzba8rcZ14bthfVq10Yqa4enX9zkfe9VfZmY8YgYoqi2uuy', '1556362980', '1556373780', 1),
(216, 'W6XiUl175u12ky7j0bU1wzt1Yv3hYqkZ9ucs8iZ6kzssdozdxkyll7atq28tktqyxWxv7b9uxV26h0yh0yUtamssrwyeuzre0ggx', '1556363120', '1556373920', 1),
(217, 'lWqfVrcX64wWz542Xkvvh5pXvnbrilZd6s8vqYtl7b31kYxUa7nZaw7W4XlWhmW3gjoa90U3Xh44ynpdeZg58k8iVisd7xjZ0Xq0', '1556363324', '1556374124', 1),
(218, 'w2rZh1r5qfzZfic0hlwYruU1Zrc3uYhhzackbi33i1teaUx0y3gjelzvhrrX287W093oebdzq3nX58yiqgW7Y2eXkvhctWiht56d', '1556363401', '1556374201', 1),
(219, 'cdwytXy6rehs79XzbY7r2Zowq44h4z14ncf7enslm8etrVn22XjrlvWU7ll9riVXlr072jzc7m3Vahfd89VgnV3W5hVeootx3ciq', '1556385289', '1556396089', 1),
(220, 'sxZzb6fg8s1mlY2rtz2Xwk6baws111fzo98rbcbja7vlrbvgf9awvnq9ggUxzc4Vau83suxzbbofywql1arhjZzabxVY6yZmjW87', '1556385519', '1556396319', 1),
(221, 'pX1rsZ6edUsxpUvrbXaqnbga0xYf32ecoey3apgwc1hqltyco39kXd27XZuyVphgqayrazVvve11kdgmtZxzss1kdywWu2eecdjb', '1556385701', '1556396501', 1),
(222, 'Yf6vxas78Yn5v3h3kf8Y1dgkqwWi4oaVz5i413d2uUoh5paWo7uaeo2y4jUszkn4env4s5x469Uu3pymns5tptVrdhpkouitxlb3', '1556386071', '1556396871', 1),
(223, 'jpa6gyiVqUbblvaVgUWi4Xlbex4ngma5h26o25zVuiWxUt1q3cfi1jclm12chuZ8oftg6eodrvZwz7o6i124rVghovbhbp8zg5oX', '1556386139', '1556396939', 1),
(224, 'X4Vlhn2wqal6bblfvb0lp6rz4bis2r8oUW75bs707WrcXoXlrsrcZfzyp31ZmofeXVz2u1c0q5Vvvz1eiuxiclfurwoY1bculxpv', '1556386439', '1556397239', 1),
(225, 'napY0n9eV23WqxypWfhglkXq2wZfu975YUnZv3hvqkp2mlu8p8afVoxZ90byVf1Y5fxeth3Un02o0ifzoc9cv0w4b2U2k0c3u6t5', '1556386893', '1556397693', 1),
(226, '54l6o4lb2elYsuolt80U275rdvu8ZmU9gce2kslfUn8uj5jg8Wlxs2YWduXplc95sp0XZt5hyucd45aj6c3VU27wa0i50Z9yeapr', '1556387224', '1556398024', 1),
(227, 'a28beYjbt17VwWzrlWhvUxsdkkzqi8913a21U5tWn2i16bzezvecmq9XYezzngyjymbpuh3cz1rysswmzhYnl05uVZ6vV3h43uor', '1556387494', '1556398294', 1),
(228, 'ld37vrst604Wyf3XmqpWYWfwwcziieaVhnW2hjh2UZelfqyWUl9lb32tkrceU3ru5a1vYa0W86X4Xmzv0uxplp61bb38klZhXoah', '1556387613', '1556398413', 1),
(229, 'lYgikzjazxr4o6dr3ig47YYiszV5emp4gelqxjVhm6iefg4oy7f4wfzUrg4Ylg4nZh9zjfhlWjeb0d3vbarVe8tUgu9Zue6mqkzi', '1556388111', '1556398911', 1),
(230, '91re7Zsxmt2Xs7ymcXqm21uve1UkgcymUlb3XV1nZXh61YujWi6YW6s9lnafdpghovt1hnbkwUclasWt2doilsesb4tzxXqoo2cr', '1556389111', '1556399911', 1),
(231, 'Yc7mgyfah97gWc9dxvmZoW1eVVjqgwfv9qmt1qp8Ujw87pYgpdimyqhthbk6VZf0zWm9qn9gw3i1Vl2ctloy5unvYjhwgopov3k6', '1556389213', '1556400013', 1),
(232, 'UVyqojvg6lijoh3hlgmvZ2retVlUfXdv9c12wbfg9Vkdjhu4sVaUfk0j830rX5wVcprvrthZd2zzn4fsb5srqu4fZ1n1xokUro5U', '1556430217', '1556441017', 1),
(233, 'pubp48UebW01pwak1Vy7au2rq8Yeuotdc6kkj4WVydrq33ka5x89uf7ronxvsZc3zyv1vYi7pavWwuqVUw2X3m2pjuiXx5scrZx7', '1556430643', '1556441443', 1),
(234, 'ehzV7uwY3x3cetnhpYgXhZ4wt193XujjVgikliogr4z1qkU5c7dW9rbZrq6x7UtcXotWlrqYfqju52W9oxyk9u3aUnXvujUZgj4r', '1556436245', '1556447045', 1),
(235, 'gq9qx1Vqbs3woXfV1YWYguUt7Zj0rvbiZeerwpmjaZ4gUe7889VhhmVj9nWgoV4cbgeZ1m81Xh8qpYbYvsVWulXzsj4VVf1W89cj', '1556437259', '1556448059', 1),
(236, 'zssmef0Y44asf9dWpzZao4WUhzp3prx1rdc84nhVde2mVgvwop2tswiXzdiwex9jfX5abia71szgxUVgw9sW9dtYXV0j5n1Ytv1s', '1556437339', '1556448139', 1),
(237, 'lY2fn7o5pjcV388VVksYw9nsfcrkYzxn6W6gdc9UdbmysviX032svkz4lvrWek20vulYgncfiy0o8trygXdXkbo020rfxp4b2m8l', '1556437452', '1556448252', 1),
(238, 'X23m9c5UxbwnqVbWznu7va78s0mUgdgmZ0vshlip74ekb88dmYjo6kaYlwrmnXymi7gxd3vld79Ws3nwdw9rf1apdpWnjmdelp2n', '1556437610', '1556448410', 1),
(239, 'Ybs4W6lk1ajydfexv3yxhyoyiX43grb3xvW8gy7V6vf90epf6afV7pk95Z5arkgaj7bl1jzxWsyii5Ycz9nWXWjc885W8u5bdVUp', '1556438285', '1556449085', 1),
(240, 'Ub7tiw97YcYat7v9sYVy1iu8Z0etzxbzdplji9k6Zkx5i8tUkg90a0n21acXY0zY08p9pc0qv7473Wjtig0g1lik164eXproZ7gq', '1556438628', '1556449428', 1),
(241, 'xfdf8gXt2vqnkZwqaj7i12csiheY0bxY0jxXYcimohc7Z2ltmcnw8jn99huhucViuZwXrhxYjYe5be2V1jikWvmV5wpyih9r9pxd', '1556438819', '1556449619', 1),
(242, 'e5t0nU8xk8qZax91rkid7nqbseY9hqY71gx0zvmag04vm0Y488Wtq148a649ingihk7k1dzcWUuvia09WY8pc39j3V9z34Zha6uj', '1556438914', '1556449714', 1),
(243, 'ginsWdj2pg0snYy39ltyUqUtZkdmUssiUv0nroX46x0g4lxV3c0pngkofdV01sh0g539j3kc7hedwi7tao01Zhbdya2yvkvfqzro', '1556438981', '1556449781', 1),
(244, 'Uratvij2qt8rf2x58jVu7761zzvntVzhV4490w9e94X3ej7e2idwi2lWYrovv4s851zykxb5Ug8bhah09XZogixUU4tqXe23n1ne', '1556439077', '1556449877', 1),
(245, 'h5xq0t3wybvsq1WWtaxUum4lmeYzl930j78kzXXUv8w3jeYU8uyjt1X9a05ok252Vkjlgfk51k1zZzm4dhuZa75i86fVv2cz1jt6', '1556439247', '1556450047', 1),
(246, 'Y1focWkox4dXoez6ViWu8Y6gu0ccyWdVXVxs9w115gla0VpdrfbU62u31X64ph9cvosjff0dapx67W08pwo6lZaqopUy8ibsb210', '1556443415', '1556454215', 1),
(247, 'l07vivrjbVgdkckd2r2brcYYsvxXgjVcnaYxqp6ZynVyhUpr7dmmtjoz372dymZ6a7djgs6np6cVugVgibmargvdnZjY8m99meyb', '1556443491', '1556454291', 1),
(248, 'g8tvX2yVv4Yypykca2tqWmcbidUrtXl6glvbiyx682adqV8j12YYo1jir5bi0fybjUjs88WVowpplypbVqpymt7iltkdZnrhl57w', '1556443571', '1556454371', 1),
(249, '97ar1n8oqbdqVZxtympwgYloYnmf0y5pUV08jas5vsYx8zh9VkjfZ4k4awrv72fw9Z2ziptdnZ3k8vsi68q0zagrd8l2yvabVgub', '1556444323', '1556455123', 1),
(250, '5whUUZ6us2dgex95r54i4o6iwlhY9fdub0aW4sW2ozvh0pdho185e8e7p3w0zj1jyX01YU6zu8vc87qe4ikW0imhcYk92ijfi1en', '1556444848', '1556455648', 1),
(251, 'oY3fj8pX2Yeh89lio4l8dmlfbxkup04qj2m9UpuacbuZV62giXike5bwh2eka5tm3fy96o9qi57lb7zoVpq5zefYbem95jxk8ra1', '1556444933', '1556455733', 1),
(252, 'tjkVvqhWmdb8ank98nbjVvayrVsbbU75b8014l2unvc2YsUY3cmrulkmdUtVick2kwohf6oc5hrUjhe9iuseU0pvYgjnd171h5qf', '1556447116', '1556457916', 1),
(253, '2dyygovX9zrtppYtf9yaVWr9oal45yu27ye2wledlkr543lyb3davUtWpyWc9cz0udk880odnd767oUtred7X5n8ykaugV912qvu', '1556447259', '1556458059', 1),
(254, 'cjV8o9ebmrwqdhUjft7odc0ovjso96oZhfxkVZjlXqZvcxamylpvbps66Zpi8Zn1dk8o7UYgk849da83am0zsUve7aeqtyvcox1k', '1556468934', '1556479734', 1),
(255, 'doqZz35reozc6g9oibk2YqZ2b1ye6mjW2kcfsYq563q8UXqzr9rxq0arjtvt2fe4xVis2ukXXx4bqypVdpUohstnVYvX0X10iUXy', '1556469027', '1556479827', 1),
(256, '1a0mweklZ4m69ets42sxXxr1mz5knhd2ZjsZ38rcWlrY7W2vbldia24k6ihfwa5Vcr4n475tzupsV0vopWakouVVabg7a9bngjyt', '1556555404', '1556566204', 1),
(257, 'verjs15u62rZmiwf1ZZsrZpe7YhWaofZm5qu37uV1o27i9bUblXo2047y3ob9mo61w5xzv3wh5915e5xfh3Y18VyeW4VmnvtyYkr', '1556555489', '1556566289', 1),
(258, 'rois79jtnZuxUj5dwoVwkg65UxpbW3dbn4j804sieh0kXZi1mkg3vy3u8rd07v5ult4pstzUpmncbfU9VqjtcnWlWetp8WcfVc6u', '1556555607', '1556566407', 1),
(259, '6cgvVgw7cohz8kX75gVfXgsYve5VYmrhlggxncZoj2zyra313kyo2Xw0XknvynZ2quztYcY2qgwtd9qxyVZw25hjk56k7kl0jZXf', '1556555823', '1556566623', 1),
(260, 'qalelj7hz6spy4m5drd4dx0k92mV07XadmbftvWi3V3o18sWZf6l7sbkbf56at08YkUXWv4tZa12vaqjf5el4YlXWaUfY2sranui', '1556556000', '1556566800', 1),
(261, 'cop2WitU6xotr8ij60c7rf3wvo592azb8Z4eYZx0V2Xwpiz9vluemU03sxmsv3erWgsa1lu9y3qn5xZYrvlkiY9WkZW2fhuX9mV5', '1556556370', '1556567170', 1),
(262, '2Y9pw6vs13hv8ubvqvxvjXfwZ4oofvp6nupkZ2utultc5mXu50Vw0Yfqpvo2sepsbv0Z75dbpxbdi8cot98UazU9efnXbbuX2m3g', '1556556519', '1556567319', 1),
(263, 'yWs8m3Wz45yniViwlprw216a1lvknoi5YclnyxphUZakjcag79bYo01Y237hj4mow6gm7f2Vdpzwoe6mpjp33k4sgkXeUoY999ws', '1556642927', '1556653727', 1),
(264, 'qcmsxUclplkyX16l4s6dYi90bZv5up9XjvplbpvsrdY6dVif2doeZ01w0i4anq90rsvbqjxrXXjZo5pxmcrVivkruv9VaUnuvfZV', '1556645224', '1556656024', 1),
(265, 'Wpjgreuz4Vasc3YkjUzYX6xvfjdrqobn2x3gefcugZgZU3qlyx0p6W52g5hl67rYw46Yls8Wus3xqiVZbxZ5ric36kt1d3treVtk', '1556645332', '1556656132', 1),
(266, '8tVp2kzdV60d8yV8XccxngfX5s95Wfqetz6cvidfiu8qx6rUquk6o9y4eZwfcl3axlX6mv1drgXaV0nUbYu6sWx28qhv2g9VkVmo', '1556645644', '1556656444', 1),
(267, 'Yk3YWysoWu47s5pvWV40zarhh5zmx9qU89xn34kfZ5s2W0Xj6bv86xfac0z07Vy0okobuzoVZy3jhnnfl4X602n3va84o3Zpy7ml', '1556646705', '1556657505', 1),
(268, '9rmgyqock52uhdqWXl5ct2xooZ0hX6oU7slsynxsotwpdyui2ay9rgnvknUVrWpzZmV2ij38lrc4onvc0Xx9cpwypW9fnrekXz1t', '1556646879', '1556657679', 1),
(269, '5qodb8ij8z97hwpct457uphajfa08ky1g4yxX2dt8rxiwsg0403yY77xrWu7w6tzy2u7qZrv90hon3Uf7p8nlkk5xa52bxp5oeXZ', '1556690380', '1556701180', 1),
(270, 'q6x6pseVfw6lqlZx7oY9q8focZzuhf7nb3mUuwpgvs98pbYX8kgUgnzo3vbrU9Zq5jgjYZYY4Ul75u3yVcmVh3m6i6bUXakwlvgn', '1556691155', '1556701955', 1),
(271, 'yriyYkqcpve2quhgzsy5tdswi4ss9z2gxsz42r3uxXWoqWxWdYqjnv9Z9jun8n6pfldohmgwzged8vrh6ug7aytjplwh6smuU5ul', '1556691456', '1556702256', 1),
(272, 'iXmjZnzUxqjZqVal6v0s7q86p8l3Yh27YjaVwX0bYa5bgWc5ZZvkgfv45t0flh6c284wlkfu93fUqzysxmjjbtwiyn4ncwZ9704f', '1556691898', '1556702698', 1),
(273, 'fmjUdYo6umt2mjUkaxUdVXtxj9W8qdu858klw5WhYmwssa36UXqcaYrbdch4g9Yt3o5y8cayXlp5XwUtdxjy2r0lZ1igZu0ehm0b', '1556692085', '1556702885', 1),
(274, 'vbp5oYfcclnuggppVxtplcygVsylcfy2l2x39ViXhmzgkwsX74s98pocdzpqgdsf6agewcUUieVbac87quWYVm4kdVYs469769yU', '1556694250', '1556705050', 1),
(275, 'aZmlxw11zVUWX1YeXYt1mnpcWc6fpwuxxxthwuc7uUdxyhbYx3aV73Xgxk3uXeaVdVwhqpudaue45hjf4jaV981mcsa2ci345mtx', '1556694793', '1556705593', 1),
(276, '35edWZYWzbja9Wvkt7gjW38ju7iUmpbjnijpVlpghjqVoWx9jvyUZ18uV1Xnul7bufXYZiXc7hVsmua2rpj8twYpgmW39duqqf3z', '1556695117', '1556705917', 1),
(277, '1fZv0lw8Xac6ZmeZZrg8Vx7ozrXZrVq5nb33i79jZujcokfXYzrjt6Ywwvgpaoy9jlneXic2ZwnZ3gscjV51e1xmYqddyf463umh', '1556696644', '1556707444', 1),
(278, '9qYh9ovVh7iVfmcegZ82Vazlw0ophkxt6tdUhW7bhxlxnVa402sW7VUjpyXXyUX8eyg0yz9v93tez75gv8tei0625kxzeqa4f3gY', '1556696819', '1556707619', 1),
(279, 'rZlxffmoq9Wbsoko9fthq54vYuX7VbmYhxVYrV9gqsYd729oktw4avafrgWlagxtYYlZsixrqX1nzs3otr6iWd5estV8tusipmxy', '1556696947', '1556707747', 1),
(280, '4Xke1pvZ8tzyf3hqap2eedn2jtbyxfxab1ZiYqzysfbrmwi4hhb8lcf1Z6bVwp3i7v4xbed6gr8yhexr5gpj8jsVenvcqrU1k6ku', '1556697052', '1556707852', 1),
(281, 'oWYgVn1tx5W03dwWsrwljukUkZzXj8Ucj0W3ehkuo44g93d9sxl57vX8U1857mWZki7V2jbo5n7bjUmhbff4qZWkizhodgthVuUZ', '1556697186', '1556707986', 1),
(282, 'sipfc32rWZwclt9Z0rnkq58zhbYuZbdyx53o2qlWZjhjnqq04n3hsYU7m4rxe6ok7U7fZgd7kVZhkbmx7m2wg0l9hkmjjZf7bVea', '1556697741', '1556708541', 1),
(283, 'dwu01zn7l3e559bk4jmkflphihUyY1hw74dd8xuvfnftdWopXg9vmvZWy5oghW48bu42Zeqbcex8e5yZy6h0yfywq7y4W15zY410', '1556701668', '1556712468', 1),
(284, 'd10454vp450lpr6zi2UhXXpY7lYyrg12hxqr5ypsz1hxvk1a0ZWof4gWhXnVlhU4z0yajqmhiWphomrj96xumu74phqV50sw6w3u', '1556712225', '1556723025', 1),
(285, '02suvu9Yxy91g2xgmkbd4U6hp4eX8ng5iXhYi9q8vuriUwseelgyl9WiYUppV1pzlxXyW3vyl9Uo9t0zXsgpfuekxd46i2cZdsn6', '1556730271', '1556741071', 1),
(286, 'xjWxbUmplfgW792dy278eZV8bpywoyz9dx3w94hm0yU22pehuZu6ydbn77pXVV1eyfsW705Zkjsza8gcUi771o51Uz03ZxfvWntj', '1556730404', '1556741204', 1),
(287, 'sgnUVUrcecrzaoUp1pVv6XVrZpgxijwik7o4oaewYaag6a34gX10xsWZxjc0afq76r2YWj6WkYu6uau3xYxYVYzda5znZ7tr6p03', '1556730474', '1556741274', 1),
(288, 'wwwo63vr2W0armoU4at8dbbs20bcm1prnfecib49ztZb1v60um8jeyd89nnfh478irc9yz054nZ57h9i76bg8Yj47qWYWzj6WWyr', '1556730652', '1556741452', 1),
(289, 'sgWq19xz8u0esnbVt2oU5fbZk4d4r0cbjydhX31tm0iUfeuq8W8nYjXhZi9y7ajvY4w0m0arm6cqmhnV5Vjw793fkYaXU7vvvz5W', '1556730727', '1556741527', 1),
(290, 'gsVuV4vU36qqj6V5okdkodu7zhg9X1bv2y57zUY739s5Vzz854w6Y8onXyYmc515utukqVzk8eizlqc4VX3tzljX7ipdWVaa9lrj', '1556730993', '1556741793', 1),
(291, '9krtjm5bnpbfjkXVakymnZ5xzWy8Vh0t2ZfpkWrklZb1feUuWeztYZyX7Vib0xV3V6fuq816iawUvf1r4rtXhWn3dlv5dfane4dq', '1556731541', '1556742341', 1),
(292, 'trg9lxc1rebbtacyY2pwekc5wadmovy38yiswVcuzqdxpXom9lkxVuZosqWpmdsUfZh5jsmevVcnjjXUlgjW9tZe0yn1z9ib1le7', '1556731776', '1556742576', 1),
(293, '4vW2X4413splYhY7vbpZ31U2h6Wulco8d8gYxj0bj4Wqm2jfVfdlZoa9dvesZihw4zZ1zqZvjUZdeWwxzd08mftzhhYWVvlomjyz', '1556731932', '1556742732', 1),
(294, 'w8q5YmpoXc6ViUzbkgf23hfUz6wsyW7e3Wa2YifvefsbUsgnkZdxbxeV9vZ75pUU7Vstkov8k8tVuc25x8WXzz3UZYrmhcl4rw9u', '1556732312', '1556743112', 1),
(295, '2l9k50ekefobzqkgeXmc2cm3erUmVu46x88a03d47nni160tmqgVre24YWn8a507YazhlX8o2imsWUzmvVe9o438Wsl808YlmWuY', '1556732525', '1556743325', 1),
(296, '9jn5sc7X7tvhc08pbn1ZYV7yUz22t8XUvYop62inahyuosUaxe5Wipd758XY35X13pYmg4t7zd12cgmknft75jXliusu5i8vbos7', '1556733140', '1556743940', 1),
(297, 'gs1aWXv7kfv5ay31gUz62Use9euebYX9zUcn5elrqe9h7ubny9W373xvno6YgVacgkw2u4Z5iuzh6lx1Wug1swig291t60Zm3305', '1556733275', '1556744075', 1),
(298, '1h4bdYzem6hnejo64hblq1szzWxUx63des0xXz516d89Y39m31qttti0omzckgofyeVyVsqq8oz6jkvWVYk9mU2Uuzpn558u8ZX5', '1556733446', '1556744246', 1),
(299, 'yzhaV8h3XXW94Wdc90Z0ijZrypljow3mojnhas6UrbW35ulsxpn7gmftxr1ktjgpl2avU1ZqWVxiWfk532yoaYU8n43pV7agghn4', '1556733655', '1556744455', 1),
(300, '5dvUV6jZjvVll2j8bnY55p4v0haxVwgwqpbts0i05Vj23mtxWYt4Xj4arsV39Vjcnysm0mVxqpiZc78tz2hqaUimXdZypuxn64kc', '1556733915', '1556744715', 1),
(301, '79oktZjdc1bovr0VawVc0zu3gXqeucwjhp4Y6uUtxnn5o41z788YkZfnznWpcWkk0vxbXU8d4Xuy14uf38poh2ybW7gvav5Xjuoa', '1556734085', '1556744885', 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `checkin` date NOT NULL,
  `checkout` date NOT NULL,
  `room_entity_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reset_password`
--

CREATE TABLE `reset_password` (
  `id` int(11) NOT NULL,
  `token` text NOT NULL,
  `expiry_date` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL,
  `price` varchar(255) NOT NULL,
  `room_number` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_reservation_entities`
--

CREATE TABLE `room_reservation_entities` (
  `room_entity_id` bigint(20) NOT NULL,
  `reservation_entities_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sellers`
--

CREATE TABLE `sellers` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `mobile_no` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seller_bank_details`
--

CREATE TABLE `seller_bank_details` (
  `id` int(11) NOT NULL,
  `user_attribute` varchar(100) NOT NULL,
  `user_value` varchar(100) NOT NULL,
  `seller_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `system_user`
--

CREATE TABLE `system_user` (
  `id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `isActive` tinyint(4) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `mobile_no` varchar(100) NOT NULL,
  `password_reset_token` varchar(200) DEFAULT NULL,
  `expire_length` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `system_user`
--

INSERT INTO `system_user` (`id`, `userName`, `password`, `email`, `isActive`, `first_name`, `last_name`, `mobile_no`, `password_reset_token`, `expire_length`) VALUES
(1, 'asantha', '928ed038b8c834689f990225b55ea63fee834ecd61cb997c5fd951f3272113ec04208bacd9613dc61fff05a6cd4c5c08ca7d66a2c0dcc2f647cb0b41d38b8c94qkzIMf2iTa4/0393vWnqmVL6gwmwp+JMcHk/6V3dtj8=', 'asantha@gmail.com', 1, 'asantha', 'thilina', '0712833941', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `account_expired` bit(1) DEFAULT NULL,
  `account_locked` bit(1) DEFAULT NULL,
  `credentials_expired` bit(1) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `account_expired`, `account_locked`, `credentials_expired`, `enabled`, `password`, `user_name`) VALUES
(1, b'0', b'0', b'0', b'1', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'admin@gmail.com'),
(2, b'0', b'0', b'0', b'1', '$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe', 'reader'),
(3, b'0', b'0', b'0', b'1', '$2a$08$kPjzxewXRGNRiIuL4FtQH.mhMn7ZAFBYKB3ROz.J24IX8vDAcThsG', 'modifier'),
(4, b'0', b'0', b'0', b'1', '$2a$08$vVXqh6S8TqfHMs1SlNTu/.J25iUCrpGBpyGExA.9yI.IlDRadR6Ea', 'reader2');

-- --------------------------------------------------------

--
-- Table structure for table `user_authorities`
--

CREATE TABLE `user_authorities` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_authorities`
--

INSERT INTO `user_authorities` (`user_id`, `authority_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(2, 2),
(2, 6),
(3, 3),
(3, 7),
(4, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ads`
--
ALTER TABLE `ads`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ad_user_id` (`userID`),
  ADD KEY `ad_slot_id` (`adSlotID`);

--
-- Indexes for table `adslots`
--
ALTER TABLE `adslots`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_access_token`
--
ALTER TABLE `oauth_access_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `oauth_approvals`
--
ALTER TABLE `oauth_approvals`
  ADD PRIMARY KEY (`userId`,`clientId`);

--
-- Indexes for table `oauth_client_details`
--
ALTER TABLE `oauth_client_details`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `oauth_client_token`
--
ALTER TABLE `oauth_client_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `oauth_refresh_token`
--
ALTER TABLE `oauth_refresh_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Indexes for table `refresh_token`
--
ALTER TABLE `refresh_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2ub8d3c2m0wegd94jnhvk1x14` (`room_entity_id`);

--
-- Indexes for table `reset_password`
--
ALTER TABLE `reset_password`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room_reservation_entities`
--
ALTER TABLE `room_reservation_entities`
  ADD UNIQUE KEY `UK_1dp5omyxw1fw9eknnato2ofhh` (`reservation_entities_id`),
  ADD KEY `FKokkues30by6015ppw1fq7ypwp` (`room_entity_id`);

--
-- Indexes for table `sellers`
--
ALTER TABLE `sellers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seller_bank_details`
--
ALTER TABLE `seller_bank_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `system_user`
--
ALTER TABLE `system_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_authorities`
--
ALTER TABLE `user_authorities`
  ADD PRIMARY KEY (`user_id`,`authority_id`),
  ADD KEY `FK2n9bab2v62l3y2jgu3qup4etw` (`authority_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ads`
--
ALTER TABLE `ads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `adslots`
--
ALTER TABLE `adslots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `authority`
--
ALTER TABLE `authority`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `refresh_token`
--
ALTER TABLE `refresh_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;

--
-- AUTO_INCREMENT for table `reset_password`
--
ALTER TABLE `reset_password`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seller_bank_details`
--
ALTER TABLE `seller_bank_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `system_user`
--
ALTER TABLE `system_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ads`
--
ALTER TABLE `ads`
  ADD CONSTRAINT `fk_ad_seller` FOREIGN KEY (`userID`) REFERENCES `sellers` (`id`),
  ADD CONSTRAINT `fk_ad_slot` FOREIGN KEY (`adSlotID`) REFERENCES `adslots` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
