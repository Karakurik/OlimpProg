import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class FastScanner(inputStream: InputStream) {
    private val reader = BufferedReader(InputStreamReader(inputStream))
    private var tokenizer: StringTokenizer? = null

    fun next(): String {
        while (true) {
            tokenizer.let {
                if (it == null || !it.hasMoreTokens()) {
                    tokenizer = StringTokenizer(reader.readLine())
                } else {
                    return it.nextToken()
                }
            }
        }
    }
}

val reader = FastScanner(System.`in`)
fun next() = reader.next()
fun nextInt() = reader.next().toInt()
fun nextLong() = reader.next().toLong()
fun nextDouble() = reader.next().toDouble()
fun nextStrings(n: Int) = Array(n) { next() }
fun nextInts(n: Int) = IntArray(n) { nextInt() }
fun nextLongs(n: Int) = LongArray(n) { nextLong() }
fun nextDoubles(n: Int) = DoubleArray(n) { nextDouble() }

fun main() = repeat(nextInt()) {
    solve()
}

fun solve() {
    val n = nextInt()
    val k = nextInt()
    val set = kotlin.collections.HashSet<Int>()
    repeat(n) {
        set.add(nextInt())
    }
    for (i in set) {
        if (set.contains(i + k))  {
            println("YES")
            return
        }
    }
    println("NO")
}
