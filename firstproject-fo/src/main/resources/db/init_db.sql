INSERT INTO `notes_app`.`fuel_kind`
(`name`,`version`)
VALUES
("SP95",now()),
("SP95-E10",now()),
("SP98",now()),
("DIESEL",now())
;

INSERT INTO `notes_app`.`driver`
(`name`,`version`)
VALUES
("Yves",now()),
("Audrey",now()),
("HugoTsr",now())
;

INSERT INTO `notes_app`.`mycar`
(`color`,`fuel_usage`,`les_chevals`,`max_speed`,`plate`,`type`,`version`,`fuel_kind_id`)
VALUES
("red",5.0,null,70,"Yeah !","citadine",1,1),
("blue",12.0,null,70,"Yeah !","berline",1,3),
("vert|jaune",10.0,null,70,"Yeah !","berline",1,4);

INSERT INTO `notes_app`.`driver_cars`
(`driver_id`,`car_id`)
VALUES
(1,4),
(1,5),
(1,6),
(2,5)
;

SELECT * FROM notes_app.fuel_kind;
select * from driver;
select * from mycar;
select * from driver_cars;

UPDATE `notes_app`.`mycar` SET `les_chevals`='1' WHERE 1=1;