package io.mature.extension.infix.mysql5.cv;

public interface MySqlStatement {
    /* 检查表是否存在 */
    String E_TABLE = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES " +
        "WHERE TABLE_TYPE=''BASE TABLE'' AND TABLE_SCHEMA = ''{0}'' AND TABLE_NAME = ''{1}''";
    /* 读取约束信息 */
    String R_CONSTRAINTS = "SELECT CONSTRAINT_NAME,CONSTRAINT_TYPE FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS " +
        "WHERE TABLE_SCHEMA=''{0}'' AND TABLE_NAME=''{1}'' ORDER BY CONSTRAINT_NAME";
    /* 读取列信息 */
    String R_COLUMNS = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS " +
        "WHERE TABLE_SCHEMA=''{0}'' AND TABLE_NAME=''{1}''";
    /* 读取列详细信息 */
    String R_COLUMNS_DETAILS = "SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, NUMERIC_PRECISION, NUMERIC_SCALE FROM INFORMATION_SCHEMA.COLUMNS " +
        "WHERE TABLE_SCHEMA=''{0}'' AND TABLE_NAME=''{1}''";
    /* MySQL 约束变更 */
    String ATDC_CONSTRAINT = "ALTER TABLE {0} DROP {1};";
    /* MySQL 列变更 */
    String ATMC_COLUMN = "ALTER TABLE {0} MODIFY {1};";
    /* MySQL 列重命名 */
    String ATMR_COLUMN = "ALTER TABLE {0} CHANGE {1} {2} {3};";
}
