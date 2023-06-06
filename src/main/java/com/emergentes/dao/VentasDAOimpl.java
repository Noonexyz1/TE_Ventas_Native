
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDAOimpl extends ConexionDB implements VentasDAO{
    
    @Override
    public void insert(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "insert into ventas(producto_id, cliente_id, fecha) values(?, ?, ?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error insert(): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "update ventas set producto_id=?, cliente_id=?, fecha=? where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());

            ps.setInt(4, venta.getId());

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
            String sql = "delete from ventas where id=?";
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
    public Venta getById(int id) throws Exception {
        Venta venta = new Venta();
        try {
            this.conectar();
            String sql = "select * from ventas where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venta.setId(rs.getInt("id"));
                venta.setProducto_id(rs.getInt("producto_id"));
                venta.setCliente_id(rs.getInt("cliente_id"));
                venta.setFecha(rs.getDate("fecha"));
                

            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener  getById(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return venta;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = new ArrayList<>();
        try {
            this.conectar();
            //String sql = "select v.*, p.nombre as producto, c.nombre as cliente from ventas v left join productos p on v.producto_id = p.id left join clientes c on v.clientes_id = c.id";
            String sql = "select v.*, p.nombre as producto, c.nombre as cliente from ventas v "
                    + "left join productos p on v.producto_id = p.id "
                    + "left join clientes c on v.cliente_id = c.id";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setProducto_id(rs.getInt("producto_id"));
                venta.setCliente_id(rs.getInt("cliente_id"));
                venta.setFecha(rs.getDate("fecha"));

                venta.setCliente(rs.getString("cliente"));
                venta.setProducto(rs.getString("producto"));
                
                lista.add(venta);
            
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
