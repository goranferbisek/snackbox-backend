-- =====================
-- Categories
-- =====================
INSERT INTO categories (name) VALUES ('Chinese food');
INSERT INTO categories (name) VALUES ('Pizzas');
INSERT INTO categories (name) VALUES ('Balkan');
INSERT INTO categories (name) VALUES ('Bakery');
INSERT INTO categories (name) VALUES ('Sweets');

-- =====================
-- Users (Restaurant Owners)
-- =====================
INSERT INTO users (email, password, username) VALUES ('owner1@example.com', 'pass123', 'Dragon Palace Owner');
INSERT INTO users (email, password, username) VALUES ('owner2@example.com', 'pass123', 'Golden Wok Owner');
INSERT INTO users (email, password, username) VALUES ('owner3@example.com', 'pass123', 'Pizza Roma Owner');
INSERT INTO users (email, password, username) VALUES ('owner4@example.com', 'pass123', 'Bella Napoli Owner');
INSERT INTO users (email, password, username) VALUES ('owner5@example.com', 'pass123', 'Balkan Grill Owner');
INSERT INTO users (email, password, username) VALUES ('owner6@example.com', 'pass123', 'Cevabdzinica Owner');
INSERT INTO users (email, password, username) VALUES ('owner7@example.com', 'pass123', 'Fresh Bakery Owner');
INSERT INTO users (email, password, username) VALUES ('owner8@example.com', 'pass123', 'Golden Crust Owner');
INSERT INTO users (email, password, username) VALUES ('owner9@example.com', 'pass123', 'Sweet Dreams Owner');
INSERT INTO users (email, password, username) VALUES ('owner10@example.com', 'pass123', 'Candy Heaven Owner');

-- =====================
-- Merchants (Restaurants)
-- =====================
-- Chinese Restaurants
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Dragon Palace', 'Authentic Chinese cuisine', 3.50, 1, 1);
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Golden Wok', 'Traditional Chinese dishes', 2.99, 2, 1);

-- Pizza Restaurants
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Pizza Roma', 'Italian style pizzas', 2.50, 3, 2);
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Bella Napoli', 'Neapolitan pizza specialists', 3.00, 4, 2);

-- Balkan Restaurants
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Balkan Grill', 'Traditional Balkan grilled meats', 3.00, 5, 3);
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Cevabdzinica', 'Best cevapi in town', 2.50, 6, 3);

-- Bakeries
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Fresh Bakery', 'Freshly baked goods daily', 2.00, 7, 4);
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Golden Crust', 'Artisan breads and pastries', 2.50, 8, 4);

-- Sweet Shops
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Sweet Dreams', 'Delicious desserts and cakes', 2.00, 9, 5);
INSERT INTO merchants(name, description, delivery_fee, owner_id, category_id) VALUES ('Candy Heaven', 'Premium chocolates and sweets', 1.99, 10, 5);

-- =====================
-- Menu Sections - Dragon Palace
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Appetizers', 1);
INSERT INTO menu_section (name, merchant_id) VALUES ('Main Dishes', 1);
INSERT INTO menu_section (name, merchant_id) VALUES ('Rice & Noodles', 1);

-- =====================
-- Menu Items - Dragon Palace
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Spring Rolls', 4.99, 1, 1);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Dumplings', 5.99, 1, 1);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Wonton Soup', 6.50, 1, 1);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Kung Pao Chicken', 12.99, 1, 2);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Sweet and Sour Pork', 13.50, 1, 2);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Beef with Broccoli', 14.99, 1, 2);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Fried Rice', 8.99, 1, 3);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chow Mein', 9.99, 1, 3);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Lo Mein', 10.50, 1, 3);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Pad Thai', 11.99, 1, 3);

-- =====================
-- Menu Sections - Golden Wok
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Starters', 2);
INSERT INTO menu_section (name, merchant_id) VALUES ('Chef Specials', 2);
INSERT INTO menu_section (name, merchant_id) VALUES ('Vegetarian', 2);
INSERT INTO menu_section (name, merchant_id) VALUES ('Soups', 2);

-- =====================
-- Menu Items - Golden Wok
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Egg Rolls', 4.50, 2, 4);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Crab Rangoon', 6.99, 2, 4);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('General Tso Chicken', 13.99, 2, 5);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Mongolian Beef', 15.50, 2, 5);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Orange Chicken', 12.99, 2, 5);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Buddha Delight', 10.99, 2, 6);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Mapo Tofu', 9.99, 2, 6);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Vegetable Stir Fry', 8.99, 2, 6);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Hot and Sour Soup', 5.99, 2, 7);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Egg Drop Soup', 4.99, 2, 7);

-- =====================
-- Menu Sections - Pizza Roma
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Classic Pizzas', 3);
INSERT INTO menu_section (name, merchant_id) VALUES ('Gourmet Pizzas', 3);
INSERT INTO menu_section (name, merchant_id) VALUES ('Sides', 3);

-- =====================
-- Menu Items - Pizza Roma
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Margherita', 10.99, 3, 8);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Pepperoni', 11.99, 3, 8);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Hawaiian', 12.50, 3, 8);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Vegetarian', 11.50, 3, 8);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Quattro Formaggi', 14.99, 3, 9);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Prosciutto e Rucola', 15.99, 3, 9);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Truffle Pizza', 18.99, 3, 9);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Garlic Bread', 4.99, 3, 10);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Caesar Salad', 6.99, 3, 10);

-- =====================
-- Menu Sections - Bella Napoli
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Traditional Pizzas', 4);
INSERT INTO menu_section (name, merchant_id) VALUES ('Specialty Pizzas', 4);
INSERT INTO menu_section (name, merchant_id) VALUES ('Appetizers', 4);

-- =====================
-- Menu Items - Bella Napoli
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Marinara', 9.99, 4, 11);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Napoli', 12.99, 4, 11);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Diavola', 13.50, 4, 11);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Carbonara Pizza', 15.50, 4, 12);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Seafood Pizza', 17.99, 4, 12);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Capricciosa', 14.99, 4, 12);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Calzone', 13.99, 4, 12);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Bruschetta', 5.99, 4, 13);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Mozzarella Sticks', 6.50, 4, 13);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Caprese Salad', 7.99, 4, 13);

-- =====================
-- Menu Sections - Balkan Grill
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Grilled Meats', 5);
INSERT INTO menu_section (name, merchant_id) VALUES ('Platters', 5);
INSERT INTO menu_section (name, merchant_id) VALUES ('Sides & Salads', 5);

-- =====================
-- Menu Items - Balkan Grill
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cevapi (10 pcs)', 8.99, 5, 14);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Pljeskavica', 9.99, 5, 14);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chicken Shish Kebab', 10.50, 5, 14);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Lamb Chops', 16.99, 5, 14);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Mixed Grill Platter', 22.99, 5, 15);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Family Feast', 49.99, 5, 15);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Ajvar', 3.50, 5, 16);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Shopska Salad', 5.99, 5, 16);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Baked Beans', 4.50, 5, 16);

-- =====================
-- Menu Sections - Cevabdzinica
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Cevapi Specialties', 6);
INSERT INTO menu_section (name, merchant_id) VALUES ('Other Grills', 6);
INSERT INTO menu_section (name, merchant_id) VALUES ('Traditional Dishes', 6);
INSERT INTO menu_section (name, merchant_id) VALUES ('Extras', 6);

-- =====================
-- Menu Items - Cevabdzinica
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cevapi Portion (5 pcs)', 5.99, 6, 17);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cevapi Portion (10 pcs)', 9.50, 6, 17);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Jumbo Cevapi (15 pcs)', 13.99, 6, 17);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Raznjici', 11.99, 6, 18);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Veal Pljeskavica', 10.99, 6, 18);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Bosanski Lonac', 12.99, 6, 19);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Sarma', 11.50, 6, 19);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Somun Bread', 2.00, 6, 20);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Kajmak', 3.50, 6, 20);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Grilled Peppers', 4.00, 6, 20);

-- =====================
-- Menu Sections - Fresh Bakery
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Breads', 7);
INSERT INTO menu_section (name, merchant_id) VALUES ('Pastries', 7);
INSERT INTO menu_section (name, merchant_id) VALUES ('Breakfast', 7);

-- =====================
-- Menu Items - Fresh Bakery
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Sourdough Loaf', 4.50, 7, 21);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Whole Wheat Bread', 3.99, 7, 21);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Baguette', 2.50, 7, 21);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Croissant', 2.99, 7, 22);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Pain au Chocolat', 3.50, 7, 22);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Apple Strudel', 4.99, 7, 22);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Danish Pastry', 3.99, 7, 22);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Breakfast Sandwich', 5.99, 7, 23);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Bagel with Cream Cheese', 4.50, 7, 23);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Muffin Variety', 2.99, 7, 23);

-- =====================
-- Menu Sections - Golden Crust
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Artisan Breads', 8);
INSERT INTO menu_section (name, merchant_id) VALUES ('Sweet Pastries', 8);
INSERT INTO menu_section (name, merchant_id) VALUES ('Savory Bakes', 8);
INSERT INTO menu_section (name, merchant_id) VALUES ('Cakes', 8);

-- =====================
-- Menu Items - Golden Crust
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Ciabatta', 4.99, 8, 24);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Multigrain Loaf', 5.50, 8, 24);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cinnamon Roll', 3.99, 8, 25);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Almond Croissant', 4.50, 8, 25);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Pecan Danish', 4.25, 8, 25);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cheese Burek', 5.99, 8, 26);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Spinach Pie', 6.50, 8, 26);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Meat Pie', 7.50, 8, 26);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Carrot Cake Slice', 5.99, 8, 27);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Cheesecake Slice', 6.50, 8, 27);

-- =====================
-- Menu Sections - Sweet Dreams
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Cakes & Tortes', 9);
INSERT INTO menu_section (name, merchant_id) VALUES ('Cookies & Brownies', 9);
INSERT INTO menu_section (name, merchant_id) VALUES ('Ice Cream', 9);

-- =====================
-- Menu Items - Sweet Dreams
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chocolate Torte', 6.99, 9, 28);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Red Velvet Cake', 6.50, 9, 28);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Tiramisu', 7.50, 9, 28);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Black Forest Cake', 7.99, 9, 28);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chocolate Chip Cookies (6 pcs)', 4.99, 9, 29);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Brownies (4 pcs)', 5.50, 9, 29);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Macarons (6 pcs)', 8.99, 9, 29);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Vanilla Ice Cream', 3.99, 9, 30);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chocolate Ice Cream', 3.99, 9, 30);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Strawberry Ice Cream', 3.99, 9, 30);

-- =====================
-- Menu Sections - Candy Heaven
-- =====================
INSERT INTO menu_section (name, merchant_id) VALUES ('Premium Chocolates', 10);
INSERT INTO menu_section (name, merchant_id) VALUES ('Candy Selection', 10);
INSERT INTO menu_section (name, merchant_id) VALUES ('Gift Boxes', 10);

-- =====================
-- Menu Items - Candy Heaven
-- =====================
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Belgian Truffles (12 pcs)', 15.99, 10, 31);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Dark Chocolate Bar', 4.99, 10, 31);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Milk Chocolate Bar', 4.50, 10, 31);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chocolate Pralines (6 pcs)', 9.99, 10, 31);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Gummy Bears (500g)', 6.99, 10, 32);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Lollipops Mix (10 pcs)', 5.50, 10, 32);

INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Chocolate Gift Box', 24.99, 10, 33);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Mixed Sweets Box', 19.99, 10, 33);
INSERT INTO menu_item (name, price, merchant_id, section_id) VALUES ('Luxury Truffle Collection', 39.99, 10, 33);
