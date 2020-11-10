package playground.wire

import org.kodein.di.*
import com.google.common.io.BaseEncoding

private val hex = BaseEncoding.base16()!!

internal fun ByteArray.toHexString(): String = hex.encode(this)

internal fun String.hexStringToByteArray(): ByteArray = hex.decode(this)

internal fun getConfig(): DI = DI {
    constant(tag = "greeting") with "hello, world!"
    constant(tag = "binary") with "baadd00d".toUpperCase().hexStringToByteArray()
}

public fun main(args: Array<String>) {
    val di = getConfig()
    val message by di.instance<String>(tag = "greeting")
    val bytes by di.instance<ByteArray>(tag = "binary")
    println(message)
    println("args: " + args.joinToString())
    println("baadd00d == " + bytes.toHexString())
    // todo: build a Dinosaur message, serialise it as a ByteArray and print it as hex
}
