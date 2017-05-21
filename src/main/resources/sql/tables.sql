    create table APP_USER (
         id INT NOT NULL AUTO_INCREMENT,
        AGE integer not null,
        NAME varchar(255) not null,
        SALARY double not null,
        primary key (id)
    )
    
  
    create table APP_USER_LEVEL (
         id INT NOT NULL AUTO_INCREMENT, 
        LEVEL_NAME varchar(255) not null,
		LEVEL_DESC varchar(255) ,
        primary key (id)
    )