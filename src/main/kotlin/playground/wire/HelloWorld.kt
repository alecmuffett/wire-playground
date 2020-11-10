package playground.wire

import org.kodein.di.*
import com.google.common.io.BaseEncoding

private val hex = BaseEncoding.base16()!!
fun ByteArray.toHexString(): String = hex.encode(this)
fun String.hexStringToByteArray(): ByteArray = hex.decode(this)

fun getConfig(): DI = DI {
    constant(tag = "greeting") with "hello, world!"
    constant(tag = "binary") with "baadd00d".toUpperCase().hexStringToByteArray()
}

fun main(args: Array<String>) {
    val di = getConfig()
    val message by di.instance<String>(tag = "greeting")
    val bytes by di.instance<ByteArray>(tag = "binary")
    println(message)
    println("baadd00d == " + bytes.toHexString())
    println("args: " + args.joinToString())
}
