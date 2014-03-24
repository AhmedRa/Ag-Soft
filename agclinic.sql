/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-03-24 17:52:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for long_term_mediaction
-- ----------------------------
DROP TABLE IF EXISTS `long_term_mediaction`;
CREATE TABLE `long_term_mediaction` (
  `long_term_id` int(20) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `medication_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dose` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`long_term_id`),
  KEY `long_term_patient_id` (`patient_id`),
  CONSTRAINT `long_term_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of long_term_mediaction
-- ----------------------------

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` int(20) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `patient_phone` int(15) DEFAULT NULL,
  `patient_address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `patient_birthday` date DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `notes` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `active` int(1) DEFAULT '1' COMMENT '1 active  0- not active',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient
-- ----------------------------

-- ----------------------------
-- Table structure for patient_growth
-- ----------------------------
DROP TABLE IF EXISTS `patient_growth`;
CREATE TABLE `patient_growth` (
  `growth_id` int(20) NOT NULL AUTO_INCREMENT,
  `weight` double(3,2) DEFAULT NULL,
  `hc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` date DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`growth_id`),
  KEY `patient_growth_id` (`patient_id`),
  CONSTRAINT `patient_growth_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient_growth
-- ----------------------------

-- ----------------------------
-- Table structure for patient_invistigation
-- ----------------------------
DROP TABLE IF EXISTS `patient_invistigation`;
CREATE TABLE `patient_invistigation` (
  `invistigation_id` int(20) NOT NULL AUTO_INCREMENT,
  `invistigation_date` date DEFAULT NULL,
  `invistigation_type` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `invistigation_result` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`invistigation_id`),
  KEY `patient_invistigation_id` (`patient_id`),
  CONSTRAINT `patient_invistigation_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient_invistigation
-- ----------------------------

-- ----------------------------
-- Table structure for patient_presentation
-- ----------------------------
DROP TABLE IF EXISTS `patient_presentation`;
CREATE TABLE `patient_presentation` (
  `presentation_id` int(20) NOT NULL AUTO_INCREMENT,
  `presentation_date` date DEFAULT NULL,
  `presentation_diagnosis` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `presentation_treatment` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`presentation_id`),
  KEY `patient_presentation_id` (`patient_id`),
  CONSTRAINT `patient_presentation_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient_presentation
-- ----------------------------

-- ----------------------------
-- Table structure for patient_vaccination
-- ----------------------------
DROP TABLE IF EXISTS `patient_vaccination`;
CREATE TABLE `patient_vaccination` (
  `vaccination_id` int(20) NOT NULL,
  `vaccination_date` date DEFAULT NULL,
  `vaccination_type` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `vaccination_dose_number` int(11) DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`vaccination_id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `patient_vaccination_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient_vaccination
-- ----------------------------

-- ----------------------------
-- Table structure for patient_visit
-- ----------------------------
DROP TABLE IF EXISTS `patient_visit`;
CREATE TABLE `patient_visit` (
  `visit_id` int(20) NOT NULL AUTO_INCREMENT,
  `visit_number` int(15) DEFAULT NULL,
  `visit_date` date DEFAULT NULL,
  `patient_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `patient_visit_id` (`patient_id`),
  CONSTRAINT `patient_visit_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of patient_visit
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(2) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(100) COLLATE utf8_bin NOT NULL,
  `active` tinyint(1) DEFAULT '1' COMMENT '0 = deleted  1 = active',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
