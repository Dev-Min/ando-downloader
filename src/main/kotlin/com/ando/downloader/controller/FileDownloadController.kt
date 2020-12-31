package com.ando.downloader.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Paths

@RestController
class FileDownloadController {
    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    @GetMapping("download-ando-apk")
    fun download(): ResponseEntity<Resource> {
        val path = Paths.get("classpath:static/ando.apk")

        val headers = HttpHeaders()
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ando.apk")

        val resource = resourceLoader.getResource("classpath:static/ando.apk")
        return ResponseEntity(resource, headers, HttpStatus.OK)
    }
}