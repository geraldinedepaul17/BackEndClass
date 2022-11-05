DROP TABLE IF EXISTS jewlery_owner;
DROP TABLE IF EXISTS jewlery;
DROP TABLE IF EXISTS stones;
DROP TABLE IF EXISTS pieces;
DROP TABLE IF EXISTS owner;



CREATE TABLE owner (
owner_pk int unsigned NOT NULL AUTO_INCREMENT,
  owner_id varchar(40) NOT NULL,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20),
  PRIMARY KEY (owner_pk)
);

CREATE TABLE pieces (
  piece_pk int unsigned NOT NULL AUTO_INCREMENT,
  piece_id enum('NECKLACE', 'RING', 'BRACELET', 'EARINGS', 'FULL_SET', 'TIE PIN') NOT NULL,
  piece_style varchar(40) NOT NULL,
  num_pieces int NOT NULL,
  item_size int NOT NULL,
  price decimal(9, 2) NOT NULL,
  PRIMARY KEY (piece_pk),
  UNIQUE KEY (piece_id, piece_style, num_pieces)
);

CREATE TABLE stones ( 
  stone_pk int unsigned NOT NULL AUTO_INCREMENT, 
  jems varchar(30) NOT NULL, 
  cost decimal(7, 2) NOT NULL,
is_mulitstone boolean NOT NULL, 
  PRIMARY KEY (stone_pk)

);  

CREATE TABLE jewlery (  
  jewlery_pk int unsigned NOT NULL AUTO_INCREMENT,  
  owner_fk int unsigned NOT NULL, 
  jewel_fk int unsigned NOT NULL, 
  piece_fk int unsigned NOT NULL, 
  price decimal(9, 2) NOT NULL, 
  PRIMARY KEY (jewlery_pk), 
  FOREIGN KEY (owner_fk) REFERENCES owners (owner_pk) ON DELETE CASCADE,  
  FOREIGN KEY (stone_fk) REFERENCES stones (stone_pk) ON DELETE CASCADE,    
  FOREIGN KEY (piece_fk) REFERENCES pieces (piece_pk) ON DELETE CASCADE,  
);  
  
CREATE TABLE jewlery_owner (  
jewlery_fk int unsigned NOT NULL, 
owner_fk int unsigned NOT NULL, 
  FOREIGN KEY (jewlery_fk) REFERENCES options (jewlery_pk) ON DELETE CASCADE, 
  FOREIGN KEY (owner_fk) REFERENCES orders (owner_pk) ON DELETE CASCADE 
);  
