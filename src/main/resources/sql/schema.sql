CREATE DATABASE IF NOT EXISTS snackbox
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE snackbox;

-- =====================
-- Users
-- =====================
CREATE TABLE IF NOT EXISTS users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    UNIQUE (email),
    UNIQUE (username)
);

-- =====================
-- Categories
-- =====================
CREATE TABLE IF NOT EXISTS categories
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,

    UNIQUE (name)
);

-- =====================
-- Merchant
-- =====================
CREATE TABLE IF NOT EXISTS merchant
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(500),
    delivery_fee DECIMAL(10, 2) NOT NULL,
    owner_id     BIGINT,
    category_id  BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,

    UNIQUE (owner_id),

    FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE RESTRICT,
    FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE RESTRICT
);

-- =====================
-- Menu Section
-- =====================
CREATE TABLE IF NOT EXISTS menu_section
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    merchant_id BIGINT,

    FOREIGN KEY (merchant_id) REFERENCES merchant (id) ON DELETE CASCADE,
    CONSTRAINT UC_Menu_Section UNIQUE (name, merchant_id)
);

-- =====================
-- Menu Item
-- =====================
CREATE TABLE IF NOT EXISTS menu_item
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    price       DECIMAL(10, 2),
    merchant_id BIGINT,
    section_id  BIGINT,

    FOREIGN KEY (merchant_id) REFERENCES merchant (id) ON DELETE CASCADE,
    FOREIGN KEY (section_id) REFERENCES menu_section (id) ON DELETE CASCADE,
    CONSTRAINT UC_Menu_Item UNIQUE (name, section_id)
);