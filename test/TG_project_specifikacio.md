Specifikáció

A program célja:
A megbízás egy olyan platformfüggetlen program megírása volt mely különböző fájlformátumokat képes md kiterjesztésű markdown fájllá alakítani.

A program használata:
A program elindításakor megjelenő ablakban két bemeneti mezőttalálhatunk,ahol megadhatjuk az átalakítandófájlunkat,valamint azt, hogy melyik fájlba történjen az átalakítás. Ezt megadhatjuk az elérési út bemásolásával vagy a tallózásgomb megnyomásával a felugrófájlválasztóablakban kiválasztjuk azátalakítandóés a cél fájlt.
Abban azesetben,ha az átalakítandó fájlt helytelenül adtuk meg, tehát nem létezik vagy nincs írási jogunk rá a program a megfelelőhibát írja ki a képernyőre.
A program a .doc/.docx .txt és .htmltípusúfájlokat képes átalakítani, ha nem ezek közül adunk megy egy fájlt a program a megfelelőhibát írja ki a képernyőre.
Abban azesetben,ha a cél fájlunk nem létezik a program létrehozza azt.Ha létezik akkor az eredeti tartalma elvész és a program felülíja azt az átalakított tartalommal, bármi is legyen az ami előzőleg benne volt.
Miután mindkét fájlt helyesen megadtunk rákattinthatunk a Convert gombra. Mialatt a program az átalakítástvégzi,a gomb inaktívvá válik ( elszürkül és nem lehet megnyomni ), mikor az átalakítás befejeződött a gomb újra aktív lesz és a megfelelő üzenet tájékoztatja a folyamat sikeres lezajlásáról a felhasználót. Ekkor a fájlrendszeren már megtalálható a sikeresen átalakított fájl.

Tesztelés eredménye:
Atesztelés során a következő eseteket vettük sorra:

1. Nem létező fájlt adunk meg bemenetként: A program hibaüzenetet ad.
1. Nem támogatott fájltípust adunk meg bemenetként: A program hibaüzenetet ad.
1. Nem .md kiterjesztésű fájlt adunk meg kimenetnek: A program olyan kiterjesztésként de .md tartalommal menti a fájlt.
1. HTML fájlt adunk meg bemenetként: A program rendben átalakítja .md fájlá, egyes az md formátum által nem támogatott formázások elvesznek. Abban az esetben ha a html fájl css formázást is tartalmaz a progam azt figyelmen kívül hagyja.
1. txt fájlt adunk meg: A program rendben átalakítja md fájlá.
1. A programnak .doc/.docx fájlt adunk meg: A program átalakítja html fájlá, aztán azt md fájlá. Egyes formázások az átalakítás során elvesznek.