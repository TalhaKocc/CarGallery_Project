# 🚗 Car Gallery Project

Car Gallery Project, bir oto galeri için geliştirilen, **JWT tabanlı kimlik doğrulama**, **rol bazlı yetkilendirme** ve **katmanlı mimari** prensiplerini içeren bir **Spring Boot backend uygulamasıdır**.

Proje; araç, çalışan ve satış yönetimi süreçlerini kapsayan RESTful API’ler sunar.

---

## 🛠 Kullanılan Teknolojiler

- **Java 21**
- **Spring Boot**
- **Spring Security (JWT Authentication & Authorization)**
- **Spring Data JPA (Hibernate)**
- **Maven**
- **MapStruct (DTO ↔ Entity Mapping)**
- **PostgreSQL**
- **Postman (API testleri)**
- **DBeaver (Database yönetimi)**
- **BCrypt Password Encoder**

---

## 🧩 Mimari Yapı

Proje, **katmanlı mimari (Layered Architecture)** prensiplerine uygun olarak geliştirilmiştir:

- **Controller Layer** – REST API endpoint’leri
- **Service Layer** – İş kuralları ve transaction yönetimi
- **Repository Layer** – Veritabanı işlemleri
- **DTO Layer** – Veri transfer nesneleri
- **Mapper Layer** – MapStruct ile otomatik dönüşümler
- **Security Layer** – JWT filtreleri, yetkilendirme ve güvenlik yapılandırmaları

---

## 🔐 Güvenlik

- JWT (JSON Web Token) tabanlı authentication
- Rol bazlı authorization (ADMIN / EMPLOYEE)
- Şifreler **BCrypt** ile hashlenerek saklanır
- Yetkisiz erişimler için özelleştirilmiş **401 / 403 JSON response** yapısı

---

## 📌 Temel Özellikler

- Kullanıcı girişi (Login) – JWT üretimi
- Araç ekleme, listeleme ve durum yönetimi
- Çalışan yönetimi
- Araç satış işlemleri
- Validation (Bean Validation – `@NotNull`, `@Positive`, vb.)
- Hata yönetimi (global ve security seviyesinde)

---

## 🧪 Test & Geliştirme Araçları

- **Postman** ile API testleri
- **DBeaver** ile PostgreSQL veritabanı yönetimi

---

## 📈 Teknik Tercihler ve Gerekçeler

- MapStruct, reflection tabanlı mapping yaklaşımlarına
  alternatif olarak compile-time dönüşüm sağladığı için tercih edilmiştir.

- JWT ile stateless authentication kullanılarak,
  sunucu tarafında session yönetimi ihtiyacı ortadan kaldırılmıştır.

- PostgreSQL tercih edilerek ACID uyumlu ve güçlü
  ilişkisel veri yönetimi hedeflenmiştir.


## ⚠️ Not

Bu proje **öğrenme ve gelişim amaçlı** geliştirilmiştir.  
Hata yönetimi ve bazı optimizasyonlar zamanla iyileştirilmektedir.

---

## 👤 Geliştirici

**Talha Koç**  
Junior Java Backend Developer  
