package com.kelompok4.todolist.todo

object DataTodo {
    private val todoTask = arrayOf(
        "Kelas Bahasa Inggris",
        "Rapat Kerja UKM",
        "Kerkom Tugas Java",
        "TM Esport Valorant",
        "Ngontel Waduk Undip",
        "Ngaret Ngarep Masjid",
        "Nggantang Manuk",
        "Touring Sekelas Tindak Bromo",
        "Nyetrum Iwak Area banjir kanal kulon",
        "Nonton Drama Layangan Tugel",
        "Temu Kangen Mas Aris Mba Kinan",
        "Ngewibu Anime Oni Chinchi",
        "Mbengkel Mrogram Android",
        "Jual Kandang Sapi"
    )

    private val todoTime = arrayOf(
        "Jumat, 28 Feb 2022",
        "Sabtu, 01 Mar 2022",
        "Senin, 03 Mar 2022",
        "Rabu, 05 Mar 2022",
        "Kamis, 09 Mar 2022",
        "Jumat, 10 Maret 2022",
        "senin, 22 Maret 2022",
        "Kamis, 31 Maret 2022",
        "Jumat, 05 April 2022 ",
        "Sabtu, 12 April 2022",
        "Kamis, 33 April 2022",
        "Minggu, 31 Agustus 2022",
        "Senin 01 September 2022",
        "Rabu 01 November 2022"
    )

    private val todoNote = arrayOf(
        "Pak Sasongko",
        "Rapat",
        "TCP",
        "Turnamen",
        "Semangatt",
        "Masjid Polines",
        "kopdar gabungan murai mania",
        "Refreshing",
        "Jangan lupa bawa karung",
        "Inget beli tiket",
        "Siapin jajanan",
        "Jangan lupa ngunci kamar",
        "awkawoawkoak",
        "Naikin harga setinggi mungkin"
    )

    val listData: ArrayList<Todo>
        get() {
            val list = arrayListOf<Todo>()
            for(position in todoTask.indices) {
                val todo = Todo()
                todo.task = todoTask[position]
                todo.time = todoTime[position]
                todo.note = todoNote[position]
                list.add(todo)
            }
            return list
        }
}