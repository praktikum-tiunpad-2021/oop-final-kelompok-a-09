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
   - Melakukan perubahan pada code dari swing ke javaFx
   - Menambahkan kontrol player pause dan restart
   - Membuat User Interface
   
- **[Sprint 3](changelog/sprint-3.md) - (30/11/2021-06/12/2021)** 
   - Membuat UML

## Running The App

1. Compile dan jalankan project dengan menggunakan perintah :

 ```
 gradlew run
 ```

2. Tombol Keyword yang digunakan adalah sebagai berikut :
   - Tombol `space` untuk memulai permainan dan mengulangi permainan
   - Tombol `P` untuk menghentikan sementara permainan
   - Tombol `←`, `↓`, `→`, dan `↑` untuk menentukan arah pergerakan snake

## Classes Used

1. **Board** - `Board.java`
   - Class board untuk menginsialisasi ukuran tinggi dan lebar frame
   - 2 Class Variable
      - **@height** - Tinggi frame
      - **@width** - Lebar frame
   - 2 Method
      - **getHeight()** - Getter tinggi frame
      - **getWidth()** - Getter lebar frame
      
2. **Fruit** - `Fruit.java`
   - Class fruit untuk menginsialisasi letak dan warna buah
   - 3 Class Variable
      - **@fruitX** - Koordinat x buah
      - **@fruitY** - Koordinat y buah
      - **@fruitColor** - Warna buah
   - 6 Method
      - **setFruitX(fruitX)** - Setter koordinat x buah
      - **setFruitY(fruitY)** - Setter koordinat y buah
      - **setColor(fruitColor)** - Setter warna buah
      - **getFruitX()** - Getter koordinat x buah
      - **getFruitY()** - Getter koordinat y buah
      - **getColor()** - Getter warna buah

3. **Direction** - `Direction.java`
   - Enum class untuk menyimpan nama arah pergerakan snake
   - 0 Class Variable
   - 0 Method

4. **Point** - `Point.java`
   - Class point untuk menentukan titik koordinat pada board game
   - 2 Class Variable
      - **@x** - Koordinat x
      - **@y** - Koordinat y
   - 6 Method
      - **setX(x)** - Setter koordinat x
      - **setY(y)** - Setter koordinat y
      - **getX()** - Getter koordinat x
      - **getY()** - Getter koordinat y
      - **addX(x)** - Menambahkan koordinat x
      - **addY(y)** - Menambahkan koordinat y
5. **SnakeGame** - `SnakeGame.java`
   - Program utama yang berisi method main.
   - Arguments (1 arg)
     1 arg (args) - args tidak digunakan.
   - 13 Class Variable
      - **@speed** - Kecepatan Ular
      - **@fruitEaten** - Untuk menghitung jumlah buah yang sudah dimakan
      - **@pointSize** - Ukuran cell
      - **@bodyParts** - Tubuh ular 
      - **@running** -  Untuk mengecek apakah game berjalan atau tidak
      - **@isPaused** - Untuk mengecek game berhenti sebentar
      - **@isNewGame** - Untuk mengecek apakah baru memulai game atau tidak
      - **@isGameOver** - Untuk mengecek game berakhir
      - **@snake** - Ular
      - **@direction** - Arah ular berjalan
      - **@rand** - Untuk menghasilkan random koordinat x dan y
      - **@board** - Mengatur ukuran frame
      - **@fruit** - Buah (makanan Ular)
   - 5 Method
      - **start** - Untuk memulai game
      - **resetGame** - Untuk memulai game baru
      - **snakeCheck** - Berisi tampilan start, tampilan game over dan movement dari snake
      - **newFruit** - Untuk memunculkan buah baru secara randon
      - **main** - Untuk menjalankan program

![UML](/img/UML_NantiDulu.jpg "UML")

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
