CREATE TABLE `categories` (
  `id` INTEGER,
  `name` TEXT NOT NULL,
  `parent_id` INTEGER DEFAULT '0',
  `params` TEXT NOT NULL,
  `status` INTEGER NOT NULL DEFAULT '1',
  `classname` TEXT NOT NULL,
  `html` TEXT NOT NULL,
  `alias` TEXT NOT NULL,
  `lang_del` INTEGER DEFAULT '1',
  `nameLatin` TEXT NOT NULL,
  `nameEn` TEXT NOT NULL,
  `nameLatinEn` TEXT NOT NULL,
  `aliasEn` TEXT NOT NULL
) ;
INSERT INTO `categories` (`id`, `name`, `parent_id`, `params`, `status`, `classname`, `html`, `alias`, `lang_del`, `nameLatin`, `nameEn`, `nameLatinEn`, `aliasEn`) VALUES
(1, 'HRANA I PIĆE', 0, '1', 1, 'hranaipice', '', 'hrana-i-piće', 1, 'hrana i pice', 'FOOD AND DRINKS', 'food and drinks', 'food-and-drinks'),
(2, 'Restoran', 1, '1', 1, 'icon-restoran', '', 'restoran-hrana-i-piće', 1, 'restoran', 'Restaurant', 'restaurant', 'restaurant'),
(3, 'Smještaj', 0, '4', 1, 'turizam', '', 'smještaj-category', 1, 'smjestaj', 'Accommodation', 'accommodation', 'accommodation'),
(5, 'Kafić', 1, '2', 1, 'icon-kafa', '', 'kafić-hrana-i-piće', 1, 'kafic', 'Cafe', 'cafe', 'cafe'),
(6, 'Poslastice', 1, '1', 1, 'icon-poslastice', '', 'poslastice-hrana-i-piće', 1, 'poslastice', 'Confectionery', 'confectionery', 'confectionery'),
(9, 'NOĆNI ŽIVOT', 0, '2', 1, 'nocnizivot', '', 'noćni-život', 1, 'nocni zivot', 'NIGHT LIFE', 'night life', 'night-life'),
(10, 'OBRAZOVANJE', 0, '3', 1, 'obrazovanje', '', 'obrazovanje', 1, 'obrazovanje', 'EDUCATION', 'education', 'education'),
(11, 'TURIZAM I TRANSPORT', 0, '4', 1, 'turizam', '', 'turizam-i-transport', 1, 'turizam i transport', 'TOURISM AND TRANSPORT', 'tourism and transport', 'tourism-and-transport'),
(12, 'PRODAVNICE I USLUGE', 0, '5', 1, 'prodavnice', '', 'prodavnice-i-usluge', 1, 'prodavnice i usluge', 'SHOPS AND SERVICES', 'shops and services', 'shops-and-services'),
(13, 'UMJETNOST I ZABAVA', 0, '6', 1, 'umjetnost', '', 'umjetnost-i-zabava', 1, 'umjetnost i zabava', 'ARTS AND ENTERTAINMENT', 'arts and entertainment', 'arts-and-entertainment'),
(14, 'PARKOVI I ATRAKCIJE', 0, '7', 1, 'parkovi', '', 'parkovi-i-atrakcije', 1, 'parkovi i atrakcije', 'Parks and Attractions', 'parks and attractions', 'parks-and-attractions'),
(15, 'PROFESIJE I OSTALA MJESTA', 0, '8', 1, 'usluge', '', 'profesije-i-ostala-mjesta', 1, 'profesije i ostala mjesta', 'PROFESSION AND OTHER PLACES', 'profession and other places', 'profession-and-other-places'),
(16, 'Bar', 9, '0', 1, 'icon-cocktail20', '', 'bar-noćni-život', 1, 'bar', 'Bar', 'bar', 'bar'),
(17, 'Slastičarna', 1, '0', 1, 'icon-slasticarna', '', 'slastičarna-hrana-i-piće', 1, 'slasticarna', 'Patisserie', 'patisserie', 'patisserie'),
(20, 'Optika', 15, '0', 1, 'icon-optic', '', 'optika-profesije-i-ostala-mjesta', 1, 'optika', 'Optics', 'optics', 'optics'),
(22, 'Turistička agencija', 11, '11', 1, 'icon-agencija', '', 'turistička-agencija-turizam-i-transport', 1, 'turisticka agencija', 'Tourist agency', 'tourist agency', 'tourist-agency'),
(24, 'Javni prevoz', 11, '0', 1, 'icon-javniprezov', '', 'javni-prevoz-turizam-i-transport', 1, 'javni prevoz', 'Public transport', 'public transport', 'public-transport'),
(26, 'Pekara', 1, '5', 1, 'icon-pekara', '', 'pekara-hrana-i-piće', 1, 'pekara', 'Bakery', 'bakery', 'bakery'),
(27, 'Picerija', 1, '6', 1, 'icon-fast-food6', '', 'picerija-hrana-i-piće', 1, 'picerija', 'Pizza place', 'pizza place', 'pizza-place'),
(28, 'Kasino', 9, '2', 1, 'icon-kladionica', '', 'kasino-noćni-život', 1, 'kasino', 'Casino', 'casino', 'casino'),
(29, 'Klub', 9, '3', 1, 'icon-cocktail20', '', 'klub-noćni-život', 1, 'klub', 'Club', 'club', 'club'),
(30, 'Pub', 9, '4', 1, 'icon-pub', '', 'pub-noćni-život', 1, 'pub', 'Pub', 'pub', 'pub'),
(31, 'Pivnica', 9, '5', 1, 'icon-pub', '', 'pivnica-noćni-život', 1, 'pivnica', 'Beerhouse', 'beerhouse', 'beerhouse'),
(32, 'Vino', 9, '6', 1, 'icon-wine22', '', 'vino-noćni-život', 1, 'vino', 'Wine', 'wine', 'wine'),
(33, 'Osnovna škola', 10, '1', 1, 'icon-skola', '', 'osnovna-škola-obrazovanje', 1, 'osnovna skola', 'Elementary School', 'elementary school', 'elementary-school'),
(34, 'Srednja škola', 10, '2', 1, 'icon-sskola', '', 'srednja-škola-obrazovanje', 1, 'srednja skola', 'High school', 'high school', 'high-school'),
(35, 'Fakultet', 10, '3', 1, 'icon-fakultet', '', 'fakultet-obrazovanje', 1, 'fakultet', 'Faculty', 'faculty', 'faculty'),
(36, 'Akademija', 10, '4', 1, 'icon-akademija', '', 'akademija-obrazovanje', 1, 'akademija', 'Academy', 'academy', 'academy'),
(37, 'Visoka škola', 10, '5', 1, 'icon-vskola', '', 'visoka-škola-obrazovanje', 1, 'visoka skola', 'Higher Education', 'higher education', 'higher-education'),
(38, 'Hotel', 3, '1', 1, 'icon-hotel', '', 'hotel-smještaj', 1, 'hotel', 'Hotel', 'hotel', 'hotel'),
(39, 'Motel', 3, '2', 1, 'icon-motel', '', 'motel-smještaj', 1, 'motel', 'Motel', 'motel', 'motel'),
(40, 'Hostel', 3, '3', 1, 'icon-hostel', '', 'hostel-smještaj', 1, 'hostel', 'Hostel', 'hostel', 'hostel'),
(41, 'Apartman', 3, '4', 1, 'icon-apartman', '', 'apartman-smještaj', 1, 'apartman', 'Apartment', 'apartment', 'apartment'),
(42, 'Pansion', 3, '5', 1, 'icon-pansion', '', 'pansion-smještaj', 1, 'pansion', 'Pansion', 'pansion', 'pansion'),
(43, 'Mjenjačnica', 11, '2', 1, 'icon-mjenjacnica', '', 'mjenjačnica-turizam-i-transport', 1, 'mjenjacnica', 'Currency exchange', 'currency exchange', 'currency-exchange'),
(44, 'Iznajmljivanje auta', 11, '3', 1, 'icon-rentacar', '', 'iznajmljivanje-auta-turizam-i-transport', 1, 'iznajmljivanje auta', 'Rent a car', 'rent a car', 'rent-a-car'),
(45, 'Iznajmljivanje bicikla', 11, '4', 1, 'icon-bicikl', '', 'iznajmljivanje-bicikla-turizam-i-transport', 1, 'iznajmljivanje bicikla', 'Rent a bicycle', 'rent a bicycle', 'rent-a-bicycle'),
(46, 'Ambasade / konzulati', 11, '5', 1, 'icon-ambasada', '', 'ambasade-konzulati-turizam-i-transport', 1, 'ambasade / konzulati', 'Embassy / Consulates', 'embassy / consulates', 'embassy-consulates'),
(47, 'Autobuska stanica', 11, '6', 1, 'icon-bus', '', 'autobuska-stanica-turizam-i-transport', 1, 'autobuska stanica', 'Bus station', 'bus station', 'bus-station'),
(48, 'Željeznička stanica', 11, '7', 1, 'icon-voz', '', 'željeznička-stanica-turizam-i-transport', 1, 'zeljeznicka stanica', 'Railway station', 'railway station', 'railway-station'),
(49, 'Taxi štand', 11, '8', 1, 'icon-taxi', '', 'taxi-štand-turizam-i-transport', 1, 'taxi stand', 'Taxi point', 'taxi point', 'taxi-point'),
(50, 'Turistički informativni centar', 11, '8', 1, 'icon-tic', '', 'turistički-informativni-centar-turizam-i-transport', 1, 'turisticki informativni centar', 'Tourist Information Center', 'tourist information center', 'tourist-information-center'),
(51, 'Zdravlje', 12, '1', 1, 'icon-zdravlje', '', 'zdravlje-prodavnice-i-usluge', 1, 'zdravlje', 'Health', 'health', 'health'),
(52, 'Vozila', 12, '2', 1, 'icon-vozila', '', 'vozila-prodavnice-i-usluge', 1, 'vozila', 'Vehicles', 'vehicles', 'vehicles'),
(53, 'Odjeća i obuća', 12, '3', 1, 'icon-odjeca', '', 'odjeća-i-obuća-prodavnice-i-usluge', 1, 'odjeca i obuca', 'Clothing and footwear', 'clothing and footwear', 'clothing-and-footwear'),
(54, 'Finansije', 12, '4', 1, 'icon-finansije', '', 'finansije-prodavnice-i-usluge', 1, 'finansije', 'Finance', 'finance', 'finance'),
(55, 'Za dom', 12, '5', 1, 'icon-dom', '', 'za-dom-prodavnice-i-usluge', 1, 'za dom', 'Home appliances', 'home appliances', 'home-appliances'),
(56, 'Tehnika', 12, '6', 1, 'icon-komp', '', 'tehnika-prodavnice-i-usluge', 1, 'tehnika', 'Technique', 'technique', 'technique'),
(57, 'Market', 12, '7', 1, 'icon-market', '', 'market-prodavnice-i-usluge', 1, 'market', 'Market', 'market', 'market'),
(58, 'Optika', 12, '8', 1, 'icon-optika', '', 'optika-prodavnice-i-usluge', 1, 'optika', 'Optics', 'optics', 'optics'),
(59, 'Ljepota', 12, '1', 1, 'icons-vello', '', 'ljepota-prodavnice-i-usluge', 1, 'ljepota', 'Beauty', 'beauty', 'beauty'),
(60, 'Kućni ljubimci', 12, '10', 1, 'icon-ljubimci', '', 'kućni-ljubimci-prodavnice-i-usluge', 1, 'kucni ljubimci', 'Pets', 'pets', 'pets'),
(61, 'Foto', 12, '11', 1, 'icon-foto', '', 'foto-prodavnice-i-usluge', 1, 'foto', 'Photo', 'photo', 'photo'),
(62, 'Muzej', 13, '1', 1, 'icon-museum33', '', 'muzej-umjetnost-i-zabava', 1, 'muzej', 'Museum', 'museum', 'museum'),
(63, 'Kino', 13, '2', 1, 'icon-kino', '', 'kino-umjetnost-i-zabava', 1, 'kino', 'Cinema', 'cinema', 'cinema'),
(64, 'Pozorište', 13, '3', 1, 'icon-teatar', '', 'pozorište-umjetnost-i-zabava', 1, 'pozoriste', 'Theater', 'theater', 'theater'),
(65, 'Dvorana', 13, '4', 1, 'icon-dvorana', '', 'dvorana-umjetnost-i-zabava', 1, 'dvorana', 'Hall', 'hall', 'hall'),
(66, 'Muzika uživo', 13, '5', 1, 'icon-muzicka', '', 'muzika-uživo-umjetnost-i-zabava', 1, 'muzika uzivo', 'Live Music', 'live music', 'live-music'),
(67, 'Sport i rekreacija', 13, '5', 1, 'icon-sport', '', 'sport-i-rekreacija-umjetnost-i-zabava', 1, 'sport i rekreacija', 'Sports and Recreation', 'sports and recreation', 'sports-and-recreation'),
(68, 'Mostovi', 14, '1', 1, 'icon-def', '', 'mostovi-parkovi-i-atrakcije', 1, 'mostovi', 'Bridges', 'bridges', 'bridges'),
(69, 'Park', 14, '2', 1, 'icon-park', '', 'park-parkovi-i-atrakcije', 1, 'park', 'Park', 'park', 'park'),
(70, 'Tvrđava', 14, '3', 1, 'icon-hram', '', 'tvrđava-parkovi-i-atrakcije', 1, 'tvrdava', 'Fortress', 'fortress', 'fortress'),
(71, 'Planina', 14, '4', 1, 'icon-def', '', 'planina-parkovi-i-atrakcije', 1, 'planina', 'Mountain', 'mountain', 'mountain'),
(72, 'Groblje', 15, '3', 1, 'icon-groblje', '', 'groblje-profesije-i-ostala-mjesta', 1, 'groblje', 'Cemetery', 'cemetery', 'cemetery'),
(73, 'Vjerski objekti', 11, '10', 1, 'icon-vjerski', '', 'vjerski-objekti-turizam-i-transport', 1, 'vjerski objekti', 'Religious buildings', 'religious buildings', 'religious-buildings'),
(74, 'Kulturni centar', 15, '1', 1, 'icon-kulturni', '', 'kulturni-centar-profesije-i-ostala-mjesta', 1, 'kulturni centar', 'Cultural Center', 'cultural center', 'cultural-center'),
(75, 'Fabrika', 15, '2', 1, 'icon-fabrika', '', 'fabrika-profesije-i-ostala-mjesta', 1, 'fabrika', 'Factory', 'factory', 'factory'),
(76, 'Pogreb', 15, '4', 1, 'icon-pogreb', '', 'pogreb-profesije-i-ostala-mjesta', 1, 'pogreb', 'Funeral service', 'funeral service', 'funeral-service'),
(77, 'Institucije', 15, '5', 1, 'icon-institucije', '', 'institucije-profesije-i-ostala-mjesta', 1, 'institucije', 'Institutions', 'institutions', 'institutions'),
(78, 'Knjižara', 15, '6', 1, 'icon-knjizara', '', 'knjižara-profesije-i-ostala-mjesta', 1, 'knjizara', 'Bookstore', 'bookstore', 'bookstore'),
(79, 'Općina', 15, '7', 1, 'icon-opcina', '', 'općina-profesije-i-ostala-mjesta', 1, 'opcina', 'Municipality', 'municipality', 'municipality'),
(80, 'Parking', 15, '8', 1, 'icon-parking', '', 'parking-profesije-i-ostala-mjesta', 1, 'parking', 'Parking', 'parking', 'parking'),
(81, 'Pošta', 15, '9', 1, 'icon-posta', '', 'pošta-profesije-i-ostala-mjesta', 1, 'posta', 'Post office', 'post office', 'post-office'),
(82, 'Radio / TV', 15, '10', 1, 'icon-tv', '', 'radio-tv', 1, 'radio / tv', 'Radio / TV', 'radio / tv', 'radio-tv'),
(83, 'Vrtić za djecu', 15, '12', 1, 'icon-vrtic', '', 'vrtić-za-djecu-profesije-i-ostala-mjesta', 1, 'vrtic za djecu', 'Nursery for children', 'nursery for children', 'nursery-for-children'),
(84, 'Dizajn studio', 15, '13', 1, 'icon-usluge', '', 'dizajn-studio-profesije-i-ostala-mjesta', 1, 'dizajn studio', 'Design Studio', 'design studio', 'design-studio'),
(85, 'Nakit', 15, '13', 1, 'icon-nakit', '', 'nakit-profesije-i-ostala-mjesta', 1, 'nakit', 'Jewelry', 'jewelry', 'jewelry'),
(86, 'Advokat', 15, '14', 1, 'icon-advokat', '', 'advokat-profesije-i-ostala-mjesta', 1, 'advokat', 'Lawyer', 'lawyer', 'lawyer'),
(87, 'Notar', 15, '15', 1, 'icon-advokat', '', 'notar-profesije-i-ostala-mjesta', 1, 'notar', 'Public notary', 'public notary', 'public-notary'),
(88, 'Tržni centar', 12, '0', 1, 'icon-tcentar', '', 'tržni-centar-prodavnice-i-usluge', 1, 'trzni centar', 'Shopping center', 'shopping center', 'shopping-center'),
(89, 'Vjerski / Duhovni objekti', 15, '0', 1, 'icon-vjerskiobjekti', '', 'vjerski-duhovni-objekti-profesije-i-ostala-mjesta', 1, 'vjerski / duhovni objekti', 'Religious / Spiritual places', 'religious / spiritual places', 'religious-spiritual-places'),
(90, 'Ostale profesije', 15, '0', 1, 'icon-ostale', '', 'ostale-profesije', 1, 'ostale profesije', 'Other professions', 'other professions', 'other-professions'),
(91, 'Ostale atrakcije', 14, '0', 1, 'icon-foto', '', 'ostale-atrakcije-parkovi-i-atrakcije', 1, 'ostale atrakcije', 'Other attractions', 'other attractions', 'other-attractions'),
(92, 'Nevladina organizacija', 15, '0', 1, 'icon-udruzenje', '', 'nevladina-organizacija-profesije-i-ostala-mjesta', 1, 'nevladina organizacija', 'NGO', 'ngo', 'ngo'),
(93, 'Ostale prodavnice', 12, '0', 1, 'icon-prodavnica', '', 'ostale-prodavnice', 1, 'ostale prodavnice', 'Other shops', 'other shops', 'other-shops'),
(94, 'Festival', 13, '0', 1, 'icon-festival', '', 'festival', 1, 'festival', 'Festival', 'festival', 'festival'),
(95, 'Spomenik', 14, '0', 1, 'icon-spomenik', '', 'spomenik-parkovi-i-atrakcije', 1, 'spomenik', 'Monument', 'monument', 'monument'),
(96, 'Galerija', 13, '0', 1, 'icon-galerija', '', 'galerija-umjetnost-i-zabava', 1, 'galerija', 'Gallery', 'gallery', 'gallery'),
(97, 'Poslovni centar', 12, '0', 1, 'icon-poslovni', '', 'poslovni-centar', 1, 'poslovni centar', 'Business center', 'business center', 'business-center'),
(98, 'Udruženje', 15, '0', 1, 'icon-udruzenje', '', 'udruženje-no-parent', 1, 'udruzenje', 'Association', 'association', 'association'),
(99, 'Ostale usluge', 12, '0', 1, 'icon-usluge', '', 'ostale-usluge', 1, 'ostale usluge', 'Other services', 'other services', 'other-services'),
(100, 'Ostala mjesta', 15, '0', 1, 'icon-def', '', 'ostala-mjesta', 1, 'ostala mjesta', 'Other places', 'other places', 'other-places') ;