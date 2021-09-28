package io.keepcoding.spark.exercise.provisioner

import java.sql.{Connection, DriverManager}

object JdbcProvisioner {

  def main(args: Array[String]) {

    // there's probably a better way to do this
    var connection: Connection = null

    try {
      // make the connection
      Class.forName(args(3))
      connection = DriverManager.getConnection(args(0), args(1), args(2))

      // create the statement, and run the select query
      val statement = connection.createStatement()
      println("Conexión establecida correctamente!")
      println("Creando la tabla user_metadata (id TEXT, nombre TEXT, email TEXT, quota BIGINT)")
      statement.execute("CREATE TABLE IF NOT EXISTS user_metadata(id TEXT, nombre TEXT, email TEXT, quota BIGINT)")

      println("Creando la tabla bytes para modelar las métricas agregadas de bytes")
      statement.execute("CREATE TABLE IF NOT EXISTS bytes(timestamp TIMESTAMP, id TEXT, value BIGINT, tipo TEXT)")

      println("Creando la tabla bytes para modelar las métricas agregadas de bytes")
      statement.execute("CREATE TABLE IF NOT EXISTS bytes_hourly(timestamp TIMESTAMP, id TEXT, value BIGINT, tipo TEXT)")

      println("Creando la tabla bytes para modelar las métricas agregadas de bytes")
      statement.execute("CREATE TABLE IF NOT EXISTS user_quota_limit(email TEXT, usage BIGINT, quota BIGINT, timestamp TIMESTAMP)")

      println("Dando de alta la información de los metadatos")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000001', 'andres', 'andres@gmail.com', 200000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000002', 'paco', 'paco@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000003', 'juan', 'juan@gmail.com', 100000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000004', 'fede', 'fede@gmail.com', 5000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000005', 'gorka', 'gorka@gmail.com', 200000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000006', 'luis', 'luis@gmail.com', 200000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000007', 'eric', 'eric@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000008', 'carlos', 'carlos@gmail.com', 100000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000009', 'david', 'david@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000010', 'juanchu', 'juanchu@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000011', 'charo', 'charo@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000012', 'delicidas', 'delicidas@gmail.com', 1000000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000013', 'milagros', 'milagros@gmail.com', 200000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000014', 'antonio', 'antonio@gmail.com', 1000000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000015', 'sergio', 'sergio@gmail.com', 1000000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000016', 'maria', 'maria@gmail.com', 1000000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000017', 'cristina', 'cristina@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000018', 'lucia', 'lucia@gmail.com', 300000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000019', 'carlota', 'carlota@gmail.com', 200000)")
      statement.execute("INSERT INTO user_metadata (id, nombre, email, quota) VALUES ('00000000-0000-0000-0000-000000000020', 'emilio', 'emilio@gmail.com', 200000)")

    } catch {
      case e => e.printStackTrace()
    }
    connection.close()
  }

}