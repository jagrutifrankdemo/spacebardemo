CREATE TABLE `game` (
  `gameid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gamedetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gameid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `usernotes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_login_audit` (
  `userloginauditid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `logintime` datetime NOT NULL,
  `logout` datetime DEFAULT NULL,
  `uuid` varchar(45) NOT NULL,
  PRIMARY KEY (`userloginauditid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';


CREATE TABLE `useraudit` (
  `userauditid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `gameid` int(11) NOT NULL,
  `uuid` varchar(45) NOT NULL,
  PRIMARY KEY (`userauditid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




