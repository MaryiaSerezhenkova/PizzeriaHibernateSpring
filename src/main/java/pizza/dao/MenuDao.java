package pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import pizza.api.IMenu;
import pizza.api.IMenuRow;
import pizza.api.core.Menu;
import pizza.api.core.MenuRow;
import pizza.api.core.PizzaInfo;
import pizza.dao.api.IMenuDao;

public class MenuDao implements IMenuDao {

	@Override
	public IMenu create(IMenu item, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMenu read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMenu> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMenu update(long id, LocalDateTime dtUpdate, IMenu type, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IMenuRow readByRowId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

//	public MenuDao(DataSource ds) {
//		this.ds = ds;
//	}
//
//	@Override
//	public List<IMenu> get() {
//		List<IMenu> data = new ArrayList<>();
//		try (Connection conn = ds.getConnection();
//				PreparedStatement stm = conn.prepareStatement(SELECT_SQL);
//				PreparedStatement stmRows = conn.prepareStatement(SELECT_ROWS_BY_MENU_ID_SQL);) {
//			try (ResultSet rs = stm.executeQuery()) {
//				while (rs.next()) {
//					long id = rs.getLong(1);
//					stmRows.setLong(1, id);
//					try (ResultSet rsRows = stmRows.executeQuery()) {
//						data.add(mapper(rs, rsRows));
//					}
//				}
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//
//		return data;
//	}
//
////	public IMenu mapper(ResultSet rs) throws SQLException {
////		return new Menu(rs.getLong("id"), rs.getObject("dt_create", LocalDateTime.class),
////				rs.getObject("dt_update", LocalDateTime.class), rs.getString("name"), rs.getBoolean("enable"));
////	}
//
//	public IMenu create(IMenu item) {
//		try (Connection conn = ds.getConnection();
//				PreparedStatement stm = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
//				PreparedStatement stmRows = conn.prepareStatement(INSERT_ROWS_SQL);) {
//			stm.setObject(1, item.getDtCreate());
//			stm.setObject(2, item.getDtUpdate());
//			stm.setString(3, item.getName());
//			stm.setBoolean(4, item.isEnabled());
//			stm.executeUpdate();
//			try (ResultSet rs = stm.getGeneratedKeys();) {
//
//				while (rs.next()) {
//					long menuId = rs.getLong(1);
//					for (IMenuRow row : item.getItems()) {
//						stmRows.setLong(1, row.getInfo().getId());
//						stmRows.setDouble(2, row.getPrice());
//						stmRows.setDouble(3, menuId);
//
//						stmRows.addBatch();
//					}
//
//					stmRows.executeBatch();
//
//					return read(menuId);
//				}
//
//				return null;
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//	}
//
//	public IMenu read(long id) {
//		try (Connection conn = ds.getConnection();
//				PreparedStatement stm = conn.prepareStatement(SELECT_BY_ID_SQL);
//				PreparedStatement stmRows = conn.prepareStatement(SELECT_ROWS_BY_MENU_ID_SQL)) {
//			// stm.setObject(1, id);
//			stm.setLong(1, id);
//			try (ResultSet rs = stm.executeQuery()) {
//				while (rs.next()) {
//					stmRows.setLong(1, id);
//					try (ResultSet rsRows = stmRows.executeQuery()) {
//						return mapper(rs, rsRows);
//					}
//				}
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//		return null;
//	}
//
//	public IMenu update(long id, LocalDateTime dtUpdate, IMenu item) {
//		try (Connection conn = ds.getConnection();
//				PreparedStatement stm = conn.prepareStatement(UPDATE_SQL);
//				PreparedStatement stmRowsDel = conn.prepareStatement(DELETE_ROWS_SQL);
//				PreparedStatement stmRowsIns = conn.prepareStatement(INSERT_ROWS_SQL);) {
//			conn.setAutoCommit(false);
//			stm.setObject(1, item.getDtUpdate());
//			stm.setString(2, item.getName());
//			stm.setBoolean(3, item.isEnabled());
//
//			stm.setLong(4, id);
//			stm.setObject(5, dtUpdate);
//
//			int countUpdatedRows = stm.executeUpdate();
//
//			if (countUpdatedRows != 1) {
//				if (countUpdatedRows == 0) {
//					throw new IllegalArgumentException("Не смогли обновить какую либо запись");
//				} else {
//					throw new IllegalArgumentException("Обновили более одной записи");
//				}
//			}
//
//			stmRowsDel.setLong(1, item.getId());
//
//			stmRowsDel.executeUpdate();
//
//			for (IMenuRow row : item.getItems()) {
//				stmRowsIns.setLong(1, row.getInfo().getId());
//				stmRowsIns.setDouble(2, row.getPrice());
//				stmRowsIns.setDouble(3, item.getId());
//
//				stmRowsIns.addBatch();
//			}
//
//			stmRowsIns.executeBatch();
//			conn.commit();
//			return read(id);
//		} catch (SQLException e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//	}
//
//	@Override
//	public void delete(long id, LocalDateTime dtUpdate) {
//		 try (Connection conn = ds.getConnection();
//	             PreparedStatement stm = conn.prepareStatement(DELETE_SQL, Statement.RETURN_GENERATED_KEYS)
//	        ){
//	            stm.setLong(1, id);
//	            stm.setObject(2, dtUpdate);
//
//	            int countUpdatedRows = stm.executeUpdate();
//
//	            if(countUpdatedRows != 1){
//	                if(countUpdatedRows == 0){
//	                    throw new IllegalArgumentException("Не смогли удалить какую либо запись");
//	                } else {
//	                    throw new IllegalArgumentException("Удалили более одной записи");
//	                }
//	            }
//	        } catch (SQLException e){
//	            throw new RuntimeException("При сохранении данных произошла ошибка", e);
//	        }
//	    }
//
//	public IMenu mapper(ResultSet rs, ResultSet rsRows) throws SQLException {
//		IMenu menu = new Menu(rs.getLong(1), rs.getObject(2, LocalDateTime.class), rs.getObject(3, LocalDateTime.class),
//				rs.getString(4), rs.getBoolean(5));
//
//		List<IMenuRow> rows = new ArrayList<>();
//		while (rsRows.next()) {
//			MenuRow row = new MenuRow();
//
//			rows.add(row);
//
//			PizzaInfo info = new PizzaInfo();
//
//			row.setPrice(rsRows.getDouble("row_price"));
//			row.setPizzaInfo(info);
//
//			info.setId(rsRows.getLong("info_id"));
//			info.setDtCreate(rsRows.getObject("info_dt_create", LocalDateTime.class));
//			info.setDtUpdate(rsRows.getObject("info_dt_update", LocalDateTime.class));
//			info.setName(rsRows.getString("info_name"));
//			info.setDescription(rsRows.getString("info_description"));
//			info.setSize(rsRows.getInt("info_size"));
//		}
//
//		menu.setItems(rows);
//
//		return menu;
//	}
//	public IMenuRow rowMapper(ResultSet rsRows) throws SQLException {
//		IMenuRow row = new MenuRow();
//		while (rsRows.next()) {
//			PizzaInfo info = new PizzaInfo();
//			row.setPrice(rsRows.getDouble("row_price"));
//			row.setPizzaInfo(info);
//			info.setId(rsRows.getLong("info_id"));
//			info.setDtCreate(rsRows.getObject("info_dt_create", LocalDateTime.class));
//			info.setDtUpdate(rsRows.getObject("info_dt_update", LocalDateTime.class));
//			info.setName(rsRows.getString("info_name"));
//			info.setDescription(rsRows.getString("info_description"));
//			info.setSize(rsRows.getInt("info_size"));
//		}
//
//		return row;
//	}
//
//	public IMenuRow readByRowId(long id) {
//		try (Connection conn = ds.getConnection();
//
//				PreparedStatement stm = conn.prepareStatement(SELECT_ROW_BY_ID_SQL)) {
//			stm.setLong(1, id);
//			try (ResultSet rs = stm.executeQuery()) {
//				while (rs.next()) {
//
//					return rowMapper(rs);
//				}
//			}
//
//		} catch (SQLException e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//		return null;
//	}
}