const express = require('express');
const app = express();
const port = 8080; // 포트 번호 설정

// 기본 경로에 대한 응답 설정
app.get('/', (req, res) => {
    res.send('Hello, this is the home page!');
});

// /endpoint 경로에 대한 응답 설정
app.get('/endpoint', (req, res) => {
    res.json({ message: 'Server is running' });
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
