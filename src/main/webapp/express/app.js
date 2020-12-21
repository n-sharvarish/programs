// require express
var express = require('express');
var app = express();

var morgan = require('morgan');
app.use(morgan('combined'));

// Middleware Functions
app.use('/', function (req, res, next) {
    console.log("/ request received at " + Date.now());
    next();
});

app.use('/hello', function (req, res, next) {
    console.log("/hello request received at " + Date.now());
    next();
});

app.use('/routes', function (req, res, next) {
    console.log("/routes request received at " + Date.now());
    next();
});

app.get('/', function (req, res) {
    res.send("Hello world!");
});

app.post('/', function (req, res) {
    res.send("Post Hello world!");
});

app.get('/hello', function (req, res) {
    res.send("You just called the GET method at '/hello'!");
});

app.post('/hello', function (req, res) {
    res.send("You just called the POST method at '/hello'!");
});

app.get('/hello/:id', function (req, res) {
    res.send("You just called the GET method at '/hello'! " + req.params.id);
});

var routes = require('./routes.js');
app.use('/routes', routes);

app.listen(3000, function () {
    console.log('Express server running at http://localhost:3000');
});