package com.ted.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.greendao.ted.greendaodemo.TradeDate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRADE_TABLE".
*/
public class TradeTableDao extends AbstractDao<TradeDate, Long> {

    public static final String TABLENAME = "TRADE_TABLE";

    /**
     * Properties of entity TradeTable.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ItemId = new Property(1, String.class, "itemId", false, "ITEM_ID");
        public final static Property PriceId = new Property(2, int.class, "priceId", false, "PRICE_ID");
    }


    public TradeTableDao(DaoConfig config) {
        super(config);
    }
    
    public TradeTableDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRADE_TABLE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ITEM_ID\" TEXT," + // 1: itemId
                "\"PRICE_ID\" INTEGER NOT NULL );"); // 2: priceId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRADE_TABLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TradeDate entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String itemId = entity.getItem();
        if (itemId != null) {
            stmt.bindString(2, itemId);
        }
        stmt.bindLong(3, entity.getPrice());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TradeDate entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String itemId = entity.getItem();
        if (itemId != null) {
            stmt.bindString(2, itemId);
        }
        stmt.bindLong(3, entity.getPrice());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TradeDate readEntity(Cursor cursor, int offset) {
        TradeDate entity = new TradeDate( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // itemId
            cursor.getInt(offset + 2) // priceId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TradeDate entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItem(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrice(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TradeDate entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TradeDate entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TradeDate entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
