drop database if exists DB_Web
create database DB_Web;
USE DB_Web;
go 


create table LoaiSanPham(
	IDLoaiSanPham int AUTO_INCREMENT, 
	TenLoaiSanPham varchar(200),
	constraint LoaiSanPham_IDLoaiSanPham primary key (IDLoaiSanPham)
);
create table SanPham(
	IDSanPham int AUTO_INCREMENT ,
	TenSanPham varchar(200),
	NguonGoc varchar(200),
	Gia int, 
	ChiTietSanPham text,
	IDLoaiSanPham int ,
	constraint SanPham_IDSanPham  primary key (IDSanPham),
	constraint SanPham_IDLoaiSanPham foreign key (IDLoaiSanPham) references LoaiSanPham(IDLoaiSanPham)
);
create table Anh(
	IDAnh int AUTO_INCREMENT ,
	IDSanPham int ,
	UrlAnh varchar(200),
	constraint Anh_IDAnh primary key (IDAnh),
	constraint Anh_IDSanPham  foreign Key (IDAnh) references SanPham(IDSanPham)
);
create table NguoiDung(
	IDNguoiDung int AUTO_INCREMENT ,
	HoTen varchar(100),
	TaiKhoan varchar(100),
	MatKhau varchar(100),
	DiaChi varchar(100),
	SoDT varchar(10),
	GioiTinh tinyint,
	NgaySinh Date,
	Email varchar(100), 
	UrlAnhNuoiDUng varchar(200),
	constraint NguoiDung_IDNguoiDung primary key (IDNguoiDung)
);
create table LoaiNguoiDung(
	IDLoaiNguoiDung int AUTO_INCREMENT ,
	TenLoaiNguoiDung varchar(100),
	constraint LoaiNguoiDung_IDLoaiNguoiDung primary key (IDLoaiNguoiDung)
);
create table XacThuc(
	IDNguoiDung int ,
	IDLoaiNguoiDung int ,
	constraint XacThuc_PrimaryKey primary key(IDNguoiDung,IDLoaiNguoiDung),
	constraint XacThuc_IDNguoiDung foreign key (IDNguoiDung) references NguoiDung(IDNguoiDung),
	constraint XacThuc_IDLoaiNguoiDung foreign key (IDLoaiNguoiDung) references LoaiNguoiDung(IDLoaiNguoiDung)
);

create table DanhGia(
	IDNguoiDung int ,
	IDSanPham int ,
	SoSao int , 
	constraint DanhGia_PrimaryKey  primary key (IDNguoiDung, IDSanPham),
	constraint DanhGia_IDNguoiDung foreign key (IDNguoiDung) references NguoiDung(IDNguoiDung),
	constraint DanhGia_IDSanPham foreign key (IDSanPham) references SanPham(IDSanPham)
);

create table ChiTietBinhLuan(
	IDBinhLuan int AUTO_INCREMENT,
	IDNguoiDung int ,
	IDSanPham int ,
	NoiDungBinhLuan text,
	NgayBinhLuan date,
	constraint ChiTietBinhLuan_IDBinhLuan primary key (IDBinhLuan),
	constraint ChiTietBinhLuan_IDNguoiDung foreign key(IDNguoiDung) references NguoiDung(IDNguoiDung),
	constraint ChiTietBinhLuan_IDSanPham foreign key (IDSanPham) references SanPham(IDSanPham)
);

create table DonDatHang(
	IDDonHang int AUTO_INCREMENT,
	IDNguoiDung int ,
	TrangThai varchar(200),
	DiaChiGiaoHang varchar(200),
	NgayDat date, 
	NgayGiao date,
	MoTa text ,
	Tong int,
	constraint  DonDatHang_IDDonHang primary key (IDDonHang),
	constraint DonDatHang_IDNguoiDung foreign key (IDNguoiDung) references NguoiDung(IDNguoiDung)
);
create table ChiTietHoaDon(
	IDDonHang int , 
	IDSanPham int,
	SoLuong int,

	constraint ChiTietDonHang_Primarykey primary key (IDDonHang, IDSanPham) ,
	constraint ChiTietDonHang_IDNguoiDung foreign key (IDDonHang) references DonDatHang(IDDonHang),
	constraint ChiTietDonHang_IDSanPham foreign key (IDSanPham) references SanPham(IDSanPham)

);