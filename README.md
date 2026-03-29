# StoreSystem

A simple Java console application for managing a small store: products, customers, and shopping carts.

## Overview

This project provides a menu-driven command-line interface that allows you to:

- Add new products to the store
- Add new customers
- Add products to a customer's cart
- View a customer's cart and total price
- Empty a customer's cart
- Search for a product by name

The application keeps data in memory while running (no database or file persistence).

## Project Structure

- `src/Main.java`: program entry point and menu flow
- `src/Product.java`: base product model
- `src/ProductType.java`: marker interface for product categories
- `src/Book.java`: book-specific details (`authorName`, `language`)
- `src/Shoes.java`: shoes-specific details (`style`, `color`, `size`)
- `src/Game.java`: game-specific details (`releaseDate`, `companyName`, `rating`)
- `src/Cart.java`: cart item (product + quantity)
- `src/Customer.java`: customer model and cart display logic
- `build.xml`: Ant build configuration (NetBeans-style project)
- `nbproject/`: NetBeans project metadata


