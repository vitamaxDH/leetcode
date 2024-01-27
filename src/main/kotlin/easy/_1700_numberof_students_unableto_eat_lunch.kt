package easy

class _1700_numberof_students_unableto_eat_lunch {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val stuQ = ArrayDeque<Int>()
        for (s in students) {
            stuQ.add(s)
        }
        val sanQ = ArrayDeque<Int>()
        for (s in sandwiches) {
            sanQ.add(s)
        }
        var count = 0
        while (count < sanQ.size) {
            if (stuQ.first() != sanQ.first()) {
                stuQ.add(stuQ.removeFirst())
                count++
            } else {
                stuQ.removeFirst()
                sanQ.removeFirst()
                count = 0
            }
        }

        return stuQ.size
    }
}
