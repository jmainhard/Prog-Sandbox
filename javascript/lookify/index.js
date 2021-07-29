// 29-07-2021 Jorge M. Prueba Práctica 2 Leng. Prog. 2021-1
const express = require('express')
const app = express()
var mysql = require('mysql');
const port = 3000
var conect = require('./mysql');

app.set('view engine', 'ejs');

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

app.get('/', (req, res) => {
  res.render('index');
});

// canciones
app.get('/principal', (req, res) => {
  con = conect.conectar_bbdd();
  con.connect(function (err) {
    if (err) throw err;
    con.query("SELECT * FROM songs", function (err, result, fields) {
      if (err) throw err;
      res.render('canciones', { songs: result });
    });
  });
})

app.get('/canciones/nueva', (req, res) => {
  res.render('create_song');
});

app.get('/actualizar/:id', (req, res) => {

  var id = req.params.id;

  con = conect.conectar_bbdd();

  con.connect(function (err) {
    if (err) throw err;
    con.query("SELECT * FROM canciones where id = " + id, function (err, result, fields) {
      if (err) throw err;
      console.log(result);
      res.render('update_song', { canciones: result });
    });
  });
});

app.get('/eliminar/:id', (req, res) => {
  var id = req.params.id;
  con = conect.conectar_bbdd();
  con.connect(function (err) {
    if (err) throw err;
    var sql = "DELETE FROM songs WHERE id =" + id;
    con.query(sql, function (err, result) {
      if (err) throw err;
      console.log("Number of records deleted: " + result.affectedRows);
      res.redirect('/principal');
    });
  });
});

app.post('/insert_song', (req, res) => {
  let title = req.body.title;
  let author = req.body.author;
  let rating = req.body.rating;

  //conexion
  con = conect.conectar_bbdd();
  con.connect(function (err) {
    if (err) throw err;
    console.log("Conexión establecida");
    var sql = "INSERT INTO songs (id, title, author, rating) VALUES (null,'" + title + "', '" + author + "', '" + rating  + "')";
    con.query(sql, function (err, result) {
      if (err) throw err;
      console.log("1 Registro insertado");
    });
  });
  // FIXME redirect no considera la canción insertada, se debe hacer reload
  res.redirect('/principal');
});

app.listen(port, () => {
  console.log(`Lookify app listening at http://localhost:${port}`)
})
