/*
 * This file is generated by jOOQ.
 */
package com.sda.taskmanager.entity.tables;


import com.sda.taskmanager.entity.Tasks;
import com.sda.taskmanager.entity.tables.records.Databasechangelog_Record;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Databasechangelog_ extends TableImpl<Databasechangelog_Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tasks.databasechangelog </code>
     */
    public static final Databasechangelog_ DATABASECHANGELOG_ = new Databasechangelog_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Databasechangelog_Record> getRecordType() {
        return Databasechangelog_Record.class;
    }

    private Databasechangelog_(Name alias, Table<Databasechangelog_Record> aliased) {
        this(alias, aliased, null);
    }

    private Databasechangelog_(Name alias, Table<Databasechangelog_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>tasks.databasechangelog </code> table reference
     */
    public Databasechangelog_(String alias) {
        this(DSL.name(alias), DATABASECHANGELOG_);
    }

    /**
     * Create an aliased <code>tasks.databasechangelog </code> table reference
     */
    public Databasechangelog_(Name alias) {
        this(alias, DATABASECHANGELOG_);
    }

    /**
     * Create a <code>tasks.databasechangelog </code> table reference
     */
    public Databasechangelog_() {
        this(DSL.name("databasechangelog "), null);
    }

    public <O extends Record> Databasechangelog_(Table<O> child, ForeignKey<O, Databasechangelog_Record> key) {
        super(child, key, DATABASECHANGELOG_);
    }

    @Override
    public Schema getSchema() {
        return Tasks.TASKS;
    }

    @Override
    public Databasechangelog_ as(String alias) {
        return new Databasechangelog_(DSL.name(alias), this);
    }

    @Override
    public Databasechangelog_ as(Name alias) {
        return new Databasechangelog_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog_ rename(String name) {
        return new Databasechangelog_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog_ rename(Name name) {
        return new Databasechangelog_(name, null);
    }
}
