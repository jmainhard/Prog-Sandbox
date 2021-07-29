var mysql = require('mysql');

exports.conectar_bbdd = function () {
  var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "lookify"
  });
  return con;
};