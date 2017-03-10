CREATE TABLE `categories_events` (
  `id` INTEGER NOT NULL,
  `title` TEXT NOT NULL,
  `class` TEXT NOT NULL,
  `titleEn` TEXT DEFAULT NULL
) ;
INSERT INTO `categories_events` (`id`, `title`, `class`, `titleEn`) VALUES
(1, 'Film', 'eventmoviecat', 'Movie'),
(2, 'Sport', 'eventsportcat', 'Sport'),
(3, 'Pozorište', 'eventtheatercat', 'Theater'),
(4, 'Muzika', 'eventmusiccat', 'Music'),
(5, 'Ostalo', 'ostalo', 'Others') ;