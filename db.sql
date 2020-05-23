
DROP DATABASE `db`;
CREATE DATABASE `db`;

CREATE USER 'user'@'%' identified by 'user';
grant all on db.* to 'user'@'%';

USE `db`;

CREATE TABLE  `db`.`Customer` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `phoneNo` varchar(12) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`Feedback` (
  `feedbackId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `remarks` varchar(1000) NOT NULL DEFAULT '',
  `date` DATE NOT NULL ,
  PRIMARY KEY (`feedbackId`),
  FOREIGN KEY (customerId) REFERENCES Customer(customerId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`Cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `date` DATE NOT NULL ,
  PRIMARY KEY (`cartId`),
  FOREIGN KEY (customerId) REFERENCES Customer(customerId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`Brand` (
  `brandId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `since` DATE NOT NULL,
  PRIMARY KEY (`brandId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`Item` (
  `itemId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `size` int not null DEFAULT '1',
  `brandId` int NOT NULL,
  `buyingPrice` int NOT NULL,
  `sellingPrice` int NOT NULL,
  `colour` varchar(20) NOT NULL DEFAULT '',
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`itemId`),
  FOREIGN KEY (brandId) REFERENCES Brand(brandId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

ALTER TABLE Item
ADD CONSTRAINT c1 CHECK (quantity>=0);

CREATE TABLE  `db`.`CartItem` (
  `cartId` int NOT NULL,
  `itemId` int NOT NULL,
  `quantity` int NOT NULL default '1',
  PRIMARY KEY (`cartId`,`itemId`),
  FOREIGN KEY (cartId) REFERENCES Cart(cartId) ON DELETE CASCADE,
  FOREIGN KEY (itemId) REFERENCES Item(itemId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

delimiter @
CREATE TRIGGER t1 BEFORE INSERT ON CartItem
  FOR EACH ROW
  begin 
    UPDATE Item SET quantity=quantity-NEW.quantity WHERE itemId = NEW.itemId;
  end@
delimiter ;

delimiter @
CREATE TRIGGER t2 AFTER INSERT ON CartItem
  FOR EACH ROW
  begin 
    UPDATE Cart SET amount=amount+(NEW.quantity)*(select sellingPrice from Item where itemId=NEW.itemId) WHERE cartId = NEW.cartId;
  end@
delimiter ;

CREATE TABLE  `db`.`Supplier` (
  `supplierId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `amount` int NOT NULL DEFAULT '0',
  `address` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

ALTER TABLE Supplier
ADD CONSTRAINT c2 CHECK (amount>=0);

CREATE TABLE  `db`.`Invoice` (
  `invoiceId` int NOT NULL AUTO_INCREMENT,
  `supplierId` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `date` DATE NOT NULL,
  PRIMARY KEY (`invoiceId`),
  FOREIGN KEY (supplierId) REFERENCES Supplier(supplierId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`InvoiceItem` (
  `invoiceId` int NOT NULL,
  `itemId` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`invoiceId`,`itemId`),
  FOREIGN KEY (invoiceId) REFERENCES Invoice(invoiceId) ON DELETE CASCADE,
  FOREIGN KEY (itemId) REFERENCES Item(itemId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

delimiter @
CREATE TRIGGER t3 AFTER INSERT ON InvoiceItem
  FOR EACH ROW
  begin 
    UPDATE Invoice SET amount=amount+(NEW.quantity)*(select buyingPrice from Item where itemId=NEW.itemId) WHERE invoiceId = NEW.invoiceId;
    UPDATE Supplier SET amount=amount+(NEW.quantity)*(select buyingPrice from Item where itemId=NEW.itemId) WHERE supplierId = (select supplierId from Invoice where invoiceId=NEW.invoiceId);
  end@
delimiter ;

CREATE TABLE  `db`.`PaySupplier` (
  `paySupplierId` int NOT NULL AUTO_INCREMENT,
  `supplierId` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `date` DATE NOT NULL,
  PRIMARY KEY (`paySupplierId`),
  FOREIGN KEY (supplierId) REFERENCES Supplier(supplierId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

delimiter @
CREATE TRIGGER t4 BEFORE INSERT ON PaySupplier
  FOR EACH ROW
  begin 
    UPDATE Supplier SET amount=amount-NEW.amount where supplierId=NEW.supplierId;
  end@
delimiter ;

CREATE TABLE  `db`.`Employee` (
  `employeeId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `phoneNo` varchar(12) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `monthlyWage` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `db`.`Wage` (
  `wageId` int NOT NULL AUTO_INCREMENT,
  `employeeId` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `date` DATE NOT NULL,
  PRIMARY KEY (`wageId`),
  FOREIGN KEY (employeeId) REFERENCES Employee(employeeId) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;












