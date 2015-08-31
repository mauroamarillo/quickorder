-- Borro todos los datos de la base de datos

TRUNCATE TABLE usuarios CASCADE;
TRUNCATE TABLE categorias CASCADE;

-- Clientes e imagenes de clientes

INSERT INTO usuarios(nickname, contrasenia, nombre, email, direccion) VALUES('costas', '1234', 'Gerardo', 'gcostas@gmail.com', 'Av. Italia 2078');
INSERT INTO clientes("nicknameC", apellido, "fechaN") VALUES('costas', 'Costas', '15/11/1983');
INSERT INTO clientes_imagenes(cliente, imagen) VALUES ('costas', 'http://bit.ly/1yTfPav');

INSERT INTO usuarios(nickname, contrasenia, nombre, email, direccion) VALUES('roro', '1234', 'Rodrigo', 'rcotelo@yahoo.com', 'Pdte. Berro 1548');
INSERT INTO clientes("nicknameC", apellido, "fechaN") VALUES('roro', 'Cotelo', '02/08/1975');
INSERT INTO clientes_imagenes(cliente, imagen) VALUES ('roro', 'http://bit.ly/Xwsg0F');

INSERT INTO usuarios(nickname, contrasenia,nombre, email, direccion) VALUES('chechi', '1234', 'Cecilia', 'cgarrido@hotmail.com', 'Gral.Urquiza 1548');
INSERT INTO clientes("nicknameC", apellido, "fechaN") VALUES('chechi', 'Garrido', '12/09/1951');
INSERT INTO clientes_imagenes(cliente, imagen) VALUES ('chechi', 'http://bit.ly/1AtwVOA');

INSERT INTO usuarios(nickname, contrasenia,nombre, email, direccion) VALUES('andy', '1234', 'Andrea', 'agarcia@gmail.com', 'Dr. Manuel Albo 5412');
INSERT INTO clientes("nicknameC", apellido, "fechaN") VALUES('andy', 'Garcia', '28/07/1951');
INSERT INTO clientes_imagenes(cliente, imagen) VALUES ('andy', 'http://bit.ly/1AtxfwQ');

INSERT INTO usuarios(nickname, contrasenia,nombre, email, direccion) VALUES('weiss', '1234', 'Adrian', 'aweiss@hotmail.com', 'Monte Caseros 5615');
INSERT INTO clientes("nicknameC", apellido, "fechaN") VALUES('weiss', 'Weiss', '23/12/1978');
INSERT INTO clientes_imagenes(cliente, imagen) VALUES ('weiss', 'http://bit.ly/1uPV2XC');

-- Categorias para restaurantes
 
INSERT INTO categorias(nombre) VALUES('Chivitos');
INSERT INTO categorias(nombre) VALUES('Minutas');
INSERT INTO categorias(nombre) VALUES('Parrilla');
INSERT INTO categorias(nombre) VALUES('Pizzas');
INSERT INTO categorias(nombre) VALUES('Empanadas');
INSERT INTO categorias(nombre) VALUES('Milanesas');
INSERT INTO categorias(nombre) VALUES('Ensaladas');
INSERT INTO categorias(nombre) VALUES('Pastas');
INSERT INTO categorias(nombre) VALUES('Comida China');
INSERT INTO categorias(nombre) VALUES('Picadas');
INSERT INTO categorias(nombre) VALUES('Woks');
INSERT INTO categorias(nombre) VALUES('Comida Mexicana');
INSERT INTO categorias(nombre) VALUES('Entradas');
INSERT INTO categorias(nombre) VALUES('Bebidas');
INSERT INTO categorias(nombre) VALUES('Sushi');

-- Restaurantes

INSERT INTO usuarios(nickname,contrasenia, nombre, email, direccion) VALUES('mera', '1234', 'Pizzeria Mera', 'mera@hotmail.com', 'Av. 8 de octubre 2704');
INSERT INTO restaurantes("nicknameR") VALUES('mera');

INSERT INTO usuarios(nickname,contrasenia, nombre, email, direccion) VALUES('rossell','1234', 'Bar Rosell', 'bar.rosell@gmail.com', 'Bvar. Artigas 1601');
INSERT INTO restaurantes("nicknameR") VALUES('rossell');

INSERT INTO usuarios(nickname,contrasenia, nombre, email, direccion) VALUES('bocatti','1234', 'Empanadas Bocatti', 'bocatti@gmail.com', '18 de julio 2138');
INSERT INTO restaurantes("nicknameR") VALUES('bocatti');

INSERT INTO usuarios(nickname,contrasenia, nombre, email, direccion) VALUES('winb', '1234','Wok in Box', 'wok.in.box@hotmail.com', 'Libertad 2535');
INSERT INTO restaurantes("nicknameR") VALUES('winb');

-- Categorias de restaurantes

INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('mera', (SELECT "idCat" FROM categorias WHERE nombre = 'Chivitos'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('mera', (SELECT "idCat" FROM categorias WHERE nombre = 'Minutas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('mera', (SELECT "idCat" FROM categorias WHERE nombre = 'Parrilla'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('mera', (SELECT "idCat" FROM categorias WHERE nombre = 'Pizzas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('rossell', (SELECT "idCat" FROM categorias WHERE nombre = 'Chivitos'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('rossell', (SELECT "idCat" FROM categorias WHERE nombre = 'Minutas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('rossell', (SELECT "idCat" FROM categorias WHERE nombre = 'Pizzas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('rossell', (SELECT "idCat" FROM categorias WHERE nombre = 'Pastas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('bocatti', (SELECT "idCat" FROM categorias WHERE nombre = 'Empanadas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('winb', (SELECT "idCat" FROM categorias WHERE nombre = 'Pastas'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('winb', (SELECT "idCat" FROM categorias WHERE nombre = 'Comida China'));
INSERT INTO restaurantes_categorias(restaurante, categoria) VALUES('winb', (SELECT "idCat" FROM categorias WHERE nombre = 'Woks'));

-- Imagenes de restaurantes

INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('rossell', 'http://bit.ly/Ys5eIs');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('rossell', 'http://bit.ly/1p8epYD');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('bocatti', 'http://bit.ly/1tc54QS');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('bocatti', 'http://bit.ly/1oVRg6G');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('bocatti', 'http://bit.ly/1vaOm3K');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('winb', 'http://bit.ly/1o7Uy6L');
INSERT INTO restaurantes_imagenes(restaurante, imagen) VALUES('winb', 'http://bit.ly/1vaOPmv');

-- Productos individuales

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'Asado', 'Asado a la parrilla');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('mera', 'Asado', 225);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'Milanesa de Carne', 'Con lechuga, tomate, mayonesa y fritas');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('mera', 'Milanesa de Carne', 180);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'Chivito canadiense', 'Lomito, jamon, muzza, tomate, aceitunas, panceta, huevo, morron y fritas');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('mera', 'Chivito canadiense', 305);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'Pizza 2 gustos', 'Pizza con dos gustos a elección');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('mera', 'Pizza 2 gustos', 130);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('rossell', 'Chivito al plato', 'Ensalada rusa, mixta, huevo, jamon, muzza, panceta, aceitunas y fritas');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('rossell', 'Chivito al plato', 324);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('rossell', 'Milanesa a caballo', 'Milanesa con dos huevos fritos acomañada de fritas');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('rossell', 'Milanesa a caballo', 270);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('rossell', 'Pizza con 2 gustos', 'Pizza con dos gustos a elección');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('rossell', 'Pizza con 2 gustos', 103);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('rossell', 'Agnolotis', 'Agnolotis de jamón y queso');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('rossell', 'Agnolotis', 225);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('bocatti', 'Empanada de Carne', 'Carne, aceitunas, huevo duro, condimentos');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('bocatti', 'Empanada de Carne', 44);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('bocatti', 'Empanada Americana', 'Carne, panceta y huevo duro');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('bocatti', 'Empanada Americana', 44);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('bocatti', 'Empanada QyC', 'Empanada de queso y cebolla');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('bocatti', 'Empanada QyC', 44);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('bocatti', 'Empanada Capresse', 'Queso, tomate y albahaca');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('bocatti', 'Empanada Capresse', 44);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('winb', 'Thai wok', 'Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('winb', 'Thai wok', 240);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('winb', 'China wok', 'Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('winb', 'China wok', 240);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('winb', 'Classic wok de pollo', 'Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('winb', 'Classic wok de pollo', 230);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('winb', 'Classic wok de cerdo', 'Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz');
INSERT INTO individuales(restaurante, nombre, precio) VALUES('winb', 'Classic wok de cerdo', 230);

-- Imagenes de productos

INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('mera', 'Milanesa de Carne', 'http://bit.ly/1pc6CsT');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('mera', 'Chivito canadiense', 'http://bit.ly/1rlbezv');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('rossell', 'Milanesa a caballo', 'http://bit.ly/1tfL3Zv');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('rossell', 'Agnolotis', 'http://bit.ly/1tfLenI');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('bocatti', 'Empanada de Carne', 'http://bit.ly/1pJfdTS');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('bocatti', 'Empanada QyC', 'http://bit.ly/1uU6hhH');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('bocatti', 'Empanada Capresse', 'http://bit.ly/1oY1kfm');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('winb', 'Thai wok', 'http://bit.ly/1lgkX7Y');
INSERT INTO productos_imagenes(restaurante, producto, imagen) VALUES('winb', 'Classic wok de pollo', 'http://bit.ly/VEgHTD');

-- Productos promocion

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'ChiviPizza', 'Chivito y Pizza');
INSERT INTO promociones(restaurante, nombre, descuento, activa) VALUES('mera', 'ChiviPizza', 20, true);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('mera', 'ChiviPizza', 'Chivito canadiense', 1);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('mera', 'ChiviPizza', 'Pizza 2 gustos', 1);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('mera', 'MilaAsado', '3 milanesas + 1 Asado para compartir');
INSERT INTO promociones(restaurante, nombre, descuento, activa) VALUES('mera', 'MilaAsado', 30, true);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('mera', 'MilaAsado', 'Milanesa de Carne', 3);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('mera', 'MilaAsado', 'Asado', 1);

INSERT INTO productos(restaurante, nombre, descripcion) VALUES('rossell', 'MilaPizza', '2 Milanesas a caballo + 1 Pizzas 2 gustos');
INSERT INTO promociones(restaurante, nombre, descuento, activa) VALUES('rossell', 'MilaPizza', 10, true);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('rossell', 'MilaPizza', 'Milanesa a caballo', 2);
INSERT INTO promociones_productos(restaurante, nombrepromo, nombreprod, cantidad) VALUES('rossell', 'MilaPizza', 'Pizza con 2 gustos', 2);

-- Pedidos

DO $$
DECLARE p1 bigint;
BEGIN
 INSERT INTO pedidos(fecha, estado, cliente, restaurante) VALUES('12/8/2014', 0, 'costas', 'bocatti') RETURNING numero INTO p1;

 -- Detalle de pedido
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p1, 'bocatti', 'Empanada de Carne', 1);
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p1, 'bocatti', 'Empanada Americana', 2);
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p1, 'bocatti', 'Empanada QyC', 2);
END $$;

DO $$
DECLARE p2 bigint;
BEGIN
 INSERT INTO pedidos(fecha, estado, cliente, restaurante) VALUES('19/8/2014', 0, 'roro', 'mera') RETURNING numero INTO p2;

 -- Detalle de pedido
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p2, 'mera', 'Asado', 3);
END $$;

DO $$
DECLARE p3 bigint;
BEGIN
 INSERT INTO pedidos(fecha, estado, cliente, restaurante) VALUES('19/8/2014', 0, 'chechi', 'winb') RETURNING numero INTO p3;

 -- Detalle de pedido
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p3, 'winb', 'Thai wok', 2);
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p3, 'winb', 'China wok', 3);
END $$;

DO $$
DECLARE p4 bigint;
BEGIN
 INSERT INTO pedidos(fecha, estado, cliente, restaurante) VALUES('22/8/2014', 0, 'andy', 'mera') RETURNING numero INTO p4;

 -- Detalle de pedido
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p4, 'mera', 'Chivito canadiense', 4);
END $$;

DO $$
DECLARE p5 bigint;
BEGIN
 INSERT INTO pedidos(fecha, estado, cliente, restaurante) VALUES('25/8/2014', 0, 'weiss', 'rossell') RETURNING numero INTO p5;

 -- Detalle de pedido
 INSERT INTO pedidos_producto(pedido, restaurante, producto, cantidad) VALUES(p5, 'rossell', 'Agnolotis', 1);
END $$;