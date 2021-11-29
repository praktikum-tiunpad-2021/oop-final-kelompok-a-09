# Snake Game

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Implementasi dari game terkenal yaitu Snake dimana ada seekor ular yang dapat diarahkan untuk memakan buah. Jika ular tersebut memakan buah, maka panjangnya akan bertambah.**

## Credits
| NPM           | Name                  |
| ------------- |-----------------------|
| 140810200015  | Nanda Raihan Sukma    |
| 140810200033  | Rafa Azka Ulinnuha    |
| 140810200045  | Amalia Nur Ftri       |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (16/11/2021)** 
   - Melakukan meet dan diskusi pertama
   - Membuat challenge guidelines
   - Membuat perencanaan changelog

- **[Sprint 1](changelog/sprint-1.md) - (16/11/2021-22/11/2021)** 
   - Inisialisasi Gradle dan JavaFX
   - Inisialisasi frame dan cell
   - Inisialisasi snake
   - Inisialisasi fruit
   - Membuat kontrol player
   - Logika move snake
   - Logika scoring
   - Logika pertambahan panjang tubuh snake
   - Logika crashed

- **[Sprint 2](changelog/sprint-2.md) - (23/11/2021-29/11/2021)** 
   - Membuat Side panel
   - Membuat Leaderboard
   - Menambahkan kontrol player pause dan restart
   - Membuat User Interface
   
- **[Sprint 3](changelog/sprint-3.md) - (date from x until x)** 
   - Short changes 1
   - Short changes 2

## Running The App

TO;DO with steps

## Classes Used

Board - Board.java
   - Objek board untuk menginsialisasi ukuran tinggi dan lebar frame
   - 2 Class Variable
      - @height - Tinggi frame
      - @width - Lebar frame
   - 2 Method
      - getHeight() - Getter tinggi frame
      - getWidth() - Getter lebar frame
      
Fruit - Fruit.java
   - Objek fruit untuk menginsialisasi letak dan warna buah
   - 3 Class Variable
      - @fruitX - Koordinat x buah
      - @fruitY - Koordinat y buah
      - @fruitColor - Warna buah
   - 6 Method
      - setFruitX() - Setter koordinat x buah
      - setFruitY() - Setter koordinat y buah
      - setColor() - Setter warna buah
      - getFruitX() - Getter koordinat x buah
      - getFruitY() - Getter koordinat y buah
      - getColor() - Getter warna buah

UML image here

## Notable Assumption and Design App Details

Desain Aplikasi
   - Aplikasi didesain untuk ukuran window 600x600.
   - Background warna aplikasi adalah hitam.
   - Ular muncul dengan panjang awal 5 sel dan posisi kepala ada ditengah-tengah area game.
   - Buah muncul dengan ukuran satu sel dan diposisikan secara acak.
   - Ular akan mulai bergerak maju dan buah akan muncul setelah pengguna memberikan input dengan menekan tombol spasi.
   - Jika buah dimakan ular, ular akan bertambah panjangnya pada bagian kepala sebanyak satu sel.
   - Jika ular menabrak dinding atau menabrak bagian tubuhnya, game akan selesai.
   - Jika game selesai, munculkan dialog baru untuk menampilkan score.
   - Jika dialog ditutup, game akan mereset ke posisi awal.
