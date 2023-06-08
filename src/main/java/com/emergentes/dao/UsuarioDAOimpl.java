
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            this.conectar();
            String sql = "insert into usuarios(nombres, apellidos, email, password) values(?, ?, ?, sha1(?))";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error insert(): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            this.conectar();
            String sql = "update usuarios set nombres=?, apellidos=?, email=?, password=sha1(?) where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());

            ps.setInt(5, usuario.getId());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error al actualizar  update( ): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from usuarios where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error al eliminar  delete(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usuario = new Usuario();
        try {
            this.conectar();
            String sql = "select * from usuarios where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                //usuario.setPassword(rs.getString("password"));

            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener  getById(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            String sql = "select * from usuarios";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                //usuario.setPassword(rs.getString("password"));

                lista.add(usuario);
                
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("ERROR EN SQL getAll(): " + e.getMessage());
            e.printStackTrace();

        } finally {
            this.desconectar();
        }

        return lista;
    }
    
}
