INSERT INTO viviendas (
    titulo, descripcion, ciudad, provincia, precio, metros_cuadrados,
    habitaciones, banos, tipo, estado, ascensor, terraza, garaje,
    disponible, fecha_publicacion
) VALUES

-- SEVILLA
('Piso céntrico en Triana', 'Luminoso piso reformado', 'Sevilla', 'Sevilla', 180000, 85, 3, 1, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2024-01-10'),
('Ático con terraza en Nervión', 'Ático moderno con vistas', 'Sevilla', 'Sevilla', 320000, 95, 2, 2, 'ATICO', 'NUEVA', true, true, true, true, '2024-02-15'),
('Casa familiar en Dos Hermanas', 'Casa amplia con patio', 'Dos Hermanas', 'Sevilla', 240000, 140, 4, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-12-01'),
('Piso para reformar en Macarena', 'Ideal inversión', 'Sevilla', 'Sevilla', 120000, 70, 2, 1, 'PISO', 'REFORMAR', false, false, false, false, '2023-10-20'),
('Chalet en Aljarafe', 'Chalet independiente con jardín', 'Mairena del Aljarafe', 'Sevilla', 410000, 220, 5, 3, 'CHALET', 'SEGUNDA_MANO', false, true, true, true, '2024-03-01'),

-- CÁDIZ
('Piso cerca de la playa', 'A 200m del mar', 'Cádiz', 'Cádiz', 210000, 80, 3, 1, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2024-01-05'),
('Ático en La Caleta', 'Terraza con vistas al mar', 'Cádiz', 'Cádiz', 350000, 90, 2, 2, 'ATICO', 'NUEVA', true, true, true, true, '2024-02-28'),
('Casa adosada en Chiclana', 'Zona tranquila', 'Chiclana', 'Cádiz', 190000, 120, 3, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-11-18'),
('Piso económico', 'Buena oportunidad', 'San Fernando', 'Cádiz', 95000, 65, 2, 1, 'PISO', 'REFORMAR', false, false, false, false, '2023-09-10'),
('Chalet con piscina', 'Ideal vacaciones', 'Conil', 'Cádiz', 420000, 200, 4, 3, 'CHALET', 'NUEVA', false, true, true, true, '2024-03-12'),

-- MÁLAGA
('Piso en el centro histórico', 'Ubicación premium', 'Málaga', 'Málaga', 275000, 88, 3, 2, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2024-01-25'),
('Ático en la Malagueta', 'Vistas panorámicas', 'Málaga', 'Málaga', 480000, 110, 3, 2, 'ATICO', 'NUEVA', true, true, true, true, '2024-02-05'),
('Casa rural', 'Ideal turismo rural', 'Ronda', 'Málaga', 160000, 130, 3, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-10-05'),
('Piso pequeño', 'Ideal para parejas', 'Torremolinos', 'Málaga', 140000, 55, 1, 1, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2023-12-22'),
('Chalet de lujo', 'Zona exclusiva', 'Marbella', 'Málaga', 750000, 300, 5, 4, 'CHALET', 'NUEVA', false, true, true, true, '2024-03-20'),

-- HUELVA
('Piso en el centro', 'Muy bien comunicado', 'Huelva', 'Huelva', 130000, 75, 2, 1, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2024-01-12'),
('Casa con patio', 'Barrio tranquilo', 'Almonte', 'Huelva', 165000, 115, 3, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-11-30'),
('Piso para reformar', 'Gran potencial', 'Lepe', 'Huelva', 90000, 70, 2, 1, 'PISO', 'REFORMAR', false, false, false, false, '2023-08-15'),
('Chalet en la playa', 'Primera línea', 'Isla Cristina', 'Huelva', 380000, 180, 4, 3, 'CHALET', 'SEGUNDA_MANO', false, true, true, true, '2024-02-18'),
('Ático moderno', 'Recién construido', 'Huelva', 'Huelva', 260000, 85, 2, 2, 'ATICO', 'NUEVA', true, true, true, true, '2024-03-08'),

-- CÓRDOBA
('Piso casco histórico', 'Cerca de la Mezquita', 'Córdoba', 'Córdoba', 170000, 78, 2, 1, 'PISO', 'SEGUNDA_MANO', false, false, false, true, '2024-01-03'),
('Casa tradicional', 'Patio andaluz', 'Córdoba', 'Córdoba', 230000, 160, 4, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-12-05'),
('Piso nuevo', 'Obra nueva', 'Lucena', 'Córdoba', 195000, 90, 3, 2, 'PISO', 'NUEVA', true, false, true, true, '2024-02-11'),
('Ático para reformar', 'Gran terraza', 'Puente Genil', 'Córdoba', 150000, 100, 2, 1, 'ATICO', 'REFORMAR', false, true, false, false, '2023-09-25'),
('Chalet en la sierra', 'Naturaleza y tranquilidad', 'Pozoblanco', 'Córdoba', 310000, 210, 4, 3, 'CHALET', 'SEGUNDA_MANO', false, true, true, true, '2024-03-02'),

-- GRANADA
('Piso cerca de la Alhambra', 'Zona histórica', 'Granada', 'Granada', 220000, 85, 3, 1, 'PISO', 'SEGUNDA_MANO', true, false, false, true, '2024-01-08'),
('Casa en el Albaicín', 'Encanto tradicional', 'Granada', 'Granada', 340000, 170, 4, 2, 'CASA', 'SEGUNDA_MANO', false, true, true, true, '2023-11-12'),
('Ático moderno', 'Edificio nuevo', 'Armilla', 'Granada', 260000, 90, 2, 2, 'ATICO', 'NUEVA', true, true, true, true, '2024-02-20'),
('Piso económico', 'Ideal estudiantes', 'Maracena', 'Granada', 110000, 60, 2, 1, 'PISO', 'SEGUNDA_MANO', false, false, false, true, '2023-10-01'),
('Chalet con vistas', 'Vistas a Sierra Nevada', 'La Zubia', 'Granada', 395000, 230, 5, 3, 'CHALET', 'NUEVA', false, true, true, true, '2024-03-18');
