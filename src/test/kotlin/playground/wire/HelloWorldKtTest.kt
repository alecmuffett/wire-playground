package playground.wire

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HelloWorldKtTest {

    @Test
    fun `gentlemen, behold! unit tests!`() {
        val expected = "CAFEBABE"
        val actual = expected.hexStringToByteArray().toHexString()
        assertEquals(expected, actual)
        println("FOOO")
    }
}