use mobile_handset;


DROP TABLE IF EXISTS hardware;
CREATE TABLE hardware (
	hardware_id INT NOT NULL,
    audio_jack VARCHAR(3),
    gps VARCHAR(50),
    battery VARCHAR(255),
    mobile_id INT,
    PRIMARY KEY (hardware_id)
);

DROP TABLE IF EXISTS release_table;
CREATE TABLE release_table (
	release_id INT NOT NULL,
    announce_date Date,
    price_eur DECIMAL(6,5),
    PRIMARY KEY (release_id),
    mobile_id INT
);

DROP TABLE IF EXISTS Mobile;
CREATE TABLE Mobile (
	id INT NOT NULL,
    brand VARCHAR(50),
    phone VARCHAR(50),
    sim VARCHAR(50),
    resolution VARCHAR(50),
    picture VARCHAR(255),
    release_id INT ,
    hardware_id INT,
    PRIMARY KEY (id),
	CONSTRAINT `FK_RELEASE_ID` FOREIGN KEY (`release_id`) REFERENCES `release_table` (`release_id`),
    CONSTRAINT `FK_HAEDWARE_ID` FOREIGN KEY (`hardware_id`) REFERENCES `hardware` (`hardware_id`)
);

alter table release_table
add CONSTRAINT `FK_Release_Mobile_ID` FOREIGN KEY (`mobile_id`) REFERENCES `Mobile` (`id`);

alter table hardware
add CONSTRAINT `FK_Hardware_Mobile_ID` FOREIGN KEY (`mobile_id`) REFERENCES `Mobile` (`id`);

