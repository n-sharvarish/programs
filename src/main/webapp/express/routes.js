var express = require('express');
var router = express.Router();

router.get('/', function (req, res) {
    res.send('GET Route using Express Router');
});
router.post('/', function (req, res) {
    res.send('POST Route using Express Router');
});

//export this router to use in our index.js
module.exports = router;