CREATE TABLE `user` (
`userid` int(11) NOT NULL,
`username` varchar(255) NULL,
`userpwd` varchar(255) NULL,
`position` varchar(255) NULL,
`sex` varchar(255) NULL,
`status` int(1) NULL,
PRIMARY KEY (`userid`) 
);

CREATE TABLE `menu` (
`foodid` int(11) NOT NULL,
`foodname` varchar(255) NULL,
`price` decimal(10,2) NULL,
`category` varchar(255) NULL,
`status` int(1) NULL,
`cost` decimal(10,2) NULL,
`picture` varchar(255) NULL,
PRIMARY KEY (`foodid`) 
);

CREATE TABLE `book` (
`id` int(255) NOT NULL AUTO_INCREMENT,
`clientname` varchar(255) NULL,
`phone` varchar(255) NULL,
`deskid` int(11) NULL,
`book_time` datetime NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `deskstutas` (
`deskid` int(11) NOT NULL,
`status` int(1) NULL,
PRIMARY KEY (`deskid`) 
);

CREATE TABLE `orderform` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`deskid` int(11) NULL,
`clietname` varchar(255) NULL,
`food` varchar(255) NULL,
`ordertime` datetime NULL,
`status` int(1) NULL,
`totalprice` decimal(10,2) NULL,
`paytype` varchar(255) NULL,
`paystatus` int(1) NULL,
PRIMARY KEY (`id`) 
);

