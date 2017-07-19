
/*System_Admin*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Иван', 'Иванов', 'Иванович', 'ivanov123@mail.ru', 'Минск', 'Калиновского', '21', '65', 'ivan_superman', 'fd8sf97s07f', '5gds7fs7', NULL, 1 );
/*Admin*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Петров', 'Петр', 'Петрович', 'petrov123@mail.ru', 'Минск', 'Казинца', '38', '176', 'petya_superman', 'gfd7gs9gs0sfe', 'e89wr78w', 1, 2);
/*Dispatcher*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Борискин', 'Борис', 'Борисович', 'borisov123@mail.ru', 'Минск', 'пр. Машерова', '32', '567', 'boris_superman', 'dasdr78rew9w', 'fse5sfr8', 1, 3);
/*Manager*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Прекрасная', 'Елена', 'Васильевна', 'lenka123@mail.ru', 'Минск', 'Ульяновская', '123', '4', 'lena_superwoman', '2f37gs9gsdsf5', 'ert46xkr', 1, 4);
/*Driver*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Моржов', 'Анатолий', 'Петрович', 'tolik123@mail.ru', 'Минск', 'Асаналиева', '7', '223', 'tolik_superman', 'fs89fsd0gs7w', 'c8s0f8sa', 1, 5);
/*Company owner*/
INSERT INTO user (name, surname, patronymic, email, city, street, house, flat, login,  password,  salt,  trucking_company, user_role)
  VALUES ('Абрамович', 'Аркадий', 'Иванович', 'abram123@mail.ru', 'Абу-Даби', 'Царская', '14', 'е', 'abram_superman', 'dsaf8fsdfsd9', 'ds0fsa8a', 1, 6);
commit;
