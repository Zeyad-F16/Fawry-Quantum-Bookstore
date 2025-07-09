# 📚 Fawry Quantum Bookstore

A simple Java-based bookstore system that supports both **paper books** and **eBooks**. The system allows for adding books to inventory, removing outdated books, and processing purchases with delivery (either shipping or email).

---
## Screenshots from my running app
---
![image](https://github.com/user-attachments/assets/149a533a-86fb-41d3-a697-dd157f5ac747)
![image](https://github.com/user-attachments/assets/012f425f-201e-45eb-b6c5-e73bb79810b4)
![image](https://github.com/user-attachments/assets/2d2f6cce-3a52-4c59-ac4e-a980eb7c4ba1)



---

## 🧠 Project Structure

```
Fawry-Quantum-Bookstore/
├── Main.java                     // Entry point of the application
├── bookStore/
│   └── BookStore.java            // Main store logic (buying books, connecting inventory and services)
├── inventory/
│   └── Inventory.java            // Handles storage and management of books
├── models/
│   ├── Book.java                 // Abstract base class for all book types
│   ├── Paper.java                // Represents a physical book
│   ├── EBook.java                // Represents a digital book
│   └── FileType.java             // Enum for eBook formats (PDF, EPUB, MOBI)
├── services/
│   ├── MailService.java          // Handles email delivery for eBooks
│   └── ShippingService.java      // Handles physical shipping for paper books
```

---

## 🚀 Features

- Add physical and digital books to inventory  
- Remove outdated books (older than 20 years)  
- Buy books:
  - Email delivery for eBooks  
  - Shipping for paper books  
- Prevents purchase of demo books  
- Tracks quantity of physical books  

---

## 🛠️ Classes Overview

### `Book` (Abstract)
- Fields: `ISBN`, `title`, `publishYear`, `price`, `isDemo`
- Abstract method: `isShippable()`

### `Paper` (extends `Book`)
- Fields: `quantity`
- `isShippable() → true`

### `EBook` (extends `Book`)
- Fields: `fileType`
- `isShippable() → false`

### `Inventory`
- Stores books
- Adds/removes/fetches books
- Removes books older than 20 years

### `BookStore`
- Buys books by ISBN
- Differentiates between shippable and emailable books
- Uses `ShippingService` and `MailService`

### `ShippingService`
- `ship(Book book, String address, String email, int quantity)`

### `MailService`
- `sendEmail(Book book, String email, FileType fileType)`

```mermaid

classDiagram
    direction LR
    
    class Book {
        -String ISBN
        -String title
        -int publishYear
        -double price
        -boolean isDemo
        +getISBN()
        +getTitle()
        +getPublishYear()
        +getPrice()
        +isDemo()
        +isShippable()*
    }

    class EBook {
        -FileType fileType
        +getFileType()
        +isShippable()
    }

    class Paper {
        -int quantity
        +getQuantity()
        +reduceQuantity(quantity)
        +isShippable()
    }

    class Inventory {
        -ArrayList~Book~ books
        +addBook(book)
        +removeOutdatedBooks(currentYear, books)
        +getBooks()
        +getBook(ISBN)
        +isEmpty()
    }

    class BookStore {
        -Inventory inventory
        -ArrayList~Book~ books
        +buy(ISBN, quantity, email, address)
    }

    class MailService {
        +sendEmail(book, email, fileType)
    }

    class ShippingService {
        +ship(book, address, email, quantity)
    }

    class FileType

    Book <|-- EBook
    Book <|-- Paper

    Inventory o-- Book
    BookStore --> Inventory
    BookStore --> Book
    BookStore --> MailService
    BookStore --> ShippingService
    EBook --> FileType
    MailService --> Book
    ShippingService --> Book
```

```mermaid
sequenceDiagram
    participant Main
    participant Inventory
    participant BookStore
    participant Paper
    participant EBook
    participant MailService
    participant ShippingService

    Main->>Inventory: new Inventory()
    Main->>EBook: create EBook
    Main->>Paper: create Paper
    Main->>Inventory: addBook(ebook)
    Main->>Inventory: addBook(paper)
    Main->>Inventory: removeOutdatedBooks(2020)
    Main->>BookStore: new BookStore(inventory)

    Main->>BookStore: buy("1234567890", 1, email, address)
    BookStore->>Inventory: getBook(ISBN)
    BookStore->>EBook: isDemo()
    BookStore->>EBook: isShippable()
    BookStore->>MailService: sendEmail(book, email, fileType)

    Main->>BookStore: buy("1234567891", 1, email, address)
    BookStore->>Inventory: getBook(ISBN)
    BookStore->>Paper: isDemo()
    BookStore->>Paper: isShippable()
    BookStore->>Paper: getQuantity()
    BookStore->>Paper: reduceQuantity(1)
    BookStore->>ShippingService: ship(book, address, email, 1)
```

