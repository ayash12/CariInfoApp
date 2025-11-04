# 📰 CariInfoApp

**CariInfoApp** adalah aplikasi portal berita berbasis **Jetpack Compose (Material 3)** yang menampilkan berita terkini dari berbagai sumber.  
Dibangun menggunakan arsitektur **MVVM + Repository Pattern**, dengan dukungan **offline cache (Room)**, **Hilt DI**, dan **modern UI Compose**.

---

## 🚀 Tech Stack

| Layer | Teknologi |
|-------|------------|
| **UI** | Jetpack Compose, Material 3, Pull-to-Refresh |
| **Architecture** | MVVM, Repository Pattern |
| **Async / State** | Kotlin Coroutines, Flow, StateFlow |
| **Dependency Injection** | Hilt |
| **Networking** | Retrofit + OkHttp |
| **Database (Offline Cache)** | Room |
| **Image Loading** | Coil |
| **Navigation** | Navigation Compose |
| **Theming** | Material 3 + Dark Mode Toggle |
| **UI Skeleton** | Accompanist Placeholder (Shimmer) |

---

## ✨ Fitur Utama

- 📰 **Home Screen**
   - Menampilkan daftar berita dalam bentuk **Card Compose** (gambar, judul, penulis, tanggal, deskripsi).
   - **Swipe to Refresh (Material 3 PullToRefreshBox)** untuk memuat ulang data.
   - **Shimmer Loading** saat data dimuat pertama kali.
   - **Empty State** dan **Error State** dengan tampilan modern.
   - Toggle **Dark / Light Mode** langsung dari TopBar.

- 📄 **Detail Screen**
   - Menampilkan detail lengkap artikel (gambar header, judul, penulis, tanggal, deskripsi).
   - Tombol **Baca Selengkapnya** membuka tautan di browser.
   - **Icon Share** di TopBar untuk membagikan berita.
   - Konten dapat di-scroll sepenuhnya.

- 🌙 **Tema & Tipografi**
   - Palet warna konsisten Material 3.
   - Typography: `titleLarge`, `bodyMedium`, `labelSmall`.

- 💾 **Offline Mode**
   - Data berita disimpan di database lokal Room.
   - Jika offline, aplikasi tetap dapat menampilkan data terakhir.

---

## 🧩 Arsitektur MVVM Overview

```
UI (Jetpack Compose)
   ↓
ViewModel (InfoViewModel)
   ↓
Repository (InfoRepository)
   ↓
Data Sources (Retrofit + Room)
```

---

## 📁 Struktur Project

```
com.example.cariinfoapp
├── App.kt
├── MainActivity.kt
├── data
│   ├── database
│   │   └── model/ArticleModel.kt
│   ├── local
│   │   ├── ArticleMapper.kt
│   │   ├── InfoDAO.kt
│   │   ├── InfoDatabase.kt
│   │   └── InfoEntity.kt
│   └── network
│       ├── client/InfoClient.kt
│       ├── repository/InfoRepository.kt
│       ├── response/InfoResponse.kt
│       └── service/InfoAPIService.kt
├── di
│   ├── DatabaseModule.kt
│   └── NetworkModule.kt
├── ui
│   ├── features
│   │   ├── home
│   │   │   ├── HomeScreen.kt
│   │   │   ├── HomeContent.kt
│   │   │   ├── HomeTopBar.kt
│   │   │   └── components/ArticleCard.kt
│   │   ├── detail
│   │   │   ├── DetailScreen.kt
│   │   │   ├── DetailContent.kt
│   │   │   ├── DetailTopBar.kt
│   │   │   ├── DetailEmptyView.kt
│   │   │   └── components/DetailComponents.kt
│   │   └── model/InfoViewModel.kt
│   ├── navigation
│   │   ├── AppNavHost.kt
│   │   └── NavRoutes.kt
│   ├── state/UiState.kt
│   └── theme
│       ├── Color.kt
│       ├── MyColors.kt
│       ├── Theme.kt
│       └── Type.kt
└── utils/Constants.kt
```

---

## 🧪 Quality & Testing (Sprint 5 Review)

✅ AppBar & Navigation modern (CenterAlignedTopAppBar)  
✅ Swipe Refresh Material 3 menggantikan tombol refresh  
✅ Shimmer Loading menggantikan CircularProgressIndicator  
✅ Clean architecture dengan pemisahan `HomeContent`, `ArticleCard`, `DetailComponents`  
✅ Dark mode toggle berfungsi penuh  
✅ Error & Empty state UI responsif  
✅ DetailScreen lebih ringkas & modular  
✅ Semua sesuai dengan target Sprint 5 (UI/UX Polish & Presentation Ready)

---

## 🛠 Cara Menjalankan Project

```bash
git clone https://github.com/username/CariInfoApp.git
cd CariInfoApp
```
1. Buka di **Android Studio Giraffe atau lebih baru**
2. Pastikan internet aktif untuk memuat data API
3. Jalankan pada emulator / perangkat fisik

---

## 📜 Lisensi
MIT License © 2025 Ayash Abdus Syahiid
