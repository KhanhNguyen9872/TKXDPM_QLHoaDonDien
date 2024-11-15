create database invoice;
use invoice;

CREATE TABLE `invoice` (
  `maKH` int(11) NOT NULL AUTO_INCREMENT,
  `tenKH` varchar(255) NOT NULL,
  `ngayHD` date NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` int(11) NOT NULL,
  `quocTich` varchar(255) NOT NULL,
  `doiTuongKH` varchar(255) NOT NULL,
  `dinhMuc` int(11) NOT NULL,
  primary key (`maKH`)
);

CREATE TABLE `doiTuongKH` (
  `maDT` int(11) NOT NULL AUTO_INCREMENT,
  `doiTuong` varchar(255) NOT NULL,
  primary key (`maDT`)
);

CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `isAdmin` bit DEFAULT 0,
  primary key (`username`)
);

DELETE FROM `invoice`;
ALTER TABLE `invoice` AUTO_INCREMENT = 1;

INSERT INTO `invoice` (`tenKH`, `ngayHD`, `soLuong`, `donGia`, `quocTich`, `doiTuongKH`, `dinhMuc`) VALUES
('Văn Khánh', '2024-04-01', '12', '100', '', 'Sinh hoạt', '20'),
('Chiến Thắng', '2024-05-05', '8', '120', '', 'Sinh hoạt', '20'),
('Đức Thịnh', '2024-04-20', '7', '125', '', 'Sinh hoạt', '20'),
('Ngọc Hào', '2024-04-16', '14', '90', '', 'Sinh hoạt', '20'),
('Văn A', '2024-03-12', '17', '160', 'USA', '', '0'),
('Văn B', '2024-02-04', '13', '140', 'USA', '', '0'),
('Văn C', '2024-05-09', '19', '150', 'USA', '', '0');

DELETE FROM `doiTuongKH`;
ALTER TABLE `doiTuongKH` AUTO_INCREMENT = 1;

INSERT INTO `doiTuongKH` (`doiTuong`) VALUES
('Sinh hoạt'),
('Kinh doanh'),
('Sản xuất');

DELETE FROM `account`;

INSERT INTO `account` (`username`, `password`, `email`, `isAdmin`) VALUES
('admin', 'admin', 'admin@localhost.com', 1),
('user', 'user', 'user@localhost.com', 0);

SELECT * FROM invoice;
SELECT * FROM account;