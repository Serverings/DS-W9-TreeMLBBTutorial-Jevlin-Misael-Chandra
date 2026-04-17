What is the root node in this program?
node paling atas atau yang menjadi parent dari semua percabangan yaitu Start Build
Which nodes are leaf nodes?
nodes yang sudah tidak memiliki percabangan lagi dalam contoh kasus saya itu adalah leather jerkin
Why is children stored as a List<ItemNode> instead of a single variable?
karena dalam children itu bisa saja lagi ada anaknya misalnya kalau dia punya anak lagi itu bisa saja bercabang lagi kalau cuma pakai single variabel dia jalannya itu cuma 1 arah dan tidak ada percabangang
What is the difference between a linear structure and a tree structure in this example?
tree structure itu dia memiliki percabangan dan 1 anak itu bisa lagi punya lebih dari 1 percabangan itu menjadi pembeda terbesar
How does recursion help when working with trees?
dalam pemilihan jalur dan bisa membantu memberhentikan proses percabangannya berdasarkan banyak data yang kita punya
What path is printed when searching for Corrosion Scythe?
start build > demon hunter sword > golden staff > corossion

Result of Practice
1. membuat percabangan baru contohnya membuat dhs kemudian lanjut ke immortal
2. mencari suatu item berapa kali muncul dalam percabangannya
3. mencari path yang memiliki ending nodes tertentu yang kita mau
4. mencari path sebuah node
5. itu membuat branch baru jadi kita menambah level dari tinggi branchnya itu di tambah dari 4 sampai 5

Reflection 
Dalam tugas ini, struktur data tree lebih cocok digunakan dibandingkan array karena mampu merepresentasikan berbagai kemungkinan jalur build item yang bersifat bercabang, bukan linear. Setiap node dapat memiliki beberapa child yang menggambarkan pilihan item berikutnya, sehingga lebih fleksibel dalam memodelkan keputusan dalam game. Implementasi rekursi pada fungsi seperti printTree(), printAllBuildPaths(), dan findPath() sangat membantu dalam memahami cara traversal tree secara mendalam, terutama konsep backtracking saat mencari jalur tertentu. Tantangan utama yang dihadapi adalah memahami alur rekursi dan memastikan struktur tree dibangun dengan benar, namun hal tersebut justru membantu memperkuat pemahaman tentang konsep penting seperti root, parent, child, leaf, path, dan height dalam tree.