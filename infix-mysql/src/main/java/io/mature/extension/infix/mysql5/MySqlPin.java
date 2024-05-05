package io.mature.extension.infix.mysql5;

import io.modello.atom.app.KDatabase;
import io.zerows.extension.mbse.basement.uca.jdbc.AoConnection;
import io.zerows.extension.mbse.basement.uca.jdbc.DataConnection;
import io.zerows.extension.mbse.basement.uca.jdbc.Pin;
import io.zerows.extension.mbse.basement.uca.metadata.AoBuilder;
import io.modello.specification.action.HDao;
import io.zerows.extension.mbse.basement.eon.AoCache;

/**
 * MySQL统一接口
 */
public class MySqlPin implements Pin {

    private AoConnection getConnection(final KDatabase database) {
        return AoCache.CC_CONNECTION.pick(() -> (new DataConnection(database)), database.getJdbcUrl());
        // return Fn.po?l(AoCache.POOL_CONNECTION, database.getJdbcUrl(), () -> (new DataConnection(database)));
    }

    @Override
    public AoBuilder getBuilder(final KDatabase database) {
        return AoCache.CC_BUILDER.pick(() -> new MySqlBuilder(this.getConnection(database)));
        // return Fn.po?lThread(AoCache.POOL_T_BUILDER, () -> new MySqlBuilder(this.getConnection(database)));
    }

    @Override
    public HDao getDao(final KDatabase database) {
        // return Fn.po?lThread(AoCache.POOL_T_DAO, () -> new MySqlDao(this.getConnection(database)));
        /* 共享连接 */
        return new MySqlDao(this.getConnection(database));
    }
}
