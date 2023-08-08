package com.example.imagesearchapp

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


class MockNetworkAPICallTest {
    private var mockWebServer: MockWebServer? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer?.start()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mockWebServer?.shutdown()
    }

    @Test
    @Throws(Exception::class)
    fun testNetworkRequest() {
        val json = loadJsonFromFile("src/test/java/com/example/imagesearchapp/mockresp/Resp.json")

        // Create a mock response using the JSON content
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(json!!)

        mockWebServer!!.enqueue(mockResponse)
    }

    @Throws(IOException::class)
    private fun loadJsonFromFile(filePath: String): String? {
        return String(Files.readAllBytes(Paths.get(filePath)))
    }
}