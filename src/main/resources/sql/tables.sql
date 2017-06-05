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
    
    create table APP_MODULES (
		id INT NOT NULL AUTO_INCREMENT, 
		MODULE_NAME varchar(255) not null,
		MODULE_DESC varchar(255) ,               
		WHOCOLUMN varchar(25) ,
		primary key (id)
	)
	
	
	create table APP_PAGES (
		id INT NOT NULL AUTO_INCREMENT, 
		MODULE_ID INT NOT NULL,
		PAGE_NAME varchar(255) not null,
		PAGE_DESC varchar(255) ,    
		UPDATE_RIGHT TINYINT(1),
		SAVE_RIGHT TINYINT(1),
		SEARCH_RIGHT TINYINT(1),
		VIEW_RIGHT TINYINT(1),
		DELETE_RIGHT TINYINT(1),
		ADMIN_RIGHT TINYINT(1),
		WHOCOLUMN varchar(25) ,
		primary key (id),
		CONSTRAINT PAGE_RIGHTS FOREIGN KEY (MODULE_ID) REFERENCES APP_MODULES (id)  
	)
