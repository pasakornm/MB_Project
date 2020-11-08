var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql')

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

app.get('/', function (req, res) {
    return res.send({ error: true, message: 'Test Student Web API' })
});

var dbConn = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'hotel_mb'
});

dbConn.connect();


app.post('/customer', function (req, res) {
    var cus = req.body;
    console.log(cus);

    if (!cus) {
        return res.status(400).send({ error: true, message: 'Please provide student ' });
    }

    dbConn.query("INSERT INTO customer SET ?", cus, function (error, results, fields) {
        if (error) throw error;
        console.log(results);
        return res.send({ error: false, message: 'successfully' });
    });
});
app.post('/login', function (req, res) {
    var login1 = req.body.Cus_username;
    var login2 = req.body.Cus_password;

    if (!login1 && !login2) {
        return res.status(400).send({ error: true, message: 'Login Fail ' });
    }
    dbConn.query("SELECT * FROM customer where Cus_username = ? AND Cus_password = ?", [login1, login2], function (error, results, fields) {
        if (error) throw error;
        console.log(results);
        return res.send(results[0]);
    });

}

);

app.put('/edit/:Cus_ID', function (req, res) {
    var edit = req.params.Cus_ID;
    var edit2 = req.body;
    if (!edit && !edit2) {
        return res.status(400).send({ error: true, message: 'Error ' });
    }
    dbConn.query('UPDATE customer SET ? WHERE Cus_ID = ?', [edit2, edit], function (error, results, fields) {
        if (error) throw error;
        return res.send({ error: false, message: 'Customer has been updated successfully' });
    });


});

app.post('/reserve', function (req, res) {
    var reserve = req.body;
    dbConn.query("INSERT INTO reserve SET ?", reserve, function (error, results, fields) {
        if (error) throw error;
        return res.send({ error: false, message: 'successfully' });
    });
});

app.delete('/roomcancle/:Reserve_ID',function (req, res){
    var delete1 = req.params.Reserve_ID;
    if (!delete1){
        return res.status(400).send({ error: true, message: 'Error ' });
    }
    dbConn.query('DELETE FROM reserve WHERE Reserve_ID = ?', delete1, function (error,results,fields){
        if (error) throw error;
        return res.send({ error: false, message: 'Room Cancle Successfully'});
    });
});

app.get('/serch/:Reserve_ID',function (req, res){
    var serch = req.params.Reserve_ID;
    if (!serch){
        return res.status(400).send({ error: true, message: 'Error ' });
    }
    dbConn.query('SELECT * FROM reserve WHERE Reserve_ID = ?', serch, function(error,results,fields){
        if (error) throw error;
        return res.send(results);
    });
});

app.get('/serchall', function (req, res){
    dbConn.query('SELECT * FROM reserve' , function(error,results,fields){
        if (error) throw error;
        return res.send(results);
    });
});


app.listen(3000, function () {
    console.log('Node app is running on port 3000');
});



module.exports = app;