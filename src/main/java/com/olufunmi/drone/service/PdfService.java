package com.olufunmi.drone.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface PdfService {
    void export(HttpServletResponse httpServletResponse) throws IOException;
}
