# 📰 CariInfoApp

Aplikasi Android berbasis **Jetpack Compose** untuk menampilkan berita terbaru dari berbagai sumber.  
Dibangun dengan arsitektur **MVVM + Repository Pattern** menggunakan **Kotlin**, **Coroutines**, dan **Retrofit**.

---

## 🚀 Tech Stack

| Layer | Teknologi |
|-------|------------|
| **UI** | Jetpack Compose, Material 3 |
| **Architecture** | MVVM, StateFlow, Repository Pattern |
| **Networking** | Retrofit + OkHttp |
| **Dependency Injection (Sprint 2)** | Hilt |
| **Async / Concurrency** | Kotlin Coroutines |
| **Image Loading (Sprint 2)** | Coil |
| **Navigation (Sprint 2)** | Navigation Compose |
| **Data Persistence (Sprint 3)** | Room Database |

---

## 🧩 Fitur Utama (Sprint 1)

- Menampilkan daftar berita menggunakan API.  
- Arsitektur MVVM terpisah antara ViewModel, Repository, dan UI.  
- Integrasi `Retrofit` untuk koneksi API.  
- Data ditampilkan melalui `HomeScreen` menggunakan **Jetpack Compose**.  
- Struktur kode modular dan scalable.

---

## 📅 Rencana Sprint

### ✅ **Sprint 1 (Selesai)**
> _Fokus pada pondasi arsitektur dan integrasi data API._

- [x] Setup project & package structure  
- [x] Setup Retrofit client  
- [x] Buat `InfoRepository` untuk fetch data berita  
- [x] Buat `InfoViewModel` dengan `StateFlow`  
- [x] Implement `HomeScreen` Compose  
- [x] Integrasi `MainActivity` dengan `InfoViewModel`

---

### 🚧 **Sprint 2 (Sedang Berjalan)**
> _Fokus pada peningkatan arsitektur dan tampilan._

- [ ] Integrasi Hilt (Dependency Injection)  
- [ ] Buat state management (`UiState`: Loading, Success, Error)  
- [ ] Improve UI tampilan artikel (Material 3 + Coil)  
- [ ] Implementasi navigasi ke `DetailScreen`  
- [ ] Tambahkan error handling & fitur refresh  
- [ ] Polishing tampilan (dark mode, typography)  

---

### 🧠 **Sprint 3 (Rencana Berikutnya)**
> _Fokus pada fitur lanjutan dan optimasi._

- [ ] Tambahkan penyimpanan offline (Room Database)  
- [ ] Tambahkan pencarian berita  
- [ ] Tambahkan filter kategori  
- [ ] Tambahkan unit test (ViewModel & Repository)  
- [ ] CI/CD setup (GitHub Actions)

---

## 🧱 Struktur Project (Ringkas)

```
com.example.cariinfoapp/
├── data/
│   ├── database/
│   │   └── model/Article.kt
│   ├── network/
│   │   ├── client/RetrofitClient.kt
│   │   ├── repository/InfoRepository.kt
│   │   └── service/InfoApiService.kt
├── ui/
│   ├── features/
│   │   ├── home/HomeScreen.kt
│   │   ├── detail/DetailScreen.kt (Sprint 2)
│   │   └── model/InfoViewModel.kt
│   └── theme/
│       ├── Color.kt, Theme.kt, Typography.kt
└── MainActivity.kt
```

---

## 🧩 Arsitektur MVVM Overview

```
UI (Jetpack Compose)
   ↓
ViewModel (InfoViewModel)
   ↓
Repository (InfoRepository)
   ↓
Data Source (RetrofitClient → InfoApiService)
```

---

## 🛠 Cara Menjalankan Project

1. Clone repository:
   ```bash
   git clone https://github.com/username/CariInfoApp.git
   ```
2. Buka dengan **Android Studio (Arctic Fox / lebih baru)**  
3. Sync Gradle & pastikan internet aktif (untuk fetch API).  
4. Jalankan di emulator / perangkat fisik Android.

---


---

## 👨‍💻 Kontributor
- **Ayash Abdus Syahiid** — Mobile Developer (Android & Kotlin)  
- Stack: Kotlin, XML, Jetpack Compose, Flutter, Swift (basic), PHP-MySQL (backend support)

---

## 📜 Lisensi
MIT License © 2025 Ayash Abdus Syahiid

---

