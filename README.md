# Fawry Quantum Bookstore

A simple **Console-based Bookstore System** built in Java for the Fawry Quantum Internship challenge.  
This project simulates a real-world bookstore with different book types — managing inventory, validating actions, and performing book purchases.


## 🚀 Features

- **📗 Book Types:**
  - `PaperBook` : Includes stock and requires shipping.
  - `EBook` : Has file format (e.g. PDF) and sent via email.
  - `ShowcaseBook` : Demo book for display only (not for sale).

- **🧩 Interfaces / Abstraction:**
  - `Purchasable` : Implemented by books that can be purchased.
  - `Shippable` : Implemented by books that require shipping.
  - `Emailable` : Implemented by books that can be emailed.

- **📦 Inventory Management:**
  - Add different types of books.
  - View current inventory.
  - Handle purchase requests based on type.

- **📬 Purchase Logic:**
  - Paper books: Check and reduce stock.
  - EBooks: Simulate email delivery.
  - Showcase books: Cannot be purchased.
