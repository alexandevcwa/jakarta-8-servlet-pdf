<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script>
        function openPdwPreview(){
            window.open("http://localhost:8080/jakarta_8_servlet_pdf_war_exploded/sv-pdf-service    ", "pdwPreview", "width=800, height=600, center=true, resizable=false, scrollbars=true");
        }
    </script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<button onclick="openPdwPreview()">Open PDF Preview</button>
</body>
</html>