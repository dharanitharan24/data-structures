# 🧠 LRU Cache in Java

This repository contains a simple and beginner-friendly implementation of the **Least Recently Used (LRU) Cache** in Java — built entirely from scratch using **HashMap** and **Doubly Linked List**.  

The goal of this implementation is to help learners understand how caching algorithms work under the hood, step by step, with clear examples and readable code.

---

## 🚀 What is an LRU Cache?

**LRU (Least Recently Used)** is a caching algorithm that keeps only a limited number of items in memory.  
When the cache is full and a new item is added, the *least recently used* item is removed.  

In short:  
> “If you haven’t used it in a while, it’s out!”

---

## 🧩 Real-life Example

Imagine your **mobile browser tabs**:  
- You can have only 5 tabs open.  
- When you open a 6th tab, the browser automatically closes the *oldest* one (the one you haven’t visited for the longest time).  
- Every time you open or revisit a tab, it becomes *most recently used*.  

This is exactly how the **LRU cache** works internally.

---

## ⚙️ Data Structures Used

This implementation combines **two powerful structures**:

1. **HashMap** — allows instant access (`O(1)` time) to check if a key exists.  
   - Key → Node (containing both the value and position info).  
2. **Doubly Linked List** — maintains the order of usage efficiently.  
   - The **front** represents the most recently used element.  
   - The **back** represents the least recently used element.

Together, these make both `get()` and `put()` operations run in constant time `O(1)`.

---

## 🧠 How It Works

### 1. `get(String key)`
- If the key exists in the cache:
  - Move that node to the *front* of the list (mark as most recently used).
  - Return its value.
- If it doesn’t exist:
  - Return `null`.

🧭 **Example Flow:**
```
Cache = [Luffy, Zoro, Sanji, Ussop]
get("Zoro") ➜ Move Zoro to front
New order = [Zoro, Luffy, Sanji, Ussop]
```

---

### 2. `put(String key, V value)`
- If the key **already exists**:
  - Update its value.
  - Move it to the front.
- If it’s **new**:
  - If the cache is full, remove the *last* element (least recently used).
  - Add the new node at the *front*.
  - Update the HashMap.

🧭 **Example Flow:**
```
Cache = [Zoro, Luffy, Sanji, Ussop]
put("Chopper", 52)
➜ Remove least used (Ussop)
➜ Add Chopper to front
New order = [Chopper, Zoro, Luffy, Sanji]
```

---

### 3. Supporting Methods

- **`pushFront(Node node)`** — Moves a node to the front of the linked list.
- **`removeLast()`** — Removes the last (least recently used) node from the list.
- **`getLastKey()`** — Returns the key of the least recently used node.
- **`displayCacheOrder()`** — Prints the current cache order from front to back.

---

## 🔍 Code Flow Visualization

```
+---------------------------------------------+
|                  LRUcache                   |
+---------------------------------------------+
| HashMap<String, Node> cache                 |
| DoublyList cacheList                        |
| int currSize, maxSize                       |
+---------------------------------------------+
| + get(key): V                               |
| + put(key, val): void                       |
| + displayCacheOrder(): void                 |
+---------------------------------------------+
             ↑
             |
     +------------------+
     |     DoublyList   |
     +------------------+
     | + pushFront()    |
     | + addFront()     |
     | + removeLast()   |
     | + getLastKey()   |
     +------------------+
             ↑
             |
         +--------+
         |  Node  |
         +--------+
         | key     |
         | val     |
         | next    |
         | prev    |
         +--------+
```

---

## 🧮 Time & Space Complexity

| Operation | Complexity |
|------------|-------------|
| `get()`    | O(1) |
| `put()`    | O(1) |
| Space      | O(capacity) |

Both operations are constant time because of the efficient combination of a HashMap and Doubly Linked List.

---

## 🧑‍💻 Example Output

```
Added key: luffy
Added key: zoro
Added key: sanji
Added key: ussop
Accessed key: zoro → moved to front
Added key: chopper
Accessed key: luffy → moved to front
Removed least recently used key: sanji
Added key: franky
Cache order (front -> back): 29 19 52 13 40

Final cache keys: [ussop, franky, chopper, luffy, zoro]
```

---

## 🧰 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/data-structures.git
   cd data-structures
   ```

2. Compile the code:
   ```bash
   javac src/cache/LRUcache.java
   ```

3. Run it:
   ```bash
   java src.cache.LRUcache
   ```

---

## 🌱 Learning Outcome

From this implementation, beginners can understand:
- How **page replacement algorithms** like LRU work in Operating Systems.
- How **HashMap** and **LinkedList** can work together for performance.
- Why efficient caching is crucial in systems like:
  - Browser history
  - CPU cache management
  - Database query caching
  - Image loading in mobile apps

---

## 🧩 Future Improvements

- Convert to a **generic** cache (e.g., `<K, V>` types).  
- Add **unit tests** under the `/tests` directory.  
- Implement other cache algorithms like **MRU**, **LFU**, or **FIFO** for comparison.

---

## 📘 Author

**Dharanitharan**  
📍 Learning Data Structures & Algorithms in Java  
💡 Exploring system design, caching, and performance engineering
