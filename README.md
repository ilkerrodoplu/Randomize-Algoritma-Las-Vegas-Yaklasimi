# Las Vegas Algoritması Analizi

Bu proje, Randomize Algoritmalar kapsamında **Las Vegas yaklaşımını** kullanarak belirli bir koşulu sağlayan elemanların aranmasını ve bu arama işleminin teorik ve deneysel analizlerini gerçekleştiren bir Java uygulamasıdır.

Program, rastgele oluşturulmuş büyük bir veri seti içerisinde 10'a tam bölünebilen (`x % 10 == 0`) elemanları bulmayı hedefler. Geometrik Dağılım prensipleri üzerinden teorik beklentileri hesaplar ve algoritmanın çoklu çalıştırılması sonucu elde edilen deneysel verilerle karşılaştırır.

## 🚀 Özellikler

* **Büyük Veri Seti Üretimi:** Benzersiz bir `seed` değeri kullanılarak 1.000.000 elemanlı (n = 10^6) rastgele bir tam sayı dizisi oluşturulur.
* **Teorik İstatistikler:** Hedef elemanların bulunma olasılığı (p), Beklenen Adım Sayısı (E[X] = 1/p) ve Varyans (Var[X] = (1-p)/p^2) formülleriyle algoritmanın teorik sınırları belirlenir.
* **Deneysel Analiz:** Las Vegas algoritması 100 kez ardışık olarak çalıştırılır. Her çalıştırmadaki adım sayısı ve geçen süre (nanosaniye cinsinden) kaydedilerek ortalama, minimum, maksimum değerler ve standart sapmalar hesaplanır.
* **Karşılaştırmalı Raporlama:** Uygulama, teorik beklentiler ile deneysel sonuçlar arasındaki farkı yüzdelik sapma oranlarıyla birlikte konsola detaylı bir rapor olarak yazdırır.

## 📁 Proje Yapısı

| Sınıf Adı | Görevi |
| :--- | :--- |
| `Main.java` | Uygulamanın ana giriş noktasıdır. Veri üretimini, teorik hesaplamaları ve deneysel analizi sırasıyla organize eder. |
| `LasVegas.java` | Las Vegas arama algoritmasının çekirdek yapısıdır. Verilen dizide koşulu sağlayan elemanı bulana kadar rastgele indeks seçimi yapar. |
| `TeorikHesap.java` | Veri seti üzerindeki toplam hedef eleman sayısını tespit ederek olasılık ve beklenen değer (E[X]) hesaplamalarını yapar. |
| `DeneyselAnaliz.java` | Algoritmayı belirlenen döngü sayısı kadar test ederek istatistiksel sonuçları (ortalama adım, çalışma süresi, sapma oranları) derler. |
| `VeriOlusturucu.java` | Seed değeri kullanarak rastgele sayı dizisini üretir ve dizide en az bir hedef eleman olmasını garanti altına alır. |
| `YardimciMetotlar.java` | Ortalama, standart sapma, minimum ve maksimum değer bulma gibi temel matematiksel işlemleri gerçekleştiren statik metotları içerir. |

## 🛠️ Kurulum ve Kullanım

Projeyi yerel bilgisayarınızda derleyip çalıştırmak için sisteminizde **Java (JDK)** kurulu olması gerekmektedir.
