/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs
Target Host: localhost
Target Database: crs
Date: 24-10-2021 04:34:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) default NULL,
  `adminuserName` varchar(255) default NULL,
  `adminPassword` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `courseId` int(11) NOT NULL default '0',
  `courseCode` varchar(255) default NULL,
  `courseName` varchar(255) default NULL,
  `instructorId` int(11) default NULL,
  `seats` int(11) NOT NULL default '10',
  PRIMARY KEY  (`courseId`),
  KEY `pf` (`instructorId`),
  CONSTRAINT `pf` FOREIGN KEY (`instructorId`) REFERENCES `professors` (`professorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `studentid` int(11) default NULL,
  `courseid` int(11) default NULL,
  `grade` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `std` (`studentid`),
  KEY `course` (`courseid`),
  CONSTRAINT `course` FOREIGN KEY (`courseid`) REFERENCES `courses` (`courseId`),
  CONSTRAINT `std` FOREIGN KEY (`studentid`) REFERENCES `students` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professors
-- ----------------------------
DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
  `professorId` int(11) NOT NULL default '0',
  `professorDept` varchar(255) default NULL,
  `professorName` varchar(255) default NULL,
  `professorEmail` varchar(255) default NULL,
  `professorMobile` varchar(255) default NULL,
  `professorPasword` varchar(255) default NULL,
  `approvedStatus` varchar(255) default 'pending',
  PRIMARY KEY  (`professorId`),
  KEY `professorId` (`professorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registeredcourse
-- ----------------------------
DROP TABLE IF EXISTS `registeredcourse`;
CREATE TABLE `registeredcourse` (
  `id` int(11) NOT NULL auto_increment,
  `std` int(11) default NULL,
  `cou` int(11) default NULL,
  `grade` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `stdid` (`std`),
  KEY `kh` (`cou`),
  CONSTRAINT `kh` FOREIGN KEY (`cou`) REFERENCES `courses` (`courseId`),
  CONSTRAINT `stdid` FOREIGN KEY (`std`) REFERENCES `students` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `studentId` int(11) NOT NULL default '0',
  `studentName` varchar(255) default NULL,
  `studentDept` varchar(255) default NULL,
  `studentEmail` varchar(255) default NULL,
  `studentMobile` varchar(255) default NULL,
  `studentGender` varchar(255) default NULL,
  `studentPassword` varchar(255) default NULL,
  `approvedStatus` varchar(255) default 'pending',
  PRIMARY KEY  (`studentId`),
  KEY `studentId` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'aniketjha1729', 'a@Aniket');
INSERT INTO `courses` VALUES ('1', 'CIVIL120', 'CIVIL', '705', '10');
INSERT INTO `courses` VALUES ('2', 'CSE120', 'CSE', '985', '10');
INSERT INTO `courses` VALUES ('3', 'IT430', 'IT', '775', '10');
INSERT INTO `courses` VALUES ('4', 'ECE893', 'ECE', '745', '10');
INSERT INTO `courses` VALUES ('5', 'EE450', 'EE', null, '10');
INSERT INTO `courses` VALUES ('6', 'MECH820', 'MECH', '999', '10');
INSERT INTO `professors` VALUES ('112', 'CSE', 'Mr. Aggrawal', 'agg@gmail.com', '9966440055', 'ad@1729', 'approved');
INSERT INTO `professors` VALUES ('705', 'CIVIL', 'Mrs. Kapoor', 'ka@gmail.com', '7744004499', 'ad@1729', 'approved');
INSERT INTO `professors` VALUES ('745', 'ECE', 'Mrs. Jha', 'ja@gmail.com', '9999007700', 'ad@1729', 'pending');
INSERT INTO `professors` VALUES ('775', 'IT', 'Mrs. Jaspal', 'ja@gmail.com', '7777414499', 'ad@1729', 'pending');
INSERT INTO `professors` VALUES ('985', 'CSE', 'Mr. Singh', 'sin@gmail.com', '8877331144', 'ad@1729', 'approved');
INSERT INTO `professors` VALUES ('999', 'MECH', 'Mrs. Gosh', 'gh@gmail.com', '784446699', 'ad@1729', 'pending');
INSERT INTO `registeredcourse` VALUES ('1', '100', '1', 'B');
INSERT INTO `registeredcourse` VALUES ('2', '100', '6', 'C');
INSERT INTO `registeredcourse` VALUES ('3', '205', '2', 'F');
INSERT INTO `registeredcourse` VALUES ('4', '205', '3', 'A');
INSERT INTO `registeredcourse` VALUES ('5', '205', '4', 'C');
INSERT INTO `registeredcourse` VALUES ('6', '205', '5', 'B');
INSERT INTO `registeredcourse` VALUES ('7', '243', '1', 'D');
INSERT INTO `registeredcourse` VALUES ('8', '243', '4', 'A');
INSERT INTO `registeredcourse` VALUES ('9', '243', '5', 'A');
INSERT INTO `students` VALUES ('100', 'Vaidehi Setty', 'CIVIL', 'vaid@gmail.com', '7755003311', 'Female', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('101', 'Avinash Gupta', 'ECE', 'avi@gmail.com', '6699880040', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('103', 'Tuhin Gupta', 'EE', 'tu@gmail.com', '9999551335', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('142', 'Amit Bhattachrya', 'CSE', 'amik@gmail.com', '8899004411', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('204', 'Sanjana Patil', 'IT', 'sanjana@gmail.com', '9966112200', 'Female', 'a@kniket', 'approved');
INSERT INTO `students` VALUES ('205', 'Aniket Jha', 'CSE', 'aniket@gmail.com', '8866110055', 'Male', 'a@kniket', 'approved');
INSERT INTO `students` VALUES ('208', 'Vedant Kisore', 'ECE', 'vek@gmail.com', '7700117799', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('243', 'Shreya Bhattachrya', 'MECH', 'shreya@gmail.com', '8899554411', 'Female', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('278', 'Shashank Rai', 'IT', 'rai@gmail.com', '7788330099', 'Male', 'a@kniket', 'approved');
INSERT INTO `students` VALUES ('854', 'Ashish Bhattachrya', 'MECH', 'ashish@gmail.com', '7700554474', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('885', 'Anuj Yadav', 'ECE', 'anuj@gmail.com', '6647571231', 'Male', 'a@kniket', 'pending');
INSERT INTO `students` VALUES ('999', 'Yash Yadav', 'EE', 'yash@gmail.com', '7712371231', 'Male', 'a@kniket', 'pending');
