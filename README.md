# A feladat összefoglaló leírása

Ebben a feladatban a közismert Snake játék működését fogjuk szimulálni. A játékban egy rögzített méretű pályán kell egy kígyót irányítani, mely almákat szed össze, és eszik meg, egyre növelve a méretét, miközben nem ütközhet sem falba, sem saját magába.

A feladat megoldása során be kell tartani a kódolási konvenciókat. Ennek megfelelően ügyeljünk arra, hogy a megadottakon kívül egyetlen osztály se tartalmazzon más publikus metódust vagy adattagot, illetve egyik csomag se tartalmazzon más osztályokat! Ha az implementáció megköveteli, akkor az osztályok rejtett adattagokkal és metódusokkal szabadon bővíthetők.

A fordításhoz legalább a Java Standard Edition 8 használata kötelező.

A feladathoz tartozik egy letölthető segédlet, ahol találunk több minta bemeneti fájlt és kimeneti fájlt, valamint egy futtató Main osztályt, egy magyarázó leírással kiegészítve.
# Beadás módja

    A megoldást egyetlen .zip állományként kell feltölteni, amely tartalmazza a csomagnak megfelelő könyvtárszerkezetben az összes forráskódot.

    A .zip állomány NE tartalmazzon egy (se több) legkülső összefogó mappát, közvetlen az elvárt csomagszerkezetnek megfelelő könyvtárak tagozódjanak alá. (Ne legyen egy bead, bead_NEPTUN vagy bármi hasonló, legkülső mappa a zip-ben.)

    A fordítás során keletkező .class állományokat és a JUnit futtatásához használatos két .jar fájlt sem szabad mellékelni!

# A feladat részletes ismertetése
# 1. Segédtípusok

## snake.exception.CollisionException

Készítsük el a snake.exception.CollisionException ellenőrzött kivételosztályt (származzon az Exception osztályból). Ez a kivétel fogja jelezni, ha a kígyó nekiütközik valaminek.

# snake.exception.InvalidIndexException

Készítsük el a snake.exception.InvalidIndexException nem ellenőrzött kivételosztályt (származzon a RuntimeException osztályból). Ez a kivétel fogja jelezni, ha a játéktér határain kívülre próbálnánk menni.

# snake.util.Position

Hozzuk létre a snake.util.Position osztályt, mely egy oszlop- és sorkoordinátáival azonosított pozíciót fog reprezentálni a játéktéren.

Adattagjai:

    SIZE_OF_BOARD: publikus, osztályszintű, módosíthatatlan, egész szám típusú. A játéktér sorainak és oszlopainak maximális darabszáma. Értéke 10.

    row: módosíthatatlan, egész szám típusú. A pozíció sorindexe.

    column: módosíthatatlan, egész szám típusú. A pozíció oszlopindexe.

    Megjegyzés: mivel minden adattagja módosíthatatlan, a Position egy immutable típus.

Metódusai:

    Legyen egy publikus, két egész szám paramétert fogadó konstruktora. A két paraméter a sor- és oszlopindex. Ezek akkor megfelelőek, ha értékük nemnegatív és kisebb, mint a SIZE_OF_BOARD értéke. Ha valamelyik nem megfelelő, dobjunk snake.exception.InvalidIndexException kivételt. Különben mentsük le az értéküket a megfelelő adattagokba.

    Legyen egy publikus getRow és egy publikus getColumn metódusa a megfelelő adattagok lekérdezésére.

    Legyen egy publikus, logikai visszatérési értékű isSame metódusa, mely egy Position objektumot vár paraméterül. Ha a paraméter nem null, és sor-, illetve oszlopindexe megegyezik az aktuális objektuméval, akkor térjünk vissza igazzal, máskülönben hamissal.

    Megjegyzés: a feladat egy későbbi fázisában szükség lesz a Position osztály hashCode és equals metódusainak megírására is. Ha ezt megtesszük előre, akkor bárhol, ahol két Position objektumot kell összehasonlítani, tetszőlegesen használható az isSame helyett az előre megírt equals is.

# snake.util.Direction

Készítsük el a snake.util.Direction felsorolási típust, melynek lehetséges értékei a következők legyenek: UP, DOWN, RIGHT és LEFT.
# 2. Alapszerkezet

Hozzuk létre a feladat alapszerkezetét adó típusokat!

# snake.Game

A program vezérlését a snake.Game osztály fogja végezni. Ezt egyelőre még csak hozzuk létre, később fogjuk metódusokkal kiegészíteni.

# snake.Tile

Készítsük el a snake.Tile interfészt, mely a játéktér egy mezőjét fogja ábrázolni. Legyen egyetlen metódusa, a Position visszatérési értékű, paraméter nélküli getPosition, melynek implementációi a játékmező aktuális pozícióját fogják visszaadni.

# snake.Snake

A kígyót a snake.Snake interfészen keresztül szeretnénk majd vezérelni. Ez az interfész származzon a Tile interfészből.

Metódusai:

    Legyen egy publikus, visszatérési érték nélküli, Direction paramétert fogadó move metódusa, mely dobhat CollisionException-t. Ennek a metódusnak az implementációi majd az adott irányba fogják mozdítani a kígyót 1 mezőnyit, ha ez nem okoz ütközést.

    Legyen egy publikus, visszatérési érték nélküli, kétparaméteres move metódusa, mely dobhat CollisionException-t. Az első paramétere Direction típusú, a második egy egész szám (times). Ennek a metódusnak az implementációi majd az adott irányba fogják mozdítani a kígyót times mezőnyit, ha ez nem okoz ütközést.

# snake.Apple

Készítsük el a Tile interfészt megvalósító snake.Apple osztályt, mely az almákat fogja ábrázolni.

Adattagjai:

    position: módosíthatatlan, Position típusú. Az alma pozícióját tárolja.

Metódusai:

    Legyen egy publikus konstruktora, melynek egyetlen Position típusú paramétere van. Tárolja le a paramétert az adattagba.

    Valósítsa meg a Tile interfészből örökölt getPosition metódust: térjen vissza az adattag értékével.
